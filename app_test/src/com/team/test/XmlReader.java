package com.team.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;

public class XmlReader {
	
	public static void main (String args[]){
		

	    try {
	    	
	    	File xsdFile = new File("test.xsd");
		    XMLReaderJDOMFactory schemafac = new XMLReaderXSDFactory(xsdFile);
	    	
	    	SAXBuilder builder = new SAXBuilder(schemafac);
		    File xmlFile = new File("test.xml");
		    	    	
	        Document document = (Document) builder.build(xmlFile);
	        Element rootNode = document.getRootElement();
	        
	        Element email 	= rootNode.getChild("email");
	        Element ftp 	= rootNode.getChild("ftp");
	        Element file 	= rootNode.getChild("file");
	        List<Element> lstMapping 	= rootNode.getChildren("mapping");
	        
	        System.out.println("Email");
	        System.out.println("---------------------------------------");
	        System.out.println("server:"+email.getChildText("server"));
	        System.out.println("account:"+email.getChildText("account"));
	        System.out.println("password:"+email.getChildText("password"));
	        System.out.println("port:"+email.getChildText("port"));
	        System.out.println("connection:"+email.getChildText("connection"));
	        
	        System.out.println("Ftp");
	        System.out.println("---------------------------------------");
	        
	        System.out.println("server:"+ftp.getChildText("server"));
	        System.out.println("account:"+ftp.getChildText("account"));
	        System.out.println("password:"+ftp.getChildText("password"));
	        System.out.println("port:"+ftp.getChildText("port"));
	        System.out.println("connection:"+ftp.getChildText("connection"));
	        System.out.println("mode:"+ftp.getChildText("mode"));
	        
	        System.out.println("File");
	        System.out.println("---------------------------------------");
	        
	        System.out.println("download:"+file.getChildText("download"));
	        System.out.println("upload:"+file.getChildText("upload"));
	        System.out.println("extension:"+file.getChildText("extension"));
	        int delimiter = Integer.parseInt(file.getChildText("delimiter"));
	        System.out.println("delimiter:"+ Character.toString ((char) delimiter));
	        System.out.println("log:"+file.getChildText("log"));
	        
	        System.out.println("Mapping");
	        System.out.println("---------------------------------------");
	        for (Iterator<Element> iterator = lstMapping.iterator(); iterator.hasNext();) {
				Element mapping = iterator.next();
				Element filter	= mapping.getChild("filter");
				System.out.println("Carpeta:"+mapping.getChildText("folder"));
				System.out.println(filter.getChildText("subject"));
				System.out.println(filter.getChildText("from"));
				System.out.println(filter.getChildText("filename"));
				System.out.println();
			}
	        
	    } catch (IOException io) {
	    	System.out.println(io.getMessage());
	    } catch (JDOMException jdomex) {
	    	System.out.println(jdomex.getMessage());
	    }
	}
}
