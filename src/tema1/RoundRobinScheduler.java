//package tema1;
/**
 * Clasa ce implementeaza functionalitatile unui scheduler RoundRobin.
 * @author Mocanu Alexandru
 *
 */
public class RoundRobinScheduler extends Scheduler {

	public RoundRobinScheduler(int numar, ProcessStructure[] procese) {
		super(numar, procese);
	}

	private int index_proc = 0;

	public String NumeProc() {

		return super.vector[index_proc].toName();
	}

	public int Run(int numar) {

		int aux = super.vector[index_proc].Actiune(numar);
		index_proc++;
		if (index_proc == super.vector.length) {
			index_proc = 0;
		}
		return aux;

	}

	public int getIndex_proc() {
		return index_proc;
	}

	public void setIndex_proc() {
		index_proc++;
		if (index_proc == super.vector.length) {
			index_proc = 0;
		}
	}

}
