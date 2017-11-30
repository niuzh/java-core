package v1.ch11;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


import v1.ch08.ButtonFrame;

public class RobotTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ButtonFrame frame=new ButtonFrame();
				frame.setTitle("ButtonTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocation(new Point(10,10 ) );
				frame.setVisible(true);
			} 
		});
		
		//attach a robot
		GraphicsEnvironment environment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice sDevice=environment.getDefaultScreenDevice();
		try {
			final Robot robot=new Robot(sDevice);
			robot.waitForIdle();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					runTest(robot);
				}

				private void runTest(Robot robot) {
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.delay(2000);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(' ');
					robot.delay(2000); 
					
					robot.mouseMove(220, 60);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease( InputEvent.BUTTON1_MASK);
					
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
