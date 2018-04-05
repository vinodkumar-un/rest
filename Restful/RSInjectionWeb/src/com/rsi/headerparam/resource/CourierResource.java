package com.rsi.headerparam.resource;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/courier")
public class CourierResource {

	/*
	 * @HeaderParam("courier-agent-id") private String courierAgentId;
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAgentName(@HeaderParam("agentId") String agentId) {
		return "Agent id : " + agentId + " name : apparao";
	}

	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCourierStatus(@CookieParam("agentId") String agentId,
			@QueryParam("trackingId") String trackingId) {
		return "Agent : " + agentId + " trackingId : " + trackingId
				+ " is in progress...";
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String send(InputStream is,
			@HeaderParam("courier-agent-id") String courierAgentId) {
		StringBuffer buffer = null;
		int c = 0;

		buffer = new StringBuffer();
		try (BufferedInputStream bis = new BufferedInputStream(is)) {
			while ((c = bis.read()) != -1) {
				buffer.append((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (courierAgentId != null && !courierAgentId.equals("")) {
			return "Agent : " + courierAgentId
					+ " request accepted... with data : " + buffer.toString();
		}
		return "Awb no: 1313";
	}
}
