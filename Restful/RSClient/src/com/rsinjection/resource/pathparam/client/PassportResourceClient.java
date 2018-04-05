package com.rsinjection.resource.pathparam.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class PassportResourceClient {
	private final static String RESOURCE_URI = "http://localhost:8081/RSInjectionWeb/rest/passport/{passportNo}";

	public static void main(String[] args) {
		Client client = null;
		WebTarget target = null;

		client = ClientBuilder.newClient();
		client.property("connection.timeout", 1000 * 60);
		target = client.target(RESOURCE_URI);
		target = target.path("/getPassportNo/{firstname}-{lastname}");

		target = target.resolveTemplate("passportNo", "p1");
		target = target.resolveTemplate("firstname", "john");
		target = target.resolveTemplate("lastname", "blake");

		Response response = target.request().get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			response.bufferEntity();
			String body = response.readEntity(String.class);
			response.readEntity(String.class);
			System.out.println(body);
		}
	}
}
