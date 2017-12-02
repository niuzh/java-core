package v1.ch14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bounce {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Thread");
				frame.setVisible(true);
			}
		});
	}

}

class BounceFrame extends JFrame {
	private BallComponent comp;
	public static final int steps = 1000;
	public static final int delay = 30;
	public Thread thread;
	public BounceFrame() {
		comp = new BallComponent();
		setLayout(new BorderLayout());
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addBall();
			}

		});
		addButton(buttonPanel, "Close", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		addButton(buttonPanel, "Interrupted", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread.interrupt();
			}
		});

		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}

	public void addButton(JPanel buttonPanel, String string, ActionListener actionListener) {
		JButton button = new JButton(string);
		buttonPanel.add(button);
		button.addActionListener(actionListener);
	}

	public void addBall() {
		try {
			thread=new Thread(new Runnable() {
				@Override
				public void run() {
					double random = new java.util.Random().nextInt(1000);
					double randomy = new java.util.Random().nextInt(1100);
					// Logger.getGlobal().info("random"+random);
					Ball ball = new Ball(random, randomy);
					comp.add(ball);
					for (int i = 0; i < steps; i++) {
						while (!thread.isInterrupted()) {
							ball.move(comp.getBounds());
							comp.paint(comp.getGraphics());
							try {
								Thread.sleep(delay);
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
								e.printStackTrace();
							}
							Logger.getGlobal().info("Thread sleep");
						}
						
					}
				}
			});
			thread.start();
		} catch (Exception e) {
		}
	}
}
