package v2.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * socket服务器
 * 
 * @author niu 测试命令 telnet localhost 8189
 */
public class EchoServer {
	public static void main(String[] args) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(8189)) {
			System.out.println("ServerSocket(8189)");
			try (Socket socket = serverSocket.accept()) {
				System.out.println("serverSocket.accept()");
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				try (Scanner scanner = new Scanner(inputStream)) {
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println("hello ! entry BYE to exit");

					boolean done = false;
					while (!done && scanner.hasNext()) {
						String string = (String) scanner.next();
						out.println("echo:" + string+" ?");
						if (string.trim().equals("BYE"))
							done = true;
					}
				}
			}
		}
	}
}
