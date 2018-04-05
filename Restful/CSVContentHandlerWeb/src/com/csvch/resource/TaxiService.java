package com.csvch.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csvch.dto.Fare;
import com.csvch.dto.TripInfo;

@Path("/taxi")
public class TaxiService {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Fare hire(TripInfo tripInfo) {
		Fare fare = null;

		fare = new Fare();
		fare.setBillNo(tripInfo.getSrc() + "-" + tripInfo.getDest()
				+ UUID.randomUUID().toString());
		fare.setDistance("10 KM");

		return fare;
	}
}
