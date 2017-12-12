package v2.ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.EventHandler;

import javax.swing.*;
import java.awt.*;
public class TableTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame=new PlanetTableFrame();
				frame.setTitle("Table test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
//显示表格
class PlanetTableFrame extends JFrame {
	private String[] cloumnNames={"id","name","color"};
	private Object[][] cells={
		{"1","niu1",Color.BLACK},
		{"1","niu2",Color.RED},
		{"1","niu3",Color.BLUE},
		{"1","niu4",Color.GREEN},
	};
	
	public PlanetTableFrame() {
		final JTable table=new JTable(cells, cloumnNames);
		table.setAutoCreateRowSorter(true);
		add(table,BorderLayout.CENTER);
		JButton printBtn=new JButton("Print");
		printBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(printBtn);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
}
