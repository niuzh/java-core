/**
 * 
 */
package v2.分布式对象.webServices.service;

import javax.xml.ws.Endpoint;

/**
 * @author niu
 * @date Nov 17, 2017 2:43:27 PM
 * @Description: TODO
 */
public class WebServicePublish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String address="http://192.168.2.150:8081/WS_Server/Webservice";
//		String address="http://localhost:8089/n";
		String address="http://127.0.0.1:8089/n";
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("发布成功");
		//firewall-cmd --add-port=8081/tcp
		///sbin/iptables -I INPUT -p tcp --dport 8081 -j ACCEPT

	}

}
