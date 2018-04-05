package com.yw.dto;

import java.io.Serializable;
import java.util.Date;

public class ReservationDTO implements Serializable {
	private String src;
	private String dest;
	private Date doj;
	private String ssn;
	private String name;
	private int age;

	public ReservationDTO(String src, String dest, Date doj, String ssn,
			String name, int age) {
		this.src = src;
		this.dest = dest;
		this.doj = doj;
		this.ssn = ssn;
		this.name = name;
		this.age = age;
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
