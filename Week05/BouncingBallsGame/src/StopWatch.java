import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {

	private int timeIndex;
	private Timer timer;
	
	public StopWatch() {
		timeIndex = 40;
	}
	
	public void initTimer() {
			timeIndex = 40;
			timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {	
				@Override
				public void run() {
					setInterval();
					
				}
			}, 1000, 1000);
			
	}

	private final int setInterval() {
		if (timeIndex == 1)
			timer.cancel();
		return --timeIndex;
	}
	public void stop() {
		timer.cancel();
	}
	
	public int getInterval() {
		return timeIndex;
	}
}