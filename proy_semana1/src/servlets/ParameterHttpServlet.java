package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parametros")
public class ParameterHttpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro1  = request.getParameter("param1");
		String parametro2  = request.getParameter("param2");
		
		response.getWriter().write("El parametro 1: " + parametro1 + "---" + "El parametro 2 es: " + parametro2);
	}

	
}
