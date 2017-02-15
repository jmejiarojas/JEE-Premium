package pe.cibertec.service;

import java.util.List;

import pe.cibertec.dao.PersonaDAO;
import pe.cibertec.factories.DAOFactory;
import pe.cibertec.models.Persona;

public class servicePersona {

	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
	PersonaDAO daoPersona = factory.getPersonaDAO();

	public void agregar(Persona persona) {
		daoPersona.agregar(persona);
	}

	public void eliminar(Integer id) {
		daoPersona.eliminar(id);
	}

	public void actualizar(Persona persona) {
		daoPersona.actualizar(persona);
	}

	public List<Persona> listarTodos() {
		return daoPersona.listarTodos();
	}

	public Persona listarPorId(Integer id) {
		return daoPersona.listarPorId(id);
	}
}
