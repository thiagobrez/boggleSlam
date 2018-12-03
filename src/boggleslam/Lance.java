package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {

	protected int indexJogador;
	protected Carta cartaJogada;
	protected int cartaSubstituida;
	protected String stringFormada;
	protected boolean valido;
	protected boolean desafiado;

	public Lance(int indexJogador, Carta cartaJogada, int cartaSubstituida, String stringFormada) {
		this.indexJogador = indexJogador;
		this.cartaJogada = cartaJogada;
		this.cartaSubstituida = cartaSubstituida;
		this.stringFormada = stringFormada;
		this.valido = false;
		this.desafiado = false;
	}

	public int getIndexJogador() {
		return indexJogador;
	}

	public void setIndexJogador(int indexJogador) {
		this.indexJogador = indexJogador;
	}

	public Carta getCartaJogada() {
		return cartaJogada;
	}

	public void setCartaJogada(Carta cartaJogada) {
		this.cartaJogada = cartaJogada;
	}

	public int getCartaSubstituida() {
		return cartaSubstituida;
	}

	public void setCartaSubstituida(int cartaSubstituida) {
		this.cartaSubstituida = cartaSubstituida;
	}

	public String getStringFormada() {
		return stringFormada;
	}

	public void setStringFormada(String stringFormada) {
		this.stringFormada = stringFormada;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public boolean isDesafiado() {
		return desafiado;
	}

	public void setDesafiado(boolean desafiado) {
		this.desafiado = desafiado;
	}
}