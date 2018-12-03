package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class AtorJogador {

	protected Mesa mesa;
	protected String idJogador;
	protected AtorNetGames rede;
	protected InterfaceBoggleSlam interfaceBoggleSlam;
	protected int posicao;
	protected boolean conectado;
	protected Desafio lanceDesafiado;

	public AtorJogador(InterfaceBoggleSlam interfaceBoggleSlam) {
		this.mesa = new Mesa();
		this.rede = new AtorNetGames(this);
		this.interfaceBoggleSlam = interfaceBoggleSlam;
		this.conectado = false;
	}
	
	public int conectar() {
		boolean conectado = isConectado();
		
		if(!conectado) {
			String servidor = interfaceBoggleSlam.obterServidor();
			idJogador = interfaceBoggleSlam.obterIdJogador();

			boolean exito = rede.conectar(servidor, idJogador);
			
			if(exito) {
				setConectado(true);
				return 0;
			} else {
				return 2;
			}
		}
		return 1;
	}

	public int desconectar() {
		boolean conectado = isConectado();
		
		if(conectado) {
			boolean exito = rede.desconectar();
			
			if(exito) {
				setConectado(false);
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
			conectado = isConectado();
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
	
	public boolean verificaDesafio(Jogada jogada) {
		return jogada instanceof Desafio;
	}

	public boolean verificaVoto(Jogada jogada) {
		return jogada instanceof Voto;
	}
	
	public boolean verificaMensagem(Jogada jogada) {
		return jogada instanceof Mensagem;
	}
	
	public boolean verificaPersistencia(Jogada jogada) {
		return jogada instanceof Persistencia;
	}
	
	public boolean verificaPassarTurno(Jogada jogada) {
		return jogada instanceof PassarTurno;
	}	
	
	public void receberJogada(Jogada jogada) {
		boolean isPrimeiroLance = verificaPrimeiroLance(jogada);
		boolean isDesafio = verificaDesafio(jogada);
		boolean isVoto = verificaVoto(jogada);
		boolean isMensagem = verificaMensagem(jogada);
		boolean isPersistencia = verificaPersistencia(jogada);
		boolean isPassarTurno = verificaPassarTurno(jogada);
		
		if(isPrimeiroLance) {
			setMesa(((PrimeiroLance) jogada).getMesa());
		} else if(isDesafio) {
			this.mesa.setTurnosPassados(0);
			boolean aprovado = this.interfaceBoggleSlam.exibeDesafio(((Desafio) jogada).getLance().getStringFormada());
			Voto voto = new Voto(aprovado);
			this.rede.enviarJogada(voto);
		} else if(isVoto) {
			Voto voto = (Voto) jogada;
			this.lanceDesafiado.getVotos().add(voto);

			if(this.lanceDesafiado.getVotos().size() == 3) {
				int votosAprovados = 0;

				for(Voto votoIterado : this.lanceDesafiado.getVotos()) {
					if(votoIterado.isAprovado()) votosAprovados++;
				}

				if(votosAprovados >= 2) {
					this.lanceDesafiado.getLance().setValido(true);
//					atualizarMesa(this.lanceDesafiado.getLance());
					GerenciadorPersistencia.getInstance().persistirPalavra(this.lanceDesafiado.getLance().getStringFormada());
					this.rede.enviarJogada(new Persistencia(this.lanceDesafiado.getLance().getStringFormada()));
				}
				
				atualizarMesa(this.lanceDesafiado.getLance());
				this.rede.enviarJogada(this.lanceDesafiado.getLance());
			}
		} else if(isMensagem) {
			Mensagem mensagem = (Mensagem) jogada;
			
			//TODO TROCAR CODIGO PARA VENCEDOR			
			if(mensagem.getCodigo() == 100) {
				this.mesa.setJogadorAtual(-1);
				this.interfaceBoggleSlam.notificarVencedor(mensagem.getTexto());
			} else {
				interfaceBoggleSlam.notificarResultado(((Mensagem) jogada).getCodigo());	
			}
		} else if(isPersistencia) {
			GerenciadorPersistencia.getInstance().persistirPalavra(((Persistencia) jogada).getPalavra());
		} else if(isPassarTurno) {
			this.mesa.passarTurno(((PassarTurno) jogada).getIndexJogador());
		} else {
			Lance lance = (Lance) jogada;
			atualizarMesa(lance);
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
	
	public void lance(Carta cartaJogada, int cartaSubstituida) {
		String stringFormada = preparaStringFormada(cartaJogada, cartaSubstituida);
		
		Lance lance = new Lance(
				this.posicao - 1,
				cartaJogada,
				cartaSubstituida,
				stringFormada
		);
		
		boolean daVez = this.mesa.verificaDaVez(this.posicao - 1);
		
		if(daVez) {
			Lance lanceValidado = this.mesa.lance(lance);
			
			if(lanceValidado.isDesafiado()) {
				this.lanceDesafiado = new Desafio(lanceValidado);
				this.rede.enviarJogada(this.lanceDesafiado);
			} else {
				this.rede.enviarJogada(lanceValidado);
				atualizarMesa(lanceValidado);
				
				boolean vencedor = this.mesa.getJogadores().get(this.posicao - 1).verificaVencedor();
				if(vencedor) {
					this.mesa.setJogadorAtual(-1);
					
					//TODO TROCAR CODIGO VENCEDOR
					this.rede.enviarJogada(new Mensagem(100, this.idJogador));
					this.interfaceBoggleSlam.notificarVencedor(this.idJogador);
				}
			}
		} else {
			//TODO TROCAR CODIGO NAO DA VEZ
			this.interfaceBoggleSlam.notificarResultado(101);
		}
	}

	public void passarTurno() {
		boolean daVez = this.mesa.verificaDaVez(this.posicao - 1);
		
		if(daVez) {
			this.mesa.passarTurno(this.posicao - 1);
			this.rede.enviarJogada(new PassarTurno(this.posicao - 1));
			
			int turnosPassados = this.mesa.getTurnosPassados();
			if(turnosPassados == this.mesa.getJogadores().size()) {
				String jogadorVencedor = this.mesa.verificaVencedorTurnoPassado(this.posicao - 1);
				this.rede.enviarJogada(new Mensagem(100, jogadorVencedor));
				this.interfaceBoggleSlam.notificarVencedor(jogadorVencedor);
			}
			
			this.interfaceBoggleSlam.exibirEstado();
		} else {
			//TODO TROCAR CODIGO NAO DA VEZ
			this.interfaceBoggleSlam.notificarResultado(101);
		}
	}
	
	public InterfaceBoggleSlam getInterfaceBoggleSlam() {
		return interfaceBoggleSlam;
	}

	public void setInterfaceBoggleSlam(InterfaceBoggleSlam interfaceBoggleSlam) {
		this.interfaceBoggleSlam = interfaceBoggleSlam;
	}

	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public int getPosicao() {
		return posicao;
	}

	public void atualizarMesa(Lance lance) {
		if(lance.isValido()) {
			this.mesa.setTurnosPassados(0);
			this.mesa.substituirCartas(lance.getCartaJogada(), lance.getCartaSubstituida());
			this.mesa.getJogadores().get(lance.getIndexJogador()).removerCarta(lance.getCartaJogada());	
		}
		this.mesa.substituiJogadorDaVez(lance.getIndexJogador());
		this.interfaceBoggleSlam.exibirEstado();
	}

	public void iniciarNovaPartida(int posicao) {
		this.posicao = posicao;
		
		if(posicao == 1) {
			ArrayList<Jogador> jogadores = new ArrayList<>();
			jogadores.add(new Jogador(this.posicao, this.idJogador));
			ArrayList<String> nomesAdversarios = rede.obterNomeAdversarios();
			
			for(int i = 0; i < 3; i++) {
				jogadores.add(new Jogador(i + 2, nomesAdversarios.get(i)));
			}

			this.mesa.setJogadores(jogadores);
			this.mesa.distribuirCartas();
			
			PrimeiroLance primeiroLance = new PrimeiroLance(mesa);
			rede.enviarJogada(primeiroLance);
			
			interfaceBoggleSlam.exibirEstado();
		}
		
		interfaceBoggleSlam.comecar();
	}

}