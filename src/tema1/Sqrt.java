//package tema1;
/**
 * Clasa ce calculeaza radicalul unui numar.
 * @author Mocanu Alexandru
 *
 */
public class Sqrt implements Proces {

	public int Actiune(int numar) {
		return (int) Math.sqrt(Math.abs(numar));
	}

	public String toName() {
		return "Sqrt";
	}
}
