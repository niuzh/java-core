/**
 * 
 */
package v1.ch07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author niu
 *
 */
public class NotHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame=new NotHelloWorldFrame();
				frame.setTitle("Not Hello World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
class NotHelloWorldFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -996697970076100110L;

	public NotHelloWorldFrame(){
		add(new NotHelloWorldComponent());
		pack();
	}
}

class NotHelloWorldComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2837811405991835301L;
	private static final int MESSAGE_X=75;
	private static final int MESSAGE_Y=100;
	
	private static final int DEFAULT_WIDTH=300; 
	private static final int DEFAULT_HEIGHT=200;
	
	public void paintComponent(Graphics graphics) {
		graphics.drawString("Not a Hello World", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}