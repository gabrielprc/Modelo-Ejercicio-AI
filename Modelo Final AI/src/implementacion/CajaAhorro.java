package implementacion;

public class CajaAhorro extends Cuenta {
	private float intereses;
	
	public CajaAhorro(int numero, float saldo, float intereses, Cliente cliente) {
		super(numero, saldo, cliente);
		this.intereses = intereses;
	}
	
	public float getIntereses() {
		return intereses;
	}

	public void setIntereses(float intereses) {
		this.intereses = intereses;
	}

	@Override
	public float getSaldo() {
		return saldo + saldo * intereses;
	}
	
}
