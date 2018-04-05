package com.cch.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.cch.readers.JAXBMessageBodyReader;
import com.cch.resource.OrderResource;
import com.cch.writers.JAXBMessageBodyWriter;

@ApplicationPath("/rest")
public class CCHApplication extends Application {
	private Set<Object> singletons;
	private Set<Class<?>> classes;

	public CCHApplication() {
		singletons = new HashSet<Object>();
		classes = new HashSet<Class<?>>();

		singletons.add(new OrderResource());
		classes.add(JAXBMessageBodyReader.class);
		classes.add(JAXBMessageBodyWriter.class);
		classes.add(JAXBContextResolver.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
