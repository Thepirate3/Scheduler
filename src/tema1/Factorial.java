//package tema1;
/**
 * Clasa ce calculeaza factorialul unui numar.
 * 
 * @author Mocanu Alexandru
 *
 */
public class Factorial implements Proces {

	public int Actiune(int numar) {

		if (numar < 0) {
			return 0;
		}
		int rezultat = 1;
		for (int i = 1; i <= numar; i++) {
			rezultat = ((rezultat % 9973) * (i % 9973)) % 9973;
		}
		return rezultat;
	}

	public String toName() {
		return "Factorial";
	}

}
