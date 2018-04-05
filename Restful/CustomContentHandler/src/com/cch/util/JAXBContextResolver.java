package com.cch.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.cch.dto.OrderInfo;

@Provider
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
	private JAXBContext jContext;

	public JAXBContextResolver() {
		try {
			jContext = JAXBContext.newInstance(OrderInfo.class);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
	}

	@Override
	public JAXBContext getContext(Class<?> arg0) {
		return jContext;
	}

}
