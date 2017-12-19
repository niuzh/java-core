package v2.ch11.webServices;

import javax.jws.WebMethod;
import javax.jws.WebService;

//使用@WebService注解标注WebServiceI接口
@WebService
public interface IWebService {
	//使用@WebMethod注解标注WebServiceI接口中的方法
	@WebMethod
	String sayHello(String name);
}
