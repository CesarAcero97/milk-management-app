package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextManager {
	File f;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw;
	BufferedReader br;

	public TextManager(String nameFile) {
		f = new File(nameFile);
	}

	public ArrayList<String> readFile(String fileName) throws IOException {
		ArrayList<String> readLines = new ArrayList<>();
		fr = new FileReader(fileName);
		br = new BufferedReader(fr);
		String readLine;
		while ((readLine = br.readLine()) != null) {
			readLines.add(readLine);
		}
		br.close();
		return readLines;
	}
	
	public void writeFile(String nameFile, ArrayList<String> dataList) throws IOException {
		fw = new FileWriter(nameFile);
		bw = new BufferedWriter(fw);
		for (String line : dataList) {
			bw.write(line);
			bw.newLine();
		}
		bw.flush();
	}
}
