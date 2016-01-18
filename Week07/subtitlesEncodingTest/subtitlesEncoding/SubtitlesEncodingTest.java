package subtitlesEncoding;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubtitlesEncodingTest {

	private Path myPath;
	private File myFile;
	private BufferedWriter out;
	
	@Before
	public void setUp() throws Exception {
		myPath = Paths.get("/home/georgi/workspace/HackBulgaria-101-Java/Week07_Monday/tempSubs.srt");
		
		Charset resultCh = Charset.forName("windows-1251");
		FileOutputStream fos = new FileOutputStream(myPath.toFile());
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		out = new BufferedWriter(osw);
		out.write("Какво си мислиш, че правиш?");
		out.newLine();
		
		myFile = new File(myPath.toString());
	}

	@After
	public void tearDown() throws Exception {
		out.close();
		//myFile.delete();
	}

	@Test
	public void testToUTF8() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		SubtitlesEncoding.toUTF8(myPath);
	}

}
