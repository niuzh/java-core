package v2.ch11.warehouse1;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 启动RMI注册表 新开控制台  rmiregistry
 * 启动服务 java v2.ch11.warehouse1.WarehouseServer
 * This server program instantiates a remote warehouse object, registers it with the naming
 * service, and waits for clients to invoke methods.
 * @version 1.12 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseServer {
	public static void main(String[] args) throws RemoteException, NamingException {
		System.out.println("Constructing server implementation...");
		WarehouseImpl centralWarehouse = new WarehouseImpl();

		System.out.println("Binding server implementation to registry...");
		// 注册对象
		Context namingContext = new InitialContext();
		namingContext.bind("rmi:central_warehouse", centralWarehouse);

		System.out.println("Waiting for invocations from clients...");
	}
}
