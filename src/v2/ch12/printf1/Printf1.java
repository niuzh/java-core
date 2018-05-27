package v2.ch12.printf1;

/**
 * gcc -fPIC -I ${JAVA_HOME}/include/ -I ${JAVA_HOME}/include/linux -shared -o libPrintf1.so v2/ch12/printf1/v2_ch12_printf1_Printf1.c
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf1 {
	public static native int print(int width, int precision, double x);

	static {
		System.loadLibrary("Printf1");
	}
}
