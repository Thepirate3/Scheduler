//package tema1;
/***
 * 
 * Clasa ce verifica daca un numar este prim.
 * @author Mocanu Alexandru
 */
public class CheckPrime implements Proces {

	public int Actiune(int numar) {

		if (numar < 2) {
			return 0;
		}
		for (int i = 2; i < numar; i++) {
			if (numar % i == 0)
				return 0;
		}
		return 1;
	}

	public String toName() {
		return "CheckPrime";
	}
}
