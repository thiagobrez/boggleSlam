import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {

	protected Jogador jogador;
	protected Carta cartaJogada;
	protected int cartaSubstituida;
	protected String stringFormada;
	protected boolean valido;
	protected boolean desafiado;

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
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

	public ILance verificaPrimeiroLance() {
		// TODO - implement Lance.verificaPrimeiroLance
		throw new UnsupportedOperationException();
	}

}