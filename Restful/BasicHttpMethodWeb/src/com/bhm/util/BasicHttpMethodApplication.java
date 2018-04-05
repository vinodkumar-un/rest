package com.bhm.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.bhm.resource.BluedartCourierResource;

public class BasicHttpMethodApplication extends Application {
	private Set<Object> singletons;

	public BasicHttpMethodApplication() {
		singletons = new HashSet<Object>();
		singletons.add(new BluedartCourierResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
