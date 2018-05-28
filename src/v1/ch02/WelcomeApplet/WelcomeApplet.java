package v1.ch02.WelcomeApplet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 该程序编译后放入引用html文件下对因的文件夹中。或者把html拷贝到src目录下。
 * appletviewer WelcomeApplet.html
 * This applet displays a greeting from the authors.
 * @version 1.22 2007-04-08
 * @author Cay Horstmann
 */
public class WelcomeApplet extends JApplet {
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setLayout(new BorderLayout());

				JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
				label.setFont(new Font("Serif", Font.BOLD, 18));
				add(label, BorderLayout.CENTER);

				JPanel panel = new JPanel();

				JButton cayButton = new JButton("Cay Horstmann");
				cayButton.addActionListener(makeAction("http://www.horstmann.com"));
				panel.add(cayButton);

				JButton garyButton = new JButton("Gary Cornell");
				garyButton.addActionListener(makeAction("mailto:gary_cornell@apress.com"));
				panel.add(garyButton);

				add(panel, BorderLayout.SOUTH);
			}
		});
	}

	private ActionListener makeAction(final String urlString) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					getAppletContext().showDocument(new URL(urlString));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
