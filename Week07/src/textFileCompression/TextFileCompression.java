package textFileCompression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TextFileCompression {

	private Map<Integer, String> compressedWords;
	private Path compressedFilePath;
	
	public TextFileCompression() {
		compressedWords = new HashMap<>();
	}

	public void compress(Path filePath) throws FileNotFoundException, IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			FileReader fr = new FileReader(filePath.toFile());
			reader = new BufferedReader(fr);

			Path newPath = getNewPath(filePath);
			FileWriter fw = new FileWriter(newPath.toFile());
			writer = new BufferedWriter(fw);

			String line = null;
			int index = 0;
			StringBuilder newLine = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				String[] words = line.split("(?<!^)\\b");

				newLine.setLength(0);
				for (String word : words) {

					boolean wordIsWhitespace = word.trim().length() == 0;
					boolean notWord = !Character.isLetter(word.charAt(0));

					if (wordIsWhitespace) {
						newLine.append("~");

					} else if (notWord) {
						newLine.append(word);

					} else if (!compressedWords.containsValue(word)) {
						compressedWords.put(index, word);
						
						newLine.append(index);
						index++;

					} else {
						for (Map.Entry<Integer, String> entry : compressedWords.entrySet()) {
							if (word.equals(entry.getValue())) {
								int wordIndex = entry.getKey();
								newLine.append(wordIndex);
							}
						}

					}
				}
				writer.write(newLine.toString());
				writer.newLine();

			}

		} finally {
			reader.close();
			writer.close();
		}
	}

	private Path getNewPath(Path filePath) {
		int dotIndex = filePath.toString().lastIndexOf('.');
		String removedExtension = filePath.toString().substring(0, dotIndex);
		Path newPath = Paths.get(removedExtension + ".compr");
		
		compressedFilePath = newPath;
		
		return newPath;
	}
	
	public void decompress(Path toDecompress) throws FileNotFoundException, IOException {
		
		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			FileReader fr = new FileReader(compressedFilePath.toFile());
			reader = new BufferedReader(fr);

			Path newPath = toDecompress;
			FileWriter fw = new FileWriter(newPath.toFile());
			writer = new BufferedWriter(fw);

			String line = null;
			StringBuilder newLine = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				String[] words = line.split("(?<!^)\\b");
				
				
				newLine.setLength(0);
				for (String word : words) {

					boolean wordIsDigit = Character.isDigit(word.charAt(0));

					if (wordIsDigit) {
						int digit = Integer.parseInt(word);
						String digitValue = compressedWords.get(digit);
						newLine.append(digitValue);

					} else if (word.equals("~")) {
						newLine.append(" ");
						
					} else {
						newLine.append(word);

					} 
				}
				
				writer.write(newLine.toString());
				writer.newLine();

			}

		} finally {
			reader.close();
			writer.close();
		}
	}
}
