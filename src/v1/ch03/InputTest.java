package v1.ch03;

import java.io.Console;
import java.util.Scanner;

/**
 * 备注：执行环境 终端窗口 [niu@localhost bin]$ java v1.ch03.InputTest
 * @author niu 测试输入
 */
public class InputTest {

	private static Scanner in;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		in = new Scanner(System.in);
		// get first input
		System.out.println("What is your name");
		String name = in.nextLine();
		// get second input
		System.out.println("how old are you?");
		int age = in.nextInt();
		// display output on console
		System.out.println("hello ," + name + ",next year you'll be " + (age + 1));

		Console cons = System.console();
		String userName = cons.readLine("User name");
		char[] password = cons.readPassword("password:");
		System.out.println("username:" + userName);
		System.out.println("password:" + password);
	}

}
