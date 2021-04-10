package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Config {

	private File cyclistData;

	public Config() throws FileNotFoundException, IOException {
		cyclistData = new File("resources/file/Corredores.bike");
	}

	public File getCyclistData() {
		return cyclistData;
	}
}
