/**
 * 
 */
package v1.ch06;

import java.util.Arrays;

/**
 * @author zhihuan.niu
 * @date 2017-11-23 9:13:10 AM
 * @Description: TODO
 */
public class EmployeeSortTest {

	/**
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		Employee[] employees=new Employee[3];
		employees[0]=new Employee("n1", 11);
		employees[1]=new Employee("n3", 13);
		employees[2]=new Employee("n2", 12);
		Arrays.sort(employees);
		for(Employee e:employees){
			System.out.println(e);
		}
	}

}
