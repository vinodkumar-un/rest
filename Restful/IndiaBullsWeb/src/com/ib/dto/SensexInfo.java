package com.ib.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sensexInfo")
public class SensexInfo {
	private String market;
	private double tradingLevel;
	private Date lastUpdatedDate;

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public double getTradingLevel() {
		return tradingLevel;
	}

	public void setTradingLevel(double tradingLevel) {
		this.tradingLevel = tradingLevel;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
