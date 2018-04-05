package com.wia.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wia.resource.AbstractOrderImpl;
import com.wia.resource.OrderImpl;

@ApplicationPath("/service")
public class WIAApplication extends Application {
	private Set<Class<?>> classes;

	public WIAApplication() {
		classes = new HashSet<Class<?>>();
		// classes.add(OrderImpl.class);
		classes.add(AbstractOrderImpl.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
