package com.cw.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.cw.resource.StockResource;

@ApplicationPath("/rest")
public class CacheApplication extends Application {
	Set<Object> singletons;

	public CacheApplication() {
		singletons = new HashSet<Object>();
		singletons.add(new StockResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
