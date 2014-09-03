package com.atex.h11.sph.metadata.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.xml.xpath.XPathExpressionException;

import com.atex.h11.sph.metadata.component.CheckBoxList;
import com.atex.h11.sph.metadata.common.ConfigModel;
import com.atex.h11.sph.metadata.common.Constants;
import com.atex.h11.sph.metadata.autocomplete.Autocomplete;


public class MetadataPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ConfigModel config = null;
	private HashMap<String, String> metadata = null;
	
	private String keywordsFile = null;
	private List<String> keywords = null;
	private Autocomplete autoComplete = null;
	private final String COMMIT_ACTION = "commit";
	private final String DELIMITER = ",";
	
	private JLabel jLabel112 = null;
	private JComboBox<String> jCmbPrimary = null;
	private JLabel jLabelFrame = null;
	private JComboBox<String> jCmbPriority = null;
	private JComboBox<String> jCmbSub = null;
	private JLabel jLabel111 = null;
	private JScrollPane jScrollSecondary = null;
	private CheckBoxList cbListSecondary;
	private JLabel jLabel1 = null;
	private JLabel jLabelKeywords = null;
	private JLabel jLabelPri = null;
	private JTextField jTextFieldKeywords = null;
	private JLabel jLabelPrimaryMandatory;
	private JLabel jLabelSecondaryMandatory;
	private JLabel jLabelPriorityMandatory;
	private JLabel jLabelKeywordsMandatory;
	private JLabel jLabel1111 = null;
	private JCheckBox jCheckBoxExclusive = null;
	private JLabel jLabelVersion = null;
	private JLabel jLabel1112 = null;
	private JTextField jTextFieldURL = null;
	private JCheckBox jCheckBoxSecondary = null;
	
	/**
	 * This method initializes jTextFieldKeywords	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldKeywords() {
		if (jTextFieldKeywords == null) {
			jTextFieldKeywords = new JTextField();
			jTextFieldKeywords.setBounds(new Rectangle(37, 266, 369, 22));
			jTextFieldKeywords.setToolTipText("Press ENTER to enter a new keyword");
		}
		return jTextFieldKeywords;
	}
	
	/**
	 * This method initializes jTextFieldURL	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldURL() {
		if (jTextFieldURL == null) {
			jTextFieldURL = new JTextField();
			jTextFieldURL.setBounds(new Rectangle(37, 351, 369, 20));
		}
		return jTextFieldURL;
	}	

	/**
	 * This method initializes jCheckBoxExclusive	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxExclusive() {
		if (jCheckBoxExclusive == null) {
			jCheckBoxExclusive = new JCheckBox();
			jCheckBoxExclusive.setBounds(new Rectangle(204, 163, 21, 21));
		}
		return jCheckBoxExclusive;
	}

	/**
	 * This method initializes getJCmbPrimary	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws XPathExpressionException 
	 */
	
	private JComboBox<String> getJCmbPrimary() throws XPathExpressionException {
		if (jCmbPrimary == null) {
			jCmbPrimary = new JComboBox<String>();
			jCmbPrimary.setBounds(new Rectangle(37, 76, 292, 21));
			jCmbPrimary.setName("");
			jCmbPrimary.setFont(new Font("Dialog", Font.BOLD, 12));
			jCmbPrimary.setMaximumRowCount(20);
			config.InitComboBox(jCmbPrimary, "primarycat");
		}
		return jCmbPrimary;
	}

	/**
	 * This method initializes jCheckBoxSec	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxSecondary() {
		if (jCheckBoxSecondary == null) {
			jCheckBoxSecondary = new JCheckBox();
			jCheckBoxSecondary.setBounds(new Rectangle(526, 53, 21, 21));
			jCheckBoxSecondary.setVisible(true);
			jCheckBoxSecondary.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	            	if (e.getStateChange() == ItemEvent.SELECTED) {
	            		jScrollSecondary.setEnabled(true);
	            		cbListSecondary.setEnabled(true);
	            	}
	            	else {
	            		jScrollSecondary.setEnabled(false);
	            		cbListSecondary.setEnabled(false);
	            		cbListSecondary.deselectAll();
	            	}
	            }
	        });	
		}
		return jCheckBoxSecondary;
	}	
	
	/**
	 * This method initializes getJScrollSecondary	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollSecondary() throws XPathExpressionException {
		if (jScrollSecondary == null) {
			DefaultListModel<JCheckBox> listModel = config.InitCheckBoxListModel("secondarycat");	
			cbListSecondary = new CheckBoxList();
			cbListSecondary.setModel(listModel);			
			jScrollSecondary = new JScrollPane(cbListSecondary);
			jScrollSecondary.setBounds(new Rectangle(435, 77, 233, 334));
			jScrollSecondary.setBorder(null);
			jScrollSecondary.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jScrollSecondary.setViewportBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jScrollSecondary.setToolTipText("You could select more than one item");
		}
		return jScrollSecondary;
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
			jCmbPriority.setLocation(new Point(37, 169));
			jCmbPriority.setName("");			
			config.InitComboBox(jCmbPriority, "priority");
		}
		return jCmbPriority;
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
			jCmbSub.setBounds(new Rectangle(37, 410, 289, 21));
			config.InitComboBox(jCmbSub, "sub");
		}
		return jCmbSub;
	}


	/**
	 * This is the default constructor
	 * 
	 * @return void
	 * @throws FileNotFoundException 
	 */
	public MetadataPanel(ConfigModel config, HashMap<String, String> metadata) 
			throws XPathExpressionException, FileNotFoundException {
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
	 * @throws FileNotFoundException 
	 */
	private void initialize() 
			throws XPathExpressionException, FileNotFoundException {
		jLabel1112 = new JLabel();
		jLabel1112.setBounds(new Rectangle(37, 327, 78, 19));
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
		jLabelKeywordsMandatory = new JLabel();
		jLabelKeywordsMandatory.setBounds(new Rectangle(38, 291, 368, 16));
		jLabelKeywordsMandatory.setForeground(Color.red);
		jLabelKeywordsMandatory.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelKeywordsMandatory.setText("");
		jLabelKeywordsMandatory.setVerticalAlignment(SwingConstants.TOP);
		jLabelKeywordsMandatory.setVerticalTextPosition(SwingConstants.TOP);
		jLabelKeywordsMandatory.setVisible(true);
		jLabelPriorityMandatory = new JLabel();
		jLabelPriorityMandatory.setBounds(new Rectangle(37, 192, 292, 16));
		jLabelPriorityMandatory.setForeground(Color.red);
		jLabelPriorityMandatory.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelPriorityMandatory.setText("");
		jLabelPriorityMandatory.setVerticalAlignment(SwingConstants.TOP);
		jLabelPriorityMandatory.setVerticalTextPosition(SwingConstants.TOP);
		jLabelPriorityMandatory.setVisible(true);
		jLabelSecondaryMandatory = new JLabel();
		jLabelSecondaryMandatory.setBounds(new Rectangle(437, 417, 259, 16));
		jLabelSecondaryMandatory.setForeground(Color.red);
		jLabelSecondaryMandatory.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelSecondaryMandatory.setText("");
		jLabelSecondaryMandatory.setVerticalAlignment(SwingConstants.TOP);
		jLabelSecondaryMandatory.setVerticalTextPosition(SwingConstants.TOP);
		jLabelSecondaryMandatory.setVisible(true);
		jLabelPrimaryMandatory = new JLabel();
		jLabelPrimaryMandatory.setBounds(new Rectangle(37, 99, 292, 24));
		jLabelPrimaryMandatory.setVerticalAlignment(SwingConstants.TOP);
		jLabelPrimaryMandatory.setVerticalTextPosition(SwingConstants.TOP);
		jLabelPrimaryMandatory.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelPrimaryMandatory.setForeground(Color.red);
		jLabelPrimaryMandatory.setText("");
		jLabelPrimaryMandatory.setVisible(true);
		jLabelPri = new JLabel();
		jLabelPri.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelPri.setSize(new Dimension(73, 23));
		jLabelPri.setLocation(new Point(37, 143));
		jLabelPri.setText("Priority");
		jLabelKeywords = new JLabel();
		jLabelKeywords.setBounds(new Rectangle(37, 242, 77, 21));
		jLabelKeywords.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelKeywords.setText("Keywords");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(436, 53, 82, 24));
		jLabel1.setToolTipText("You may select more than one web categories");
		jLabel1.setText("<html>Secondary</html>");
//		jLabel1.setBounds(new Rectangle(29, 119, 82, 30));
		jLabel1.setVerticalAlignment(SwingConstants.TOP);
		jLabel1.setVerticalTextPosition(SwingConstants.TOP);
		jLabel1.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel111 = new JLabel();
		jLabel111.setBounds(new Rectangle(37, 386, 54, 24));
		jLabel111.setText("Sub");
		jLabel111.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelFrame = new JLabel();
		jLabelFrame.setName("");
		jLabelFrame.setBounds(new Rectangle(283, 8, 123, 23));
		jLabelFrame.setFont(new Font("Dialog", Font.BOLD, 12));
		jLabelFrame.setText("NEWS CATEGORY");
		jLabel112 = new JLabel();
		jLabel112.setBounds(new Rectangle(38, 53, 77, 26));
		jLabel112.setText("<html>Primary</html>");
		jLabel112.setVerticalAlignment(SwingConstants.TOP);
		jLabel112.setVerticalTextPosition(SwingConstants.TOP);
		jLabel112.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.setLayout(null);
		this.setSize(720, 481);

		this.add(getJCmbPrimary(), null);
		this.add(jLabel112, null);
		this.add(jLabelFrame, null);
		this.add(getJCmbPriority(), null);
		this.add(getJCmbSub(), null);
		this.add(jLabel111, null);
		this.add(getJScrollSecondary(), null);
		this.add(jLabel1, null);
		this.add(jLabelKeywords, null);
		this.add(jLabelPri, null);
		this.add(getJTextFieldKeywords(), null);
		this.add(jLabelPrimaryMandatory, null);
		this.add(jLabelSecondaryMandatory, null);
		this.add(jLabelPriorityMandatory, null);
		this.add(jLabelKeywordsMandatory, null);
		this.add(jLabel1111, null);
		this.add(getJCheckBoxExclusive(), null);
		this.add(jLabelVersion, null);
		this.add(jLabel1112, null);
		this.add(getJTextFieldURL(), null);
		this.add(getJCheckBoxSecondary(), null);

		
		// for keywords autocomplete
		keywordsFile = config.GetAttribValue("keywords", "file");
		initAutoComplete();
	}
	
	private void initAutoComplete() 
			throws FileNotFoundException, XPathExpressionException {
		// read keywords from file
		Scanner scanner = new Scanner(new File(keywordsFile));
		keywords = new ArrayList<String>();
		while (scanner.hasNext()) {
			String s = scanner.next();
			//System.out.println("added keyword: " + s);
			keywords.add(s.toLowerCase());	// case-insensitive			
		}
		scanner.close();		
		
		// autocomplete listener
		autoComplete = new Autocomplete(getJTextFieldKeywords(), keywords, DELIMITER);
		getJTextFieldKeywords().getDocument().addDocumentListener(autoComplete);
		
		// text field commit action
		getJTextFieldKeywords().getInputMap().put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
		getJTextFieldKeywords().getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());			
	}
	
	private void SetComponentValues() 
			throws XPathExpressionException {
		
		// combo boxes
		jCmbPrimary.setSelectedItem(metadata.get(config.GetMetadataName("primarycat")));
		jCmbPriority.setSelectedItem(metadata.get(config.GetMetadataName("priority")));

		// subbing info
		jCmbSub.setSelectedItem(metadata.get(config.GetMetadataName("sub")));
		
		// checkbox lists
		cbListSecondary.setSelectedFromListString(metadata.get(config.GetMetadataName("secondarycat")));			
		
		// Text field
		jTextFieldKeywords.setText(metadata.get(config.GetMetadataName("keywords")));
		jTextFieldURL.setText(metadata.get(config.GetMetadataName("hyperlink")));

		// checkboxes
		if (metadata.containsKey(config.GetMetadataName("exclusive"))) {
			jCheckBoxExclusive.setSelected(metadata.get(config.GetMetadataName("exclusive")).equalsIgnoreCase(Constants.TRUE));
		}
		else {
			jCheckBoxExclusive.setSelected(false);
		}		

		if (metadata.containsKey(config.GetMetadataName("hassecondarycat"))) {
			jCheckBoxSecondary.setSelected(metadata.get(config.GetMetadataName("hassecondarycat")).equalsIgnoreCase(Constants.TRUE));
		}
		else {
			jCheckBoxSecondary.setSelected(false);
		}		

	}
	
	public boolean isReady() {
		/*
		 * put any required validations here
		 */
		boolean isReady = true;
		String requiredMsg = "<html>You cannot leave this empty.</html>";

		jLabelPrimaryMandatory.setText("");
		jLabelSecondaryMandatory.setText("");
		jLabelKeywordsMandatory.setText("");
		jLabelPriorityMandatory.setText("");

		if (((String)jCmbPrimary.getSelectedItem()).trim().isEmpty() || jCmbPrimary.getSelectedIndex() < 0) {
			jLabelPrimaryMandatory.setText(requiredMsg);
			isReady = false;
		}
		
		if (((String)jCmbPriority.getSelectedItem()).trim().isEmpty() || jCmbPriority.getSelectedIndex() < 0) {
			jLabelPriorityMandatory.setText(requiredMsg);
			isReady = false;
		}
		
		if (! jTextFieldKeywords.getText().trim().matches(".*[A-Za-z0-9]+.*")) {
			jLabelKeywordsMandatory.setText(requiredMsg);
			isReady = false;
		}
		
		if (jCheckBoxSecondary.isSelected()) {
			if (cbListSecondary.getSelectedCount() <= 0) {
				jLabelSecondaryMandatory.setText(requiredMsg);
				isReady = false;
			}
		}
		
		return isReady;
	}	
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException, IOException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();

		// radio/check boxes
		// Text area
		String keywordsList = jTextFieldKeywords.getText();
		keywordsList = keywordsList.replaceAll(",*$", ""); 	// replace ending comma
		retMetadata.put(config.GetMetadataName("keywords"), keywordsList);
		retMetadata.put(config.GetMetadataName("hyperlink"), jTextFieldURL.getText());	
		// combo boxes
		retMetadata.put(config.GetMetadataName("primarycat"), (String) jCmbPrimary.getSelectedItem());
		retMetadata.put(config.GetMetadataName("priority"), (String) jCmbPriority.getSelectedItem());
		// Subbing info
		retMetadata.put(config.GetMetadataName("sub"), (String) jCmbSub.getSelectedItem());
		// checkbox lists
	    retMetadata.put(config.GetMetadataName("secondarycat"), swapFunction(cbListSecondary.getSelectedListString()));
		// checkbox
	    retMetadata.put(config.GetMetadataName("exclusive"), jCheckBoxExclusive.isSelected() ? Constants.TRUE : Constants.FALSE);
	    retMetadata.put(config.GetMetadataName("hassecondarycat"), jCheckBoxSecondary.isSelected() ? Constants.TRUE : Constants.FALSE);
	    
	    // update the keywords list file
	    SaveKeywords(keywordsList);
	    
		return retMetadata;
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

	private void SaveKeywords(String keywordsList) 
			throws IOException {	
		// include newly entered keywords to the list
		StringTokenizer tokenizer = new StringTokenizer(keywordsList, DELIMITER);
		while (tokenizer.hasMoreTokens()) {
			String s = tokenizer.nextToken();
			s = s.trim();
			s = s.toLowerCase();	// case-insensitive
			if (! keywords.contains(s)) {
				keywords.add(s);
			}
		}
		
		// save keywords to the file
        FileWriter outFile = new FileWriter(keywordsFile);  
        BufferedWriter outStream = new BufferedWriter(outFile);  
        for (String s : keywords) {
            outStream.write(s + "\n");  	
        }
        outStream.close();  
	}
	
}  //  @jve:decl-index=0:visual-constraint="-32,-1"








