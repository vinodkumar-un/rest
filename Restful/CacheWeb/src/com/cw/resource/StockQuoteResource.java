package com.cw.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stock")
public class StockQuoteResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{stocknm}")
	public Response getStockPrice(@PathParam("stocknm") String stocknm) {
		Response response = null;
		CacheControl cc = null;

		cc = new CacheControl();
		cc.setPrivate(true);
		cc.setMaxAge(20009200);

		System.out.println("Request is processing...");
		response = Response.ok("stock nm : " + stocknm + " price : 2422")
				.cacheControl(cc).build();

		return response;
	}

}
