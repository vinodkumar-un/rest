package com.rsi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

@Path("/passport/{passportNo}")
public class PassportResource {
	/* @PathParam("passportNo") */
	/* private String passportNo; */

	/*
	 * public PassportResource(@PathParam("passportNo") String passportNo) {
	 * this.passportNo = passportNo; }
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getPassportNo/{firstname}-{lastname}")
	public String getPassportNo(@PathParam("firstname") String firstname,
			@PathParam("lastname") String lastname) {
		return lastname + " - " + firstname;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getStatus(
			@PathParam("passportNo") PathSegment passportNoPathSeg) {
		return "Passport No : " + passportNoPathSeg.getPath()
				+ " status : approved";
	}
}
