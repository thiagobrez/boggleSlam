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
	void finalizarPartidaComErro(String message);

	/**
	 * 
	 * @param message
	 */
	void receberMensagem(String message);

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
	void tratarPartidaNaoIniciada(String message);

}