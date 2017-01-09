package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="ParameterServlet",
		description = "Este es un servlet de parametros",
		urlPatterns = {"/parameter","parameters"},
		initParams = {
				@WebInitParam(name = "param1", value = "Mito"),
				@WebInitParam(name = "param2", value = "Code")
		}
		)
public class ParameterHttpServletFull extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro1 = this.getInitParameter("param1");
		String parametro2 = this.getInitParameter("param2");
		
		response.getWriter().write("El parametro 1: " + parametro1 + "---" + "El parametro 2 es: " + parametro2);
	}

	
}
