
import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

/**
 * RMI客户端
 * 	
 * @author zhihuan.niu
 */
public class WarehouseClient {

	public static void main(String[] args) throws NamingException, RemoteException {
		Context context=new InitialContext();
		System.out.println("RMI registry bindings");
		Enumeration<NameClassPair> enumeration=context.list("rmi://localhost/");
		while (enumeration.hasMoreElements()) {
			NameClassPair nameClassPair = (NameClassPair) enumeration.nextElement();
			System.out.println(nameClassPair.getName());
		}
		String url="rmi://localhost:1099/central_warehouse";
		Warehouse centralWarehosue=(Warehouse)context.lookup(url);
		String desc="c#";
		double price=centralWarehosue.getPrice(desc);
		System.out.println(desc+":"+price);
	}

}
