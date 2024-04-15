package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.edu.fateczl.queue.Queue;
import controller.ScheduleController;

public class Main {

	public static void main(String[] args) {

		try {
			ScheduleController controller = new ScheduleController();
			Queue<model.Process> queue = new Queue<>();
			fillProcessQueue(queue, 5);
			controller.scheduler(queue);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	public static void fillProcessQueue(Queue<model.Process> queue, int numberOfProcess) {
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new ProcessBuilder().command("TASKLIST", "/FO", "CSV", "/NH").start().getInputStream()));

			String line = reader.readLine();
			int count = 0;
			while (count < numberOfProcess && line != null) {
				if (line.contains(".exe")) {
					queue.insert(new model.Process(count, line.split(",")[0].replace("\"", ""), (int) ((Math.random() * 51) + 10)));
					count++;
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
