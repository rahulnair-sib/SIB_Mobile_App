package com.SIB.App.Utils;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	
	public HashMap<String,String> parseXML(InputStream file) throws Exception{
		
		HashMap<String,String> stringMap = new HashMap<String,String>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(file);
		document.getDocumentElement().normalize();
		
		Element root = document.getDocumentElement();
		
		NodeList nList = document.getElementsByTagName("String");
		
		for(int temp=0;temp<nList.getLength();temp++) {
			
			Node node = nList.item(temp);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) node;
				stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
			}
		}
		
		return stringMap;
	}

}
