package com.srl.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/payment")
public class PaymentResource {

	/**
	 * Dynamic Dispatching
	 * @param type
	 * @return
	 */
	@Path("/{type}/{gateWay}")
	public Object process(@PathParam("type") String type) {
		Object subResource = null;

		if (type.equals("creditcard")) {
			subResource = new CreditCardPaymentResource();
		} else if (type.equals("debitcard")) {
			subResource = new DebitCardPaymentResource();
		}
		return subResource;
	}
}
