package com.bsl.sonar.java.checks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Modifier;
import org.sonar.plugins.java.api.tree.ModifiersTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

import com.bsl.sonar.model.ModifiersUtils;
import com.bsl.sonar.model.ReadYamlUtil;
import com.bsl.sonar.model.WhiteListVarVo;
import com.bsl.sonar.model.WhiteListVariables;

@Rule(key = "AvoidClassInstanceObject", name = "Variables should not be instantiated in class level", description = "Global variables are prohibitted in the BSL applications.", priority = Priority.BLOCKER, tags = {
	"bug" })
public class AvoidClassInstanceObjectRule extends BaseTreeVisitor implements JavaFileScanner {

    private Deque<Boolean> isClassStack = new ArrayDeque<>();
    private Deque<Boolean> isVarStack = new ArrayDeque<>();

    private Map<String, List<String>> whiteListParams = new HashMap<String, List<String>>();

    private JavaFileScannerContext context;

    WhiteListVarVo whiteListVo = new WhiteListVarVo();
    List<String> whiteListClass = new ArrayList<String>();
    List<String> whiteListInstance = new ArrayList<String>();

    private void collectDataFromYaml() {

	try {
	    whiteListVo = new ReadYamlUtil().readFromYaml();
	    whiteListClass = Arrays.asList(whiteListVo.getWhiteListClass().split(","));
	    whiteListInstance = Arrays.asList(whiteListVo.getWhiteListInstance().split(","));

	    List<WhiteListVariables> whiteListVars = whiteListVo.getWhiteListVariables();

	    for (WhiteListVariables vars : whiteListVars) {
		whiteListParams.put(vars.getWhiteClass(), Arrays.asList(vars.getWhiteVariables().split(",")));
	    }
	    System.out.println("Data Collected from Yaml file ");
	} catch (Exception e) {
	    System.out.println("Exception Occured on reading the YAML :" + e);
	}

    }

    public boolean isWhiteListVariable(VariableTree tree) {
	boolean isWhiteListed = false;

	String classname = tree.simpleName().symbol().owner().name();
	String variname = tree.simpleName().name();
	String varitype = tree.type().toString();

	if (whiteListParams.containsKey(classname)) {
	    if (whiteListParams.get(classname).contains(variname) || whiteListInstance.contains(varitype)) {
		System.out.println("White Listed Variable Classname: " + classname + ", Type :" + varitype
			+ ", Variable :" + variname);
		isWhiteListed = true;
	    }
	}
	return isWhiteListed;
    }

    @Override
    public void scanFile(JavaFileScannerContext context) {
	collectDataFromYaml();
	this.context = context;
	scan(context.getTree());
    }

    @Override
    public void visitClass(ClassTree tree) {
	String className = tree.simpleName().name();

	System.out.println("Visiting Class :" + className);

	isVarStack.push(tree.is(Tree.Kind.INSTANCE_OF) || tree.is(Tree.Kind.VARIABLE));

	if (whiteListClass.contains(className)) {
	    System.out.println("WhiteListed Class :" + className);
	}

	else if ((tree.is(Tree.Kind.CLASS) || tree.is(Tree.Kind.ENUM))) {
	    isClassStack.push(tree.is(Tree.Kind.CLASS) || tree.is(Tree.Kind.ENUM));
	}
	super.visitClass(tree);
	isClassStack.pop();
    }

    @Override
    public void visitVariable(VariableTree tree) {

	// ModifiersTree modifiers = tree.modifiers();
	// List<AnnotationTree> annotations = modifiers.annotations();

	if (isClass() && tree.parent().is(Tree.Kind.CLASS)) {
	    if (!isWhiteListVariable(tree)) {
		context.reportIssue(this, tree.simpleName(),
			"Restricted to define " + tree.simpleName() + "  as Global variable." + " Parent Kind :"
				+ tree.parent().kind() + ", Class Variable :" + tree.parent().is(Tree.Kind.CLASS));
	    }
	}
	super.visitVariable(tree);
    }

    private boolean isClass() {
	return !isClassStack.isEmpty() && isClassStack.peek();
    }

    private static boolean isFinal(ModifiersTree modifiers) {
	return ModifiersUtils.hasModifier(modifiers, Modifier.FINAL);
    }

    private static boolean isPublic(ModifiersTree modifiers) {
	return ModifiersUtils.hasModifier(modifiers, Modifier.PUBLIC);
    }

}
