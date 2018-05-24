package v2.ch10.buttons3;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
public class ButtonTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				ButtonFrame frame = new ButtonFrame();
				frame.setTitle("ButtonTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}