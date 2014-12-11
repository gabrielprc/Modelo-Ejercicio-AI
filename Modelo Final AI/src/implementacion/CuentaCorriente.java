package implementacion;

public class CuentaCorriente extends Cuenta {
	private float descubierto;
	
	public CuentaCorriente(int numero, float saldo, float descubierto, Cliente cliente) {
		super(numero, saldo, cliente);
		this.descubierto = descubierto;
	}
	
	@Override
	public float getSaldo() {
		return saldo + descubierto;
	}

	public float getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(float descubierto) {
		this.descubierto = descubierto;
	}

}
