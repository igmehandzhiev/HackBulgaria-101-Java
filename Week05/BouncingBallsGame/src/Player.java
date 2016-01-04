
public class Player {
	
	private int xAxis;
	private int yAxis;
	private int width;
	public int height;
	private double speed;
	
	//player dimensions
	private final static int defaultWidth = 20;
	private final static int defaultHeight = 50;
	
	
	public Player(int x) {
		this(x, defaultWidth, defaultHeight);
	}
	
	public Player(int x, int width, int height) {
		xAxis = x;
		this.width = width;
		this.height = height;
		speed = 25;
	}

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}
	
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void movePlayerLeft() {
		xAxis -= speed;
	}
	public void movePlayerRight() {
		xAxis += speed;
	}	
}
