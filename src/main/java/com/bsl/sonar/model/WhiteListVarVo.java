package com.bsl.sonar.model;

import java.util.List;

public class WhiteListVarVo {

    public WhiteListVarVo() {
    }

    private List<WhiteListVariables> whiteListVariables;
    private String whiteListClass;
    private String whiteListInstance;

    public WhiteListVarVo(List<WhiteListVariables> whiteListVariables) {

	this.whiteListVariables = whiteListVariables;
    }

    public List<WhiteListVariables> getWhiteListVariables() {
	return whiteListVariables;
    }

    public void setWhiteListVariables(List<WhiteListVariables> whiteListVariables) {
	this.whiteListVariables = whiteListVariables;
    }

    public String getWhiteListClass() {
	return whiteListClass;
    }

    public void setWhiteListClass(String whiteListClass) {
	this.whiteListClass = whiteListClass;
    }

    public String getWhiteListInstance() {
	return whiteListInstance;
    }

    public void setWhiteListInstance(String whiteListInstance) {
	this.whiteListInstance = whiteListInstance;
    }

    @Override
    public String toString() {
	return "WhiteListVarVo [whiteListVariables=" + whiteListVariables + ", whiteListClass=" + whiteListClass
		+ ", whiteListInstance=" + whiteListInstance + "]";
    }

}
