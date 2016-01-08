package misc;



import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class xPathExample {

	public static void main(String args[]){
		
		String xml="<bookstore><book>";
		xml=xml+"<title>Everyday Italian</title>";
		xml=xml+"<author>Giada De Laurentiis</author>";
		xml=xml+"<year>2005</year>";
		xml=xml+"</book></bookstore>";  
			DocumentBuilderFactory domFactory = 
				  DocumentBuilderFactory.newInstance();
				  domFactory.setNamespaceAware(true); 
				  DocumentBuilder builder;
				try {
					builder = domFactory.newDocumentBuilder();
				
				  Document doc = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));
				  XPath xpath = XPathFactory.newInstance().newXPath();
				   // XPath Query for showing all nodes value
				  XPathExpression expr = xpath.compile("/bookstore/book/title/text()");
//QueryPlan/DisplayPlan/DirectDisplay/template_type/text()
				  
				  
				  Object result = expr.evaluate(doc, XPathConstants.NODESET);
				  NodeList nodes = (NodeList) result;
				  for (int i = 0; i < nodes.getLength(); i++) {
				 System.out.println(nodes.item(i).getNodeValue()); 
				  }
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XPathExpressionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
//	public static void main(String args[]) {
//		String xml = "<urn:ResponseStatus version=\"1.0\" xmlns:urn=\"urn:camera-org\">\r\n"
//				+ //
//				"\r\n"
//				+ //
//				"<urn:requestURL>/CAMERA/Streaming/status</urn:requestURL>\r\n"
//				+ //
//				"<urn:statusCode>4</urn:statusCode>\r\n" + //
//				"<urn:statusString>Invalid Operation</urn:statusString>\r\n" + //
//				"<urn:id>0</urn:id>\r\n" + //
//				"\r\n" + //
//				"</urn:ResponseStatus>";
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		DocumentBuilder builder;
//		Document doc;
//		try {
//			builder = factory.newDocumentBuilder();
//
//			doc = builder
//					.parse(new java.io.ByteArrayInputStream(xml.getBytes()));
//		
//		XPath xpath = XPathFactory.newInstance().newXPath();
//			xpath.setNamespaceContext(new NamespaceContext() {
//				public String getNamespaceURI(String prefix) {
//					return prefix.equals("urn") ? "urn:camera-org" : null;
//				}
//
//				public Iterator<?> getPrefixes(String val) {
//					return null;
//				}
//
//				public String getPrefix(String uri) {
//					return null;
//				}
//			});
//		XPathExpression expr;
//			expr = xpath.compile("//urn:requestURL");
//			Object result = expr.evaluate(doc, XPathConstants.NODESET);
//			NodeList nodes = (NodeList) result;
//			for (int i = 0; i < nodes.getLength(); i++) {
//				Node currentItem = nodes.item(i);
//				System.out.println("found node -> " + currentItem.getLocalName()
//						+ " (namespace: " + currentItem.getNamespaceURI() + ")");
//			}
//		} catch (XPathExpressionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
