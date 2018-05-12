package v2.ch03.server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 测试终端命令 telnet localhost 8189
 * This program implements a simple server that listens to port 8189 and echoes
 * back all client input.
 * 
 * @version 1.21 2012-05-19
 * @author Cay Horstmann
 */
public class EchoServer {
	public static void main(String[] args) throws IOException {
		// establish server socket
		//创建一个监听端口的服务器套接字
		try (ServerSocket s = new ServerSocket(8189)) {
			// wait for client connection
			//等待客户端连接
			try (Socket incoming = s.accept()) {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();

				try (Scanner in = new Scanner(inStream)) {
					PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

					out.println("Hello! Enter BYE to exit.");

					// echo client input
					boolean done = false;
					while (!done && in.hasNextLine()) {
						String line = in.nextLine();
						out.println("Echo: " + line);
						if (line.trim().toUpperCase().equals("BYE"))
							done = true;
					}
				}
			}
		}
	}
}