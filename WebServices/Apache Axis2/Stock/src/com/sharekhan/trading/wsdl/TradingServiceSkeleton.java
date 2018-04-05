/**
 * TradingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package com.sharekhan.trading.wsdl;

import javax.naming.OperationNotSupportedException;

import com.sharekhan.trading.types.BuyResponse;
import com.sharekhan.trading.types.Reason;
import com.sharekhan.trading.types.StockInfo;

/**
 * TradingServiceSkeleton java skeleton for the axisService
 */
public class TradingServiceSkeleton implements TradingServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param buy0
	 * @return buyResponse1
	 * @throws OperationFailedException
	 */

	public com.sharekhan.trading.types.BuyResponse buy(
			com.sharekhan.trading.types.Buy buy)
			throws OperationFailedException {
		BuyResponse response = null;
		Reason reason = null;

		if (buy.getQuoteInfo().getQuantity() <= 0) {
			reason = new Reason();
			reason.setErrorCode(201);
			reason.setErrorMsg("Invalid Inputs");
			reason.setDetail("Quantity should be non-zero positive integer");
			OperationFailedException exception = new OperationFailedException();
			exception.setFaultMessage(reason);
			throw exception;
		}

		response = new BuyResponse();
		StockInfo si = new StockInfo();
		si.setOrderId(242);
		si.setStockNm(buy.getQuoteInfo().getStockNm());
		si.setQuantity(buy.getQuoteInfo().getQuantity());
		si.setPrice(buy.getQuoteInfo().getPrice());
		si.setTotalAmount(buy.getQuoteInfo().getPrice()
				* buy.getQuoteInfo().getQuantity());
		response.setStockInfo(si);

		return response;
	}

}
