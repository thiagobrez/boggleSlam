package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class Jogador implements Jogada {

	protected int id;
	protected String nome;
	protected ArrayList<Carta> cartas;
	protected boolean vencedor;
	protected boolean jogadaHabilitada;

	public Jogador(int id, String nome) {
		this.id = id;
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
	public void removerCarta(Carta cartaJogada) {
		this.cartas.remove(cartaJogada);
	}

	public void adicionarCarta(Carta carta) {
		this.cartas.add(carta);
	}
	
	public boolean verificaVencedor() {
		return this.cartas.isEmpty();
	}

}