package pe.cibertec.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.cibertec.dao.PersonaDAO;
import pe.cibertec.models.Persona;
import pe.cibertec.util.Conexion;

public class PostgresPersonaDao implements PersonaDAO {

	private Connection cx;

	public PostgresPersonaDao() {
		cx = Conexion.conectar();
	}

	public void agregar(Persona persona) {
		String sql = "INSERT INTO PERSONA(nombres, apellidos) VALUES(?,?)";

		try {
			PreparedStatement pstm = cx.prepareStatement(sql);
			pstm.setString(1, persona.getNombres());
			pstm.setString(2, persona.getApellidos());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminar(Integer id) {
		String sql = "DELETE FROM PERSONA WHERE ID = ?";

		try {
			PreparedStatement pstm = cx.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizar(Persona persona) {
		String sql = "UPDATE PERSONA SET NOMBRES= ?, APELLIDOS= ? WHERE ID = ?";

		try {
			PreparedStatement pstm = cx.prepareStatement(sql);
			pstm.setString(1, persona.getNombres());
			pstm.setString(2, persona.getApellidos());
			pstm.setInt(3, persona.getId());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Persona> listarTodos() {
		List<Persona> listado = new ArrayList<>();
		String sql = "SELECT * FROM PERSONA";
		
		try {
			Statement stm = cx.createStatement();
			ResultSet resultados = stm.executeQuery(sql);
			while(resultados.next()){
				Persona persona = new Persona();
				persona.setId(resultados.getInt("id"));
				persona.setNombres(resultados.getString("nombres"));
				persona.setApellidos(resultados.getString("apellidos"));
				listado.add(persona);
			}
			resultados.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listado;
	}

	public Persona listarPorId(Integer id) {
		String sql = "SELECT * FROM PERSONA WHERE ID = ?";
		Persona persona = null;
		try {
			PreparedStatement pstm = cx.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet resultados = pstm.executeQuery();
			if(resultados.next()){
				 persona = new Persona();
				persona.setId(resultados.getInt("id"));
				persona.setNombres(resultados.getString("nombres"));
				persona.setApellidos(resultados.getString("apellidos"));
			}
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return persona;
	}

}
