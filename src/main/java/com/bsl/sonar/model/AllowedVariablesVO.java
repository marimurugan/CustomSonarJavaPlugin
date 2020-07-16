package com.bsl.sonar.model;

import java.util.List;

public class AllowedVariablesVO {

    public AllowedVariablesVO() {
	super();
    }

    public AllowedVariablesVO(List<AllowedClassVariables> allowedClassVariables, String allowedClass,
	    String allowedInstance) {
	super();
	this.allowedClassVariables = allowedClassVariables;
	this.allowedClass = allowedClass;
	this.allowedInstance = allowedInstance;
    }

    private List<AllowedClassVariables> allowedClassVariables;
    private String allowedClass;
    private String allowedInstance;

    public String getAllowedClass() {
	return allowedClass;
    }

    public void setAllowedClass(String allowedClass) {
	this.allowedClass = allowedClass;
    }

    public String getAllowedInstance() {
	return allowedInstance;
    }

    public void setAllowedInstance(String allowedInstance) {
	this.allowedInstance = allowedInstance;
    }

    @Override
    public String toString() {
	return "WhiteListVarVo [allowedClassVariables=" + allowedClassVariables + ", allowedClass=" + allowedClass
		+ ", allowedInstance=" + allowedInstance + "]";
    }

    public List<AllowedClassVariables> getAllowedClassVariables() {
	return allowedClassVariables;
    }

    public void setAllowedClassVariables(List<AllowedClassVariables> allowedClassVariables) {
	this.allowedClassVariables = allowedClassVariables;
    }

}
