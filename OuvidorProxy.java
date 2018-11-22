public interface OuvidorProxy {

	/**
	 * 
	 * @param posicao
	 */
	void iniciarNovaPartida(int posicao);

	/**
	 * 
	 * @param message
	 */
	void finalizarPartidaComErro(string message);

	/**
	 * 
	 * @param message
	 */
	void receberMensagem(string message);

	/**
	 * 
	 * @param jogada
	 */
	void receberJogada(Jogada jogada);

	void tratarConexaoPerdida();

	/**
	 * 
	 * @param message
	 */
	void tratarPartidaNaoIniciada(string message);

}