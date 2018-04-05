package com.rsi.autoparamconv.resource;

public class SearchCriteria {
	private String areaCode;

	public SearchCriteria(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String valueOf(SearchCriteria criteria) {
		return String.valueOf(areaCode);
	}
}
