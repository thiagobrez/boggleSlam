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
public class Persistencia implements Jogada {
	
	protected String palavra;

	public Persistencia(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavra() {
		return palavra;
	}	
}
