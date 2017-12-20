import java.rmi.*;

/**
 * 远程对象的能力由在客户端和服务器之间共享的接口表示
 * 	接口必须扩展Remote接口 方法必须抛出 RemoteException
 * @author zhihuan.niu
 */
public interface Warehouse extends Remote{
	double getPrice(String description) throws RemoteException;
}
