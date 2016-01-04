package theOne;

import java.util.Scanner;

public class Matrix {
	private final static int defaultRows = 5;
	private final static int defaultColumns = 5;
	
	private Pixel[][] pixels;
	private int rows;
	private int columns;
	
	public Matrix() {
		this(defaultRows, defaultColumns);
	}
	
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		pixels = new Pixel[rows][columns];
		initDefault(pixels);
	}
	
	public Matrix(Pixel[][] p) {
		rows = p.length;
		columns = p[0].length;
		pixels = new Pixel[rows][columns];
		init(pixels, p);
	}
	
	private void init(Pixel[][] p, Pixel[][] initWith) {
		for(int i = 0; i < p.length; i++) {
			for(int j = 0; j < p[0].length; j++) {
				p[i][j] = new Pixel(initWith[i][j].getR(), initWith[i][j].getG(), initWith[i][j].getB());
			}
		}
	}
	
	private void initDefault (Pixel[][] p) {
		for(int i = 0; i < p.length; i++) {
			for(int j = 0; j < p[0].length; j++) {
				p[i][j] = new Pixel();
			}
		}
	}
	
	public void initMatrix() {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				System.out.println("[" + i + "] [" + j + "]: ");
				
				System.out.println("R: ");
				float R = sc.nextFloat();
				System.out.println("G: ");
				float G = sc.nextFloat();
				System.out.println("B: ");
				float B = sc.nextFloat();
				pixels[i][j] = new Pixel(R, G, B);
			}
		}
		sc.close();
	}
	
	public void operate(MatrixOperation op) {
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = op.withPixel(i, j, pixels);
			}
		}
	}


	
	@Override
	public String toString() {
		
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				System.out.print(pixels[i][j].toString() + "  ");
			}
			System.out.println();
			System.out.println();
		}
		return null;
	}
}
