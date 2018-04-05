package com.em.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.em.dto.Customer;
import com.em.exception.CustomerNotFoundException;

@Path("/customer")
public class CustomerResource {
	private Map<Integer, Customer> dbMap;
	private AtomicInteger customerindex;

	public CustomerResource() {
		dbMap = new ConcurrentHashMap<Integer, Customer>();
		customerindex = new AtomicInteger(0);

	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createCustomer(Customer customer) throws URISyntaxException {
		String baseUri = null;
		int id = 0;

		baseUri = "/customer/";
		id = customerindex.incrementAndGet();
		baseUri += id;
		customer.setId(id);
		dbMap.put(id, customer);
		return Response.created(new URI(baseUri)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateCustomer(Customer customer)
			throws CustomerNotFoundException {

		if (dbMap.containsKey(customer.getId()) == false) {
			throw new CustomerNotFoundException(
					"Customer is not found to update...");
		}
		dbMap.put(customer.getId(), customer);
		return Response.ok("Customer updated").build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getCustomer(@PathParam("id") int customerId)
			throws CustomerNotFoundException {
		if (dbMap.containsKey(customerId) == false) {
			throw new CustomerNotFoundException("Customer Id is invalid");
		}
		return Response.ok().entity(dbMap.get(customerId)).build();
	}
}
