/**
 * 
 */
package v1.ch05;

import java.lang.reflect.Constructor;
import java.util.Date;

/**
 * @author zhihuan.niu
 * @date 2017-11-22 10:40:04 AM
 * @Description: class
 */
public class ClassTest {

	/**
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @Description: class
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Date date=new Date();
		Class<?> class1=date.getClass();
		System.out.println(class1.getSimpleName());
		System.out.println(class1.getName());
		String className="java.util.Date";
		class1=Class.forName(className);
		System.out.println(class1.getSimpleName());
		Date date2=(Date)class1.newInstance();
		System.out.println(date2);
		Class class2=IntergerTest.class;
		System.out.println(class2);
		Constructor[] list= class2.getConstructors();
		for (Constructor constructor : list) {
			System.out.println(constructor);
		}

	}

}
