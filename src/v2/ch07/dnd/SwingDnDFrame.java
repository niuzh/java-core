package v2.ch07.dnd;

import java.awt.BorderLayout;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingDnDFrame extends JFrame {
	public SwingDnDFrame() {
		JTabbedPane tabbedPane = new JTabbedPane();

		JList<String> list = SampleComponents.list();
		tabbedPane.addTab("List", list);
		JTable table = SampleComponents.table();
		tabbedPane.addTab("Table", table);
		JTree tree = SampleComponents.tree();
		tabbedPane.addTab("Tree", tree);
		JFileChooser fileChooser = new JFileChooser();
		tabbedPane.addTab("File Chooser", fileChooser);
		JColorChooser colorChooser = new JColorChooser();
		tabbedPane.addTab("Color Chooser", colorChooser);

		final JTextArea textArea = new JTextArea(4, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Drag text here"));

		JTextField textField = new JTextField("Drag color here");
		// 设置数据传递处理器
		textField.setTransferHandler(new TransferHandler("background"));

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textArea.setText("");
			}
		});
		// 启动拖拽
		tree.setDragEnabled(true);
		table.setDragEnabled(true);
		list.setDragEnabled(true);
		fileChooser.setDragEnabled(true);
		colorChooser.setDragEnabled(true);
		textField.setDragEnabled(true);

		add(tabbedPane, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		pack();
	}
}
