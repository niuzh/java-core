package v2.ch12.helloNative;

/**
 * 编辑Java引用本地方法类
 * [niu@localhost src]$ javac v2/ch12/helloNative/HelloNative.java
 * 生成C头文件
 * [niu@localhost src]$ javah v2.ch12.helloNative.HelloNative
 * [niu@localhost src]$ javac v2/ch12/helloNative/HelloNativeTest.java 
 * [niu@localhost src]$ java -Djava.library.path=v2/ch12/helloNative/ v2.ch12.helloNative.HelloNativeTest 
 *  @version 1.11 2007-10-26
 *  @author Cay Horstmann
 */
class HelloNativeTest {
	public static void main(String[] args) {
		HelloNative.greeting();
	}

	// 动态加载C库
	static {
		System.loadLibrary("HelloNative");
	}
}
