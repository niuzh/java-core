package v2.分布式对象.webServices.service;

import javax.jws.WebService;

@WebService
public class WebServiceImpl implements IWebService{

	@Override
	public String sayHello(String name) {
		System.out.println("WebService sayHello "+name);
		return "sayHello "+name;
	}

}
