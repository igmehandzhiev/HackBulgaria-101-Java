package theOne;

public class BrightnessReduce implements MatrixOperation{

	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		float R = matrix[x][y].getR();
		float G = matrix[x][y].getG();
		float B = matrix[x][y].getB();
		
		
		Pixel newPixel = new Pixel(R * 0.5f, G * 0.5f, B * 0.5f);
		
		return newPixel;
	}
}
