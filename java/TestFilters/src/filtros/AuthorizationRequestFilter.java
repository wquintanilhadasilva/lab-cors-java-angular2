package filtros;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 * @author wedson.silva
 * 
 * No Web.xml está definido para varrer o package, no entanto, os recursos neste package que serão 
 * carregados devem ser anotados com <pre>@Provider</pre>
 * Neste caso, a realização da interface <code>ContainerRequestFilter</code> habilita esse componente a interceptar
 * requisições, antes de seu destino, para tratar segurança usando JAAS
 */
@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter{
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		final SecurityContext securityContext = requestContext.getSecurityContext();
		
        String fullUri = requestContext.getUriInfo().getAbsolutePath().toString();
        
        System.out.println("Verificando autorização para uri=" + fullUri + " com usuário " + securityContext.getUserPrincipal());
        
        System.out.println(fullUri);
        
       /* if (securityContext == null || securityContext.getUserPrincipal() == null || !securityContext.isUserInRole("auth"))
        {
        	JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();

    		jsonObjBuilder.add("Erro de Autenticação", "Você não está autorizado acessar este recurso, Entre no sistema por favor.");

    		JsonObject jsonObj = jsonObjBuilder.build();

            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(jsonObj).build());
            
        }*/
		
	}

}
