package com.bs.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.bs.resource.AddressResource;

@ApplicationPath("/rest")
public class BootstrapApplication extends Application {
	/* private Set<Class<?>> classes; */
	private Set<Object> singletons;

	public BootstrapApplication() {
		/*
		 * classes = new HashSet<Class<?>>();
		 * classes.add(AddressResource.class);
		 */
		singletons = new HashSet<Object>();
		singletons.add(new AddressResource());
	}

	@Override
	public Set<Object> getSingletons() {
		System.out.println("getSingletons()");
		return singletons;
	}

	/*
	 * @Override public Set<Class<?>> getClasses() {
	 * System.out.println("getClasses()"); return classes; }
	 */

}
