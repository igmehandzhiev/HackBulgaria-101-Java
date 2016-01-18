package subtitlesEncoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class SubtitlesEncoding {
	
	public static void toUTF8(Path path) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		
		BufferedReader buff = null;
		BufferedWriter out = null;
		
		try {
			Charset defaultCh = Charset.forName("windows-1251");
			
			FileInputStream fis = new FileInputStream(path.toFile());
			InputStreamReader isr = new InputStreamReader(fis, defaultCh);
			buff = new BufferedReader (isr);
			
			
			File fileDestination = new File("/home/georgi/tmp/fixed_subs.srt");
			
			Charset resultCh = Charset.forName("UTF8");
			FileOutputStream fos = new FileOutputStream(fileDestination);
			OutputStreamWriter osw = new OutputStreamWriter(fos, resultCh);
			out = new BufferedWriter(osw);
			
	
			String line = null;
			while( (line = buff.readLine()) != null ) {
				
				byte[] bytes = line.getBytes("windows-1251");
				String s = new String(bytes, "windows-1251");
				out.write(s);
				out.newLine();
			}
		} finally {
			buff.close();
			out.close();
		}
		
	}
}
