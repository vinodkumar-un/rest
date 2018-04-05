package com.async.resource.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class StockQuoteClient {
	private final static String RESOURCE_URI = "http://localhost:8081/AsyncWeb/rest/stock";

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		Client client = null;
		WebTarget target = null;

		client = ClientBuilder.newClient();
		target = client.target(RESOURCE_URI);
		target = target.queryParam("stocknm", "icicbank");
		target.request().async().get(new ResponseCallback());
		/*
		 * System.out.println("control released");
		 * 
		 * Response response = future.get();
		 * System.out.println("response collected"); if (response.getStatus() ==
		 * 200) { String data = response.readEntity(String.class);
		 * System.out.println(data); }
		 */
		System.out.println("main method ended...");
	}

	private static final class ResponseCallback implements InvocationCallback<Response> {

		@Override
		public void completed(Response response) {
			String data = response.readEntity(String.class);
			System.out.println(data);
		}

		@Override
		public void failed(Throwable ex) {

		}

	}
}
