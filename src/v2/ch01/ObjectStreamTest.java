package v2.ch01;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectStreamTest {

	public static void main(String[] args) throws Exception {
		Employee harry = new Employee("harry", 50000, 1981, 10, 1);
		Employee carl = new Employee("carl", 50000, 1980, 10, 1);
		Employee tony = new Employee("tony", 50000, 1983, 10, 1);

		Employee[] employees = new Employee[3];
		employees[0] = harry;
		employees[1] = carl;
		employees[2] = tony;
		String path = System.getProperty("user.dir");
		String filePath = path + File.separator + "bin" + File.separator + "employee.dat";
		System.out.println(filePath);
		/*
		 * try(ObjectOutputStream out=new ObjectOutputStream(new
		 * FileOutputStream(filePath))){ out.writeObject(employees); }
		 */
		// try(ObjectInputStream inputStream=new ObjectInputStream(new
		// FileInputStream(filePath))){
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
			Employee[] employees2 = (Employee[]) inputStream.readObject();
			employees2[0].raiseSalary(11);
			for (Employee employee : employees2) {
				System.out.println(employee);
			}
		}
	}

}
