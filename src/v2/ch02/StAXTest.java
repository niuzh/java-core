package v2.ch02;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXTest {

	public static void main(String[] args) throws Exception {
		String urlString="http://www.funi.com";
		URL url=new URL(urlString);
		System.out.println(urlString);
		InputStream inputStream=url.openStream();
		XMLInputFactory factory=XMLInputFactory.newFactory();
		XMLStreamReader reader=factory.createXMLStreamReader(inputStream);
		while (reader.hasNext()) {
			int event=reader.next();
			if(event==XMLStreamConstants.START_ELEMENT){
				if(reader.getLocalName().equals("a")){
					String href=reader.getAttributeValue(null,"href");
					if(href!=null){
						System.out.println(href);
					}
				}
			}
		}
	}

}
