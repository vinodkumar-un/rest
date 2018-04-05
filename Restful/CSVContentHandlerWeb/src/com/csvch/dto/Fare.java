package com.csvch.dto;

import com.csvch.common.CSVType;

@CSVType
public class Fare {
	private String billNo;
	private String distance;

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

}
