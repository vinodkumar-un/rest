package com.firstrs.resource.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class FirstRSClient {
	public static void main(String[] args) {
		ClientBuilder builder = null;
		WebTarget target = null;
		Client client = null;

		builder = ClientBuilder.newBuilder();
		builder.property("connection.timeout", 1000 * 60);

		client = builder.build();

		target = client.target("http://localhost:8081/FirstJbossRSWeb/greet");
		target = target.queryParam("person", "john");

		Response response = target.request().get();
		if (response.getStatus() == 200) {
			String data = response.readEntity(String.class);
			System.out.println(data);
		}

	}
}
