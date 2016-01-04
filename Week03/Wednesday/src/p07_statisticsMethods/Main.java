package p07_statisticsMethods;


public class Main {

	public static void main(String[] args) {
		MyStatistics statistics = new MyStatistics();
		statistics.add(13);
		statistics.add(18);
		statistics.add(13);
		statistics.add(18);
		statistics.add(13);
		statistics.add(16);
		statistics.add(14);
		statistics.add(21);
		statistics.add(13);
		statistics.displayInfo();

	}

}