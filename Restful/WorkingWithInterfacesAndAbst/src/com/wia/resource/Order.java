package com.wia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/order")
public interface Order {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	String getOrderStatus(@QueryParam("orderNo") int orderNo);
}
