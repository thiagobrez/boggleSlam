package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AtorNetGames implements OuvidorProxy {

	protected AtorJogador atorJogador;
	protected Proxy proxy;

	public AtorNetGames(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		this.proxy = Proxy.getInstance();
		proxy.addOuvinte(this);	
	}
	
	public boolean conectar(String servidor, String nome) {
		try {
			proxy.conectar(servidor, nome);
			return true;
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getInterfaceBoggleSlam(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(atorJogador.getInterfaceBoggleSlam(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(atorJogador.getInterfaceBoggleSlam(), e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean desconectar() {
		try {
			proxy.desconectar();
			return true;
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getInterfaceBoggleSlam(), e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void iniciarPartida() {
		try {
			proxy.iniciarPartida(new Integer(4));
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getInterfaceBoggleSlam(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void enviarJogada(Jogada jogada) {
		try {
			proxy.enviaJogada(jogada);
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador.getInterfaceBoggleSlam(), e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void receberJogada(Jogada jogada) {
		atorJogador.receberJogada(jogada);
	}
	
	public ArrayList<String> obterNomeAdversarios() {
		return (ArrayList) proxy.obterNomeAdversarios();
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