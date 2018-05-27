package v2.ch12.printf1;

/**
 * [niu@localhost src]$ javac v2/ch12/printf1/Printf1Test.java 
 * [niu@localhost src]$ java -Djava.library.path=v2/ch12/printf1/ v2.ch12.printf1.Printf1Test
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf1Test {
	public static void main(String[] args) {
		int count = Printf1.print(8, 4, 3.14);
		count += Printf1.print(8, 4, count);
		System.out.println();
		for (int i = 0; i < count; i++)
			System.out.print("-");
		System.out.println();
	}
}
