package view;


public class CuentaView {
	private int numero;
	private float saldo;
	private ClienteView cliente;
	
	public CuentaView(int numero, float saldo, ClienteView cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public ClienteView getCliente() {
		return cliente;
	}

	public void setCliente(ClienteView cliente) {
		this.cliente = cliente;
	}
}
