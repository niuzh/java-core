package v1.ch07.sizedFrame;

import java.awt.*;
import java.nio.file.Paths;

import javax.swing.*;

/**
 * @version 1.32 2007-04-14
 * @author Cay Horstmann
 */
public class SizedFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SizedFrame extends JFrame {
	public SizedFrame() {
		// get screen dimensions

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// set frame width, height and let platform pick screen location

		setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);

		// set frame icon

		Image img = new ImageIcon("src/v1/ch07/icon.gif").getImage();
		System.out.println(img);
		System.out.println(Paths.get("src/v1/ch07/icon.gif").toAbsolutePath().toString());
		setIconImage(img);
	}
}
