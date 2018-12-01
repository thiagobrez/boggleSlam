/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggleslam;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author thiagobrezinski
 */
public class InterfaceBoggleSlam extends javax.swing.JFrame {

	protected AtorJogador atorJogador;
	protected ArrayList<javax.swing.JButton> botoesCartasJogador;
	
	/**
	 * Creates new form NewJFrame
	 */
	public InterfaceBoggleSlam() {
		initComponents();
		this.atorJogador = new AtorJogador(this);
		this.botoesCartasJogador = new ArrayList<>(Arrays.asList(
				this.jButton8,
				this.jButton9,
				this.jButton10,
				this.jButton11,
				this.jButton12,
				this.jButton13,
				this.jButton14,
				this.jButton15,
				this.jButton16,
				this.jButton17,
				this.jButton18,
				this.jButton19
		));
	}
	
	public void conectar() {
		int resultado = atorJogador.conectar();
		this.notificarResultado(resultado);
	}

	public String obterServidor() {
		String idServidor = ("localhost");
		idServidor = JOptionPane.showInputDialog(this, ("Insira o endereço do servidor"), idServidor);
		return idServidor;
	}

	public String obterIdJogador() {
		String idJogador = ("jogador");
		idJogador = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
		return idJogador;
	}

	/**
	 * 
	 * @param resultado
	 */
	public void notificarResultado(int resultado) {
		switch (resultado) {
			case 0:  JOptionPane.showMessageDialog(this, "Conexão efetuada com êxito"); break;
			case 1:  JOptionPane.showMessageDialog(this, "Tentativa de conexão com conexão previamente estabelecida"); break;
			case 2:  JOptionPane.showMessageDialog(this, "Tentativa de conexão falhou"); break;
			case 3:  JOptionPane.showMessageDialog(this, "Desconexão efetuada com êxito"); break;
			case 4:  JOptionPane.showMessageDialog(this, "Tentativa de desconexão sem conexão previamente estabelecida"); break;
			case 5:  JOptionPane.showMessageDialog(this, "Tentativa de desconexão falhou"); break;
			case 6:  JOptionPane.showMessageDialog(this, "Solicitação de início procedida com êxito"); break;
			case 7:  JOptionPane.showMessageDialog(this, "Tentativa de início sem conexão previamente estabelecida"); break;
			case 8:  JOptionPane.showMessageDialog(this, "Não é a sua vez"); break;
			case 9:  JOptionPane.showMessageDialog(this, "Partida encerrada"); break;
			case 10: JOptionPane.showMessageDialog(this, "Lance OK"); break;
			case 11: JOptionPane.showMessageDialog(this, "Posição ocupada"); break;
			case 12: JOptionPane.showMessageDialog(this, "Posição ilegal"); break;
			case 13: JOptionPane.showMessageDialog(this, "Partida corrente não interrompida"); break;
		};
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
	 * @param cartaJogada
	 * @param cartaSubstituida
	 */
	public void click(Carta cartaJogada, int cartaSubstituida) {
		atorJogador.click(cartaJogada, cartaSubstituida);
	}

	/**
	 * 
	 * @param cartaJogada
	 * @param cartaSubstituida
	 */
	public void lance(Carta cartaJogada, int cartaSubstituida) {
		// TODO - implement InterfaceBoggleSlam.lance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nomeJogador
	 */
	public void notificarVencedor(String nomeJogador) {
		// TODO - implement InterfaceBoggleSlam.notificarVencedor
		throw new UnsupportedOperationException();
	}

	public void notificarNaoDaVez() {
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
		Mesa mesa = atorJogador.getMesa();
		ArrayList<Carta> cartas = atorJogador.getCartas();
		
		jButton4.setText(Character.toString(mesa.getCartas().get(0).getLetra()));
		jButton5.setText(Character.toString(mesa.getCartas().get(1).getLetra()));
		jButton6.setText(Character.toString(mesa.getCartas().get(2).getLetra()));
		jButton7.setText(Character.toString(mesa.getCartas().get(3).getLetra()));
		
		for(int i = 0; i < this.botoesCartasJogador.size(); i++) {
			if(cartas.get(i) != null) {
				this.botoesCartasJogador.get(i).setVisible(true);
				this.botoesCartasJogador.get(i).setText(Character.toString(cartas.get(i).getLetra()));
			} else {
				this.botoesCartasJogador.get(i).setVisible(false);
			}
		}
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelMenuPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanelMesa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanelFimDeJogo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jPanelRegras = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel1.setText("BEM VINDO AO BOGGLE SLAM!");

        jButton1.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton1.setText("Ler Regras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton3.setText("Jogar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuPrincipalLayout = new javax.swing.GroupLayout(jPanelMenuPrincipal);
        jPanelMenuPrincipal.setLayout(jPanelMenuPrincipalLayout);
        jPanelMenuPrincipalLayout.setHorizontalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1))
                    .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton1)
                        .addGap(128, 128, 128)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanelMenuPrincipalLayout.setVerticalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel2.setText("Selecione a carta que deseja substituir:");

        jButton4.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton4.setText("A");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton5.setText("A");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton6.setText("A");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton7.setText("A");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jLabel3.setText("Selecione a carta que deseja jogar:");

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("A");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("A");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setText("A");

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("A");

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("A");

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setText("A");

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton14.setText("A");

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton15.setText("A");

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setText("A");

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton17.setText("A");

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton18.setText("A");

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton19.setText("A");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton20.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton20.setText("JOGAR");

        jButton21.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton21.setText("PASSAR");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("ENCERRAR JOGO");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMesaLayout = new javax.swing.GroupLayout(jPanelMesa);
        jPanelMesa.setLayout(jPanelMesaLayout);
        jPanelMesaLayout.setHorizontalGroup(
            jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMesaLayout.createSequentialGroup()
                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanelMesaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(73, 73, 73)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanelMesaLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMesaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton22)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelMesaLayout.setVerticalGroup(
            jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMesaLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelMesaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addGroup(jPanelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelMesaLayout.createSequentialGroup()
                                .addComponent(jButton20)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMesaLayout.createSequentialGroup()
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanelFimDeJogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel4.setText("BOGGLE SLAM!");

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel5.setText("FIM DE JOGO");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Obrigado por jogar.");

        jButton23.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton23.setText("Jogar Novamente");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFimDeJogoLayout = new javax.swing.GroupLayout(jPanelFimDeJogo);
        jPanelFimDeJogo.setLayout(jPanelFimDeJogoLayout);
        jPanelFimDeJogoLayout.setHorizontalGroup(
            jPanelFimDeJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFimDeJogoLayout.createSequentialGroup()
                .addGroup(jPanelFimDeJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFimDeJogoLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel5))
                    .addGroup(jPanelFimDeJogoLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel4))
                    .addGroup(jPanelFimDeJogoLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(jPanelFimDeJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton23)
                            .addComponent(jLabel6))))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanelFimDeJogoLayout.setVerticalGroup(
            jPanelFimDeJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFimDeJogoLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel4)
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jButton23)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jPanelRegras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jButton2.setText("Entendi!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanelRegrasLayout = new javax.swing.GroupLayout(jPanelRegras);
        jPanelRegras.setLayout(jPanelRegrasLayout);
        jPanelRegrasLayout.setHorizontalGroup(
            jPanelRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegrasLayout.createSequentialGroup()
                .addGroup(jPanelRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegrasLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jButton2))
                    .addGroup(jPanelRegrasLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanelRegrasLayout.setVerticalGroup(
            jPanelRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegrasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanelMenuPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelMesa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelFimDeJogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelRegras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelRegras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(159, 159, 159)
                    .addComponent(jPanelFimDeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelRegras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFimDeJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jMenu1.setText("Menu");
        jMenu1.setToolTipText("");

        jMenuItem1.setText("Conectar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Desconectar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Iniciar partida");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		conectar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desconectar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        iniciarPartida();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanelMenuPrincipal.setVisible(false);
        jPanelRegras.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanelRegras.setVisible(false);
        jPanelMenuPrincipal.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(this.atorJogador.isConectado()) {
			jPanelMenuPrincipal.setVisible(false);
			jPanelMenuPrincipal.setVisible(false);	
		} else {
			JOptionPane.showMessageDialog(this, "Conexão não estabelecida!");
		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jPanelMesa.setVisible(false);
        jPanelFimDeJogo.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jPanelFimDeJogo.setVisible(false);
        jPanelMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton23ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(InterfaceBoggleSlam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InterfaceBoggleSlam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InterfaceBoggleSlam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InterfaceBoggleSlam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfaceBoggleSlam().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanelFimDeJogo;
    private javax.swing.JPanel jPanelMenuPrincipal;
    private javax.swing.JPanel jPanelMesa;
    private javax.swing.JPanel jPanelRegras;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
