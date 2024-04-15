package controller;

import br.edu.fateczl.queue.Queue;

public class ScheduleController {

	public ScheduleController() {
		super();
	}

	public void scheduler(Queue<model.Process> processQueue) throws Exception {
		int count = 0;
		while (!processQueue.isEmpty()) {
			model.Process process = processQueue.remove();
			System.out.printf("\u001B[%dmProcess %s(id %d):", (count % 2 == 0 ? 32 : 36), process.getName(), process.getId());
			System.out.println();
			System.out.printf("\tRemoved from the queue (%d returns)", process.getReturnsAmount());
			System.out.println();
			if (process.getReturnsAmount() > 1) {
				process.setReturnsAmount(process.getReturnsAmount() - 1);
				System.out.printf("\tSubtracted 1 return (%d returns remaining)", (process.getReturnsAmount() - 1));
				System.out.println();
				if (process.getReturnsAmount() > 1) {
					processQueue.insert(process);
					System.out.println("\tPlaced back to the queue");
				}
			}
			System.out.println();
			count++;
		}
	}

}
