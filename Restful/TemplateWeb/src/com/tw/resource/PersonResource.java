package com.tw.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person/{ssn: \\d+}")
public class PersonResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPersonName(@PathParam("ssn") int id) {
		return id + "-Name";
	}
}
