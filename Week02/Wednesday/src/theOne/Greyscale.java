package theOne;

public class Greyscale implements MatrixOperation{

	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		float R = matrix[x][y].getR();
		float G = matrix[x][y].getG();
		float B = matrix[x][y].getB();
		
		float greyscaled = (R + G + B) / 3;
		
		Pixel newPixel = new Pixel(greyscaled, greyscaled, greyscaled);
		
		return newPixel;
	}
}
