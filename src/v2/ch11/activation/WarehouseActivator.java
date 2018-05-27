package v2.ch11.activation;

import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This server program instantiates a remote warehouse object, registers it with the naming
 * service, and waits for clients to invoke methods.
 * @version 1.13 2012-01-26
 * @author Cay Horstmann
 */
public class WarehouseActivator {
	public static void main(String[] args) throws RemoteException, NamingException, ActivationException, IOException {
		System.out.println("Constructing activation descriptors...");
		// 定义激活组
		Properties props = new Properties();
		// use the server.policy file in the current directory
		props.put("java.security.policy", new File("v2/ch11.activation/server.policy").getCanonicalPath());
		ActivationGroupDesc group = new ActivationGroupDesc(props, null);
		// 激活组ID
		ActivationGroupID id = ActivationGroup.getSystem().registerGroup(group);

		Map<String, Double> prices = new HashMap<>();
		prices.put("Blackwell Toaster", 24.95);
		prices.put("ZapXpress Microwave Oven", 49.95);
		// 包含构造信息的对象
		MarshalledObject<Map<String, Double>> param = new MarshalledObject<Map<String, Double>>(prices);

		String codebase = "http://localhost:8080/";
		// 激活描述符
		ActivationDesc desc = new ActivationDesc(id, "WarehouseImpl", codebase, param);
		// 注册绑定远程对象
		Warehouse centralWarehouse = (Warehouse) Activatable.register(desc);

		System.out.println("Binding activable implementation to registry...");
		Context namingContext = new InitialContext();
		namingContext.bind("rmi:central_warehouse", centralWarehouse);
		System.out.println("Exiting...");
	}
}
