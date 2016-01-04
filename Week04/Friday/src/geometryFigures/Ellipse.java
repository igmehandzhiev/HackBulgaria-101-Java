package geometryFigures;

final public class Ellipse implements GeometryFigure {

	private final double xAxis;
	private final double yAxis;
	private final Point center;

	Rectangle framingRectangle;

	public Ellipse(double xAxis, double yAxis, Point center) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.center = center;
		if (center.equals(Point.origin())) {
			System.out.println("Point is on the origin.");
		}

		Point upperLeft = new Point(center.getX() - (xAxis / 2), center.getY() + (yAxis / 2));
		Point lowerRight = new Point(center.getX() + (xAxis / 2), center.getY() - (yAxis / 2));

		framingRectangle = new Rectangle(upperLeft, lowerRight);
	}

	public Ellipse(Ellipse e) {
		this(e.xAxis, e.yAxis, e.center);
	}

	//framing rectangle
	public Point getUpperLeft() {
		return framingRectangle.getUpperLeft();
	}

	public Point getLowerLeft() {
		return framingRectangle.getLowerLeft();
	}

	public Point getUpperRight() {
		return framingRectangle.getUpperRight();
	}

	public Point getLowerRight() {
		return framingRectangle.getLowerRight();
	}
	
	public double getHeight() {
		
		return xAxis / 2;
	}
	
	public double getWidth () {
		
		return yAxis / 2;
	}
	
	
	
	public Point getCenter() {
		return center;
	}

	public double getPerimeter() {
		// radius xAxis
		double a = xAxis / 2;
		// radius yAxis
		double b = yAxis / 2;
		final double PI = Math.PI;

		double result = 2 * PI * Math.sqrt((a * a + b * b) / 2);
		return result;
	}

	public double getArea() {
		// radius xAxis
		double a = xAxis / 2;
		// radius yAxis
		double b = yAxis / 2;
		final double PI = Math.PI;

		double result = PI * a * b;
		return result;
	}

	@Override
	public String toString() {
		String result = "Ellipse[(" + center.getX() + ", " + center.getY() + "), (" + yAxis + ", " + xAxis + ")]";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Ellipse other = (Ellipse) obj;
		if (xAxis == other.xAxis && yAxis == other.yAxis) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 13;
		Double wrappedX = xAxis;
		Double wrappedY = yAxis;
	    hash = hash * 17 + center.hashCode();
	    hash = hash * 17 + wrappedX.hashCode();
	    hash = hash * 23 + wrappedY.hashCode();
	    return hash;
	}
}
