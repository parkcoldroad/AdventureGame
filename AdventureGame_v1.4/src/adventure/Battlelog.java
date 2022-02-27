package adventure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Battlelog {
	File file = new File("log.txt");
	
	public void writeLog(String logs) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write(logs);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> readLog() {
		Path path = Paths.get("log.txt");
		Charset cs = StandardCharsets.UTF_8;
		List<String> list = new ArrayList<String>();
		try {
			list = Files.readAllLines(path, cs);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}
}
