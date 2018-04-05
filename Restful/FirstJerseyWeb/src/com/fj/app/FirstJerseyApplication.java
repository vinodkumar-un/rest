package com.fj.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fj.resource.PersonResource;

@ApplicationPath("/rest/*")
public class FirstJerseyApplication extends Application {
	private Set<Object> singletons;

	public FirstJerseyApplication() {
		singletons = new HashSet<Object>();
		singletons.add(new PersonResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
