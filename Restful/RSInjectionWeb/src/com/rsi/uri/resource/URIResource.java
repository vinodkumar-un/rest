package com.rsi.uri.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/uri")
public class URIResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUriInformation(@Context UriInfo uri) {
		StringBuffer buffer = null;
		MultivaluedMap<String, String> queryMap = null;

		buffer = new StringBuffer();
		queryMap = uri.getQueryParameters();

		for (String paramName : queryMap.keySet()) {
			buffer.append("param : " + paramName);
			List<String> values = queryMap.get(paramName);
			for (String value : values) {
				buffer.append(",").append(value);
			}
			buffer.append(";");
		}
		return buffer.toString();
	}
}
