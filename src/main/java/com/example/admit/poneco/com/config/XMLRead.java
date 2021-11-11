package com.example.admit.poneco.com.config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.example.admit.poneco.com.ConfigPath;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * XML文件读取获取数据
 * @author Administrator
 *
 */
public class XMLRead implements ConfigPath {
    public String getValue(String idName) {
        String alex = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(SQLPath);
            Element root = doc.getDocumentElement();
            NodeList nl = root.getElementsByTagName(idName);
            Element e = (Element) nl.item(0);
            alex=e.getTextContent();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return alex;
    }
}