
import br.ufsc.inf.leobr.cliente.Jogada;

public class AtorJogador {

	protected Mesa mesa;
	protected int idJogador;
	protected AtorNetGames rede;
	protected GerenciadorPersistencia gerenciadorPersistencia;
	protected InterfaceBoggleSlam interfaceBoggleSlam;
	protected String nomeJogador;

	public AtorJogador(
			Mesa mesa,
			int idJogador,
			AtorNetGames rede,
			GerenciadorPersistencia gerenciadorPersistencia,
			InterfaceBoggleSlam interfaceBoggleSlam
	) {
		this.mesa = mesa;
		this.idJogador = idJogador;
		this.rede = rede;
		this.gerenciadorPersistencia = gerenciadorPersistencia;
		this.interfaceBoggleSlam = interfaceBoggleSlam;
	}
	
	public int conectar() {
		boolean conectado = mesa.informarConectado();
		
		if(!conectado) {
			String servidor = interfaceBoggleSlam.obterServidor();
			nomeJogador = interfaceBoggleSlam.obterNomeJogador();
			boolean exito = rede.conectar(servidor, nomeJogador);
			
			if(exito) {
				mesa.estabelecerConectado(true);
				return 0;
			} else {
				return 2;
			}
		}
		return 1;
	}

	public int desconectar() {
		// TODO - implement AtorJogador.desconectar
		throw new UnsupportedOperationException();
	}

	public int iniciarPartida() {
		// TODO - implement AtorJogador.iniciarPartida
		throw new UnsupportedOperationException();
	}

	public boolean avaliarInterrupcao() {
		// TODO - implement AtorJogador.avaliarInterrupcao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param carta
	 */
	public void click(int carta) {
		// TODO - implement AtorJogador.click
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		// TODO - implement AtorJogador.receberJogada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mesa
	 */
	public void guardarMesa(Mesa mesa) {
		// TODO - implement AtorJogador.guardarMesa
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cartas
	 */
	public void guardarCartas(Carta[] cartas) {
		// TODO - implement AtorJogador.guardarCartas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mesa
	 */
	public void atualizarMesa(Mesa mesa) {
		// TODO - implement AtorJogador.atualizarMesa
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicao
	 */
	public void iniciarNovaPartida(int posicao) {
		// TODO - implement AtorJogador.iniciarNovaPartida
		throw new UnsupportedOperationException();
	}

}