package com.rsi.autoparamconv.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/address")
public class AddressResource {

	@Path("/zip/{zip}")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String getAreaCode(@PathParam("zip") int zip) {
		return "zip : " + zip;
	}

	@GET
	@Path("/area/{areaCode}")
	@Produces(MediaType.TEXT_PLAIN)
	public String findZipCodes(@PathParam("areaCode") SearchCriteria criteria) {
		return "Zip for areaCode : " + criteria.getAreaCode();
	}

	@GET
	@Path("/blacklist")
	@Produces(MediaType.TEXT_PLAIN)
	public String addToBlackList(@QueryParam("zip") List<Integer> zipCodes) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		for (int z : zipCodes) {
			buffer.append(",").append(z);
		}
		return buffer.toString();
	}

}
