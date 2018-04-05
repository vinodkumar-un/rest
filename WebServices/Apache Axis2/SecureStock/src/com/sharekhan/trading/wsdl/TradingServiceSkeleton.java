/**
 * TradingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package com.sharekhan.trading.wsdl;

import com.sharekhan.trading.types.BuyResponse;
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
		StockInfo stockInfo = null;

		stockInfo = new StockInfo();
		stockInfo.setOrderId(141);
		stockInfo.setStockNm(buy.getQuoteInfo().getStockNm());
		stockInfo.setQuantity(buy.getQuoteInfo().getQuantity());
		stockInfo.setPrice(buy.getQuoteInfo().getPrice());
		stockInfo.setTotalAmount(2542.34f);

		response = new BuyResponse();
		response.setStockInfo(stockInfo);

		return response;
	}

}
