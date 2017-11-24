/**
 * 
 */
package v1.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Timer;

/**
 * @author niu
 *
 */
public class TimerTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		ActionListener listener = new TimerPrinter();
		Timer timer = new Timer(1000 * 30, listener);
		timer.start();
		Date now = new Date();
		Date stopDate = null;
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.set(Calendar.SECOND, 60);
		stopDate = gregorianCalendar.getTime();
		System.out.println("start"+now);
		System.out.println("stop"+stopDate);
		// JOptionPane.showMessageDialog(null, "quit program");
		do {
			now = new Date();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (now.before(stopDate));
		System.out.println("exit");
	}
}

class TimerPrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("At the tone ,the time is" + new Date());
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(500);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(500);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(500);
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(500);
			Toolkit.getDefaultToolkit().beep();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
