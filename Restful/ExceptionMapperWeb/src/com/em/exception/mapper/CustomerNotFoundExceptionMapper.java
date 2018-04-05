package com.em.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.em.exception.CustomerNotFoundException;

@Provider
public class CustomerNotFoundExceptionMapper implements
		ExceptionMapper<CustomerNotFoundException> {

	@Override
	public Response toResponse(CustomerNotFoundException ex) {
		return Response.status(Status.BAD_REQUEST).entity(ex.getMessage())
				.build();
	}
}
