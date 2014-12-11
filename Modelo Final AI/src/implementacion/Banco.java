package implementacion;

import java.util.ArrayList;
import java.util.List;

import persistencia.AdministradorPersistenciaCliente;
import persistencia.AdministradorPersistenciaCuenta;
import view.ClienteView;
import view.CuentaView;

public class Banco {
	private static Banco instancia;
	private List<Cliente> clientes;
	private List<Cuenta> cuentas;
	
	private Banco() {
		clientes = AdministradorPersistenciaCliente.getInstance().buscarClientes();
		cuentas = AdministradorPersistenciaCuenta.getInstance().buscarCuentas();
	}
	
	public static Banco getInstancia() {
		if (instancia == null)
			instancia = new Banco();
		return instancia;
	}
	
	public Cliente buscarCliente(String dni) {
		for (Cliente cliente : clientes) {
			if (cliente.sosElCliente(dni)) 
				return cliente;
		}
		return null;
	}
	
	public ClienteView obtenerCliente(String dni) {
		Cliente cliente = buscarCliente(dni);
		return cliente != null ? cliente.generarView() : null;
	}
	
	public List<CuentaView> obtenerCuentasCliente(String dni) {
		List<CuentaView> cuentasView = new ArrayList<CuentaView>();
		Cliente cliente = buscarCliente(dni);
		for (Cuenta cuenta : cuentas) {
			if (cuenta.sosDelCliente(cliente))
				cuentasView.add(cuenta.generarView());
		}
		return cuentasView;
	}
}
