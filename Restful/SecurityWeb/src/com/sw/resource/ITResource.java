package com.sw.resource;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.sw.dto.StatusInfo;

@Path("/it")
public class ITResource {

	@Context
	private SecurityContext securityContext;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{pancard}")
	public String getITRVStatus(@PathParam("pancard") String pancard) {
		if (securityContext.isUserInRole("ADMIN")) {
			return "Internal Approval in progress";
		} else if (securityContext.isUserInRole("USER")) {
			return "In progress";

		}
		return null;
	}

	@GET
	@Path("/{pancard}")
	@Produces(MediaType.APPLICATION_XML)
	@RolesAllowed("ADMIN")
	public StatusInfo getITRVSubmission(@PathParam("pancard") String pancard) {
		StatusInfo si = new StatusInfo();

		si.setPancard(pancard);
		si.setStatus("Approved");

		return si;
	}
}
