package com.wia.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

abstract public class AbstractOrder {
	@GET
	@Produces("text/plain")
	abstract String getOrderStatus(@QueryParam("orderNo") int orderNo);
}
