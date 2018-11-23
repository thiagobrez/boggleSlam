import br.ufsc.inf.leobr.cliente.Jogada;

public class PrimeiroLance implements Jogada {

	protected Mesa mesa;

	public PrimeiroLance(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}	
}