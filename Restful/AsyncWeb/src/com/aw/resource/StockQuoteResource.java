package com.aw.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stock")
public class StockQuoteResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void getQuotePrice(@QueryParam("stocknm") String stockNm,
			@Suspended AsyncResponse asyncResponse) {
		asyncResponse.resume(Response.ok(
				"stocknm : " + stockNm + " price : 2242.234f").build());
	}

}
