//package tema1;
/**
 * 
 * Clasa ce calculeaza an n-lea termen fibonacci.
 * @author Mocanu Alexandru
 *
 */
public class Fibonacci implements Proces {

	public int Actiune(int numar) {

		if (numar < 0)
			return -1;
		if (numar == 0)
			return numar;
		if (numar == 1)
			return numar;
		int vecin1 = 0;
		int vecin2 = 1;
		int nr_cautat = 0;

		for (int i = 0; i < numar - 1; i++) {
			nr_cautat = (vecin1 % 9973 + vecin2 % 9973) % 9973;
			vecin1 = vecin2;
			vecin2 = nr_cautat;
		}

		return nr_cautat;

	}

	public String toName() {
		return "Fibonacci";
	}

}
