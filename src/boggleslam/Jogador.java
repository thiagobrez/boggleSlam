
import java.util.ArrayList;

public class Jogador {

	protected int id;
	protected String nome;
	protected ArrayList<Carta> cartas;
	protected boolean vencedor;
	protected boolean jogadaHabilitada;

	public Jogador(int id, String nome) {
		this.cartas = new ArrayList<>();
		this.vencedor = false;
		this.jogadaHabilitada = false;
	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	/**
	 * 
	 * @param cartaJogada
	 */
	public void removerCarta(int cartaJogada) {
		// TODO - implement Jogador.removerCarta
		throw new UnsupportedOperationException();
	}

	public boolean verificaVencedor() {
		// TODO - implement Jogador.verificaVencedor
		throw new UnsupportedOperationException();
	}

}