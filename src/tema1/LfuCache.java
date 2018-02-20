//package tema1;
/**
 * 
 * Clasa ce implementeaza tipul LFU de cache.
 * @author Mocanu Alexandru
 *
 */
public class LfuCache implements CacheType {

	Cache[] vector;
	int poz_ocupate = -1;

	public LfuCache(int numar) {
		vector = new Cache[numar];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Cache();
		}
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
					vector[i].setTIU(vector[i].getTIU() + 1);

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
			vector[Search_minTIU()].setTIU(0);
			vector[Search_minTIU()].setTIU(vector[Search_minTIU()].getTIU() + 1);

		} else {
			poz_ocupate++;
			vector[poz_ocupate].setNumar(numar);
			vector[poz_ocupate].setProces_name(proc);
			vector[poz_ocupate].setRezultat(rezultat);
			vector[poz_ocupate].setTIU(0);
			vector[poz_ocupate].setTIU(vector[poz_ocupate].getTIU() + 1);
		}
	}

}
