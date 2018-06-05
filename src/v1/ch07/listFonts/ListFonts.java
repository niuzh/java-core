package v1.ch07.listFonts;

import java.awt.*;

/**
 * 输出系统字体名称
 * @version 1.11 2004-06-05
 * @author Cay Horstmann
 */
public class ListFonts {
	public static void main(String[] args) {
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (String fontName : fontNames)
			System.out.println(fontName);
	}
}
