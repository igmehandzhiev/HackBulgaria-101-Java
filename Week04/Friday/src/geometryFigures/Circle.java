package geometryFigures;

final public class Circle implements GeometryFigure {

	public final Point center;
	public final double radius;

	Rectangle framingRectangle;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;

		Point upperLeft = new Point(center.getX() - radius, center.getY() + radius);
		Point lowerRight = new Point(center.getX() + radius, center.getY() - radius);

		framingRectangle = new Rectangle(upperLeft, lowerRight);
	}

	public Circle(Circle c) {
		this(c.center, c.radius);
	}

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

	public Point getCenter() {
		return center;
	}

	public double getHeight() {
		return radius / 2;
	}

	public double getWidth() {
		return radius / 2;
	}

	public double getPerimeter() {
		final double PI = Math.PI;

		double result = 2 * PI * radius;
		return result;
	}

	public double getArea() {
		final double PI = Math.PI;

		double result = PI * radius * radius;
		return result;
	}

	@Override
	public String toString() {
		String result = "Circle[(" + center.getX() + ", " + center.getY() + "), (" + radius * 2 + ", " + radius * 2
				+ ")]";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Circle other = (Circle) obj;
		if (radius == other.radius) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 13;
		Double wrappedRadius = radius;
		hash = hash * 17 + center.hashCode();
		hash = hash * 23 + wrappedRadius.hashCode();
		return hash;
	}
}
