package com.rsi.formparam.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/emp")
public class EmpResource {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String insert(@FormParam("id") int id, @FormParam("name") String name) {
		return "Inserted id : " + id + " name : " + name + " successfully...";
	}

}
