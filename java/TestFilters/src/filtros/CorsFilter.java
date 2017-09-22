package filtros;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter, ContainerRequestFilter{
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) throws IOException {
		System.out.println("Cors 1 - ContainerRequestContext & ContainerResponseContext!");
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        response.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		System.out.println("Cors 2 - ContainerRequestContext!");
		
		requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		requestContext.getHeaders().add("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		requestContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
		
	}

}
