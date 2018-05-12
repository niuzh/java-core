package v2.ch03.inetAddress;

import java.io.*;
import java.net.*;

/**
 * This program demonstrates the InetAddress class. Supply a host name as
 * command-line argument, or run without command-line arguments to see the
 * address of the local host.
 * 
 * @version 1.02 2012-06-05
 * @author Cay Horstmann
 */
public class InetAddressTest {
	public static void main(String[] args) throws IOException {
		// www.horstmann.com
		args = new String[1];
		args[0] = "www.horstmann.com";
		if (args.length > 0) {
			String host = args[0];
			InetAddress[] addresses = InetAddress.getAllByName(host);
			for (InetAddress a : addresses){
				System.out.println(a);
				System.out.println("getHostAddress: "+a.getHostAddress());
				System.out.println("getHostName: "+a.getHostName());
			}
		} else {
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
