package geometryFigures;

public class Main {

	public static void main(String[] args) {
		Point p1 = new Point(1, 3);
		Point p2 = new Point(4, 1);
		
		Point p3 = new Point(2, 4);
		Point p4 = new Point(5, 2);
		
		LineSegment ls1 = new LineSegment(p1, p2);
		LineSegment ls2 = new LineSegment(p3, p4);
		
		Rectangle r1 = new Rectangle(p3, p4);
		Rectangle r2 = new Rectangle(p1, p2);
		
		
		System.out.println(r1.getArea());
		

	}

}
