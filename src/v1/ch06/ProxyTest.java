/**
 * 
 */
package v1.ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author niu
 *
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] elements=new Object[2];
//		图形程序设计ksdf
		//fill elements with proxies for the integers 1.. 1000
		for(int i=0;i<elements.length;i++){
			Integer value=i+1;
			InvocationHandler handler=new TraceHander(value);
			Object proxy=Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i]=proxy;
		}
		//construct a random integerTraceHander
		Integer key=new Random().nextInt(elements.length)+1;
		//search for the key
		int result=Arrays.binarySearch(elements, key);
		//print match if found
		if(result>0){
			System.out.println(elements[result]);
		}
	}

}
class TraceHander implements InvocationHandler{
	private Object target; 
	public TraceHander(Object object){
		target=object;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.print("."+method.getName()+"(");
		System.out.println(")");
		//invoke actual method
		return method.invoke(target, args);
	}
	
}
