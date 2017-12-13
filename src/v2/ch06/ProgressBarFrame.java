package v2.ch06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * 用于实验进度条 
 * @author niu
 *
 */
public class ProgressBarFrame extends JFrame {
	private JButton startButton;
	private JProgressBar progressBar;
	private JCheckBox checkBox;
	private JTextArea textArea;
	private SimulateActivity activity;
	private static final int max=1000;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame=new ProgressBarFrame();
				frame.setSize(400, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}
	public ProgressBarFrame() {		
		textArea=new JTextArea(10, 40);
		add(new JScrollPane(textArea),BorderLayout.CENTER);
		JPanel panel=new JPanel();
		add(panel, BorderLayout.SOUTH);
		progressBar=new JProgressBar(0, max);
		progressBar.setStringPainted(true);
		panel.add(progressBar);
		startButton=new JButton("开始");
		panel.add(startButton);
		checkBox=new JCheckBox("Indeterminate");
		panel.add(checkBox);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				activity=new SimulateActivity(max);
				activity.execute();
			}
		});
		checkBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				progressBar.setIndeterminate(checkBox.isSelected());
				progressBar.setStringPainted(!progressBar.isIndeterminate());
			}
		});
		pack();
	}

class SimulateActivity extends SwingWorker<Void, Integer>{
	private int current;
	private int target;
	public SimulateActivity(int _target) {
		target=_target;
	}
	@Override
	protected Void doInBackground() throws Exception {
		try {
			while (current<target) {
				Thread.sleep(100);
				current+=10;
				//调用 process
				publish(current);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		return null;
	}
	//publish 后调用的方法
	@Override
	protected void process(List<Integer> chunks) {
		for (Integer integer : chunks) {
			textArea.append(integer+"\n");
			progressBar.setValue(integer);
		}
	}
	//doInBackground 完毕后
	@Override
	protected void done() {
		startButton.setEnabled(true);
	}
}
}

