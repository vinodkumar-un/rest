package com.cpc.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cpc.dto.OrderInfo;

@Path("/pizza")
public class PizzaStore {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String placeOrder(
			@QueryParam("size") @DefaultValue("SMALL") OrderInfo orderInfo) {
		return "You order for " + orderInfo.getSize()
				+ " inch pizza is under processing...";
	}
}
