package wordCountCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCountUtility {
	public static WordCountResult wordCount(Path path) throws FileNotFoundException, IOException {
		
		int wordCount = 0;
		int lineCount = 0;
		int characterCount = 0;
		
		try(BufferedReader reader = new BufferedReader(new FileReader (path.toString()))) {
			
			String line = null;
			while( (line = reader.readLine()) != null ) {
				String[] words = line.split("\\s+");
				for(String word: words) {
					characterCount += word.length();
				}
				
				wordCount += words.length;
				++lineCount;
			}
		}
		
		
		return new WordCountResult(wordCount, lineCount, characterCount);
	}
	
	public static WordCountResult wordCount(File file) throws FileNotFoundException, IOException {
		Path path = Paths.get(file.toString());
		
		return wordCount(path);
	}
	
}
