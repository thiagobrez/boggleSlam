package boggleslam;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Baralho implements Jogada {

	protected ArrayList<Carta> cartas;

	public Baralho() {
		this.cartas = new ArrayList<>();
		Random r = new Random();
		int limiteInferior = 0; //inclusivo
		int limiteSuperior = 52; //exclusivo
		int numeroCartas = 52;
		ArrayList<Character> alfabetoDuplo = new ArrayList<>(Arrays.asList(
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'
		));
		
		for(int i = 0; i < numeroCartas; i++) {
			int indiceAleatorio = r.nextInt(limiteSuperior - limiteInferior) + limiteInferior;
			this.cartas.add(new Carta(alfabetoDuplo.get(indiceAleatorio)));
			alfabetoDuplo.remove(indiceAleatorio);
			limiteSuperior--;
		}
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
}