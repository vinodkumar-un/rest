package com.cch.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cch.dto.OrderInfo;

@Path("/order")
public class OrderResource {
	private Map<String, OrderInfo> orderMap;

	public OrderResource() {
		orderMap = new HashMap<String, OrderInfo>();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public String placeOrder(OrderInfo orderInfo) {
		orderInfo.setOrderId(UUID.randomUUID().toString());
		orderMap.put(orderInfo.getOrderId(), orderInfo);
		return "Your order for item : " + orderInfo.getItemCode()
				+ " with orderId : " + orderInfo.getOrderId()
				+ " is accepted and under processing...";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{orderId}")
	public OrderInfo getOrderInfo(@PathParam("orderId") String orderId) {
		return orderMap.get(orderId);
	}
}
