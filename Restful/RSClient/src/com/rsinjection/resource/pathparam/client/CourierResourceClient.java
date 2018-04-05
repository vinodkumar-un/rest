package com.rsinjection.resource.pathparam.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

public class CourierResourceClient {
	private static final String RESOURCE_URI = "http://localhost:8081/RSInjectionWeb/rest/courier";

	public static void main(String[] args) {
		Client client = null;
		WebTarget target = null;

		try {
			client = ClientBuilder.newClient();
			target = client.target(RESOURCE_URI);

			String data = getCourierStatus(target);
			System.out.println(data);
		} finally {
			client.close();
		}

	}

	public static String getAgentName(WebTarget target) {
		String data = target.request().header("agentId", "007")
				.get(String.class);
		return data;
	}

	public static String sendCourier(WebTarget target) {
		Response response = target.request().header("courier-agent-id", "c1")
				.post(Entity.text("Internal Courier"));
		String data = response.readEntity(String.class);
		return data;
	}

	public static String getCourierStatus(WebTarget target) {
		NewCookie cookie = null;

		cookie = new NewCookie("agentId", "007");

		return target.path("/status").queryParam("trackingId", "t24242")
				.request().cookie(cookie).get(String.class);
	}
}
