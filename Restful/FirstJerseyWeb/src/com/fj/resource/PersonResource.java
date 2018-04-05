package com.fj.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

	public PersonResource() {
		System.out.println("PersonResource()");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String findName(@QueryParam("ssn") int ssn) {
		return ssn + " - name";
	}
}
