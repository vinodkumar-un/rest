package com.cch.resource.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class TaxiResourceClient {
	private final static String RESOURCE_URI = "http://localhost:8081/CSVContentHandlerWeb/rest/taxi";

	public static void main(String[] args) {
		Client client = null;
		WebTarget target = null;

		client = ClientBuilder.newClient();
		client.register(CSVMessageBodyReader.class);
		client.register(CSVMessageBodyWriter.class);

		target = client.target(RESOURCE_URI);
		
		Fare fare = hire(target);
		System.out.println(fare.getBillNo());
	}

	public static Fare hire(WebTarget target) {
		TripInfo trip = null;
		Fare fare = null;

		trip = new TripInfo();
		trip.setSrc("ameerpet");
		trip.setDest("secunderabad");

		Response response = target.request().post(
				Entity.entity(trip, MediaType.TEXT_PLAIN));
		if (response.getStatus() == Status.OK.getStatusCode()) {
			fare = response.readEntity(Fare.class);
			return fare;
		}
		return null;
	}
}
