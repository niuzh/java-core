package v2.ch01.textFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 
 * @author niuzhihuan
 */
public class TextFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Carl Creacker", 75000, 1987, 12, 15);
		staff[1]=new Employee("Harry Hacker", 50000, 1987, 12, 15);
		staff[2]=new Employee("Tony Tester", 40000, 1987, 12, 15);
		//输出文本
		try(PrintWriter out=new PrintWriter("employee.dat", "UTF-8")){
			writeData(staff,out);
		}
		//读取文本，注意文件编码
		try(Scanner in=new Scanner(new FileInputStream("employee.dat"),"UTF-8")){
			Employee[] newStaff=readData(in);
			for (Employee e : newStaff) {
				System.out.println(e);
			}
		}
	}
	
	private static void writeData(Employee[] staff, PrintWriter out) {
		out.println(staff.length);
		for (Employee employee : staff) {
			writeEmployee(out,employee);
		}
	}
	//对象提取属性组成字符串放入输出流中
	private static void writeEmployee(PrintWriter out, Employee employee) {
		GregorianCalendar calendar=new GregorianCalendar();
		calendar.setTime(employee.getHireDay());
		out.println(employee.getName()+"|"+employee.getSalary()+"|"+calendar.get(Calendar.YEAR)+"|"
				+(calendar.get(Calendar.MARCH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}

	private static Employee[] readData(Scanner in) {
		int n=in.nextInt();
		in.nextLine();
		Employee[] employees=new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i]=readEmployee(in);
		}
		return employees;
	}
	//从输入流中读取一行字符串，解析后赋值给对象
	private static Employee readEmployee(Scanner in) {
		String line=in.nextLine();
		String[] tokens=line.split("\\|");
		String name=tokens[0];
		double salary=Double.parseDouble(tokens[1]);
		int year=Integer.parseInt(tokens[2]);
		int month=Integer.parseInt(tokens[3]);
		int day=Integer.parseInt(tokens[4]);
		return new Employee(name, salary, year, month, day);
	}

}
