package geometryFigures;

final public class Triangle implements GeometryFigure {
	private final Point upper;
	private final Point lowerLeft;
	private final Point lowerRight;
		
	public Triangle(Point p1, Point p2, Point p3) {
		if((p1.getX() == p2.getX() && p1.getX() == p3.getX()) || (p1.getY() == p2.getY() && p1.getY() == p3.getY()) ) {
			throw new IllegalArgumentException("Points are on the same axis.");
		}
		
		this.upper = p1;
		this.lowerLeft = p2;
		this.lowerRight = p3;
	}
	
	public Triangle(Triangle tr) {
		this(tr.upper, tr.lowerLeft, tr.lowerRight);
	}
	
	public Point getUpper() {
		return upper;
	}
	
	public Point getLowerLeft() {
		return lowerLeft;
	}
	
	public Point getLowerRight() {
		return lowerRight;
	}
	
	public LineSegment getLeftLine() {
		return new LineSegment(upper, lowerLeft);
	}
	
	public LineSegment getRightLine() {
		return new LineSegment(upper, lowerRight);
	}
	
	public LineSegment getLowerLine() {
		return new LineSegment(lowerLeft, lowerRight);
	}
	
	public LineSegment getBase() {
		return getLowerLine();
	}
	
	public double getHeight() {
		double height = 2 * getArea() / getLowerLine().getLength();
		
		return height;
	}
	
	public double getWidth() {
		double width = getLowerLine().getLength();
		
		return width;
	}
	
	public Point getCenter() {
		double centerX = (upper.getX() + lowerLeft.getX() + lowerRight.getX()) / 3;
		double centerY = (upper.getY() + lowerLeft.getY() + lowerRight.getY()) /3;
		
		return new Point(centerX, centerY);
	}
	
	public double getPerimeter() {
		double leftLine = getLeftLine().getLength();
		double rightLine = getRightLine().getLength();
		double lowerLine = getLowerLine().getLength();
		
		return leftLine + rightLine + lowerLine;
	}
	
	public double getArea() {
		double halfP = getPerimeter() / 2;
		double area = Math.sqrt(halfP * (halfP - getLeftLine().getLength()) * (halfP - getRightLine().getLength()) * 
				(halfP - getLowerLine().getLength()));
		return area;
	}
	
	@Override
	public String toString() {
		String result = "Triangle[(" + getLowerLeft() + ", " + getLowerRight() + ", " + getUpper() + "), (" + getHeight()
				+ ", " + getBase().getLength() + ")]";
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Triangle other = (Triangle) obj;
		if (getLeftLine().getLength() == other.getLeftLine().getLength() && getRightLine().getLength() == other.getRightLine().getLength() && 
				getLowerLine().getLength() == other.getLowerLine().getLength()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 13;
	    hash = hash * 17 + upper.hashCode();
	    hash = hash * 17 + lowerRight.hashCode();
	    hash = hash * 23 + lowerLeft.hashCode();
	    return hash;
	}
}
