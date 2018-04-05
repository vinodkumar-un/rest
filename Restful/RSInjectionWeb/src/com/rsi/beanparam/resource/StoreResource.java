package com.rsi.beanparam.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/store")
public class StoreResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String search(@BeanParam Criteria criteria) {
		return "itemCode : " + criteria.getItemCode() + ", category : "
				+ criteria.getCategory() + ", manufacturer : "
				+ criteria.getManufacturer() + ", price : "
				+ criteria.getPrice();
	}
}
