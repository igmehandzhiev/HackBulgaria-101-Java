package p02_toDoList;

public class Main {

	public static void main(String[] args) {
		ToDoList list = new ToDoList(24);

		list.add(new WatchFootballTask(2));
		list.add(new GoOutTask(3));
		list.add(new LearnGeometryTask(4));
		list.add(new LearnJavaTask(5));
		list.add(new SleepTask());

		if (list.canFinish()) {
			System.out.println("Woohoo!");
		} else {
			System.out.println("I am ...screwed");
		}
		
	}

}
