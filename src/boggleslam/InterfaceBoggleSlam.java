/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggleslam;

import javax.swing.JOptionPane;

/**
 *
 * @author thiagobrezinski
 */
public class InterfaceBoggleSlam extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	public InterfaceBoggleSlam() {
		initComponents();
		this.atorJogador = new AtorJogador(this);
	}

	protected AtorJogador atorJogador;
	
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
		// TODO - implement InterfaceBoggleSlam.exibirEstado
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		conectar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
