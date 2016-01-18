package propertiesFileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropertiesUtil {
	
	public static Map<String, String> parseProperties(File file) throws FileNotFoundException, IOException {
		
		Map<String, String> result = new HashMap<>();
		
		try(BufferedReader reader = new BufferedReader( new FileReader (file))) {
			
			String line = null;
			
			while( (line = reader.readLine()) != null ) {
				
				line = line.replaceAll("\\s+","");
				extractValues(result, line);
			}
		}
		
		return result;
	}

	private static void extractValues(Map<String, String> result, String line) {
		String key = null;
		String value = null;
		
		int equalsSignIndex = line.indexOf('=');
		int numberSignIndex = line.indexOf('#');
		
		if(numberSignIndex == -1 || numberSignIndex > equalsSignIndex) {
			
			if(numberSignIndex == -1) {
				
				key = line.substring(0, equalsSignIndex);
				value = line.substring(equalsSignIndex + 1, line.length());
			} else {
				
				key = line.substring(0, equalsSignIndex);
				value = line.substring(equalsSignIndex + 1, numberSignIndex);
			}
		}
		
		if( key != null && value != null ){
			result.put(key, value);
		}
	}
}
