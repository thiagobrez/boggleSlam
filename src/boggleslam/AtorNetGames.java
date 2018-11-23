import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetGames implements OuvidorProxy {

	protected AtorJogador atorJogador;
	protected Proxy proxy;

	public AtorNetGames(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		this.proxy = Proxy.getInstance();
		proxy.addOuvinte(this);	
	}
	
	/**
	 * 
	 * @param servidor
	 * @param nome
	 */
	public boolean conectar(String servidor, String nome) {
		try {
			proxy.conectar(servidor, nome);
			return true;
		} catch (JahConectadoException e) {
//			JOptionPane.showMessageDialog(atorJogador.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (NaoPossivelConectarException e) {
//			JOptionPane.showMessageDialog(atorJogador.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (ArquivoMultiplayerException e) {
//			JOptionPane.showMessageDialog(atorJogador.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean desconectar() {
		try {
			proxy.desconectar();
			return true;
		} catch (NaoConectadoException e) {
//			JOptionPane.showMessageDialog(atorJogador.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void iniciarPartida() {
		try {
			proxy.iniciarPartida(new Integer(4));
		} catch (NaoConectadoException e) {
//			JOptionPane.showMessageDialog(atorJogador.informarJanela(), e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param posicao
	 */
//	public void iniciarNovaPartida(int posicao) {
//		// TODO - implement AtorNetGames.iniciarNovaPartida
//		throw new UnsupportedOperationException();
//	}

	/**
	 * 
	 * @param lance
	 */
	public void enviarJogada(Jogada lance) {
		try {
			proxy.enviaJogada(lance);
		} catch (NaoJogandoException e) {
//			JOptionPane.showMessageDialog(atorJogador.informarJanela(), e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param jogada
	 */
	@Override
	public void receberJogada(Jogada jogada) {
		Lance estado = (Lance) jogada;
		atorJogador.receberJogada(estado);
	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		atorJogador.iniciarNovaPartida(posicao);
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