//package tema1;
/**
 * Clasa ce implementeaza funcitonalitatea unui Weighted scheduler.
 * @author Mocanu Alexandru
 *
 */
public class WeightedScheduler extends Scheduler {

	private int[] cote_procese;
	private int[] cote_prelucrate;
	private int timp_curent;
	private int timp_sistem;
	private int index_proc;

	public WeightedScheduler(int numar, ProcessStructure[] procese) {

		super(numar, procese);
		cote_procese = new int[numar];
		cote_prelucrate = new int[numar];
	}

	private int cmmdc(int a, int b) {

		if (a == 0) {
			return b;
		}
		return cmmdc(b % a, a);
	}

	public void cote(ProcessStructure[] procese) {

		int cmmdc = procese[0].getWeight();
		int suma = procese[0].getWeight();
		for (int i = 1; i < procese.length; i++) {
			cmmdc = cmmdc(cmmdc, procese[i].getWeight());
			suma += procese[i].getWeight();
		}

		for (int i = 0; i < cote_procese.length; i++) {
			cote_procese[i] = procese[i].getWeight() / cmmdc;
		}

		timp_sistem = suma / cmmdc;
		timp_curent = timp_sistem;

		System.arraycopy(cote_procese, 0, cote_prelucrate, 0, cote_procese.length);
	}

	public void Select() {
		int aux = 0;
		int i = 0;

		if (timp_curent == 0) {
			timp_curent = timp_sistem;
			System.arraycopy(cote_procese, 0, cote_prelucrate, 0, cote_procese.length);
		}
		while (i != super.vector.length) {
			if (cote_prelucrate[i] != 0) {
				aux = i;
				cote_prelucrate[i]--;
				timp_curent--;
				break;
			}
			i++;
		}
		index_proc = aux;

	}

	public String NumeProc() {
		return super.vector[index_proc].toName();
	}

	public int Run(int numar) {

		int aux = super.vector[index_proc].Actiune(numar);
		return aux;

	}
}
