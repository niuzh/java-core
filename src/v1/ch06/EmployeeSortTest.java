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
		System.out.println("cloneTest");
		System.out.println(employees[0]);
		Employee clone=cloneTest(employees[0]);
		System.out.println(employees[0]);
		System.out.println(clone);
	}

	public static Employee cloneTest(Employee employee){
		Employee clone=null;
		try {
			clone=employee.clone();
			clone.setName("clone");
			return clone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
