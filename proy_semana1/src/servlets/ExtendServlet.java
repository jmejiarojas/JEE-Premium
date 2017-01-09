package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExtendServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("<html><body>Probando GenericServlet</body></html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("[DESTROY] Generic Servlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("[INIT] Generic Servlet");
	}

	
}
