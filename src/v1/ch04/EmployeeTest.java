/**
 * 
 */
package v1.ch04;

/**
 * @author niu
 * @date Nov 15, 2017 10:34:57 AM
 * @Description: TODO
 */
public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//fill the staff arrary
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("carl",75000, 1987,12, 15);
		staff[1]=new Employee("carl2",75000, 1987,12, 15);
		staff[2]=new Employee("carl3",85000, 1977,12, 15);
		for (Employee employee : staff) {
			employee.raiseSalary(5);
		}
		//print
		for (Employee employee : staff) {
			System.out.println(employee.toString());
		}
	}

}
