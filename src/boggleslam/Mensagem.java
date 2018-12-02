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
public class Mensagem implements Jogada {
	
	protected int codigo;
	protected String texto;

	public Mensagem(int codigo) {
		this.codigo = codigo;
	}

	public Mensagem(int codigo, String texto) {
		this.codigo = codigo;
		this.texto = texto;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getTexto() {
		return texto;
	}
}
