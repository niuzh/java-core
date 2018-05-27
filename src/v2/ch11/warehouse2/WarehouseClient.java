package v2.ch11.warehouse2;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * 查询远程序列化的对象
 * The client for the warehouse program.
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseClient {
	public static void main(String[] args) throws NamingException, RemoteException {
		System.setProperty("java.security.policy", "v2/ch11/warehouse2/client.policy");
		System.setSecurityManager(new SecurityManager());
		Context namingContext = new InitialContext();

		System.out.print("RMI registry bindings: ");
		NamingEnumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
		while (e.hasMore())
			System.out.println(e.next().getName());

		String url = "rmi://localhost/central_warehouse";
		Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);

		Scanner in = new Scanner(System.in);
		System.out.print("Enter keywords: ");
		List<String> keywords = Arrays.asList(in.nextLine().split("\\s+"));
		Product prod = centralWarehouse.getProduct(keywords);

		System.out.println(prod.getDescription() + ": " + prod.getPrice());
	}
}
