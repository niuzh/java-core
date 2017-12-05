package v2.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SockTest {

	public static void main(String[] args) throws Exception, IOException {
		String server = "time-a.nist.gov";
		int port = 13;
		@SuppressWarnings("resource")
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(server, port), 10000);
		try (InputStream inputStream = socket.getInputStream()) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(inputStream);
			int step = 1;
			while (scanner.hasNext()) {
				String string = (String) scanner.next();
				if (step == 2 || step == 3)
					System.out.println(string);
				step++;
			}
		}
	}

}
