package propertiesFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Path p = Paths.get("/home/georgi/tmp/.properties");
		try{
			File reader = new File(p.toString());
			Map<String, String> parsedProperties = PropertiesUtil.parseProperties(reader);
			
			//System.out.println(parsedProperties.size());
			for (Map.Entry<String, String> entry : parsedProperties.entrySet())
			{
			    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
			}
					
					
					
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
