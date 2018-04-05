package com.srl.resource;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/courier")
public class CourierResource {
	
	/**
	 * Sub-Resource locator method
	 * @return
	 */
	@Path("/customerservice")
	// sub-resource method
	public CustomerServiceResource track() {
		return new CustomerServiceResource();
	}

}
