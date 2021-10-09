package model;

public class Banda {
	private int id;
	private String nombre;
	private int genero_id;
	private int calificacion;
	
	public Banda(String nombre, int genero_id, int calificacion) {
		super();
		this.nombre = nombre;
		this.genero_id = genero_id;
		this.calificacion = calificacion;
	}

	public Banda(int id, String nombre, int genero_id, int calificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero_id = genero_id;
		this.calificacion = calificacion;
	}
	
	@Override
	public String toString() {
		return "[" + this.id + "] " + this.nombre + " - " + this.calificacion + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGenero_id() {
		return genero_id;
	}

	public void setGenero_id(int genero_id) {
		this.genero_id = genero_id;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}
