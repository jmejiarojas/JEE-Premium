package pe.cibertec.factories;

import pe.cibertec.dao.PersonaDAO;
import pe.cibertec.postgres.PostgresPersonaDao;

public class PostgresDAOFactory extends DAOFactory{

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PostgresPersonaDao();
	}

}
