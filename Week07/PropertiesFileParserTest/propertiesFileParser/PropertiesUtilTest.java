package propertiesFileParser;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertiesUtilTest {

	private Map<String, String> myMap;
	private File myFile;
	
	@Before
	public void setUp() throws Exception {
		Charset charset = Charset.forName("UTF8");
		Path path = Paths.get("/home/georgi/tmp/writeFile.txt");
		try(BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			writer.write("a1 = b1 \n a2 = b2 = b2.1 \n a3 = b3 # comment");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		myFile = new File(path.toString());
		
		myMap = new HashMap<>();
		myMap.put("a1", "b1");
		myMap.put("a2", "b2=b2.1");
		myMap.put("a3", "b3");
		
	}

	@After
	public void tearDown() throws Exception {
		myMap = null;
		myFile.delete();
	}

	@Test
	public void testParseProperties() throws FileNotFoundException, IOException {
		assertEquals("Check if it is returning the right map.", 
				myMap, PropertiesUtil.parseProperties(myFile));
	}

}
