package com.wia.resource;

public class OrderImpl implements Order {

	@Override
	public String getOrderStatus(int orderNo) {
		return "Order No : " + orderNo + " is in processing...";
	}

}
