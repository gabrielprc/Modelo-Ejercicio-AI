package implementacion;

import view.CuentaView;

public abstract class Cuenta {
	protected int numero;
	protected float saldo;
	protected Cliente cliente;
	
	protected Cuenta(int numero, float saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public abstract float getSaldo();
	
	public CuentaView generarView() {
		return new CuentaView(numero, getSaldo(), cliente.generarView());
	}
	
	public boolean sosDelCliente(Cliente cliente) {
		return this.cliente.sosElCliente(cliente.getDni());
	}
}
