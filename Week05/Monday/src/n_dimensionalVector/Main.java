package n_dimensionalVector;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Double> coords = new ArrayList<> ();
		coords.add(12.0);
		coords.add(1.0);
		coords.add(7.0);
		coords.add(42.0);
		coords.add(13.4);
		coords.add(5.3);
		
		
		List<Double> coords2 = new ArrayList<> ();
		coords2.add(3.0);
		coords2.add(4.5);
		coords2.add(14.0);
		coords2.add(23.8);
		coords2.add(13.4);
		coords2.add(6.2);
		
		
		Vector myVector = new Vector(coords);
		Vector myVector2 = new Vector(coords2);
		
		System.out.println(myVector.toString());
		System.out.println(myVector2.toString());
		
		try{
			System.out.println("Add: " + myVector.add(myVector2));
			System.out.println("Substract: " + myVector.substract(myVector2));
			System.out.println("Add number (4.5): " + myVector.add(4.5f));
			System.out.println("Substract number (9): " + myVector.substract(9.0f));
			System.out.println("Multiply number (3): " + myVector.multiply(3.0f));
			System.out.println("Divide number (2): " + myVector.divide(2.0f));
			System.out.println("Dot product: " + myVector.dotProduct(myVector2));
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
	}

}
