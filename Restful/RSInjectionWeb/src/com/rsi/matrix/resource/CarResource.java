package com.rsi.matrix.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/car")
public class CarResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{make}/{model}")
	public String search(@PathParam("make") PathSegment makeSeg,
			@PathParam("model") PathSegment modelSeg) {
		StringBuffer buffer = null;
		MultivaluedMap<String, String> matrixParamMap = null;

		buffer = new StringBuffer();
		buffer.append("make : ").append(makeSeg.getPath())
				.append("matrix parameters :");

		matrixParamMap = makeSeg.getMatrixParameters();
		for (String key : matrixParamMap.keySet()) {
			buffer.append(key);
			for (String val : matrixParamMap.get(key)) {
				buffer.append("," + val);
			}

		}

		buffer.append("model : ").append(modelSeg.getPath())
				.append("matrix parameters : ");

		matrixParamMap = modelSeg.getMatrixParameters();
		for (String key : matrixParamMap.keySet()) {
			buffer.append(key);
			for (String val : matrixParamMap.get(key)) {
				buffer.append("," + val);
			}
		}

		return buffer.toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/price/{make}-{model}")
	public float getCarPrice(@PathParam("make") String make,
			@PathParam("model") String model,
			@QueryParam("year") @DefaultValue("2014") int year) {
		System.out.println("model : " + model + " make : " + make + " year : "
				+ year);
		return year + 10000;
	}

}
