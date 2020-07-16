package com.bsl.sonar.model;

public class AllowedClassVariables {

    public AllowedClassVariables(String classFile, String variables) {
	super();
	this.classFile = classFile;
	this.variables = variables;
    }

    String jsonString;

    public AllowedClassVariables(String jsonString) {
	this.jsonString = jsonString;
    }

    public AllowedClassVariables() {

    }

    private String classFile;
    private String variables;

    public String getClassFile() {
	return classFile;
    }

    public void setClassFile(String classFile) {
	this.classFile = classFile;
    }

    public String getVariables() {
	return variables;
    }

    public void setVariables(String variables) {
	this.variables = variables;
    }

    @Override
    public String toString() {
	return "AllowedClassVariables [classFile=" + classFile + ", variables=" + variables + "]";
    }
}