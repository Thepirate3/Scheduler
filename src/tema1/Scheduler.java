//package tema1;
/**
 * Clasa abstracta ce defineste un scheduler.
 * @author Mocanu Alexandru
 *
 */
public abstract class Scheduler {

	Proces[] vector;

	public Scheduler() {
		super();
	}

	public Scheduler(int numar, ProcessStructure[] procese) {

		this.vector = new Proces[numar];

		for (int i = 0; i < numar; i++) {

			if (procese[i].getType().equals("CheckPrime")) {
				vector[i] = new CheckPrime();

			}
			if (procese[i].getType().equals("NextPrime")) {
				vector[i] = new NextPrime();

			}
			if (procese[i].getType().equals("Fibonacci")) {
				vector[i] = new Fibonacci();

			}
			if (procese[i].getType().equals("Sqrt")) {
				vector[i] = new Sqrt();
			}
			if (procese[i].getType().equals("Square")) {
				vector[i] = new Square();
			}
			if (procese[i].getType().equals("Cube")) {
				vector[i] = new Cube();
			}
			if (procese[i].getType().equals("Factorial")) {
				vector[i] = new Factorial();
			}
		}

	}

	public abstract String NumeProc();

	public abstract int Run(int numar);

}
