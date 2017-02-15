package pe.cibertec.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pe.cibertec.models.Persona;
import pe.cibertec.service.servicePersona;

@ManagedBean
@SessionScoped
public class PersonaBean {

	private List<Persona> lista;
	private servicePersona service;
	private Persona persona;
	
	public PersonaBean() {
		service = new servicePersona();
		persona = new Persona();
		lista = new ArrayList<>();
		this.listar(); //Cuando se instancie el Bean, ya se llene la lista de Personas.
	}
	
	public void listar() {
		try {
			lista = service.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminar(Persona per){
		try {
			service.eliminar(per.getId());
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registrar(){
		try {
			if(persona.getId()>0){
				service.actualizar(persona);
			}else{
				service.agregar(persona);
			}
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarPorId(Persona per){
		try {
			persona = service.listarPorId(per.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}
	
	public void limpiarControles(){
		persona = new Persona();
	}
}
