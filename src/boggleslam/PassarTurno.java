/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author thiagobrezinski
 */
public class PassarTurno implements Jogada {
	
	protected int indexJogador;

	public PassarTurno(int indexJogador) {
		this.indexJogador = indexJogador;
	}

	public int getIndexJogador() {
		return indexJogador;
	}
}
