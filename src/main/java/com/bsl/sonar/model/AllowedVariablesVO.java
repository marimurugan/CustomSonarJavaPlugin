package com.bsl.sonar.model;

import java.util.List;

public class AllowedVariablesVO {

    public AllowedVariablesVO() {
	super();
    }

    public AllowedVariablesVO(List<AllowedClassVariables> allowedClassVariables, String allowedClass,
	    String allowedInstance, String defaultVariables) {
	super();
	this.allowedClassVariables = allowedClassVariables;
	this.allowedClass = allowedClass;
	this.allowedInstance = allowedInstance;
	this.defaultVariables = defaultVariables;
    }

    private List<AllowedClassVariables> allowedClassVariables;
    private String allowedClass;
    private String allowedInstance;
    private String defaultVariables;

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

    public List<AllowedClassVariables> getAllowedClassVariables() {
	return allowedClassVariables;
    }

    public void setAllowedClassVariables(List<AllowedClassVariables> allowedClassVariables) {
	this.allowedClassVariables = allowedClassVariables;
    }

    public String getDefaultVariables() {
	return defaultVariables;
    }

    public void setDefaultVariables(String defaultVariables) {
	this.defaultVariables = defaultVariables;
    }

    @Override
    public String toString() {
	return "AllowedVariablesVO [allowedClassVariables=" + allowedClassVariables + ", allowedClass=" + allowedClass
		+ ", allowedInstance=" + allowedInstance + ", defaultVariables=" + defaultVariables + "]";
    }

}
