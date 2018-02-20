//package tema1;
/**
 * Clasa ce implementeaza tipul LRU de cache.
 * @author Mocanu Alexandru
 *
 */
public class LruCache implements CacheType {

	Cache[] vector;
	int poz_ocupate = -1;

	public LruCache(int numar) {
		vector = new Cache[numar];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Cache();
		}
	}

	private int Search_maxTIU() {
		int maxim = 0;
		if (poz_ocupate != 0) {
			for (int i = 0; i < vector.length; i++) {
				if (maxim < vector[i].getTIU()) {
					maxim = vector[i].getTIU();

				}
			}
			return maxim;
		}
		return 0;
	}

	private int Search_minTIU() {
		int minim = vector[0].getTIU();
		int index = 0;
		if (poz_ocupate != 0) {
			for (int i = 1; i < vector.length; i++) {
				if (minim > vector[i].getTIU()) {
					minim = vector[i].getTIU();
					index = i;

				}
			}
			return index;
		}
		return 0;
	}

	public int Check(String nume_proc, int numar) {

		for (int i = 0; i < vector.length; i++) {
			if (vector[i].getNumar() == numar) {
				if (vector[i].getProces_name().equals(nume_proc)) {
					vector[i].setTIU(Search_maxTIU() + 1);
					return vector[i].getRezultat();
				}
			}
		}
		return -1;
	}

	public void Add(int numar, String proc, int rezultat) {

		if (poz_ocupate == vector.length - 1) {
			vector[Search_minTIU()].setNumar(numar);
			vector[Search_minTIU()].setProces_name(proc);
			vector[Search_minTIU()].setRezultat(rezultat);
			vector[Search_minTIU()].setTIU(Search_maxTIU() + 1);

		} else {
			poz_ocupate++;
			vector[poz_ocupate].setNumar(numar);
			vector[poz_ocupate].setProces_name(proc);
			vector[poz_ocupate].setRezultat(rezultat);
			vector[poz_ocupate].setTIU(Search_maxTIU() + 1);
		}

	}
}
