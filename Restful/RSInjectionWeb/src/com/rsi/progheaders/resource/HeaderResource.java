package com.rsi.progheaders.resource;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/header")
public class HeaderResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllHeaders(@Context HttpHeaders headers) {
		StringBuffer buffer = null;
		MultivaluedMap<String, String> headerMap = null;
		Map<String, Cookie> cookieMap = null;

		buffer = new StringBuffer();
		headerMap = headers.getRequestHeaders();
		for (String paramName : headerMap.keySet()) {
			List<String> paramValues = headerMap.get(paramName);
			buffer.append("paramName : ").append(paramName);
			for (String paramValue : paramValues) {
				buffer.append(",").append(paramValue);
			}
			buffer.append(";");
		}
		buffer.append("********Cokiees********");
		cookieMap = headers.getCookies();
		for (String key : cookieMap.keySet()) {
			Cookie c = cookieMap.get(key);
			buffer.append("Name : ").append(c.getName()).append(" Value : ")
					.append(c.getValue());
		}

		return buffer.toString();
	}
}
