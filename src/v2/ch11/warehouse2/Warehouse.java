package v2.ch11.warehouse2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
   The remote interface for a simple warehouse.
   @version 1.0 2007-10-09
   @author Cay Horstmann
*/
public interface Warehouse extends Remote {
	double getPrice(String description) throws RemoteException;

	// 返回对象
	Product getProduct(List<String> keywords) throws RemoteException;
}
