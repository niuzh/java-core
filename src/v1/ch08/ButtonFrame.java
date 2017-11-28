package v1.ch08;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ButtonFrame extends JFrame{

	private JPanel buttonPanel;
	private static final int default_width=300;
	private static final int default_height=200;
	public ButtonFrame() {
		setSize(default_width,default_height);
		
		JButton yellowButton =new JButton("Yellow");
		JButton blueButton =new JButton("Blue");
		JButton redButton =new JButton("Red");
		
		buttonPanel=new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
		yellowButton.addActionListener(new ColorAction(Color.YELLOW));
		blueButton.addActionListener(new ColorAction(Color.BLUE));
		redButton.addActionListener(new ColorAction(Color.RED));
	}
	private class ColorAction implements ActionListener{
		private Color backgroudColor;
		public ColorAction(Color color) {
			backgroudColor=color;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(backgroudColor);
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ButtonFrame().setVisible(true);
			}
		});
	}

}
