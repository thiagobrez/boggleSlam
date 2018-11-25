import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class Mesa {

	protected Baralho baralho;
	protected ArrayList<Carta> cartas;
	protected ArrayList<Jogador> jogadores;
	protected int jogadorAtual;
	protected boolean partidaEmAndamento;
	protected boolean conectado;

	public Mesa(ArrayList<Jogador> jogadores) {
		this.baralho = new Baralho();
		this.jogadores = jogadores;
		this.partidaEmAndamento = true;
		distribuirCartas();
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}
	
	public boolean informarConectado() {
		return this.conectado;
	}

	/**
	 * 
	 * @param valor
	 */
	public void estabelecerConectado(boolean valor) {
		this.conectado = valor;
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
				substituirCartas(((Lance) lance).getCartaJogada(), ((Lance) lance).getCartaSubstituida());
				this.jogadores.get(this.jogadorAtual).removerCarta(((Lance) lance).getCartaJogada());
				
				boolean vencedor = this.jogadores.get(this.jogadorAtual).verificaVencedor();
				
				if(vencedor) {
					return 0;
				}
			} else {
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
		// TODO - implement Mesa.distribuirCartas
		throw new UnsupportedOperationException();
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
	public int verificaVotosJogadores(ILance lance) {
		// TODO - implement Mesa.verificaVotosJogadores
		throw new UnsupportedOperationException();
	}

}