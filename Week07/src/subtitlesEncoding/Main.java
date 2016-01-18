package subtitlesEncoding;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("/home/georgi/Downloads/" + 
				"0lost.s04e11.hdtv.xvid-2hd(subsunacs.net)/lost.s04e11.hdtv.xvid-2hd.srt");
		try {
			SubtitlesEncoding.toUTF8(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
