package com.fjrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/greet")
public class GreetResource {

	@Produces("text/plain")
	@GET
	public String greet(@QueryParam("person") String person) {
		return "Good Morning " + person + " !";
	}
}
