package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class Mesa implements Jogada {

	protected Baralho baralho;
	protected ArrayList<Carta> cartas;
	protected ArrayList<Jogador> jogadores;
	protected int jogadorAtual;
	protected boolean partidaEmAndamento;

	public Mesa() {
		this.baralho = new Baralho();
		this.cartas = new ArrayList<>();
		this.partidaEmAndamento = true;
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public boolean informarEmAndamento() {
		return this.partidaEmAndamento;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	/**
	 * 
	 * @param carta
	 */
	public int click(int carta) {
		// TODO - implement Mesa.click
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indexJogador
	 */
	public boolean verificaDaVez(int indexJogador) {
		return this.jogadorAtual == indexJogador;
	}

	/**
	 * 
	 * @param cartaJogada
	 * @param cartaSubstituida
	 */
	public void substituirCartas(Carta cartaJogada, int cartaSubstituida) {
		this.cartas.set(cartaSubstituida, cartaJogada);
	}

	/**
	 * 
	 * @param lance
	 * @return 
	 */
	public int lance(Jogada lance) {
		boolean daVez = verificaDaVez(((Lance) lance).getIndexJogador());
		
		if(daVez) {
			String palavra = GerenciadorPersistencia.getInstance().get(((Lance) lance).getStringFormada());
			
			if(palavra != null) {
				((Lance) lance).setValido(true);
				substituirCartas(((Lance) lance).getCartaJogada(), ((Lance) lance).getCartaSubstituida());
				this.jogadores.get(this.jogadorAtual).removerCarta(((Lance) lance).getCartaJogada());
				
				boolean vencedor = this.jogadores.get(this.jogadorAtual).verificaVencedor();
				
				if(vencedor) {
					return 0;
				}
			} else {
				((Lance) lance).setDesafiado(true);
				return desafio(lance);
			}
		}
		
		return 1;
	}

	/**
	 * 
	 * @param indexJogador
	 */
	public void passarTurno(int indexJogador) {
		// TODO - implement Mesa.passarTurno
		throw new UnsupportedOperationException();
	}

	public void incrementaContadorTurnosPassados() {
		// TODO - implement Mesa.incrementaContadorTurnosPassados
		throw new UnsupportedOperationException();
	}

	public int verificaTurnosPassados() {
		// TODO - implement Mesa.verificaTurnosPassados
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indexJogador
	 */
	public void substituiJogadorDaVez(int indexJogador) {
		// TODO - implement Mesa.substituiJogadorDaVez
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		// TODO - implement Mesa.receberJogada
		throw new UnsupportedOperationException();
	}

	public void distribuirCartas() {
		boolean encontrouJ = false;
		boolean encontrouO = false;
		boolean encontrouG = false;
		boolean encontrouSegundoO = false;
		Carta[] cartasInicioMesa = new Carta[4];
		
		for(int i = 0; i < this.baralho.getCartas().size(); i++) {
			Carta cartaIterada = this.baralho.getCartas().get(i);
			
			if(cartaIterada.getLetra() == 'J' && !encontrouJ) {
				encontrouJ = true;
				cartasInicioMesa[0] = cartaIterada;
				this.baralho.getCartas().remove(cartaIterada);
			} else if(cartaIterada.getLetra() == 'O' && !encontrouO) {
				encontrouO = true;
				cartasInicioMesa[1] = cartaIterada;
				this.baralho.getCartas().remove(cartaIterada);
			} else if(cartaIterada.getLetra() == 'G' && !encontrouG) {
				encontrouG = true;
				cartasInicioMesa[2] = cartaIterada;
				this.baralho.getCartas().remove(cartaIterada);
			} else if(cartaIterada.getLetra() == 'O' && !encontrouSegundoO) {
				encontrouSegundoO = true;
				cartasInicioMesa[3] = cartaIterada;
				this.baralho.getCartas().remove(cartaIterada);
			}
		}
		
		this.cartas.add(cartasInicioMesa[0]);
		this.cartas.add(cartasInicioMesa[1]);
		this.cartas.add(cartasInicioMesa[2]);
		this.cartas.add(cartasInicioMesa[3]);
		
		for(int i = 0; i < this.jogadores.size(); i++) {
			for(int j = 11; j >= 0; j--) {
				this.jogadores.get(i).adicionarCarta(this.baralho.getCartas().get(j));
				this.baralho.getCartas().remove(this.baralho.getCartas().get(j));
			}
		}
	}

	public ArrayList<Carta> getCartas() {
		return this.cartas;
	}

	/**
	 * 
	 * @param lance
	 */
	public int desafio(Jogada lance) {
		// TODO - implement Mesa.desafio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lance
	 */
	public int verificaVotosJogadores(Jogada lance) {
		// TODO - implement Mesa.verificaVotosJogadores
		throw new UnsupportedOperationException();
	}

}