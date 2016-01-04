package geometryFigures;

public class LineSegment implements Comparable<LineSegment> {

	private final Point p1;
	private final Point p2;

	public LineSegment(Point p1, Point p2) {
		if (p1.equals(p2)) {
			throw new IllegalArgumentException("Cannot create a line segment with zero length");
		}
		this.p1 = new Point(p1);
		this.p2 = new Point(p2);
	}

	public LineSegment(LineSegment ls) {
		this(ls.p1, ls.p2);
	}

	public Point getPoint1() {
		return p1;
	}

	public Point getPoint2() {
		return p2;
	}

	public double getLength() {
		double length = Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
		return length;
	}

	@Override
	public String toString() {
		String result = "Line[(" + p1.getX() + ", " + p1.getY() + "),(" + p2.getX() + ", " + p2.getY() + ")]";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		LineSegment other = (LineSegment) obj;
		if (p1.equals(other.getPoint1()) && p2.equals(other.getPoint2())) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(LineSegment o) {
		if (o == null) {
			// throw something?
		}

		if (this.getLength() < o.getLength()) {
			return -1;
		} else if (this.getLength() > o.getLength()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
	    hash = hash * 23 + p1.hashCode();
	    hash = hash * 23 + p2.hashCode();
	    return hash;
	}

}
