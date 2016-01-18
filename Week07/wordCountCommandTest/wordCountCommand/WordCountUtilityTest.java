package wordCountCommand;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordCountUtilityTest {

	WordCountResult expected;
	File myFile;
	Path myPath;
	
	@Before
	public void setUp() throws Exception {
		
		Charset charset = Charset.forName("UTF8");
		myPath = Paths.get("/home/georgi/tmp/writeFileForWordCount.txt");
		
		try(BufferedWriter writer = Files.newBufferedWriter(myPath, charset)) {
			writer.write("In Xanadu did Kubla Khan\nA stately pleasure-dome decree:");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		myFile = new File(myPath.toString());
		
		expected = new WordCountResult(9, 2, 48);
	}

	@After
	public void tearDown() throws Exception {
		expected = null;
		myFile.delete();
	}

	@Test
	public void testWordCountPath() throws FileNotFoundException, IOException {
		assertEquals(expected, WordCountUtility.wordCount(myPath));
	}

	@Test
	public void testWordCountFile() throws FileNotFoundException, IOException {
		assertEquals(expected, WordCountUtility.wordCount(myFile));
	}

}
