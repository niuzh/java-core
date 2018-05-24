package v2.ch10.set;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 该例子使用BCEL向已注解方法中添加日志信息
 * 先编译类文件，然后使用字节码处理工具处理，在运行处理后的类文件
 * @version 1.02 2012-01-26
 * @author Cay Horstmann
 */
public class SetTest {
	public static void main(String[] args) {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINEST);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINEST);
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).addHandler(handler);

		Set<Item> parts = new HashSet<>();
		parts.add(new Item("Toaster", 1279));
		parts.add(new Item("Microwave", 4104));
		parts.add(new Item("Toaster", 1279));
		System.out.println(parts);
	}
}
