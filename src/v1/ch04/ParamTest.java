package v1.ch04;

public class ParamTest {
	public static void main(String[] args) {
		Employee a = new Employee("a", 75000, 1987, 12, 15);
		Employee b = new Employee("b", 75000, 1987, 12, 15);
		System.out.println(a);
		System.out.println(b);
		a.raiseSalary(10);
		b.raiseSalary(12);
		System.out.println(a);
		System.out.println(b);
		notSwap(a, null, b);
		System.out.println(a);
		System.out.println(b);
	}

	public static void notSwap(Employee x, Object newParam, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("x" + x);
		System.out.println("y" + y);
	}
	public static void swap(Employee x, Employee y, Object newParam) {
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("x" + x);
		System.out.println("y" + y);
	}
}
