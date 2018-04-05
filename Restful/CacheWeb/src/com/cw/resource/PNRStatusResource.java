package com.cw.resource;

import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pnr")
public class PNRStatusResource {

	@GET
	@Path("/{pnr}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPnrStatus(@PathParam("pnr") String pnr) {
		Response response = null;
		Calendar timestamp = null;

		timestamp = Calendar.getInstance();
		timestamp.set(2014, 7, 18, 9, 0, 0);

		response = Response.ok("pnr : " + pnr + " status : WL23")
				.expires(timestamp.getTime()).build();

		return response;
	}

}
