package p07_statisticsMethods;

public interface Statistics {
	//average
	public double getMean();
	// middle element
	public int getMedian();
	//value that occurs most often
	public Integer getMode();
	//difference between largest and smallest element
	public int getRange();
}