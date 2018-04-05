package com.srl.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class CreditCardPaymentResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String processPayment(@QueryParam("cardNo") String cardNo,
			@PathParam("gateWay") String gateWay) {
		return "Processed payment with cardNo : " + cardNo + " gateWay : "
				+ gateWay;
	}
}
