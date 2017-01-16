package com.mitocode.dao;

import com.mitocode.model.Persona;

public class Test {
	public static void main(String[] args) {
		IPersonaDAO personaDAO = new PersonaDAOImpl();
		Persona persona = new Persona();
		persona.setNombres("Juana");
		persona.setApellidos("Mejia Cardenas");
		personaDAO.agregar(persona);
	}
}
