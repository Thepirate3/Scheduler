//package tema1;
/**
 * Clasa ce calculeaza patratul unui numar.
 * @author Mocanu Alexandru
 *
 */
public class Square implements Proces {

	public int Actiune(int numar) {

		return numar * numar;
	}

	public String toName() {
		return "Square";
	}

}
