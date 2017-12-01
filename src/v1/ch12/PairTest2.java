package v1.ch12;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class PairTest2 {

	public static void main(String[] args) {
		GregorianCalendar[] birthdays={
				new GregorianCalendar(1906,Calendar.DECEMBER,1),
				new GregorianCalendar(1906,Calendar.DECEMBER,2),
				new GregorianCalendar(1906,Calendar.DECEMBER,3),
				new GregorianCalendar(1906,Calendar.DECEMBER,4)
		};
		new ArrayAlg();
		Pair<GregorianCalendar> mm=ArrayAlg.minMax(birthdays);
		Logger.getGlobal().info("min="+mm.getFirst().getTime());
		Logger.getGlobal().info("max="+mm.getSecond().getTime());
	}
}
class ArrayAlg{
	public static <T extends Comparable> Pair<T> minMax(T[] aTs) {
		if(aTs==null||aTs.length==0)return null;
		T min=aTs[0];
		T max=aTs[0];
		for (int i = 0; i < aTs.length; i++) {
			if(min.compareTo(aTs[i])>0)min=aTs[i];
			if(max.compareTo(aTs[i])<0)max=aTs[i];
		}
		return new Pair<>(min, max);
	}
}
