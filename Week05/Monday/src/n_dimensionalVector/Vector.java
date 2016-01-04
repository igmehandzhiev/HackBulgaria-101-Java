package n_dimensionalVector;

import java.util.ArrayList;
import java.util.List;

public class Vector {

	private List<Double> coordinates;

	public Vector(int dimensions) {
		coordinates = new ArrayList<>(dimensions);
		for (int i = 0; i < dimensions; i++) {
			coordinates.add(null);
		}
	}

	public Vector(List<Double> coords) {
		coordinates = new ArrayList<>(coords);
	}

	public Vector(Vector c) {
		this(c.coordinates);
	}

	private Double getCoordinateAtDimension(int i) {
		if (i < 1 || i > coordinates.size()) {
			throw new IndexOutOfBoundsException("Cannot get this coordinate");
		}
		return coordinates.get(i - 1);
	}

	private void setCoordinateAtDimension(int position, double value) {
		if (position < 1 || position > coordinates.size()) {
			throw new IndexOutOfBoundsException("Cannot set this coordinate");
		}

		coordinates.set(position - 1, value);
	}

	public int getDimensionality() {
		return coordinates.size();
	}

	public double getLength() {
		double result = 0.0;

		for (int i = 0; i < coordinates.size(); i++) {
			result += Math.pow(coordinates.get(i), 2);
		}

		result = Math.sqrt(result);
		return result;
	}
	
	public Vector add(Vector vector) {
		if (this.getDimensionality() != vector.getDimensionality()) {
			throw new IllegalArgumentException("Different Lengths!");
		}

		Vector newVector = new Vector(vector.getDimensionality());

		for (int i = 1; i <= coordinates.size(); i++) {
			double newValue = this.getCoordinateAtDimension(i) + vector.getCoordinateAtDimension(i);
			newVector.setCoordinateAtDimension(i, newValue);
		}
		return newVector;
	}
	
	public Vector substract(Vector vector) {
		if (this.getDimensionality() != vector.getDimensionality()) {
			throw new IllegalArgumentException("Different Lengths!");
		}
		
		Vector newVector = new Vector(vector.getDimensionality());
		
		for (int i = 1; i <= coordinates.size(); i++) {
			double newValue = this.getCoordinateAtDimension(i) - vector.getCoordinateAtDimension(i);
			newVector.setCoordinateAtDimension(i, newValue);
			
		}
		return newVector;
	}

	public Vector add(float scalar) {

		Vector newVector = new Vector(this.getDimensionality());

		for (int i = 1; i <= coordinates.size(); i++) {
			double newValue = this.getCoordinateAtDimension(i) + scalar;
			newVector.setCoordinateAtDimension(i, newValue);
		}
		return newVector;
	}

	public Vector substract(float scalar) {

		Vector newVector = new Vector(this.getDimensionality());

		for (int i = 1; i <= coordinates.size(); i++) {
			double newValue = this.getCoordinateAtDimension(i) - scalar;
			newVector.setCoordinateAtDimension(i, newValue);
		}
		return newVector;
	}

	public Vector multiply(float scalar) {

		Vector newVector = new Vector(this.getDimensionality());

		for (int i = 1; i <= coordinates.size(); i++) {
			double newValue = this.getCoordinateAtDimension(i) * scalar;
			newVector.setCoordinateAtDimension(i, newValue);
		}
		return newVector;
	}

	public Vector divide(float scalar) {
		if(scalar == 0) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}

		Vector newVector = new Vector(this.getDimensionality());

		for (int i = 1; i <= coordinates.size(); i++) {
			double newValue = this.getCoordinateAtDimension(i) / scalar;
			newVector.setCoordinateAtDimension(i, newValue);
		}
		return newVector;
	}

	public double dotProduct(Vector vector) {
		if (this.getDimensionality() != vector.getDimensionality()) {
			throw new IllegalArgumentException("Different Lengths!");
		}

		double result = 0;

		for (int i = 1; i <= this.getDimensionality(); i++) {
			double newValue = this.getCoordinateAtDimension(i) * vector.getCoordinateAtDimension(i);
			result += newValue;
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Vector[");

		for (int i = 0; i < coordinates.size() - 1; i++) {
			result.append(coordinates.get(i) + ", ");
		}
		result.append(coordinates.get(coordinates.size() - 1) + "]");

		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Vector other = (Vector) obj;
		if (coordinates.equals(other.coordinates)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return coordinates.hashCode();
	}

}
