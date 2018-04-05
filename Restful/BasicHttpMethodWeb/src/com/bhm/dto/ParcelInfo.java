package com.bhm.dto;

import java.io.Serializable;

public class ParcelInfo implements Serializable {
	private int awbNo;
	private String src;
	private String dest;
	private String descr;
	private String status;

	public int getAwbNo() {
		return awbNo;
	}

	public void setAwbNo(int awbNo) {
		this.awbNo = awbNo;
	}

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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
