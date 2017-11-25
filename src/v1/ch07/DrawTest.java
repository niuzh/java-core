package v1.ch07;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class DrawTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame=new DrawFrame();
				frame.setTitle("DrawTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
//				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
	}

}
class DrawFrame extends JFrame{
	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent{
	private static final int DEFAULT_WIDHT=400;
	private static final int DEFAULT_HEIGHT=400;
	
	public void paintComponent(Graphics graphics) {
		Graphics2D g2=(Graphics2D)graphics;
		//draw a rectangle
		double leftx=100;
		double topy=100;
		double widht=200;
		double height=150;
		
		Rectangle2D rectangle2d=new Rectangle2D.Double(leftx, topy, widht, height);
		g2.draw(rectangle2d);
		
		//draw the enclosed ellipse 
		Ellipse2D ellipse2d=new Ellipse2D.Double();
		ellipse2d.setFrame(rectangle2d);
		g2.draw(ellipse2d);
		
		//draw a circle with the same center
		double centerX=rectangle2d.getCenterX();
		double centerY=rectangle2d.getCenterY();
		double radius=125;
		Ellipse2D circle=new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		g2.draw(circle);
		//填充颜色
		this.setBackground(Color.PINK);
		g2.setPaint(Color.GREEN);
		g2.fill(circle);
		g2.setPaint(Color.RED);
		g2.fill(rectangle2d);
		g2.setPaint(Color.BLUE);
		g2.fill(ellipse2d);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDHT, DEFAULT_HEIGHT);
	}
}