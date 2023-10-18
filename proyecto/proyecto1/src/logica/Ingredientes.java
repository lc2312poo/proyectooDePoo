package logica;

public class Ingredientes {

	private int id;
	private String nombre;

	public Ingredientes(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return id;
	}

	public void setCodigo(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}