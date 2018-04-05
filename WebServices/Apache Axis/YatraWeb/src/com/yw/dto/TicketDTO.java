package com.yw.dto;

import java.io.Serializable;

public class TicketDTO implements Serializable {
	private String pnr;
	private String coach;
	private int berth;
	private String status;

	public TicketDTO(String pnr, String coach, int berth, String status) {
		this.pnr = pnr;
		this.coach = coach;
		this.berth = berth;
		this.status = status;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public int getBerth() {
		return berth;
	}

	public void setBerth(int berth) {
		this.berth = berth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
