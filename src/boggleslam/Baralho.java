
import java.util.ArrayList;

public class Baralho {

	protected ArrayList<Carta> cartas;

	public Baralho() {
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 26; i++) {
				this.cartas.add(new Carta(alfabeto.charAt(j)));
			}
		}
	}
}