package geometryFigures;

final public class Rectangle implements GeometryFigure{

	private final Point upperLeft;
	private final Point lowerRight;
	private final double width;
	private final double height;

	public Rectangle(Point p1, Point p2) {
		if (p1.getX() == p2.getX() || p1.getY() == p2.getY()) {
			throw new IllegalArgumentException("Points are on the same axis.");
		}
		upperLeft = new Point(p1);
		lowerRight = new Point(p2);

		width = getUpperRight().getX() - getUpperLeft().getX();
		height = getUpperLeft().getY() - getLowerLeft().getY();
	}

	public Rectangle(Rectangle r) {
		this(r.upperLeft, r.lowerRight);
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public Point getLowerLeft() {
		Point lowerLeft = new Point(upperLeft.getX(), lowerRight.getY());
		return lowerLeft;
	}

	public Point getLowerRight() {
		return lowerRight;
	}

	public Point getUpperRight() {
		Point upperRight = new Point(lowerRight.getX(), upperLeft.getY());
		return upperRight;
	}

	public LineSegment getLeftLine() {
		return new LineSegment(getUpperLeft(), getLowerLeft());
	}

	public LineSegment getRightLine() {
		return new LineSegment(getUpperRight(), getLowerRight());
	}

	public LineSegment getUpperLine() {
		return new LineSegment(getUpperLeft(), getUpperRight());
	}

	public LineSegment getLowerLine() {
		return new LineSegment(getLowerLeft(), getLowerRight());
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	// ( (x1 +x2)/2 ,(y1 + y2)/2 )
	public Point getCenter() {
		double centerX = (upperLeft.getX() + lowerRight.getX()) / 2;
		double centerY = (upperLeft.getY() + lowerRight.getY()) / 2;

		return new Point(centerX, centerY);
	}

	public double getPerimeter() {
		double leftLine = getLeftLine().getLength();
		double rightLine = getRightLine().getLength();
		double upperLine = getUpperLine().getLength();
		double lowerLine = getLowerLine().getLength();

		return leftLine + rightLine + upperLine + lowerLine;
	}

	public double getArea() {
		double leftLine = getLeftLine().getLength();
		double upperLine = getUpperLine().getLength();
		return leftLine * upperLine;
	}

	@Override
	public String toString() {
		String result = "Rectangle[(" + upperLeft + ", " + lowerRight + "), (Height: " + getHeight() + ", Width: " 
						+ getWidth() + ")]";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Rectangle other = (Rectangle) obj;
		if (getHeight() == other.getHeight() && getWidth() == other.getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 13;
		hash = hash * 17 + upperLeft.hashCode();
		hash = hash * 17 + lowerRight.hashCode();
		return hash;
	}
}
