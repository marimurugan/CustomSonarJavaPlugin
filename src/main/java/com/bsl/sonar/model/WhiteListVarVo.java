package com.bsl.sonar.model;

import java.util.List;

public class WhiteListVarVo {

	public WhiteListVarVo(){}
	
	private List<WhiteListVariables> whiteListVariables;
	
	
		
	public WhiteListVarVo(List<WhiteListVariables> whiteListVariables) {
		
		this.whiteListVariables = whiteListVariables;
	}


	public List<WhiteListVariables> getWhiteListVariables() {
		return whiteListVariables;
	}


	public void setWhiteListVariables(List<WhiteListVariables> whiteListVariables) {
		this.whiteListVariables = whiteListVariables;
	}


	@Override
	public String toString() {
		return "WhiteListVarVo [whiteListVariables=" + whiteListVariables + "]";
	}


	
}
