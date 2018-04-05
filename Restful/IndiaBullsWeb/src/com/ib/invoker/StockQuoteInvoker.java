package com.ib.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.ib.dto.SensexInfo;

public class StockQuoteInvoker {
	private final String RESOURCE_URI = "http://localhost:8081/StockWeb/rest/stock";
	private static StockQuoteInvoker instance;
	private Invocation bseSensexInvocation;
	private Client client;

	private StockQuoteInvoker() {
		// no - op
	}

	public void init() {
		if (client == null) {
			client = ClientBuilder.newClient();
		}
	}

	public synchronized static StockQuoteInvoker getInstance() {
		if (instance == null) {
			instance = new StockQuoteInvoker();
		}
		return instance;
	}

	public SensexInfo getBSESensex() {
		SensexInfo sensexInfo = null;
		Response response = null;
		WebTarget target = null;

		if (bseSensexInvocation == null) {
			target = client.target(RESOURCE_URI).path("/bse");
			bseSensexInvocation = target.request().buildGet();
		}
		response = bseSensexInvocation.invoke();
		if (response.getStatus() == 200) {
			sensexInfo = response.readEntity(SensexInfo.class);
		}
		return sensexInfo;
	}

	public void close() {
		if (client != null) {
			client.close();
			client = null;
		}
	}

}
