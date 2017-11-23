/**
 * 
 */
package v1.ch06;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * @author zhihuan.niu
 * @date 2017-11-23 9:14:11 AM
 * @Description: TODO
 */
public class Employee implements Comparable<Employee> ,Cloneable{
	private String name;
	private double salary;

	public Employee(String n,double s) {
		name=n;
		salary=s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName()+"[name:"+name+",salary:"+salary+"]";
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException{
		Employee employee=(Employee)super.clone();
		return employee;
		
	}
}
