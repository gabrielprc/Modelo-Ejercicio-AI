package implementacion;

import view.ClienteView;

public class Cliente {
	private String nombre;
	private String dni;
	
	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean sosElCliente(String dni) {
		return this.dni.equals(dni);
	}
	
	public ClienteView generarView() {
		return new ClienteView(dni, nombre);
	}
}
