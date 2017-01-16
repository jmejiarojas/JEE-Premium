package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaDAO {
	
	void agregar(Persona persona);
	void eliminar(int id);
	void actualizar(Persona persona);
	List<Persona> listarTodos();
	Persona listarPorId(int id);
}
