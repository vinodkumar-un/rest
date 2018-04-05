package com.em.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.em.exception.mapper.CustomerNotFoundExceptionMapper;
import com.em.resource.CustomerResource;

@ApplicationPath("/rest")
public class ExceptionMapperApplication extends Application {
	private Set<Class<?>> classes;
	private Set<Object> singletons;

	public ExceptionMapperApplication() {
		classes = new HashSet<Class<?>>();
		singletons = new HashSet<Object>();

		classes.add(CustomerNotFoundExceptionMapper.class);
		singletons.add(new CustomerResource());
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
