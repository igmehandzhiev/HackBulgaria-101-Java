package p02_toDoList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ToDoList {

	private PriorityQueue<Task> queue;
	double timeAvailable;

	public ToDoList(double timeAvailable) {
		this.timeAvailable = timeAvailable;

		queue = new PriorityQueue<>(new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {
				return o2.compareTo(o1);
			}
		});

	}

	public void add(Task t) {
		queue.add(t);
		timeAvailable -= t.getTimeRequired();
	}

	public void displayList() {

		while (!queue.isEmpty()) {
			Task removed = queue.poll();
			System.out.println(removed.getTaskName() + "'s priority: " + removed.getPriority());
		}
		System.out.println("Remaining time: " + timeAvailable + " hours");
	}

	public void markFinished(Task t) {

	}

	public void markCancelled(Task t) {

	}

	public Task getTop() {
		return queue.peek();
	}

	public boolean canFinish() {
		return timeAvailable >= 0;
	}

	public double getRemainigTime() {
		return timeAvailable;
	}

	public String top() {
		return queue.peek().getTaskName();
	}

}
