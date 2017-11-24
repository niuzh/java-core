/**
 * 
 */
package v1.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author niu
 *
 */
public class InnerClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showConfirmDialog(null, "Quit program");
		//
		TalkingClock.TimerPrinter timerPrinter=clock.new TimerPrinter();
		System.out.println(timerPrinter.toString());
		System.exit(0);
	}

}

class TalkingClock {
	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		// TimerPrinter printer=new TimerPrinter();
		TimerPrinter printer = this.new TimerPrinter();
		Timer timer = new Timer(interval, printer);
		timer.start();
	}

	public class TimerPrinter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("the time is :" + now);
			// if(beep)Toolkit.getDefaultToolkit().beep();
			if (TalkingClock.this.beep)
				Toolkit.getDefaultToolkit().beep();

		}

	}
}
