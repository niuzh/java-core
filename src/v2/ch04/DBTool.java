package v2.ch04;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBTool {

	public static void main(String[] args) throws SQLException {
		try(Connection connection=getOracleConnection()){
			Statement statement=connection.createStatement();
			List<String> list=getTalbes(connection);
		}

	}
	public static List<String> getTalbes(Connection connection) throws SQLException{
		String catalog=null;
		//表所在的模式名称
		String schemaPattern="FIX_DEVELOP";
		//表名称;可包含单字符通配符("_"),或多字符通配符("%"); 
		List<String> list=new ArrayList<>();
		DatabaseMetaData metaData=connection.getMetaData();
		System.out.println(metaData.getDatabaseProductName());
		ResultSet schemasSet = metaData.getSchemas();
		while (schemasSet.next()) {
			System.out.println(schemasSet.getString(1));
		}
		System.out.println(metaData.getDatabaseProductName());
		ResultSet resultSet=metaData.getTables(catalog, schemaPattern, null, new String[]{"TABLE"});
		while (resultSet.next()) {
			String talbeName=resultSet.getString("TABLE_NAME");
			String talbeType=resultSet.getString("TABLE_TYPE");
			String tableRemark=resultSet.getString("REMARKS");
			System.out.println("talbeName:"+talbeName+",type:"+talbeType+",remarks="+tableRemark);
			list.add(talbeName);
			ResultSet cResultSet=metaData.getColumns(catalog, schemaPattern,talbeName, null);
			while (cResultSet.next()) {
				String columnName = cResultSet.getString("COLUMN_NAME");  //列名    
                int dataType = cResultSet.getInt("DATA_TYPE");     //对应的java.sql.Types的SQL类型(列类型ID)       
                String dataTypeName = cResultSet.getString("TYPE_NAME");  //java.sql.Types类型名称(列类型名称)  
                int columnSize = cResultSet.getInt("COLUMN_SIZE");  //列大小 
                String columnRemark=cResultSet.getString("REMARKS");
                System.out.println("dataTypeName:"+dataTypeName+",columnName:"+columnName+",columnSize="+columnSize+",columnRemark:"+columnRemark);
			}
		}
		return list;
	}
	private static Connection getConnection() throws SQLException {
		String url="jdbc:derby://localhost:1527/COREJAVA;create=true;upgrade=true";
		String drivers="org.apache.derby.jdbc.ClientDriver";
		String userName="dbuser";
		String password="secret";
		if(System.getProperty("jdbc.drivers")==null){
			System.setProperty("jdbc.drivers",drivers);
		}
		System.out.println("getConnection");
		return DriverManager.getConnection(url,userName,password);
	}
	private static Connection getOracleConnection() throws SQLException {
//		String url="jdbc:oracle:thin:@192.168.1.248:1521:CCS";
		String url="jdbc:oracle:thin:@192.168.1.230:1521:oral";
		String drivers="oracle.jdbc.OracleDriver";
		String userName="fix_develop";
		String password="fix_develop";
		if(System.getProperty("jdbc.drivers")==null){
			System.setProperty("jdbc.drivers",drivers);
		}
		System.out.println("getConnection");
		return DriverManager.getConnection(url,userName,password);
	}
}
