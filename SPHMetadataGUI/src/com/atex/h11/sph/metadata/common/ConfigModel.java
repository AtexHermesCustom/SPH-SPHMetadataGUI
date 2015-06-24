package com.atex.h11.sph.metadata.common;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class ConfigModel {
    private DocumentBuilderFactory dbf = null;
    private DocumentBuilder db = null;
    private XPathFactory xpf = null;
    private XPath xp = null;    
    
    private Properties props = null;
    private Document doc;
    private String metadataGroup = null;
    
    public ConfigModel(String group) 
    		throws ParserConfigurationException, IOException, SAXException, CustomException {
        // Prepare a document builder.
        dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        db = dbf.newDocumentBuilder();
        
		// Prepare an XPath
		xpf = XPathFactory.newInstance();
		xp = xpf.newXPath();        
		
		// load props file
		props = loadProperties(new File(Constants.METADATA_PROPERTIES_FILE));
		
		// get xml config file per group
		String xmlConfFile = props.getProperty(group);	
		if (xmlConfFile == null || xmlConfFile.isEmpty()) {
			throw new CustomException("\"" + group + "\" property cannot be found or is blank");
		}
		
		// load xml config file
		doc = db.parse(xmlConfFile);
		
		this.metadataGroup = group;
    }
    
	protected Properties loadProperties(File propsFile) 
			throws FileNotFoundException, IOException {
		Properties p = new Properties();
		FileInputStream in = null;
		in = new FileInputStream(propsFile);
		p.load(in);
		in.close();
		return p;
	}    
  
    public String GetXpathValue(String xpath)
    		throws XPathExpressionException {
    	String val = "";	// default value
    	Node n = (Node) xp.evaluate(xpath, doc.getDocumentElement(), XPathConstants.NODE);
    	if (n != null) {
    		val = n.getTextContent();
    	}
    	return val;
    }

    public String GetConfigValue(String key)
    		throws XPathExpressionException {
    	return GetXpathValue("configuration/" + key);
    }

    public String GetMetadataName(String key)
			throws XPathExpressionException {
    	return GetXpathValue(metadataGroup + "/metadataNames/" + key);
    }
        
    public NodeList GetListItems(String metadata) 
			throws XPathExpressionException {
    	NodeList nl = (NodeList) 
    	xp.evaluate(metadataGroup + "/" + metadata + "/item", doc.getDocumentElement(), XPathConstants.NODESET);
    	return nl;
    }
    
    public String GetAttribValue(String metadata, String attrib)
			throws XPathExpressionException {
    	return GetXpathValue(metadataGroup + "/" + metadata + "/@" + attrib);
    }    
    
    public void InitComboBox(JComboBox<String> cmbBox, String metadata) 
			throws XPathExpressionException {
		NodeList nl = GetListItems(metadata); 
		// insert empty item
		if (GetAttribValue(metadata, "insertEmptyItem").trim().equals("1")) {
			cmbBox.addItem("");
		}
		// insert items
		for (int i = 0; i < nl.getLength(); i++) {
			cmbBox.addItem(nl.item(i).getTextContent().trim());
		}
		// select default
		if (GetAttribValue(metadata, "selectFirstItemAsDefault").trim().equals("1")) {
			cmbBox.setSelectedIndex(0);
		}
		
		// select mandatory
		if (GetAttribValue(metadata, "selectMandatory").trim().equals("1")) {
			cmbBox.setBackground(Color.red);
		}

	}    
 
    public DefaultListModel<JCheckBox> InitCheckBoxListModel(String metadata) 
			throws XPathExpressionException {
		NodeList nl = GetListItems(metadata);
		DefaultListModel<JCheckBox> listModel = new DefaultListModel<JCheckBox>();
		// insert items
		for (int i = 0; i < nl.getLength(); i++) {
			String checkBoxText = nl.item(i).getTextContent().trim();
			listModel.addElement(new JCheckBox(checkBoxText));	// add new checkbox
		}
		return listModel;
	}	    
    
}
