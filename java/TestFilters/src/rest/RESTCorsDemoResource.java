package rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demo")
public class RESTCorsDemoResource {

	@GET
	@Path("get-method")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMethod() {
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		jsonObjBuilder.add("message", "get method ok");

		JsonObject jsonObj = jsonObjBuilder.build();

		return Response.status(Response.Status.OK).entity(jsonObj.toString()).build();
	}
	
	@GET
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Object user) {
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		jsonObjBuilder.add("isOk", "true");
		
		JsonObject jsonObj = jsonObjBuilder.build();
		
		return Response.status(Response.Status.OK).entity(jsonObj.toString()).build();
	}

	@PUT
	@Path("put-method")
	@Produces(MediaType.APPLICATION_JSON)
	public Response putMethod() {
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		jsonObjBuilder.add("message", "get method ok");

		JsonObject jsonObj = jsonObjBuilder.build();

		return Response.status(Response.Status.ACCEPTED).entity(jsonObj.toString()).build();
	}

	@POST
    @Path( "post-method" )
    @Produces( MediaType.APPLICATION_JSON )
	public Response postMethod() {
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		jsonObjBuilder.add("message", "post method ok");

		JsonObject jsonObj = jsonObjBuilder.build();

		return Response.status(Response.Status.CREATED).entity(jsonObj.toString()).build();
	}

	@DELETE
    @Path( "delete-method" )
    @Produces( MediaType.APPLICATION_JSON )
	public Response deleteMethod() {
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		jsonObjBuilder.add("message", "delete method ok");

		JsonObject jsonObj = jsonObjBuilder.build();

		return Response.status(Response.Status.ACCEPTED).entity(jsonObj.toString()).build();

	}

}