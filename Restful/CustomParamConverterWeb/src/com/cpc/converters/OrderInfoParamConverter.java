package com.cpc.converters;

import javax.ws.rs.ext.ParamConverter;

import com.cpc.dto.OrderInfo;

public class OrderInfoParamConverter implements ParamConverter<OrderInfo> {

	@Override
	public OrderInfo fromString(String val) {
		OrderInfo orderInfo = null;

		if (val != null && !val.equals("")) {
			orderInfo = new OrderInfo();
			if (val.toUpperCase().equals("SMALL")) {
				orderInfo.setSize(8);
			} else if (val.toUpperCase().equals("MEDIUM")) {
				orderInfo.setSize(12);
			} else if (val.toUpperCase().equals("LARGE")) {
				orderInfo.setSize(16);
			}
		}
		return orderInfo;
	}

	@Override
	public String toString(OrderInfo orderInfo) {
		String val = null;

		if (orderInfo != null) {
			if (orderInfo.getSize() == 8) {
				val = "SMALL";
			} else if (orderInfo.getSize() == 12) {
				val = "MEDIUM";
			} else if (orderInfo.getSize() == 16) {
				val = "LARGE";
			}
		}
		return val;
	}

}
