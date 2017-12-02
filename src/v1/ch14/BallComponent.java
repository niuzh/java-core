package v1.ch14;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class BallComponent extends JPanel{
	private static final int width=450;
	private static final int height=350;

	private List<Ball> balls=new ArrayList<>();
	public void add(Ball ball){
		balls.add(ball);
	}
	
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		Graphics2D g2=(Graphics2D)graphics;
		for (Ball ball : balls) {
			g2.fill(ball.getShape());
		}
	}
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
}
