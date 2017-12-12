package v2.ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.EventHandler;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
public class TableInvestmentTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame=new TableInvestmentFrame();
				frame.setTitle("Table test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
//显示表格
class TableInvestmentFrame extends JFrame {
	public TableInvestmentFrame() {
		TableModel model=new InvestmentTableModel(30,5,10);
		final JTable table=new JTable(model);
		table.setAutoCreateRowSorter(true);
		add(table,BorderLayout.CENTER);
		pack();
	}
}

class InvestmentTableModel  extends AbstractTableModel{
	private static double banlance=10000;
	private int years;
	private int minRate;
	private int maxRate;
	public InvestmentTableModel(int y,int r1,int r2) {
		years=y;
		minRate=r1;
		maxRate=r2;
	}
	@Override
	public int getRowCount() {
		return years;
	}
	@Override
	public int getColumnCount() {
		return maxRate-minRate+1;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		double rate=(columnIndex+minRate)/100.0;
		int nperiods=rowIndex;
		double balance=banlance* Math.pow(1+rate, nperiods);
		return String.format("%.2f", balance);
	}
}