/*package main;

import java.util.logging.Logger;

import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@Provider
public class RestAppMain extends ResourceConfig{
	
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public RestAppMain() {
		
		//Habilitando o scan de pacotes....
//		packages("rest", "filtros"); //Tudo que estiver embaixo do pacote 'rest' e 'filtros' será considerado como recurso
		
		//registrando o logger console default....
		register(new LoggingFilter(LOGGER, true));
		
		//Habilitando o tracing support para todo o callcontext...
		property(ServerProperties.TRACING, "ALL");
		
	}
	

}*/