package com.bsl.sonar.model;

public class WhiteListVariables {

    String jsonString;

    public WhiteListVariables(String jsonString) {
	this.jsonString = jsonString;
    }

    public WhiteListVariables() {

    }

    public WhiteListVariables(String whiteClass, String whiteVariables) {
	super();
	this.whiteClass = whiteClass;
	this.whiteVariables = whiteVariables;
    }

    private String whiteClass;
    private String whiteVariables;

    public String getWhiteClass() {
	return whiteClass;
    }

    public void setWhiteClass(String whiteClass) {
	this.whiteClass = whiteClass;
    }

    public String getWhiteVariables() {
	return whiteVariables;
    }

    public void setWhiteVariables(String whiteVariables) {
	this.whiteVariables = whiteVariables;
    }

    @Override
    public String toString() {
	return "WhiteListVariables [" + ", whiteClass=" + whiteClass + ", whiteVariables=" + whiteVariables + "]";
    }
}