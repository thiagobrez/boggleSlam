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
public class Voto implements Jogada {
	
	protected boolean aprovado;

	public Voto(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isAprovado() {
		return aprovado;
	}
}
