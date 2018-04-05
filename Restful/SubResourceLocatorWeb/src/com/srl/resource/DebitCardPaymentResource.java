package com.srl.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class DebitCardPaymentResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String processDebit(@QueryParam("cardNo") String cardNo,
			@QueryParam("pin") String pin, @PathParam("gateWay") String gateWay) {
		return "Processed payment with cardNo : " + cardNo + " pin : " + pin
				+ " gateWay : " + gateWay;
	}
}
