public class AtorNetGames implements OuvidorProxy {

	protected AtorJogador interfaceGrafica;
	protected Proxy proxy;

	/**
	 * 
	 * @param servidor
	 * @param nome
	 */
	public boolean conectar(String servidor, String nome) {
		// TODO - implement AtorNetGames.conectar
		throw new UnsupportedOperationException();
	}

	public boolean desconectar() {
		// TODO - implement AtorNetGames.desconectar
		throw new UnsupportedOperationException();
	}

	public void iniciarPartida() {
		// TODO - implement AtorNetGames.iniciarPartida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		// TODO - implement AtorNetGames.receberJogada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicao
	 */
	public void iniciarNovaPartida(int posicao) {
		// TODO - implement AtorNetGames.iniciarNovaPartida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param primeiroLance
	 */
	public void enviarJogada(Jogada primeiroLance) {
		// TODO - implement AtorNetGames.enviarJogada
		throw new UnsupportedOperationException();
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void receberMensagem(String message) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void tratarConexaoPerdida() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}