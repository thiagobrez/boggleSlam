package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class AtorJogador {

	protected Mesa mesa;
	protected ArrayList<Carta> cartas;
	protected String idJogador;
	protected AtorNetGames rede;
	protected GerenciadorPersistencia gerenciadorPersistencia;
	protected InterfaceBoggleSlam interfaceBoggleSlam;
	protected int posicao;

	public AtorJogador(InterfaceBoggleSlam interfaceBoggleSlam) {
		this.mesa = new Mesa();
		this.rede = new AtorNetGames(this);
		this.interfaceBoggleSlam = interfaceBoggleSlam;
	}
	
	public int conectar() {
		boolean conectado = mesa.informarConectado();
		
		if(!conectado) {
			String servidor = interfaceBoggleSlam.obterServidor();
			idJogador = interfaceBoggleSlam.obterIdJogador();
			
			System.out.println("servidor:" + servidor);
			System.out.println("idJogador: " + idJogador);
			
			boolean exito = rede.conectar(servidor, idJogador);
			
			System.out.println("exito:" + exito);
			
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
		boolean conectado = mesa.informarConectado();
		
		if(conectado) {
			boolean exito = rede.desconectar();
			
			if(exito) {
				mesa.estabelecerConectado(false);
				return 3;
			} else {
				return 5;
			}
			
		}
		return 4;
	}

	public int iniciarPartida() {
		boolean emAndamento = mesa.informarEmAndamento();
		boolean interromper = false;
		boolean conectado = false;
		
		if(emAndamento) {
			interromper = avaliarInterrupcao();
		} else {
			conectado = mesa.informarConectado();
		}
		
		if(interromper || (!emAndamento && conectado)) {
			rede.iniciarPartida();
			return 6;
		}
		
		if(!conectado) {
			return 7;
		}
		return 13;
	}

	public boolean avaliarInterrupcao() {
		return true;
	}

	public boolean verificaPrimeiroLance(Jogada jogada) {
		return jogada instanceof PrimeiroLance;
	}
	
	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		boolean primeiroLance = verificaPrimeiroLance(jogada);
		
		if(primeiroLance) {
			setMesa(((PrimeiroLance) jogada).getMesa());
			setCartas(((PrimeiroLance) jogada).getMesa().getJogadores().get(this.posicao).getCartas());
		} else {
			atualizarMesa((Lance) jogada);
		}
		
		interfaceBoggleSlam.exibirEstado();
	}

	public String preparaStringFormada(Carta cartaJogada, int cartaSubstituida) {
		String stringAntiga = "";
		
		for(Carta cartaMesa : this.mesa.getCartas()) {
			stringAntiga = stringAntiga + Character.toString(cartaMesa.getLetra());
		}
		
		char[] stringAntigaChars = stringAntiga.toCharArray();
		stringAntigaChars[cartaSubstituida] = cartaJogada.getLetra();
		
		return String.valueOf(stringAntigaChars);
	}
	
	public void click(Carta cartaJogada, int cartaSubstituida) {
		String stringFormada = preparaStringFormada(cartaJogada, cartaSubstituida);
		
		Lance lance = new Lance(
				this.posicao,
				cartaJogada,
				cartaSubstituida,
				stringFormada
		);
		
		int codigo = this.mesa.lance(lance);
		
		switch(codigo) {
			case 0: this.interfaceBoggleSlam.notificarVencedor(idJogador);
			case 1: this.interfaceBoggleSlam.notificarNaoDaVez();
			//Cases do desafio
		}
	}

	public InterfaceBoggleSlam getInterfaceBoggleSlam() {
		return interfaceBoggleSlam;
	}

	public void setInterfaceBoggleSlam(InterfaceBoggleSlam interfaceBoggleSlam) {
		this.interfaceBoggleSlam = interfaceBoggleSlam;
	}
	
	/**
	 * 
	 * @param mesa
	 */
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	/**
	 * 
	 * @param cartas
	 */
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	/**
	 * 
	 * @param lance
	 */
	public void atualizarMesa(Lance lance) {
		this.mesa.cartas.set(lance.getCartaSubstituida(), lance.getCartaJogada());
	}

	/**
	 * 
	 * @param posicao
	 */
	public void iniciarNovaPartida(int posicao) {
		this.posicao = posicao;
		
		if(posicao == 1) {
			ArrayList<Jogador> jogadores = new ArrayList<>();
			ArrayList<String> nomesAdversarios = rede.obterNomeAdversarios();
			
			for(int i = 1; i <= 4; i++) {
				jogadores.add(new Jogador(i, nomesAdversarios.get(i)));
			}
			
//			Mesa mesa = new Mesa(jogadores);
//			this.mesa = mesa;

			this.mesa.setJogadores(jogadores);

			this.cartas = this.mesa.getJogadores().get(this.posicao).getCartas();
			
			PrimeiroLance primeiroLance = new PrimeiroLance(mesa);
			
			rede.enviarJogada(primeiroLance);
		}
		
		interfaceBoggleSlam.exibirEstado();
	}

}