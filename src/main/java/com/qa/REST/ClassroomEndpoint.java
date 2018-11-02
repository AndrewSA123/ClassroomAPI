package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.business.IClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {

	@Inject
	private IClassroomService ac;

	@Path("/getAlltrainers")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainers() {
		return ac.getAllTrainers();
	}


	@Path("/getTrainer/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTrainer(@PathParam("id") Long id) {
		return ac.getTrainer(id).toString();
	}

	@Path("/getTrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTrainee(@PathParam("id") Long id) {
		return ac.getTrainee(id).toString();
	}

	@Path("/createTrainer")
	@POST
	@Produces({ "application/json" })
	public String addTrainer(String account) {
		return ac.createTrainer(account);
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String account) {
		return ac.createTrainee(account);
	}

	@Path("/deleteTrainer/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainer(@PathParam("id") Long id) {
		return ac.deleteTrainer(id);
	}

	@Path("/deleteTrainer/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return ac.deleteTrainee(id);
	}

	@Path("/updateTrainer/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainer(@PathParam("id") Long id, String acc) {
		return ac.updateTrainer(id, acc);
	}

	@Path("/updateTrainer/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String acc) {
		return ac.updateTrainee(id, acc);
	}

	public void setService(IClassroomService accountService) {
		ac = accountService;
	}

}
