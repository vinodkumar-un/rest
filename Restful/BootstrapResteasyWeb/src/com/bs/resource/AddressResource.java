package com.bs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/address")
public class AddressResource {

	public AddressResource() {
		System.out.println("AddressResource()");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAreaCode(@QueryParam("zip") int zipcode) {
		return zipcode + "-Area";
	}
}
