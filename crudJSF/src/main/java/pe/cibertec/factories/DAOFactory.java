package pe.cibertec.factories;

import pe.cibertec.dao.PersonaDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int POSTGRES = 2;
	
	public abstract PersonaDAO getPersonaDAO();
	
	public static DAOFactory getDAOFactory(int opcion){
		
		switch (opcion) {
		case MYSQL:
			return new MySqlDAOFactory();
		case POSTGRES:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
}
