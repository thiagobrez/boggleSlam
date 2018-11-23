public class InterfaceBoggleSlam extends JFrame {

	protected AtorJogador atorJogador;

	public InterfaceBoggleSlam() {
		this.atorJogador = new AtorJogador(this);
	}
	
	public void conectar() {
		int resultado = atorJogador.conectar();
		this.notificarResultado(resultado);
	}

	public String obterServidor() {
		String idServidor = ("netgames.labsoft.ufsc.br");
//		idServidor = JOptionPane.showInputDialog(this, ("Insira o endereço do servidor"), idServidor);
		return idServidor;
	}

	public String obterIdJogador() {
		String idJogador = ("jogador");
//		idJogador = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
		return idJogador;
	}

	/**
	 * 
	 * @param resultado
	 */
	public void notificarResultado(int resultado) {
//		switch (resultado) {
//			case 0:  JOptionPane.showMessageDialog(this, "Conex�o efetuada com exito"); break;        	
//			case 1:  JOptionPane.showMessageDialog(this, "Tentativa de conex�o com conex�o previamente estabelecida"); break;
//			case 2:  JOptionPane.showMessageDialog(this, "Tentativa de conexao falhou"); break;
//			case 3:  JOptionPane.showMessageDialog(this, "Desonex�o efetuada com exito"); break;
//			case 4:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao sem conexao previamente estabelecida"); break;
//			case 5:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao falhou"); break;
//			case 6:  JOptionPane.showMessageDialog(this, "Solicita��o de inicio procedida com �xito"); break;
//			case 7:  JOptionPane.showMessageDialog(this, "Tentativa de inicio sem conexao previamente estabelecida"); break;
//			case 8:  JOptionPane.showMessageDialog(this, "N�o � a sua vez"); break;
//			case 9:  JOptionPane.showMessageDialog(this, "Partida encerrada"); break;
//			case 10: JOptionPane.showMessageDialog(this, "Lance OK"); break;
//			case 11: JOptionPane.showMessageDialog(this, "Posi��o ocupada"); break;
//			case 12: JOptionPane.showMessageDialog(this, "Posi��o ilegal"); break;
//			case 13: JOptionPane.showMessageDialog(this, "Partida corrente n�o interrompida"); break;
//		};
	}

	public void desconectar() {
		int resultado = atorJogador.desconectar();
		this.notificarResultado(resultado);
	}

	public void iniciarPartida() {
		int resultado = atorJogador.iniciarPartida();
		this.notificarResultado(resultado);
	}

	public void exibeMensagemDesafioAprovado() {
		// TODO - implement InterfaceBoggleSlam.exibeMensagemDesafioAprovado
		throw new UnsupportedOperationException();
	}

	public void exibeMensagemDesafioNegado() {
		// TODO - implement InterfaceBoggleSlam.exibeMensagemDesafioNegado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param carta
	 */
	public int click(int carta) {
		// TODO - implement InterfaceBoggleSlam.click
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lance
	 */
	public void lance(ILance lance) {
		// TODO - implement InterfaceBoggleSlam.lance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogador
	 */
	public void notificarVencedor(Jogador jogador) {
		// TODO - implement InterfaceBoggleSlam.notificarVencedor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cod
	 */
	public void notificarIrregularidade(int cod) {
		// TODO - implement InterfaceBoggleSlam.notificarIrregularidade
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indexJogador
	 */
	public void passarTurno(int indexJogador) {
		// TODO - implement InterfaceBoggleSlam.passarTurno
		throw new UnsupportedOperationException();
	}

	public void exibirEstado() {
		// TODO - implement InterfaceBoggleSlam.exibirEstado
		throw new UnsupportedOperationException();
	}

}