//package tema1;
/**
 * Clasa ce calculeaza urmatorul numar prim dupa numarul curent.
 * @author Mocanu Alexandru
 *
 */
public class NextPrime implements Proces {

	public int Actiune(int numar) {

		if (numar < 2) {
			return 2;
		}
		int prim_cautat = numar;
		int contor = 0;
		while (true) {

			prim_cautat++;
			for (int i = 2; i < prim_cautat; i++) {

				if (prim_cautat % i == 0) {
					contor = 0;
					break;
				}

				else
					contor++;

			}
			if (contor == prim_cautat - 2) {

				return prim_cautat;
			}
		}
	}

	public String toName() {
		return "NextPrime";
	}
}
