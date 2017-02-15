package pe.cibertec.models;

public class Persona {

	private int id;
	private String nombres;
	private String apellidos;

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, String nombres, String apellidos) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombres + ", apellidos=" + apellidos + "]";
	}

}
