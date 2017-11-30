package v1.ch10;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class ResourceTest {

	//jar cvfe ResourceTest.jar v1.ch10.ResourceTest v1/ch10/*.class v1/ch10/*.gif v1/ch10/*.txt
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Logger.getGlobal().info("启动");
				//堆栈跟踪
				Thread.dumpStack();
				JFrame frame=new ResourceTestFrame();
				frame.setTitle("ResourceTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
class ResourceTestFrame extends JFrame{
	private JTextArea textArea;
	public ResourceTestFrame() {
		textArea=new JTextArea();
		add(textArea);
		setSize(300,300);
		URL url=getClass().getResource("tomcat.gif");
		Logger.getGlobal().info("url："+url);
		Image image=new ImageIcon(url).getImage();
		setIconImage(image);
		InputStream stream=getClass().getResourceAsStream("index.txt");
		Scanner inputStream=new Scanner(stream);
		while (inputStream.hasNext()) {
			textArea.append(inputStream.nextLine()+"\n");
		}
	}
}
