package p28_toGreyscale;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Greyscale {
	
	public static void convert(String imgPath) {
		try{
			File input = new File(imgPath);
			BufferedImage image = ImageIO.read(input);
			int height = image.getHeight();
			int width = image.getWidth();
			
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					
					Color color = new Color(image.getRGB(j, i));
					
					int red = color.getRed();
					int green = color.getGreen();
					int blue = color.getBlue();
					
					int newColor = (red + green + blue) / 3;
					Color newCol = new Color(newColor, newColor, newColor);
					image.setRGB(j, i, newCol.getRGB());
					
				}
			}
			
			File output = new File("/home/georgi/Pictures/TheLongRoad_Greyscale.jpg");
	        ImageIO.write(image, "jpg", output);
	        
	        System.out.println("Image converted to Greyscale");
	        
		} catch(IOException e) {
			System.out.println("Converion to Greyscale unsuccesful!");
		}
	}
}
