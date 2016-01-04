package geometryFigures;

final public class Point {
	private final double x;
	private final double y;

	public Point() {
		this(0, 0);
	}

	public Point(Point p) {
		this(p.x, p.y);
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public static Point origin() {
		return new Point();
	}

	@Override
	public String toString() {
		String result = "Point (" + x + ", " + y + ")";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Point other = (Point) obj;
		if (x == other.getX() && y == other.getY()) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		Double wrappedX = x;
		Double wrappedY = y;
		hash = hash * 23 + wrappedX.hashCode();
		hash = hash * 23 + wrappedY.hashCode();
		return hash;
	}

	public static LineSegment Add(Point point1, Point point2) {
		return new LineSegment(point1, point2);
	}
}
