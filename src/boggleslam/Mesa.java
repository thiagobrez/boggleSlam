package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class Mesa implements Jogada {

	protected Baralho baralho;
	protected ArrayList<Carta> cartas;
	protected ArrayList<Jogador> jogadores;
	protected int jogadorAtual;
	protected boolean partidaEmAndamento;
	protected int turnosPassados;

	public Mesa() {
		this.baralho = new Baralho();
		this.cartas = new ArrayList<>();
		this.jogadorAtual = 0;
		this.partidaEmAndamento = true;
		this.turnosPassados = 0;
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

	public int getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(int jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public int getTurnosPassados() {
		return turnosPassados;
	}

	public void setTurnosPassados(int turnosPassados) {
		this.turnosPassados = turnosPassados;
	}

	public boolean verificaDaVez(int indexJogador) {
		return this.jogadorAtual == indexJogador;
	}

	public void substituirCartas(Carta cartaJogada, int cartaSubstituida) {
		this.cartas.set(cartaSubstituida, cartaJogada);
	}

	public Lance lance(Lance lance) {
		String palavra = GerenciadorPersistencia.getInstance().get(lance.getStringFormada());

		if(palavra != null) {
			this.turnosPassados = 0;
			lance.setValido(true);
			substituirCartas(lance.getCartaJogada(), lance.getCartaSubstituida());
			this.jogadores.get(this.jogadorAtual).removerCarta(lance.getCartaJogada());
		} else {
			lance.setDesafiado(true);
		}
		return lance;
	}

	public void passarTurno(int indexJogador) {
		this.turnosPassados++;
		substituiJogadorDaVez(indexJogador);
	}

	public String verificaVencedorTurnoPassado(int indexJogador) {
		int menorNumeroCartas = 100;
		int indexVencedor = -1;
		
		for(int i = 0; i < this.jogadores.size(); i++) {
			int numeroCartasJogador = this.jogadores.get(i).getCartas().size();
			if(numeroCartasJogador < menorNumeroCartas) {
				menorNumeroCartas = numeroCartasJogador;
				indexVencedor = i;
			}
		}
		
		return this.jogadores.get(indexVencedor).getNome();
	}
	
	public void substituiJogadorDaVez(int indexJogador) {
		if(this.turnosPassados == this.jogadores.size()) {
			this.jogadorAtual = -1;
		} else if(indexJogador == 3) {
			this.jogadorAtual = 0;
		} else {
			this.jogadorAtual = ++indexJogador;	
		}
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
}