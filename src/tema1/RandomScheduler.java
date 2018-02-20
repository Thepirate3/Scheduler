//package tema1;

import java.util.Random;
/**
 * Clasa ce implementeaza functionalitatile unui random scheduler.
 * @author Mocanu Alexandru
 *
 */
public class RandomScheduler extends Scheduler {

	private int index;

	public RandomScheduler(int numar, ProcessStructure[] procese) {

		super(numar, procese);

	}

	public void Select() {
		Random generator = new Random();
		index = generator.nextInt(super.vector.length);
	}

	public String NumeProc() {
		return super.vector[index].toName();
	}

	public int Run(int numar) {

		return super.vector[index].Actiune(numar);
	}

}
