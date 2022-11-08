package modelo;

public class Usuario {
	int id;
	String Municipio;
	String nombre;
	int Grupo;
	String Carrera;
	
	public Usuario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGrupo() {
		return Grupo;
	}

	public void setGrupo(int grupo) {
		Grupo = grupo;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	
}
