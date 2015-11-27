import java.util.Scanner;

public class P10_histogram {

	public static int[] histogram(short[][] image) {
		int[] histogram = new int[256];
		
		for(int i = 0; i < histogram.length; i++) {
			for(int j = 0; j < image.length; j++) {
				for(int k = 0; k < image[0].length; k++) {
					if (image[j][k] == i) {
						histogram[i]++;
					}
				}
			}
		}
		return histogram;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Rows: ");
		int rows = sc.nextInt();
		System.out.print("Columns: ");
		int columns = sc.nextInt();

		short[][] image = new short[rows][columns];
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				image[i][j] = sc.nextShort();
			}
		}
		
		int[] histogram = histogram(image);
		for(int i = 0; i < histogram.length; i++) {
			System.out.println("Value of " + i + ": " + histogram[i] + " times");
		}
		
		sc.close();
	}

}
