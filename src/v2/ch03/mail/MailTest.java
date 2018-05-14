package v2.ch03.mail;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * This program shows how to use JavaMail to send mail messages.
 * 
 * @author Cay Horstmann
 * @version 1.00 2012-06-04
 */
public class MailTest {
	public static void main(String[] args) throws MessagingException, IOException {
		Properties props = new Properties();
		/*try (InputStream in = Files.newInputStream(Paths.get("/home/niu/workspace/java-core9/src/v2/ch03/mail", "mail.properties"))) {
			props.load(in);
		}*/
		Path msgPth=Paths.get("/home/niu/workspace/java-core9/src/v2/ch03/mail", "message.txt");
		List<String> lines = Files.readAllLines(msgPth, Charset.forName("UTF-8"));

		String from = "niuzhihuan@163.com";
		String to = lines.get(1);
		String subject = lines.get(2);

		StringBuilder builder = new StringBuilder();
		for (int i = 3; i < lines.size(); i++) {
			builder.append(lines.get(i));
			builder.append("\n");
		}
		
		props.put("mail.smtp.host", "smtp.163.com");//存储发送邮件服务器的信息  
        props.put("mail.smtp.auth", "true");//同时通过验证  
		Session mailSession = Session.getInstance(props);
		// mailSession.setDebug(true);
		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setText(builder.toString());
		Transport tr = mailSession.getTransport("smtp");
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.println("input your passowrd:");
			String password =scanner.nextLine();
			password="niu2018";
			tr.connect(from, password);
			tr.sendMessage(message, message.getAllRecipients());
		} finally {
			tr.close();
		}
	}
}
