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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import com.atex.h11.sph.metadata.common.InfoBox;
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
	private final String KEYWORDS_REGEX_CHECK = ".*[A-Za-z0-9]+.*";
	
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
	private JLabel jLabelPrimaryMandate;
	private JLabel jLabelSecondaryMandate;
	private JLabel jLabelPriorityMandate;
	private JLabel jLabelKeywordsMandate;
	private JLabel jLabel1111 = null;
	private JCheckBox jCheckBoxExclusive = null;
	private JLabel jLabelVersion = null;
	private JLabel jLabel1112 = null;
	private JTextField jTextFieldURL = null;

	private JComboBox<String> jCmbCopyright = null;

	private JLabel jLabel1113 = null;
	
	/**
	 * This method initializes jTextFieldKeywords	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldKeywords() {
		if (jTextFieldKeywords == null) {
			jTextFieldKeywords = new JTextField();
			jTextFieldKeywords.setBounds(new Rectangle(37, 266, 289, 22));
			jTextFieldKeywords.setToolTipText("Press ENTER to enter a new keyword.");
			jTextFieldKeywords.addFocusListener(new FocusListener() {
				@Override
			    public void focusLost(FocusEvent e) {
					if (! jTextFieldKeywords.getText().trim().matches(KEYWORDS_REGEX_CHECK)) {
						jLabelKeywordsMandate.setVisible(true);
					}
					else {
						jLabelKeywordsMandate.setVisible(false);
					}					
			    }

				@Override
				public void focusGained(FocusEvent e) { }
			});
			jTextFieldKeywords.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String str = jTextFieldKeywords.getText().toLowerCase();
//					String prefix = content.substring(w + 1).toLowerCase();

					jTextFieldKeywords.setText(str + ", ");
					
					if (str != null && !str.isEmpty()) {
						jLabelKeywordsMandate.setVisible(false);
			        }					
				}
			});
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
			jCheckBoxExclusive.setBounds(new Rectangle(338, 266, 21, 21));
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
			jCmbPrimary.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				    if (e.getStateChange() == ItemEvent.SELECTED) {
				    	Object source = e.getItem();
				    	if (((String)source).trim() == "") {
				    		jLabelPrimaryMandate.setVisible(true);
				    	}
				    	else {
				    		jLabelPrimaryMandate.setVisible(false);
				    	}
				    } 				
				}
			});				
			config.InitComboBox(jCmbPrimary, "primarycat");
		}
		return jCmbPrimary;
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
			cbListSecondary.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(cbListSecondary.getSelectedListString().trim() == ""){
						jLabelSecondaryMandate.setVisible(true);
					}
					else {
						jLabelSecondaryMandate.setVisible(false);
					}
				}				
			});			
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
			jCmbPriority.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				    if (e.getStateChange() == ItemEvent.SELECTED) {
				    	Object source = e.getItem();
				    	if (((String)source).trim() == "") {
				    		jLabelPriorityMandate.setVisible(true);
				    	}
				    	else {
				    		jLabelPriorityMandate.setVisible(false);
				    	}
				    } 				
				}
			});				
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
			jCmbSub.setBounds(new Rectangle(36, 411, 176, 21));
			config.InitComboBox(jCmbSub, "sub");
		}
		return jCmbSub;
	}

	/**
	 * This method initializes jCmbCopyright	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbCopyright() throws XPathExpressionException{
		if (jCmbCopyright == null) {
			jCmbCopyright = new JComboBox<String>();
			jCmbCopyright.setBounds(new Rectangle(271, 411, 133, 21));
			jCmbCopyright.setMaximumRowCount(8);
			jCmbCopyright.setName("");
			config.InitComboBox(jCmbCopyright, "copyright");
		}
		return jCmbCopyright;
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
		
		// check and highlight mandatory fields that are missing 
		isReady();		
	}	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws FileNotFoundException 
	 */
	private void initialize() 
			throws XPathExpressionException, FileNotFoundException {
		jLabel1113 = new JLabel();
		jLabel1113.setBounds(new Rectangle(271, 388, 72, 19));
		jLabel1113.setText("Copyright");
		jLabel1113.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel1112 = new JLabel();
		jLabel1112.setBounds(new Rectangle(37, 327, 78, 19));
		jLabel1112.setText("Hyperlink");
		jLabel1112.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelVersion = new JLabel();
		jLabelVersion.setBounds(new Rectangle(660, 448, 50, 18));
		jLabelVersion.setFont(new Font("Dialog", Font.ITALIC, 12));
		jLabelVersion.setForeground(Color.lightGray);
		jLabelVersion.setText(Constants.VERSION);
		jLabel1111 = new JLabel();
		jLabel1111.setBounds(new Rectangle(340, 242, 74, 23));
		jLabel1111.setText("Exclusive");
		jLabel1111.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelKeywordsMandate = new JLabel();
		jLabelKeywordsMandate.setBounds(new Rectangle(38, 291, 209, 16));
		jLabelKeywordsMandate.setForeground(Color.red);
		jLabelKeywordsMandate.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelKeywordsMandate.setText("<html>Reporters, please fill this in.</html>");
		jLabelKeywordsMandate.setVerticalAlignment(SwingConstants.TOP);
		jLabelKeywordsMandate.setVerticalTextPosition(SwingConstants.TOP);
		jLabelKeywordsMandate.setVisible(true);
		jLabelPriorityMandate = new JLabel();
		jLabelPriorityMandate.setBounds(new Rectangle(37, 192, 292, 16));
		jLabelPriorityMandate.setForeground(Color.red);
		jLabelPriorityMandate.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelPriorityMandate.setText("<html>Sub-editors or Content producers, please fill this in.</html>");
		jLabelPriorityMandate.setVerticalAlignment(SwingConstants.TOP);
		jLabelPriorityMandate.setVerticalTextPosition(SwingConstants.TOP);
		jLabelPriorityMandate.setVisible(true);
		jLabelPrimaryMandate = new JLabel();
		jLabelPrimaryMandate.setBounds(new Rectangle(37, 99, 292, 24));
		jLabelPrimaryMandate.setVerticalAlignment(SwingConstants.TOP);
		jLabelPrimaryMandate.setVerticalTextPosition(SwingConstants.TOP);
		jLabelPrimaryMandate.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelPrimaryMandate.setForeground(Color.red);
		jLabelPrimaryMandate.setText("<html>Sub-editors or Content producers, please fill this in.</html>");
		jLabelPrimaryMandate.setVisible(true);		
		jLabelSecondaryMandate = new JLabel();
		jLabelSecondaryMandate.setBounds(new Rectangle(437, 417, 259, 16));
		jLabelSecondaryMandate.setForeground(Color.red);
		jLabelSecondaryMandate.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelSecondaryMandate.setText("<html>Sub-editors or Content producers, please fill this in.</html>");
		jLabelSecondaryMandate.setVerticalAlignment(SwingConstants.TOP);
		jLabelSecondaryMandate.setVerticalTextPosition(SwingConstants.TOP);
		jLabelSecondaryMandate.setVisible(true);
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
		//jLabel1.setBounds(new Rectangle(29, 119, 82, 30));
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
		this.add(jLabelPrimaryMandate, null);
		this.add(jLabelSecondaryMandate, null);
		this.add(jLabelPriorityMandate, null);
		this.add(jLabelKeywordsMandate, null);
		this.add(jLabel1111, null);
		this.add(getJCheckBoxExclusive(), null);
		this.add(jLabelVersion, null);
		this.add(jLabel1112, null);
		this.add(getJTextFieldURL(), null);

		this.add(getJCmbCopyright(), null);
		this.add(jLabel1113, null);
		
		// for keywords autocomplete
		keywordsFile = config.GetAttribValue("keywords", "file");
		initAutoComplete();
	}

	private void initAutoComplete() 
			throws FileNotFoundException, XPathExpressionException {
		// read keywords from file
		keywords = new ArrayList<String>();
		File kwFile = new File(keywordsFile);
		if (kwFile.exists()) {
			Scanner scanner = new Scanner(kwFile);
			while (scanner.hasNext()) {
				String s = scanner.next();
				//System.out.println("added keyword: " + s);
				keywords.add(s.toLowerCase());	// case-insensitive			
			}
			scanner.close();
		}
		
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
		jCmbCopyright.setSelectedItem(metadata.get(config.GetMetadataName("copyright")));

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
	}
	
	public boolean isReady() {
		/*
		 * put any required validations here
		 */
		boolean isReady = true;

		jLabelPrimaryMandate.setVisible(false);
		jLabelSecondaryMandate.setVisible(false);
		jLabelKeywordsMandate.setVisible(false);
		jLabelPriorityMandate.setVisible(false);

		if (((String)jCmbPrimary.getSelectedItem()).trim().isEmpty() || jCmbPrimary.getSelectedIndex() < 0) {
			jLabelPrimaryMandate.setVisible(true);
//			isReady = false;
		}
		
		if (cbListSecondary.getSelectedListString().trim() == "") {
			jLabelSecondaryMandate.setVisible(true);
//			isReady = false;
		}
		
		
		if (((String)jCmbPriority.getSelectedItem()).trim().isEmpty() || jCmbPriority.getSelectedIndex() < 0) {
			jLabelPriorityMandate.setVisible(true);
//			isReady = false;
		}
		
		if (! jTextFieldKeywords.getText().trim().matches(KEYWORDS_REGEX_CHECK)) {
			jLabelKeywordsMandate.setVisible(true);
//			isReady = false;
		}
		
		if (isReady) {
			try {
			    // update the keywords list file
			    SaveKeywords(formatKeywordsList(jTextFieldKeywords.getText())); // replace ending comma
			}
			catch (Exception e) {
				InfoBox.ShowException(e);
			}
		}
				
		return isReady;
	}	
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException, IOException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();

		// radio/check boxes
		// Text area
		retMetadata.put(config.GetMetadataName("keywords"), formatKeywordsList(jTextFieldKeywords.getText()));
		retMetadata.put(config.GetMetadataName("hyperlink"), jTextFieldURL.getText());	
		// combo boxes
		retMetadata.put(config.GetMetadataName("primarycat"), (String) jCmbPrimary.getSelectedItem());
		retMetadata.put(config.GetMetadataName("pri"), swapFunction((String) jCmbPrimary.getSelectedItem()));
		retMetadata.put(config.GetMetadataName("priority"), (String) jCmbPriority.getSelectedItem());
		retMetadata.put(config.GetMetadataName("copyright"), (String) jCmbCopyright.getSelectedItem());
		// Subbing info
		retMetadata.put(config.GetMetadataName("sub"), (String) jCmbSub.getSelectedItem());
		// checkbox lists
	    retMetadata.put(config.GetMetadataName("secondarycat"), cbListSecondary.getSelectedListString());
	    retMetadata.put(config.GetMetadataName("sec"), swapFunction(cbListSecondary.getSelectedListString()));
		// checkbox
	    retMetadata.put(config.GetMetadataName("exclusive"), jCheckBoxExclusive.isSelected() ? Constants.TRUE : Constants.FALSE);
	    
		return retMetadata;
	}
	
	private String formatKeywordsList(String kwList) {
		return kwList.replaceAll(",*$", ""); // replace ending comma
	}
	
	private String swapFunction(String a) {
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








