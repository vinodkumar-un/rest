package com.csvch.dto;

import com.csvch.common.CSVType;

@CSVType
public class TripInfo {
	private String src;
	private String dest;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

}
