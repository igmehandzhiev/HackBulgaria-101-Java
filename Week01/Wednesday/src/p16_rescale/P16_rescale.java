package p16_rescale;

import java.util.Scanner;

public class P16_rescale {
	public static int[][] rescale(int[][] original, int newWidth, int newHeight) {
		int[][] rescaled = new int[newHeight][newWidth];

		double x_ratio = original.length / (double) newHeight;
		double y_ratio = original[0].length / (double) newWidth;
		int newI = 0;
		int newJ = 0;

		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {

				newI = (int) Math.floor(i * x_ratio);
				newJ = (int) Math.floor(j * y_ratio);
				rescaled[i][j] = original[newI][newJ];
			}
		}
		return rescaled;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Orginal image rows: ");
		int rows = sc.nextInt();
		System.out.print("Orginal image columns: ");
		int columns = sc.nextInt();

		int[][] original = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				original[i][j] = sc.nextInt();				
			}
		}
		
		System.out.print("New Height: ");
		int newHeight = sc.nextInt();
		System.out.print("New Width: ");
		int newWidth = sc.nextInt();
		
		int[][] rescaled = new int[newHeight][newWidth];
		
		rescaled = rescale(original, newHeight, newWidth);
		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				System.out.print(rescaled[i][j]);
			}
			System.out.println();
		}
		sc.close();
	}

}