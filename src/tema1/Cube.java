//package tema1;
/**
 * 
 * Clasa ce calculeaza cubul unui numar.
 * 
 * @author Mocanu Alexandru
 *
 */
public class Cube implements Proces {

	public int Actiune(int numar) {
		return numar * numar * numar;
	}

	public String toName() {
		return "Cube";
	}

}
