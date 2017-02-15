package pe.cibertec.dao;

import java.util.List;

import pe.cibertec.models.Persona;

public interface Dao<Key, Objeto> {
	void agregar(Objeto obj);
	void eliminar(Key llave);
	void actualizar(Objeto obj);
	List<Persona> listarTodos();
	Persona listarPorId(Key llave);
}
