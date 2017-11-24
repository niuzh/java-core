package v1.ch07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SimpleFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SimpleFrame frame=new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.toBack();
			}
		});
	}

}
class SimpleFrame extends JFrame{
	private static final int width=300;
	private static final int height=200;
	public SimpleFrame(){
		setSize(width, height);
		this.setTitle("Simple JFrame");
//		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationByPlatform(true);
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension dimension=toolkit.getScreenSize();
		int screenHeight=dimension.height;
		int screenWidth=dimension.width;
		setSize(screenWidth/4, screenHeight/2);
	}
}
