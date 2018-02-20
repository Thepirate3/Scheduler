//package tema1;
/**
 * Clasa principala unde sunt testate si compuse toate functionalitatile programului.
 * @author Mocanu Alexandru
 *
 */
public class MainClass {

	public static void main(String[] args) {

		HomeworkReader in = new HomeworkReader(args[0]);
		HomeworkWriter out = new HomeworkWriter(args[1]);
		ProblemData set_prob = in.readData();
		String rezultat = new String();
		String cache = null;
		CacheType c = null;

		if (set_prob.getCacheType().equals("NoCache")) {
			cache = "Computed";
		}

		if (set_prob.getCacheType().equals("LruCache")) {
			c = new LruCache(set_prob.getCacheCapacity());
			cache = "FromCache";
		}

		if (set_prob.getCacheType().equals("LfuCache")) {
			c = new LfuCache(set_prob.getCacheCapacity());
			cache = "FromCache";
		}

		if (set_prob.getSchedulerType().equals("RandomScheduler")) {

			RandomScheduler random = new RandomScheduler(set_prob.getProcesses().length, set_prob.getProcesses());

			for (int i = 0; i < set_prob.getNumbersToBeProcessed().length; i++) {

				int aux = set_prob.getNumbersToBeProcessed()[i];

				if (set_prob.getCacheType().equals("NoCache")) {

					random.Select();
					rezultat = Integer.toString(aux) + " " + random.NumeProc() + " " + Integer.toString(random.Run(aux))
							+ " " + cache;

				} else {
					random.Select();
					int in_cache = c.Check(random.NumeProc(), aux);

					if (in_cache == -1) {

						String nume_proc = random.NumeProc();

						int valoare = random.Run(aux);

						c.Add(aux, nume_proc, valoare);

						rezultat = Integer.toString(aux) + " " + nume_proc + " " + Integer.toString(valoare) + " "
								+ "Computed";
					} else {
						rezultat = Integer.toString(aux) + " " + random.NumeProc() + " " + Integer.toString(in_cache)
								+ " " + cache;
					}
				}
				out.println(rezultat);
			}
			out.close();
		}

		if (set_prob.getSchedulerType().equals("RoundRobinScheduler")) {

			ProcessStructure[] procese = set_prob.getProcesses();
			RoundRobinScheduler random = new RoundRobinScheduler(procese.length, procese);

			for (int i = 0; i < set_prob.getNumbersToBeProcessed().length; i++) {

				int aux = set_prob.getNumbersToBeProcessed()[i];

				if (set_prob.getCacheType().equals("NoCache")) {

					rezultat = Integer.toString(aux) + " " + random.NumeProc() + " " + Integer.toString(random.Run(aux))
							+ " " + cache;

				} else {

					int in_cache = c.Check(random.NumeProc(), aux);

					if (in_cache == -1) {

						String nume_proc = random.NumeProc();
						int valoare = random.Run(aux);

						c.Add(aux, nume_proc, valoare);

						rezultat = Integer.toString(aux) + " " + nume_proc + " " + Integer.toString(valoare) + " "
								+ "Computed";

					} else {
						rezultat = Integer.toString(aux) + " " + random.NumeProc() + " " + Integer.toString(in_cache)
								+ " " + cache;
						random.setIndex_proc();
					}
				}
				out.println(rezultat);

			}
			out.close();
		}
		if (set_prob.getSchedulerType().equals("WeightedScheduler")) {

			ProcessStructure[] procese = set_prob.getProcesses();
			WeightedScheduler random = new WeightedScheduler(procese.length, procese);
			random.cote(procese);
			for (int i = 0; i < set_prob.getNumbersToBeProcessed().length; i++) {

				int aux = set_prob.getNumbersToBeProcessed()[i];

				if (set_prob.getCacheType().equals("NoCache")) {

					random.Select();
					rezultat = Integer.toString(aux) + " " + random.NumeProc() + " " + Integer.toString(random.Run(aux))
							+ " " + cache;

				} else {
					random.Select();
					int in_cache = c.Check(random.NumeProc(), aux);

					if (in_cache == -1) {

						String nume_proc = random.NumeProc();

						int valoare = random.Run(aux);

						c.Add(aux, nume_proc, valoare);

						rezultat = Integer.toString(aux) + " " + nume_proc + " " + Integer.toString(valoare) + " "
								+ "Computed";
					} else {
						rezultat = Integer.toString(aux) + " " + random.NumeProc() + " " + Integer.toString(in_cache)
								+ " " + cache;
					}
				}
				out.println(rezultat);
			}
			out.close();
		}
		in.close();
	}

}
