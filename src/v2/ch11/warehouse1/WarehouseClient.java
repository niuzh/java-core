package v2.ch11.warehouse1;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

/**
 * 启动客户端 java v2.ch11.warehouse1.WarehouseClient
 * A client that invokes a remote method.
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseClient {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context namingContext = new InitialContext();

		System.out.print("RMI registry bindings: ");
		// 枚举RMI对象
		Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
		while (e.hasMoreElements())
			System.out.println(e.nextElement().getName());

		String url = "rmi://localhost/central_warehouse";
		Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);

		String descr = "Blackwell Toaster";
		double price = centralWarehouse.getPrice(descr);
		System.out.println(descr + ": " + price);
	}
}
