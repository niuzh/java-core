package v2.ch01.randomAccess;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 随机读取文件
 * @author niuzhihuan
 */
public class RandomAccessTest {

	/**
	 * @param args @throws IOException @throws
	 */
	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl1", 75000, 1987, 12, 15);
		staff[1] = new Employee("Carl2", 75000, 1987, 12, 15);
		staff[2] = new Employee("Carl3", 75000, 1987, 12, 15);

		try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("employee.dat"))) {
			for (Employee employee : staff) {
				writeData(outputStream, employee);
			}
		}

		try (RandomAccessFile in = new RandomAccessFile("employee.dat", "r")) {
			// 计算数组长度
			int n = (int) (in.length() / Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			// 循环读取数据
			for (int i = 0; i < n - 1; i++) {
				newStaff[i] = new Employee();
				in.seek(i * Employee.RECORD_SIZE);
				newStaff[i] = readData(in);
			}
			// 输出
			for (Employee employee : newStaff) {
				System.out.println(employee);
			}
		}
	}

	private static Employee readData(RandomAccessFile in) throws IOException {
		String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		return new Employee(name, salary, y, m - 1, d);
	}

	private static void writeData(DataOutputStream out, Employee e) throws IOException {
		DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(e.getSalary());

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) + 1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));

	}

}
