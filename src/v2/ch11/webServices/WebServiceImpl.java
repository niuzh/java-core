package v2.ch11.webServices;

import javax.jws.WebService;

@WebService
public class WebServiceImpl implements IWebService{

	@Override
	public String sayHello(String name) {
		System.out.println("WebService sayHello "+name);
		return "sayHello "+name;
	}

}
