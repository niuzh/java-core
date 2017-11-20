/**
 * 
 */
package v1.ch04;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author niu
 * @date Nov 16, 2017 10:06:49 AM
 * @Description: 雇员类
 */

public class Employee{
	private String name;
	private Double salary;
	private Date hireDay;
//	初始化块
	{
		this.name="";
	}
	public Employee(String n,double s,int year,int month,int day) {
		setName(n);
		setSalary(s);
		GregorianCalendar calendar=new GregorianCalendar(year, month, day);
		setHireDay(calendar.getTime());
	}

//	构造函数调用
	public Employee(String name,double salary){
		this(name,salary,new Date().getYear(),new Date().getMonth(),new Date().getDay());
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	
	public String toString(){
		return "name="+this.getName()+",salary="+this.getSalary()+",hirday="+this.getSalary();
	}
}