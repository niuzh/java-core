
import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * RMI 服务器端 启动服务
 * 	注册实现的服务对象
 * 启动前需要启动 rmiregistry
 * @author zhihuan.niu
 */
public class WarehouseServer {

	public static void main(String[] args) throws RemoteException, NamingException {
		System.out.println("Constructing server implementation...");
		WarehouseImpl warehouse=new WarehouseImpl();
		System.out.println("Binding server implementation to registry");
		Context context=new InitialContext();
		context.bind("rmi://localhost:1099/central_warehouse", warehouse);
		System.out.println("waiting for invocations from clients...");
	}

}
