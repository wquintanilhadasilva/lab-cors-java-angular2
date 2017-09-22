package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(filterName = "MeuFiltro", urlPatterns = {"/*", "/oi"}) 
public class MeuFiltro implements Filter {

	@Override
	public void destroy() {
		System.out.println("Destruindo o filtro servlet...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtrou!");
		// passa pela porta
	    chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Iniciando o filtro servlet...");
	}

}
