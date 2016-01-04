
public class LaserBeam {
	private final double xAxis;
	private double yAxis;

	public LaserBeam(double x, double y) {
		xAxis = x;
		yAxis = y;
	}

	public double getyAxis() {
		return yAxis;
	}

	public void incrementyAxis(double yAxis) {
		this.yAxis += yAxis;
	}

	public double getxAxis() {
		return xAxis;
	}
	
	

}
