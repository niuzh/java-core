package v1.ch09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.javafx.css.CalculatedValue;

public class CalculatorPanel extends JPanel {
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastComand;
	private boolean start;

	public CalculatorPanel() {
		setLayout(new BorderLayout());
		result = 0;
		lastComand = "";
		start = true;
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);

		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);

		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);

		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);
		add(panel, BorderLayout.CENTER);
	}

	private void addButton(String lable, ActionListener insert) {
		JButton button = new JButton(lable);
		button.addActionListener(insert);
		panel.add(button);
	}

	private class InsertAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if (start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}

	}

	private class CommandAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start = false;
				} else {
					lastComand = command;
				}
			} else {
				calculatedValue(Double.parseDouble(display.getText()));
				lastComand=command;
				start=true;
			}

		}

		private void calculatedValue(double parseDouble) {
			if(lastComand.equals("+"))result+=parseDouble;
			if(lastComand.equals("-"))result-=parseDouble;
			if(lastComand.equals("*"))result*=parseDouble;
			if(lastComand.equals("/"))result/=parseDouble;
			if(lastComand.equals("="))result=parseDouble;
			display.setText(parseDouble+"");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame=new JFrame("cal");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new CalculatorPanel());
				frame.pack();
				frame.setVisible(true);
				
			}
		});
	}

}
