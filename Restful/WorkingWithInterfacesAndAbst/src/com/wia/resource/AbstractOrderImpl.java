package com.wia.resource;

import javax.ws.rs.Path;

@Path("/absorder")
public class AbstractOrderImpl extends AbstractOrder {
	@Override
	String getOrderStatus(int orderNo) {
		return "Status : pending ... for order : " + orderNo;
	}

}
