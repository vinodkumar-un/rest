package com.sw.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sw.dto.SensexInfo;

@Path("/stock")
public class StockQuoteResource {
	@Path("/bse")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public SensexInfo getBSESensex() {
		SensexInfo sensexInfo = null;

		sensexInfo = new SensexInfo();
		sensexInfo.setMarket("BSE");
		sensexInfo.setTradingLevel(24222.23);
		sensexInfo.setLastUpdatedDate(new Date());

		return sensexInfo;
	}
}
