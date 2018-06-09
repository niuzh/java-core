package v1.ch10.webstart;

import java.awt.*;
import javax.swing.*;

/**
 * [niu@localhost src]$ javac -classpath .:./v1/ch10/javaws.jar v1/ch10/webstart/*.java
 * [niu@localhost src]$ jar cvfe Calculator.jar webstart.Calculator v1/ch10/webstart/*.class
 * A calculator with a calculation history that can be deployed as a Java Web Start application.
 * @version 1.03 2012-05-14
 * @author Cay Horstmann
 */
public class Calculator {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CalculatorFrame frame = new CalculatorFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}