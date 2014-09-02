package com.atex.h11.sph.metadata.print;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;
import java.awt.Rectangle;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.InputMap;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.xml.xpath.XPathExpressionException;
import com.atex.h11.sph.metadata.common.ConfigModel;
import com.atex.h11.sph.metadata.common.Constants;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JScrollPane;
import com.atex.h11.sph.metadata.component.CheckBoxList;

import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

//public class MetadataPanel extends JPanel implements ActionListener {
public class MetadataPanel extends JPanel {
	
    // Create the completion service.
    private final static String newline = "\n";  //  @jve:decl-index=0:
    
	private static final long serialVersionUID = 1L;
	private ConfigModel config = null;
	private HashMap<String, String> metadata = null;
	private JLabel jLabel112 = null;
	private JComboBox<String> jCmbST = null;
	private JLabel jLabelFrame = null;
	private JComboBox<String> jCmbPriority = null;
	private JComboBox<String> jCmbSub = null;
	private JLabel jLabel111 = null;
	private JScrollPane jScrollCoAuthor = null;
	private CheckBoxList cbListCoAuthor = null;
	private JLabel jLabel1 = null;
	private JLabel jLabelKeywords = null;
	private JLabel jLabelPri = null;
	private JTextField jTextFieldKeywords = null;
	private JLabel jLabelMandate = null;
	private JLabel jLabelMandate1 = null;
	private JLabel jLabelMandate12 = null;
	private JLabel jLabelMandate13 = null;
	private JLabel jLabel1111 = null;
	private JCheckBox jCheckBoxExclusive = null;
	private JTextArea jTextAreaKey = null;
	private JLabel jLabelVersion = null;
	private JLabel jLabel1112 = null;
	private JTextField jTextFieldURL = null;
	private JCheckBox jCheckBoxSec = null;
	/**
	 * This method initializes jTextFieldKeywords	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldKeywords() {
		if (jTextFieldKeywords == null) {
			jTextFieldKeywords = new JTextField();
			jTextFieldKeywords.setBounds(new Rectangle(34, 266, 236, 22));
			jTextFieldKeywords.setToolTipText("Press Enter to save keywords");

//			Press Enter			
			jTextFieldKeywords.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String text = jTextFieldKeywords.getText();
					jTextFieldKeywords.setText(text);
					jTextAreaKey.setText(text + newline);
					
					if (text == "") {
			    		jLabelMandate13.setVisible(true);
			    	}
			    	else {
			    		jLabelMandate13.setVisible(false);
			    	}			
					
		            /*  Write to a file   */
//		            try {
//		                 File newTextFile = new File(Constants.MY_KEYWORD_FILE);
//		                 FileWriter fw = new FileWriter(newTextFile,true);
//		                 jTextAreaKey.write(fw);
//		         		fw.close();

//		             } catch (IOException iox) {
		                 //do stuff with exception
//		                 iox.printStackTrace();
//		             }
		             
				}
			});

		}

		return jTextFieldKeywords;
	}

	/**
	 * This method initializes jCheckBoxExclusive	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxExclusive() {
		if (jCheckBoxExclusive == null) {
			jCheckBoxExclusive = new JCheckBox();
			jCheckBoxExclusive.setBounds(new Rectangle(206, 169, 21, 21));
		}
		return jCheckBoxExclusive;
	}
	
	/**
	 * This method initializes jCmbPriority	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbPriority() throws XPathExpressionException {
		if (jCmbPriority == null) {
			jCmbPriority = new JComboBox<String>();
			jCmbPriority.setMaximumRowCount(10);
			jCmbPriority.setSize(new Dimension(76, 21));
			jCmbPriority.setLocation(new Point(34, 169));
			jCmbPriority.setName("");
			jCmbPriority.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
				    if (e.getStateChange() == ItemEvent.SELECTED) {
				    	Object source = e.getItem();
				    	if (source == "") {
				    		jLabelMandate12.setVisible(true);
				    	}
				    	else {
				    		jLabelMandate12.setVisible(false);
				    	}
				    } 				
				}
			});			
			config.InitComboBox(jCmbPriority, "priority");
		}
		return jCmbPriority;
	}

	/**
	 * This method initializes jCmbST	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws XPathExpressionException 
	 */
	
	private JComboBox<String> getJCmbST() throws XPathExpressionException {
		if (jCmbST == null) {
			jCmbST = new JComboBox<String>();
			jCmbST.setBounds(new Rectangle(34, 76, 236, 21));
			jCmbST.setName("");
			jCmbST.setFont(new Font("Dialog", Font.BOLD, 12));
			jCmbST.setMaximumRowCount(20);
			jCmbST.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
				    if (e.getStateChange() == ItemEvent.SELECTED) {
				    	Object source = e.getItem();
				    	int myselecteditem = jCmbST.getSelectedIndex();
				    	
//				    	System.out.println(source);
				    	if (source == "") {
				    		jLabelMandate.setVisible(true);
				    	}
				    	else {
							jCmbST.setSelectedIndex(myselecteditem);
				    		jLabelMandate.setVisible(false);
				    	}
				    } 				
//					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
			config.InitComboBox(jCmbST, "webcat1");
		}
		return jCmbST;
		

	}
	
	/**
	 * This method initializes jCmbSub	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbSub() throws XPathExpressionException {
		if (jCmbSub == null) {
			jCmbSub = new JComboBox<String>();
			jCmbSub.setName("");
			jCmbSub.setMaximumRowCount(8);
			jCmbSub.setBounds(new Rectangle(37, 410, 186, 21));
			config.InitComboBox(jCmbSub, "sub");
		}
		return jCmbSub;
	}

	/**
	 * This method initializes jScrollCoAuthor	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollCoAuthor() throws XPathExpressionException {
		if (jScrollCoAuthor == null) {
			final DefaultListModel<JCheckBox> listModel = config.InitCheckBoxListModel("webcat2");	
			cbListCoAuthor = new CheckBoxList();
			cbListCoAuthor.setModel(listModel);			
			jScrollCoAuthor = new JScrollPane(cbListCoAuthor);
			jScrollCoAuthor.setBounds(new Rectangle(435, 77, 233, 334));
			jScrollCoAuthor.setBorder(null);
			jScrollCoAuthor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jScrollCoAuthor.setViewportBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jScrollCoAuthor.setToolTipText("You could select more than one item");
			cbListCoAuthor
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							if (e.getValueIsAdjusting()) {
								System.out.println("change detected");
						        return;
						    }							
						}
					});
			}
		return jScrollCoAuthor;
	}

	/**
	 * This is the default constructor
	 */
	public MetadataPanel(ConfigModel config, HashMap<String, String> metadata) 
			throws XPathExpressionException {
		super();

		this.config = config;
		this.metadata = metadata;
		
		initialize();
		
		// set component values, read from the meta-data hash
		SetComponentValues();
	}	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() 
			throws XPathExpressionException {
		jLabel1112 = new JLabel();
		jLabel1112.setBounds(new Rectangle(37, 324, 78, 19));
		jLabel1112.setText("Hyperlink");
		jLabel1112.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelVersion = new JLabel();
		jLabelVersion.setBounds(new Rectangle(10, 458, 50, 18));
		jLabelVersion.setFont(new Font("Dialog", Font.ITALIC, 8));
		jLabelVersion.setForeground(Color.lightGray);
		jLabelVersion.setText("v1.0.1");
		jLabel1111 = new JLabel();
		jLabel1111.setBounds(new Rectangle(206, 143, 74, 23));
		jLabel1111.setText("Exclusive");
		jLabel1111.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelMandate13 = new JLabel();
		jLabelMandate13.setBounds(new Rectangle(34, 290, 153, 16));
		jLabelMandate13.setForeground(Color.red);
		jLabelMandate13.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelMandate13.setText("<html>You can\'t leave this empty.</html>");
		jLabelMandate13.setVerticalAlignment(SwingConstants.TOP);
		jLabelMandate13.setVerticalTextPosition(SwingConstants.TOP);
		jLabelMandate13.setVisible(true);
		jLabelMandate12 = new JLabel();
		jLabelMandate12.setBounds(new Rectangle(34, 196, 153, 16));
		jLabelMandate12.setForeground(Color.red);
		jLabelMandate12.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelMandate12.setText("<html>You can\'t leave this empty.</html>");
		jLabelMandate12.setVerticalAlignment(SwingConstants.TOP);
		jLabelMandate12.setVerticalTextPosition(SwingConstants.TOP);
		jLabelMandate12.setVisible(true);
		jLabelMandate1 = new JLabel();
		jLabelMandate1.setBounds(new Rectangle(435, 421, 143, 16));
		jLabelMandate1.setForeground(Color.red);
		jLabelMandate1.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelMandate1.setText("<html>You can\'t leave this empty.</html>");
		jLabelMandate1.setVerticalAlignment(SwingConstants.TOP);
		jLabelMandate1.setVerticalTextPosition(SwingConstants.TOP);
		jLabelMandate1.setVisible(true);
		jLabelMandate = new JLabel();
		jLabelMandate.setBounds(new Rectangle(34, 100, 146, 24));
		jLabelMandate.setVerticalAlignment(SwingConstants.TOP);
		jLabelMandate.setVerticalTextPosition(SwingConstants.TOP);
		jLabelMandate.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelMandate.setForeground(Color.red);
		jLabelMandate.setText("<html>You can't leave this empty.</html>");
		jLabelMandate.setVisible(true);
		jLabelPri = new JLabel();
		jLabelPri.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelPri.setSize(new Dimension(73, 23));
		jLabelPri.setLocation(new Point(34, 143));
		jLabelPri.setText("Priority");
		jLabelKeywords = new JLabel();
		jLabelKeywords.setBounds(new Rectangle(34, 239, 77, 21));
		jLabelKeywords.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelKeywords.setText("Keywords");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(435, 45, 82, 24));
		jLabel1.setToolTipText("You may select more than one web categories");
		jLabel1.setText("<html>Secondary</html>");
//		jLabel1.setBounds(new Rectangle(29, 119, 82, 30));
		jLabel1.setVerticalAlignment(SwingConstants.TOP);
		jLabel1.setVerticalTextPosition(SwingConstants.TOP);
		jLabel1.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel111 = new JLabel();
		jLabel111.setBounds(new Rectangle(37, 383, 54, 24));
		jLabel111.setText("Sub");
		jLabel111.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelFrame = new JLabel();
		jLabelFrame.setName("");
		jLabelFrame.setBounds(new Rectangle(283, 8, 123, 23));
		jLabelFrame.setFont(new Font("Dialog", Font.BOLD, 12));
		jLabelFrame.setText("NEWS CATEGORY");
		jLabel112 = new JLabel();
		jLabel112.setBounds(new Rectangle(34, 44, 77, 26));
		jLabel112.setText("<html>Primary</html>");
		jLabel112.setVerticalAlignment(SwingConstants.TOP);
		jLabel112.setVerticalTextPosition(SwingConstants.TOP);
		jLabel112.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.setLayout(null);
		this.setSize(720, 481);

        //Group the web cat radio buttons.
//        ButtonGroup radioButtonGroup1 = new ButtonGroup();
		
		// lists
		this.add(getJCmbST(), null);
		this.add(jLabel112, null);
		this.add(jLabelFrame, null);
		this.add(getJCmbPriority(), null);
		this.add(getJCmbSub(), null);
		this.add(jLabel111, null);
		this.add(getJScrollCoAuthor(), null);
		this.add(jLabel1, null);
		this.add(jLabelKeywords, null);
		this.add(jLabelPri, null);
		this.add(getJTextFieldKeywords(), null);
		this.add(jLabelMandate, null);
		this.add(jLabelMandate1, null);
		this.add(jLabelMandate12, null);
		this.add(jLabelMandate13, null);
		this.add(jLabel1111, null);
		this.add(getJCheckBoxExclusive(), null);
		this.add(getJTextAreaKey(), null);
		this.add(jLabelVersion, null);
		this.add(jLabel1112, null);
		this.add(getJTextFieldURL(), null);
		this.add(getJCheckBoxSec(), null);
		
		//jTextFieldKeywords.getDocument().addDocumentListener(this);
	}
	

	private void SetComponentValues() 
			throws XPathExpressionException {
		
		// combo boxes
		jCmbST.setSelectedItem(metadata.get(config.GetMetadataName("webcat1")));
		jCmbPriority.setSelectedItem(metadata.get(config.GetMetadataName("priority")));

		// subbing info
		jCmbSub.setSelectedItem(metadata.get(config.GetMetadataName("sub")));
		
		// checkbox lists
		cbListCoAuthor.setSelectedFromListString(metadata.get(config.GetMetadataName("webcat2")));			
		
		// Text field
		jTextFieldKeywords.setText(metadata.get(config.GetMetadataName("keywords")));
		jTextFieldURL.setText(metadata.get(config.GetMetadataName("hyperlink")));

		// checkbox

		if (metadata.containsKey(config.GetMetadataName("exclusive"))) {
			jCheckBoxExclusive.setSelected(metadata.get(config.GetMetadataName("exclusive")).equalsIgnoreCase(Constants.TRUE));
		}
		else {
			jCheckBoxExclusive.setSelected(false);
		}		

		if (metadata.containsKey(config.GetMetadataName("sec"))) {
			jCheckBoxSec.setSelected(metadata.get(config.GetMetadataName("sec")).equalsIgnoreCase(Constants.TRUE));
		}
		else {
			jCheckBoxSec.setSelected(false);
		}		

	}
	
	public boolean isReady() {
		// put any required validation here
		return true;
	}	
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();

		// radio/check boxes
		// Text area
		retMetadata.put(config.GetMetadataName("keywords"), jTextFieldKeywords.getText());
		retMetadata.put(config.GetMetadataName("hyperlink"), jTextFieldURL.getText());
	
		// combo boxes
		retMetadata.put(config.GetMetadataName("webcat1"), (String) jCmbST.getSelectedItem());
		retMetadata.put(config.GetMetadataName("pri"), swapFunction((String) jCmbST.getSelectedItem()));
		retMetadata.put(config.GetMetadataName("priority"), (String) jCmbPriority.getSelectedItem());
		// Subbing info
		retMetadata.put(config.GetMetadataName("sub"), (String) jCmbSub.getSelectedItem());
		// checkbox lists
	    retMetadata.put(config.GetMetadataName("webcat2"), cbListCoAuthor.getSelectedListString());
	    retMetadata.put(config.GetMetadataName("sec"), swapFunction(cbListCoAuthor.getSelectedListString()));
		
		// checkbox
	    retMetadata.put(config.GetMetadataName("exclusive"), jCheckBoxExclusive.isSelected() ? Constants.TRUE : Constants.FALSE);
	    
		return retMetadata;
	}
	
/* -- new methods here  */	
	
    public void run() {
    	
    }


    /**
	 * This method initializes jTextAreaKey	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaKey() {
		if (jTextAreaKey == null) {
			jTextAreaKey = new JTextArea();
			jTextAreaKey.setBounds(new Rectangle(280, 267, 141, 63));
			jTextAreaKey.setLineWrap(true);
//			jTextAreaKey.getDocument().addDocumentListener(this);
			jTextAreaKey.setVisible(false);
		}
		return jTextAreaKey;
	}

	public String swapFunction(String a) {

		  String webcat = a;
		  // change to upper case
		  webcat = webcat.toUpperCase();
		  // remove amp, dash and space
		  webcat = webcat.replaceAll("&", "");
		  webcat = webcat.replaceAll(" ", "");
		  webcat = webcat.replaceAll("'", "");
		  webcat = webcat.replaceAll("\\(.*\\)", "");		  
		  webcat = webcat.replaceAll("STOCKS-","STOCKS");		  
		  webcat = webcat.replaceAll("OPINION-","");		  
		  webcat = webcat.replaceAll("WEEKLY-","");		  
		  webcat = webcat.replaceAll("LIFESTYLE-","");
		  webcat = webcat.replaceAll("FOCUS-","");
	      
	      return webcat;
	}

	/**
	 * This method initializes jTextFieldURL	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldURL() {
		if (jTextFieldURL == null) {
			jTextFieldURL = new JTextField();
			jTextFieldURL.setBounds(new Rectangle(37, 351, 230, 20));
		}
		return jTextFieldURL;
	}

	/**
	 * This method initializes jCheckBoxSec	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxSec() {
		if (jCheckBoxSec == null) {
			jCheckBoxSec = new JCheckBox();
			jCheckBoxSec.setBounds(new Rectangle(572, 45, 21, 21));
			jCheckBoxSec.setVisible(false);
			jCheckBoxSec.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
				    if (e.getStateChange() == ItemEvent.SELECTED) {
//				    	Object source = e.getItem();
				    	String source = cbListCoAuthor.getSelectedListString().toString();
//				    	System.out.println(source);
				    	if (source == "") {
				    		jLabelMandate1.setVisible(true);
				    	}
				    	else {
				    		jLabelMandate1.setVisible(false);
				    	}
				    } 				

					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return jCheckBoxSec;
	}
  
}  //  @jve:decl-index=0:visual-constraint="-32,-1"








