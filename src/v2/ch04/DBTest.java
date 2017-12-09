package v2.ch04;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBTest {

	public static void main(String[] args) {
		try {
			runTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void runTest() throws SQLException {
		try(Connection connection=getConnection()){
			Statement statement=connection.createStatement();
			//statement.executeUpdate("drop table Greetings");
			//statement.executeUpdate("create table Greetings(message char(100))");
			statement.executeUpdate("insert into Greetings values('hello world"+new Date().getTime()+"')");
			try(ResultSet resultSet=statement.executeQuery("Select * from Greetings")){
				while(resultSet.next()){
					System.out.println(resultSet.getString(1));
				}
			}
		}
	}

	private static Connection getConnection() throws SQLException {
		String url="jdbc:derby://localhost:1527/COREJAVA;create=true;upgrade=true";
		String drivers="org.apache.derby.jdbc.ClientDriver";
		String userName="dbuser";
		String password="secret";
		if(System.getProperty("jdbc.drivers")==null){
			System.setProperty("jdbc.drivers",drivers);
			//Class.forName(drivers);
		}
		System.out.println("getConnection");
		return DriverManager.getConnection(url,userName,password);
	}

}
