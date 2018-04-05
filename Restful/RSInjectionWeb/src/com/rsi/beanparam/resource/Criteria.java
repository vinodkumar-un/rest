package com.rsi.beanparam.resource;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

public class Criteria {
	@QueryParam("itemCode")
	private String itemCode;
	@HeaderParam("category")
	private String category;
	@QueryParam("manufacturer")
	private String manufacturer;
	@QueryParam("price")
	private float price;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
