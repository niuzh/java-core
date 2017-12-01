package v1.ch13;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> priorityQueue=new PriorityQueue<>();
		priorityQueue.add(new GregorianCalendar(1912, 1, 12));
		priorityQueue.add(new GregorianCalendar(1922, 1, 12));
		priorityQueue.add(new GregorianCalendar(1902, 1, 12));
		
		Logger.getGlobal().info("iterating");
		for (GregorianCalendar gregorianCalendar : priorityQueue) {
			Logger.getGlobal().info(gregorianCalendar.get(Calendar.YEAR)+"");
		}
		while (!priorityQueue.isEmpty()) {
			Logger.getGlobal().info(priorityQueue.remove().get(Calendar.YEAR)+"");
		}
	}

}
