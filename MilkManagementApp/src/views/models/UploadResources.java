package views.models;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class  UploadResources {

	public UploadResources() {
	}
	
	public  Font uploadFont(String path,int Style, float size) {
		Font font = null;
		
		try {
			InputStream input = getClass().getResourceAsStream(path);
			font = Font.createFont(Font.TRUETYPE_FONT, input);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		font = font.deriveFont(Style,size);
		return font;
	}
}
