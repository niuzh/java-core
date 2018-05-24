package v2.ch11.activation;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程对象接口
   The remote interface for a simple warehouse.
   @version 1.0 2007-10-09
   @author Cay Horstmann
*/
public interface Warehouse extends Remote {
	/**
	 * 返回产品价格
	 * @param description
	 * @return
	 * @throws RemoteException
	 */
	double getPrice(String description) throws RemoteException;
}
