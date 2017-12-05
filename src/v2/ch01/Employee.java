package v2.ch01;

import java.io.Serializable;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

/**
 * 如果该类需要序列化，该父类也要实现序列化
 * @author niu
 *
 */
public class Employee extends v1.ch04.Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -189670995730532690L;
	public Employee() {
		super(null, 0);
	}
	public Employee(String name, double salary) {
		super(name, salary);
	}
	public Employee(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
	}
	
	private String job;
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public String toString(){
		return super.toString()+",job="+getJob();
	}
}
