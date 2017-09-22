package rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
public class Authorization {
	
	private static final Logger LOG = Logger.getAnonymousLogger();

	@GET
	@Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)	
	public Response logout(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		LOG.log(Level.WARNING, "tchau querida....");
		request.getSession().invalidate();
		response.reset();
        return Response.ok().entity("Tchau").build();
	}
	
}
