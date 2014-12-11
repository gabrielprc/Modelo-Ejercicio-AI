package view;

public class ClienteView {
	private String dni;
	private String nombre;
	
	public ClienteView(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
