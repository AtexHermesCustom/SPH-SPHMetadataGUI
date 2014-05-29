package com.atex.h11.sph.metadata.category;

import java.util.HashMap;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import com.atex.h11.sph.metadata.component.CheckBoxList;
import javax.swing.JComboBox;
import javax.xml.xpath.XPathExpressionException;
import com.atex.h11.sph.metadata.common.ConfigModel;

public class MetadataPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ConfigModel config = null;
	private HashMap<String, String> metadata = null;
	private JTextField jTextKeywords = null;
	private JRadioButton jRadPositiveSentiment = null;
	private JRadioButton jRadNegativeSentiment = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private CheckBoxList cbListSectors = null;
	private CheckBoxList cbListIndustries = null;
	private JScrollPane jScrollSectors = null;
	private JScrollPane jScrollIndustries = null;
	private JLabel jLabel1111 = null;
	/**
	 * This method initializes jScrollSectors	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollSectors() 
			throws XPathExpressionException {
		if (jScrollSectors == null) {
			// initialize
			DefaultListModel<JCheckBox> listModel = config.InitCheckBoxListModel("sector");	
			cbListSectors = new CheckBoxList();
			cbListSectors.setModel(listModel);
			jScrollSectors = new JScrollPane(cbListSectors);
			jScrollSectors.setBounds(new Rectangle(17, 34, 300, 252));
			jScrollSectors.setFont(new Font("Dialog", Font.PLAIN, 12));
			return jScrollSectors;
		}
		return jScrollSectors;
	}

	/**
	 * This method initializes jScrollIndustries	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollIndustries() 
			throws XPathExpressionException {
		if (jScrollIndustries == null) {
			// initialize
			DefaultListModel<JCheckBox> listModel = config.InitCheckBoxListModel("industry");
			cbListIndustries = new CheckBoxList();
			cbListIndustries.setModel(listModel);
			jScrollIndustries = new JScrollPane(cbListIndustries);
			jScrollIndustries.setBounds(new Rectangle(332, 33, 300, 252));
			jScrollIndustries.setFont(new Font("Dialog", Font.PLAIN, 12));
			return jScrollIndustries;
		}
		return jScrollIndustries;
	}		
	
	/**
	 * This method initializes jTextKeywords	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextKeywords() {
		if (jTextKeywords == null) {
			jTextKeywords = new JTextField();
			jTextKeywords.setBounds(new Rectangle(16, 322, 614, 23));
		}
		return jTextKeywords;
	}

	/**
	 * This method initializes jRadPositiveSentiment	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadPositiveSentiment() {
		if (jRadPositiveSentiment == null) {
			jRadPositiveSentiment = new JRadioButton();
			jRadPositiveSentiment.setBounds(new Rectangle(23, 376, 89, 26));
			jRadPositiveSentiment.setFont(new Font("Dialog", Font.PLAIN, 12));
			jRadPositiveSentiment.setText("Positive");
		}
		return jRadPositiveSentiment;
	}

	/**
	 * This method initializes jRadNegativeSentiment	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadNegativeSentiment() {
		if (jRadNegativeSentiment == null) {
			jRadNegativeSentiment = new JRadioButton();
			jRadNegativeSentiment.setBounds(new Rectangle(134, 376, 97, 28));
			jRadNegativeSentiment.setFont(new Font("Dialog", Font.PLAIN, 12));
			jRadNegativeSentiment.setText("Negative");
		}
		return jRadNegativeSentiment;
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
		
		// set component values, read from the metadata hash
		SetComponentValues();
	}	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() 
			throws XPathExpressionException {
		this.setLayout(null);
		this.setSize(720, 470);

		jLabel1111 = new JLabel();
		jLabel1111.setBounds(new Rectangle(79, 298, 227, 16));
		jLabel1111.setText("- separate keywords using commas");
		jLabel1111.setFont(new Font("Dialog", Font.ITALIC, 11));		
		jLabel111 = new JLabel();
		jLabel111.setBounds(new Rectangle(17, 298, 60, 16));
		jLabel111.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel111.setText("Keywords");
		jLabel11 = new JLabel();
		jLabel11.setBounds(new Rectangle(16, 361, 99, 16));
		jLabel11.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel11.setText("Sentiment");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(332, 8, 63, 16));
		jLabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel1.setText("Industry");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(17, 10, 48, 15));
		jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel.setText("Sector");
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		this.add(jLabel111, null);
		this.add(jLabel1111, null);

		this.add(getJTextKeywords(), null);
		
        //Group the radio buttons.
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(getJRadPositiveSentiment());
        radioButtonGroup.add(getJRadNegativeSentiment());				
		this.add(getJRadPositiveSentiment(), null);
		this.add(getJRadNegativeSentiment(), null);
		// check "Positive" initially
		getJRadPositiveSentiment().setSelected(true);
		
		// lists
		this.add(getJScrollSectors(), null);
		this.add(getJScrollIndustries(), null);
	}
	
	private void SetComponentValues() 
			throws XPathExpressionException {
		cbListSectors.setSelectedFromListString(metadata.get(config.GetMetadataName("sectors")));
		cbListIndustries.setSelectedFromListString(metadata.get(config.GetMetadataName("industries")));
		jTextKeywords.setText(metadata.get(config.GetMetadataName("keywords")));
		jRadPositiveSentiment.setSelected(metadata.get(config.GetMetadataName("sentiment")).equalsIgnoreCase("Positive"));
		jRadNegativeSentiment.setSelected(metadata.get(config.GetMetadataName("sentiment")).equalsIgnoreCase("Negative"));
	}
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();
		
	    retMetadata.put(config.GetMetadataName("sectors"), cbListSectors.getSelectedListString());
	    retMetadata.put(config.GetMetadataName("industries"), cbListIndustries.getSelectedListString());
	    
	    // normalize keywords list
	    String keywordList = "";
	    int i = 0;
	    for (String s : jTextKeywords.getText().split(",")) {
	    	s = s.trim();			// trim any leading & trailing spaces
	    	if (! s.isEmpty()) {
	    		if (i > 0) { keywordList += ","; }
	    		keywordList += s;
	    		i++;
	    	}
	    }	    
	    retMetadata.put(config.GetMetadataName("keywords"), keywordList);
		
	    retMetadata.put(config.GetMetadataName("sentiment"), 
	    	getJRadPositiveSentiment().isSelected() ? "Positive" : "Negative");
	    
		// combo boxes
		return retMetadata;
	}

	
}  //  @jve:decl-index=0:visual-constraint="10,10"
