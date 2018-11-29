package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Carta implements Jogada {

	protected char letra;

	public Carta(char letra) {
		this.letra = letra;
	}

	public char getLetra() {
		return letra;
	}
	
}