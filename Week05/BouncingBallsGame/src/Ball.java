import java.awt.Color;

public class Ball {
	private double diameter;
	private int centerX;
	private int centerY;
	private Color color;
	private double speed;

	private double radius;

	// directions
	private int moveX;
	private int moveY;

	// extr points
	private double leftmostX;
	private double rightmostX;
	private double highestY;
	private double lowestY;

	public Ball(double diameter, int centerX, int centerY, Color color, double speed) {
		this.diameter = diameter;
		this.centerX = centerX;
		this.centerY = centerY;
		this.color = color;
		this.speed = speed;
		radius = diameter / 2;
		this.moveX = 0;
		this.moveY = 0;

		initExtrPoints();
	}

	private void initExtrPoints() {
		leftmostX = centerX - radius;
		rightmostX = centerX + radius;
		lowestY = centerY + radius;
		highestY = centerY - radius;

	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	public int getMoveY() {
		return moveY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}

	// extremal
	public double getLeftmostX() {
		return leftmostX;
	}

	public double getRightmostX() {
		return rightmostX;
	}

	public double getHighestY() {
		return highestY;
	}

	public double getLowestY() {
		return lowestY;
	}

	public void move() {
		centerX += moveX * speed;
		centerY += moveY * speed;
		initExtrPoints();
	}

	@Override
	public String toString() {
		String result = "Ball [ Center(" + centerX + ", " + centerY + ")," + "(leftmostX: " + getLeftmostX()
				+ ", rightmostX: " + getRightmostX() + ", upmostY: " + getHighestY() + ", lowestY: " + getLowestY()
				+ ",  diam: " + diameter;
		return result;
	}

}
