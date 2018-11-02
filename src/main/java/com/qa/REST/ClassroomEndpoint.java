package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.service.business.IClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {

	@Inject
	private IClassroomService ac;

	@Path("/getAlltrainers")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() throws JsonProcessingException {
		return ac.getAllAccounts();
	}

	@Path("/getTrainer/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnAccount(@PathParam("id") Long id) {
		return ac.getAccount(id).toString();
	}

	@Path("/createTrainer")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return ac.createAccount(account);
	}

	@Path("/deleteTrainer/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return ac.deleteAccount(id);
	}

	@Path("/updateTrainer/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String acc) {
		return ac.updateAccount(id, acc);
	}

	public void setService(IClassroomService accountService) {
		ac = accountService;
	}

}
