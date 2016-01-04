package theOne;

public class Main {
	public static void main(String[] args) {
		Pixel[][] pixels = new Pixel[4][4];
		
		
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = new Pixel(i, j, i + j);
			}
		}
		Matrix matr = new Matrix(pixels);
		
		matr.toString();
		
		MatrixOperation op = new Greyscale();
		matr.operate(op);
		
		System.out.println("After Greyscale: ");
		matr.toString();
	}
}
