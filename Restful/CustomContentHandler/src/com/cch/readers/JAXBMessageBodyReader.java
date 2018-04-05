package com.cch.readers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import com.cch.util.JAXBContextResolver;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class JAXBMessageBodyReader implements MessageBodyReader<Object> {
	@Context
	private Providers providers;

	@Override
	public boolean isReadable(Class<?> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		if (genericType.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> requestHeaderMap,
			InputStream inputStream) throws IOException,
			WebApplicationException {
		Object obj = null;
		JAXBContext jContext = null;
		ContextResolver<JAXBContext> contextResolver = null;
		Unmarshaller unmarshaller = null;
		System.out.println("JAXBMessageBodyReader -- readFrom()");
		try {
			contextResolver = providers.getContextResolver(JAXBContext.class,
					MediaType.APPLICATION_XML_TYPE);
			jContext = contextResolver.getContext(genericType);
			// jContext = JAXBContext.newInstance(genericType);
			unmarshaller = jContext.createUnmarshaller();
			obj = unmarshaller.unmarshal(inputStream);
		} catch (JAXBException e) {
			throw new WebApplicationException(e);
		}

		return obj;
	}

}
