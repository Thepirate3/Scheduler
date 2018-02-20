//package tema1;
/***
 * 
 * Clasa ce simuleaza o celula din cache.
 * @author Mocanu Alexandru
 */
public class Cache {

	private String proces_name = null;
	private int numar;
	private int rezultat;
	private int TIU;

	public String getProces_name() {
		return proces_name;
	}

	public void setProces_name(String proces_name) {
		this.proces_name = proces_name;
	}

	public int getNumar() {
		return numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public int getRezultat() {
		return rezultat;
	}

	public void setRezultat(int rezultat) {
		this.rezultat = rezultat;
	}

	public int getTIU() {
		return TIU;
	}

	public void setTIU(int tIU) {
		TIU = tIU;
	}

	public Cache() {
		super();
	}

}
