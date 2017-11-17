package v2.分布式对象.webServices;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Warehouse {
	private Map<String, Double> prices;
	public Warehouse(){
		prices=new HashMap<>();
		prices.put("Blackwell", 24.95);
		prices.put("Oven", 49.95);
	}
	
	public double getPrice(@WebParam(name="description") String description) {
		Double price=prices.get(description);
		return price==null?0:price;
	}
}
