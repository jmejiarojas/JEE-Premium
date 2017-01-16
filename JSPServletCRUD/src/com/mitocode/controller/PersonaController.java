package com.mitocode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.dao.PersonaDAOImpl;
import com.mitocode.model.Persona;

@WebServlet("/PersonaController")
public class PersonaController extends HttpServlet{

	public static final String LIST_PERSONA = "/listaPersona.jsp";
	public static final String INSERT_EDIT = "/persona.jsp";
	
	public PersonaController() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPersonaDAO dao = new PersonaDAOImpl();
		
		String redireccion = "";
		String accion = request.getParameter("accion");
		
		if(accion.equalsIgnoreCase("ELIMINAR")){
			redireccion = LIST_PERSONA;
			int id = Integer.parseInt(request.getParameter("id"));
			dao.eliminar(id);
			request.setAttribute("personas", dao.listarTodos());
		}else if(accion.equalsIgnoreCase("EDITAR")){
			redireccion = INSERT_EDIT;
			int id = Integer.parseInt(request.getParameter("id"));
			Persona persona = dao.listarPorId(id);
			request.setAttribute("persona", persona);
		}else if(accion.equalsIgnoreCase("INSERTAR")){
			redireccion = INSERT_EDIT;
		}else{
			redireccion = LIST_PERSONA;
			request.setAttribute("personas", dao.listarTodos());
		}
		
		request.getRequestDispatcher(redireccion).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPersonaDAO personaDAO = new PersonaDAOImpl();
		
		Persona persona = new Persona();
		persona.setNombres(request.getParameter("nombres"));
		persona.setApellidos(request.getParameter("apellidos"));
		
		String id = request.getParameter("id");
		
		if(id == null || id.isEmpty()){
			personaDAO.agregar(persona);
		}else{
			persona.setId(Integer.parseInt(id));
			personaDAO.actualizar(persona);
		}
		
		request.setAttribute("personas", personaDAO.listarTodos());
		request.getRequestDispatcher(LIST_PERSONA).forward(request, response);
	}

	
}














