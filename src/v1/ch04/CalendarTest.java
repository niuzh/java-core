/**
 * 
 */
package v1.ch04;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author niu
 * @date Nov 15, 2017 9:28:44 AM
 * @Description: TODO
 */
public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar d = new GregorianCalendar();
		Date date = d.getTime();
		System.out.println(date);
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		// set d to start date of month
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = d.get(Calendar.DAY_OF_WEEK);

		// get first day of week
		int firstDayOfWeek = d.getFirstDayOfWeek();

		// determine the required first line
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}

		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		System.out.println();
		for (int i = 1; i < indent; i++) {
			System.out.print("    ");
		}

		d.set(Calendar.DAY_OF_MONTH, 1);
		do {
			// print day
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			if (day == today) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			// start new line
			if (weekday == firstDayOfWeek) {
				System.out.println();
			}
		} while (d.get(Calendar.MONDAY) == month);
		if (weekday != firstDayOfWeek) {
			System.out.println();
		}
	}

}
