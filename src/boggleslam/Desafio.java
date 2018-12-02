/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

/**
 *
 * @author thiagobrezinski
 */
public class Desafio implements Jogada {
	
	protected Lance lance;
	protected ArrayList<Voto> votos;

	public Desafio(Lance lance) {
		this.lance = lance;
		this.votos = new ArrayList<>();
	}

	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}

	public ArrayList<Voto> getVotos() {
		return votos;
	}

	public void setVotos(ArrayList<Voto> votos) {
		this.votos = votos;
	}
}
