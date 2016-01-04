package p02_toDoList;

public class Task implements Comparable<Task>{

	private String taskName;
	private int priority;
	private double timeRequired;

	public Task(String taskName, int priority, double timeRequired) {
		this.taskName = taskName;
		this.priority = priority;
		this.timeRequired = timeRequired;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(double timeRequired) {
		this.timeRequired = timeRequired;
	}
	
	public void visualiseTask() {
		System.out.println(taskName + "'s priority: " + priority + ", time required: " + timeRequired + " hours." );
	}

	
	@Override
	public int compareTo(Task obj) {
		
		if(this.getPriority() >= obj.getPriority()) {
			return 1;
		} else{
			return -1;
		} 
		
	}
	

}

class StudyForAlgebraTask extends Task {

	public StudyForAlgebraTask(double timeRequired) {
		super("Algebra Task", 6, timeRequired);
	}
}

class LearnGeometryTask extends Task {

	public LearnGeometryTask(double timeRequired) {
		super("Geometry Task", 6, timeRequired);
	}
}

class GoOutTask extends Task {

	public GoOutTask(double timeRequired) {
		super("Go out dammit!", 6, timeRequired);
	}
}

class SleepTask extends Task {

	public SleepTask() {
		super("Sleep", 8, 8.0);
	}
}

class WatchFootballTask extends Task {

	public WatchFootballTask(double timeRequired) {
		super("Watch football!", 7, timeRequired);
	}
}

class LearnJavaTask extends Task {

	public LearnJavaTask(double timeRequired) {
		super("Learn the JAVA", 9, timeRequired);
	}
}