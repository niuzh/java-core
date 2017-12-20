
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *	RMI服务器端接口实现类 继承UnicastRemoteObject或则 构造器调用UnicastRemoteObject.exportObject(this,0); 
 *	实现接口 Warehouse
 * @author zhihuan.niu
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {
	private Map<String, Double> prices;
	public WarehouseImpl() throws RemoteException{
		//UnicastRemoteObject.exportObject(this,0);
		super();
		prices=new HashMap<>();
		prices.put("java",110.00);
		prices.put("c#",98.00);
	}
	@Override
	public double getPrice(String description) throws RemoteException{
		Double price=prices.get(description);
		return price==null?0:price;
	}

}
