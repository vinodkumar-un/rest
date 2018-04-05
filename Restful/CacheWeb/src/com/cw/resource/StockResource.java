package com.cw.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.cw.dto.StockInfo;

@Path("/stockinfo")
public class StockResource {
	private Map<String, StockInfo> dbMap;

	public StockResource() {
		dbMap = new ConcurrentHashMap<String, StockInfo>();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response newStock(StockInfo si) throws URISyntaxException {
		dbMap.put(si.getName(), si);
		return Response.created(new URI("/stockinfo/" + si.getName())).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{stocknm}")
	public Response getStock(@PathParam("stocknm") String stocknm,
			@Context Request request) {
		ResponseBuilder builder = null;
		StockInfo si = null;
		CacheControl cc = null;
		EntityTag eTag = null;

		if (dbMap.containsKey(stocknm) == false) {
			throw new NotFoundException("Stock doesn't exists");
		}

		// sever object
		si = dbMap.get(stocknm);
		eTag = new EntityTag(String.valueOf(si.hashCode()));

		builder = request.evaluatePreconditions(eTag);
		if (builder != null) {// pick the data from cache
			// send redirect request
			return builder.build();
		}

		cc = new CacheControl();
		cc.setMustRevalidate(true);
		cc.setMaxAge(1000 * 60 * 60);
		cc.setPrivate(true);

		return Response.ok(si).cacheControl(cc).tag(eTag).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateStock(StockInfo si, @Context Request request) {
		ResponseBuilder builder = null;
		EntityTag etag = null;
		StockInfo ssi = null;

		if (dbMap.containsKey(si.getName()) == false) {
			throw new NotFoundException("Stock doesn't exists for updating");
		}
		ssi = dbMap.get(si.getName());
		etag = new EntityTag(String.valueOf(ssi.hashCode()));
		builder = request.evaluatePreconditions(etag);
		if (builder != null) {
			// pre-conditions failed
			return builder.build();
		}

		dbMap.put(si.getName(), si);
		return Response.accepted().build();
	}

}
