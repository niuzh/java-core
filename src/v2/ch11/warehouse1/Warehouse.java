package v2.ch11.warehouse1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程对象接口必须扩展 Remote
   The remote interface for a simple warehouse.
   @version 1.0 2007-10-09
   @author Cay Horstmann
*/
public interface Warehouse extends Remote {
	/**
	 * 必须抛出异常
	 * @param description
	 * @return
	 * @throws RemoteException
	 */
	double getPrice(String description) throws RemoteException;
}
