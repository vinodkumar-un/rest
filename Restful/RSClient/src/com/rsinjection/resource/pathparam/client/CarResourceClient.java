package com.rsinjection.resource.pathparam.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CarResourceClient {
	private final static String RESOURCE_URI = "http://localhost:8081/RSInjectionWeb/rest/car";

	public static void main(String[] args) {
		Client client = null;
		WebTarget target = null;

		client = ClientBuilder.newClient();
		target = client.target(RESOURCE_URI).path("/{make}");
		target = target.resolveTemplate("make", "Maruthi").matrixParam("year",
				"2014");
		target = target.path("/{model}").resolveTemplate("model", "Swift")
				.matrixParam("color", "red");

		System.out.println(target.getUri().getPath());
		String data = target.request().get(String.class);
		System.out.println(data);
	}
}
