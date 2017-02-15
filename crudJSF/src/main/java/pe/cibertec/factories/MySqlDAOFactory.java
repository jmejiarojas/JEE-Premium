package pe.cibertec.factories;

import pe.cibertec.dao.PersonaDAO;
import pe.cibertec.mysql.MySqlPersonaDao;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public PersonaDAO getPersonaDAO() {
		return new MySqlPersonaDao();
	}

}
