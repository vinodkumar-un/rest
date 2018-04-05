package com.cr.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.cr.dto.CardUpgradeInfo;
import com.cr.dto.PersonelInfo;
import com.cr.dto.ServiceRequestStatus;

@Path("/bank")
public class BankResource {

	@GET
	@Path("/bal/{accno}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getBalance(@PathParam("accno") String accno) {
		Response response = null;
		ResponseBuilder builder = null;

		builder = Response.ok("Balance for accno : " + accno + " is 0.0");
		response = builder.build();
		return response;
	}

	@POST
	@Path("/checkbookreq/{accno}")
	public Response requestCheckbook(@PathParam("accno") String accno) {
		Response response = null;
		ResponseBuilder builder = null;

		System.out.println("accno : " + accno);
		builder = Response.status(Status.NO_CONTENT);
		response = builder.build();
		return response;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response upgradeCard(CardUpgradeInfo cardUpgradeInfo) {
		Response response = null;
		ResponseBuilder builder = null;
		ServiceRequestStatus status = null;

		status = new ServiceRequestStatus();
		status.setCardNo(cardUpgradeInfo.getCardNo());
		status.setMsg("Upgrade request accepted");
		status.setStatus("Initiated");

		builder = Response.ok();
		builder = builder.header("serviceRequestNumber", "SR31414");
		builder = builder.entity(status);
		response = builder.build();
		return response;
	}

	@POST
	@Path("/apply")
	@Consumes(MediaType.APPLICATION_XML)
	public Response applyCreditCard(PersonelInfo pInfo)
			throws URISyntaxException {
		NewCookie cookie = null;

		cookie = new NewCookie("interaction-id", "2424");
		return Response.created(new URI("/rest/bank/applyCredit_Step2"))
				.cookie(cookie).build();
	}

}
