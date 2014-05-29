package com.atex.h11.sph.metadata.productivity;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.util.HashMap;
import javax.swing.JScrollPane;
import javax.xml.xpath.XPathExpressionException;
import com.atex.h11.sph.metadata.common.ConfigModel;
import com.atex.h11.sph.metadata.common.Constants;
import com.atex.h11.sph.metadata.component.CheckBoxList;

public class MetadataPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ConfigModel config = null;
	private HashMap<String, String> metadata = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JLabel jLabel1111 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel6 = null;
	private JScrollPane jScrollNewsEvent = null;
	private JScrollPane jScrollResubReason = null;	
	private JTextArea jTextNewsEvent = null;
	private JTextArea jTextResubReason = null;	
	private JComboBox<String> jCmbSub = null;
	private JComboBox<String> jCmbChecker = null;
	private JComboBox<String> jCmbNumResub = null;
	private JComboBox<String> jCmbCopyright = null;
	private JRadioButton jRadPrint = null;
	private JRadioButton jRadOnline = null;	
	private JCheckBox jChkPrintDiary = null;
	private JCheckBox jChkPrintCommentary = null;
	private JCheckBox jChkPrintFeature = null;
	private JCheckBox jChkPrintSidebar = null;
	private JCheckBox jChkPrintOwn = null;
	private JCheckBox jChkPrintInfographics = null;
	private JCheckBox jChkPrintWire = null;
	private JCheckBox jChkOnlineDiary = null;
	private JCheckBox jChkOnlineOwn = null;
	private JCheckBox jChkOnlineTweet = null;
	private JCheckBox jChkOnlineFirstPhoto = null;
	private JCheckBox jChkOnlineFirstVideo = null;
	private JCheckBox jChkOnlineVideoPackage = null;
	private JCheckBox jChkOnlineBlog = null;
	private JScrollPane jScrollCoAuthor = null;
	private JScrollPane jScrollAddlReport = null;
	private CheckBoxList cbListCoAuthor = null;
	private CheckBoxList cbListAddlReport = null;	
	
	/**
	 * This method initializes jTextNewsEvent	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextNewsEvent() {
		if (jTextNewsEvent == null) {
			jTextNewsEvent = new JTextArea();
			jTextNewsEvent.setWrapStyleWord(true);
			jTextNewsEvent.setLineWrap(true);
		}
		return jTextNewsEvent;
	}
	
	/**
	 * This method initializes jTextResubReason	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextResubReason() {
		if (jTextResubReason == null) {
			jTextResubReason = new JTextArea();
			jTextResubReason.setWrapStyleWord(true);
			jTextResubReason.setLineWrap(true);			
		}
		return jTextResubReason;
	}	

	/**
	 * This method initializes jScrollNewsEvent	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollNewsEvent() {
		if (jScrollNewsEvent == null) {
			jScrollNewsEvent = new JScrollPane();
			jScrollNewsEvent.setBounds(new Rectangle(135, 15, 241, 61));
			jScrollNewsEvent.setViewportView(getJTextNewsEvent());
		}
		return jScrollNewsEvent;
	}

	/**
	 * This method initializes jScrollResubReason	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollResubReason() {
		if (jScrollResubReason == null) {
			jScrollResubReason = new JScrollPane();
			jScrollResubReason.setBounds(new Rectangle(136, 400, 241, 61));
			jScrollResubReason.setViewportView(getJTextResubReason());
		}
		return jScrollResubReason;
	}	
	
	/**
	 * This method initializes jCmbSub	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws XPathExpressionException 
	 */
	private JComboBox<String> getJCmbSub() throws XPathExpressionException {
		if (jCmbSub == null) {
			jCmbSub = new JComboBox<String>();
			jCmbSub.setName("");
			jCmbSub.setBounds(new Rectangle(135, 309, 232, 23));
			config.InitComboBox(jCmbSub, "sub");
		}
		return jCmbSub;
	}

	/**
	 * This method initializes jCmbChecker	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws XPathExpressionException 
	 */
	private JComboBox<String> getJCmbChecker() throws XPathExpressionException {
		if (jCmbChecker == null) {
			jCmbChecker = new JComboBox<String>();
			jCmbChecker.setName("");
			jCmbChecker.setBounds(new Rectangle(135, 339, 232, 23));
			config.InitComboBox(jCmbChecker, "checker");
		}
		return jCmbChecker;
	}

	/**
	 * This method initializes jCmbNumResub	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws XPathExpressionException 
	 */
	private JComboBox<String> getJCmbNumResub() throws XPathExpressionException {
		if (jCmbNumResub == null) {
			jCmbNumResub = new JComboBox<String>();
			jCmbNumResub.setName("");
			jCmbNumResub.setBounds(new Rectangle(135, 369, 232, 23));
			config.InitComboBox(jCmbNumResub, "numResub");			
		}
		return jCmbNumResub;
	}

	/**
	 * This method initializes jCmbCopyright	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws XPathExpressionException 
	 */
	private JComboBox<String> getJCmbCopyright() throws XPathExpressionException {
		if (jCmbCopyright == null) {
			jCmbCopyright = new JComboBox<String>();
			jCmbCopyright.setName("");
			jCmbCopyright.setBounds(new Rectangle(135, 279, 232, 23));
			config.InitComboBox(jCmbCopyright, "copyright");
		}
		return jCmbCopyright;
	}
	
	/**
	 * This method initializes jScrollCoAuthor	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws XPathExpressionException 
	 */
	private JScrollPane getJScrollCoAuthor() throws XPathExpressionException {
		if (jScrollCoAuthor == null) {
			DefaultListModel<JCheckBox> listModel = config.InitCheckBoxListModel("coAuthor");	
			cbListCoAuthor = new CheckBoxList();
			cbListCoAuthor.setModel(listModel);			
			jScrollCoAuthor = new JScrollPane(cbListCoAuthor);
			jScrollCoAuthor.setBounds(new Rectangle(136, 82, 240, 91));
		}
		return jScrollCoAuthor;
	}

	/**
	 * This method initializes jScrollAddlReport	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws XPathExpressionException 
	 */
	private JScrollPane getJScrollAddlReport() throws XPathExpressionException {
		if (jScrollAddlReport == null) {
			DefaultListModel<JCheckBox> listModel = config.InitCheckBoxListModel("addlReport");	
			cbListAddlReport = new CheckBoxList();
			cbListAddlReport.setModel(listModel);					
			jScrollAddlReport = new JScrollPane(cbListAddlReport);
			jScrollAddlReport.setBounds(new Rectangle(136, 180, 240, 91));
		}
		return jScrollAddlReport;
	}	

	/**
	 * This method initializes jRadPrint	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadPrint() {
		if (jRadPrint == null) {
			jRadPrint = new JRadioButton();
			jRadPrint.setBounds(new Rectangle(405, 15, 100, 16));
			jRadPrint.setFont(new Font("Dialog", Font.PLAIN, 12));
			jRadPrint.setText("Print");
			jRadPrint.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes(jRadPrint.getText());
				}
			});
		}
		return jRadPrint;
	}

	/**
	 * This method initializes jRadOnline	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadOnline() {
		if (jRadOnline == null) {
			jRadOnline = new JRadioButton();
			jRadOnline.setBounds(new Rectangle(555, 15, 76, 16));
			jRadOnline.setFont(new Font("Dialog", Font.PLAIN, 12));
			jRadOnline.setText("Online");
			jRadOnline.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes(jRadOnline.getText());
				}
			});			
		}
		return jRadOnline;
	}	
	
	/**
	 * This method initializes jChkPrintDiary	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintDiary() {
		if (jChkPrintDiary == null) {
			jChkPrintDiary = new JCheckBox();
			jChkPrintDiary.setBounds(new Rectangle(405, 48, 116, 13));
			jChkPrintDiary.setText("Diary/Pick-up");
			jChkPrintDiary.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintDiary;
	}

	/**
	 * This method initializes jChkPrintCommentary	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintCommentary() {
		if (jChkPrintCommentary == null) {
			jChkPrintCommentary = new JCheckBox();
			jChkPrintCommentary.setBounds(new Rectangle(405, 105, 147, 16));
			jChkPrintCommentary.setText("Commentary/Analysis");
			jChkPrintCommentary.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintCommentary;
	}

	/**
	 * This method initializes jChkPrintFeature	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintFeature() {
		if (jChkPrintFeature == null) {
			jChkPrintFeature = new JCheckBox();
			jChkPrintFeature.setBounds(new Rectangle(405, 135, 116, 16));
			jChkPrintFeature.setText("Feature");
			jChkPrintFeature.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintFeature;
	}

	/**
	 * This method initializes jChkPrintSidebar	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintSidebar() {
		if (jChkPrintSidebar == null) {
			jChkPrintSidebar = new JCheckBox();
			jChkPrintSidebar.setBounds(new Rectangle(405, 165, 116, 16));
			jChkPrintSidebar.setText("Sidebar");
			jChkPrintSidebar.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintSidebar;
	}

	/**
	 * This method initializes jChkPrintOwn	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintOwn() {
		if (jChkPrintOwn == null) {
			jChkPrintOwn = new JCheckBox();
			jChkPrintOwn.setBounds(new Rectangle(405, 75, 116, 16));
			jChkPrintOwn.setText("Own/Exclusive");
			jChkPrintOwn.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintOwn;
	}

	/**
	 * This method initializes jChkPrintInfographics	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintInfographics() {
		if (jChkPrintInfographics == null) {
			jChkPrintInfographics = new JCheckBox();
			jChkPrintInfographics.setBounds(new Rectangle(405, 195, 116, 16));
			jChkPrintInfographics.setText("Infographics");
			jChkPrintInfographics.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintInfographics;
	}

	/**
	 * This method initializes jChkPrintWire	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintWire() {
		if (jChkPrintWire == null) {
			jChkPrintWire = new JCheckBox();
			jChkPrintWire.setBounds(new Rectangle(405, 225, 116, 16));
			jChkPrintWire.setText("Wire");
			jChkPrintWire.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkPrintWire;
	}

	/**
	 * This method initializes jChkOnlineDiary	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineDiary() {
		if (jChkOnlineDiary == null) {
			jChkOnlineDiary = new JCheckBox();
			jChkOnlineDiary.setBounds(new Rectangle(555, 45, 97, 16));
			jChkOnlineDiary.setText("Diary");
			jChkOnlineDiary.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineDiary;
	}

	/**
	 * This method initializes jChkOnlineOwn	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineOwn() {
		if (jChkOnlineOwn == null) {
			jChkOnlineOwn = new JCheckBox();
			jChkOnlineOwn.setBounds(new Rectangle(555, 75, 106, 16));
			jChkOnlineOwn.setText("Own/Exclusive");
			jChkOnlineOwn.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineOwn;
	}

	/**
	 * This method initializes jChkOnlineTweet	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineTweet() {
		if (jChkOnlineTweet == null) {
			jChkOnlineTweet = new JCheckBox();
			jChkOnlineTweet.setBounds(new Rectangle(555, 105, 104, 16));
			jChkOnlineTweet.setText("Tweets");
			jChkOnlineTweet.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineTweet;
	}

	/**
	 * This method initializes jChkOnlineFirstPhoto	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineFirstPhoto() {
		if (jChkOnlineFirstPhoto == null) {
			jChkOnlineFirstPhoto = new JCheckBox();
			jChkOnlineFirstPhoto.setBounds(new Rectangle(555, 135, 104, 19));
			jChkOnlineFirstPhoto.setText("First Photos");
			jChkOnlineFirstPhoto.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineFirstPhoto;
	}

	/**
	 * This method initializes jChkOnlineFirstVideo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineFirstVideo() {
		if (jChkOnlineFirstVideo == null) {
			jChkOnlineFirstVideo = new JCheckBox();
			jChkOnlineFirstVideo.setBounds(new Rectangle(555, 165, 91, 16));
			jChkOnlineFirstVideo.setText("First Videos");
			jChkOnlineFirstVideo.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineFirstVideo;
	}

	/**
	 * This method initializes jChkOnlineVideoPkg	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineVideoPackage() {
		if (jChkOnlineVideoPackage == null) {
			jChkOnlineVideoPackage = new JCheckBox();
			jChkOnlineVideoPackage.setBounds(new Rectangle(555, 195, 121, 16));
			jChkOnlineVideoPackage.setText("Video Package");
			jChkOnlineVideoPackage.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineVideoPackage;
	}

	/**
	 * This method initializes jChkOnlineBlog	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineBlog() {
		if (jChkOnlineBlog == null) {
			jChkOnlineBlog = new JCheckBox();
			jChkOnlineBlog.setBounds(new Rectangle(555, 225, 136, 16));
			jChkOnlineBlog.setText("Blog/Communities");
			jChkOnlineBlog.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineBlog;
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
		
		jLabel6 = new JLabel();
		jLabel6.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel6.setBounds(new Rectangle(15, 279, 76, 16));
		jLabel6.setText("Copyright");
		jLabel4 = new JLabel();
		jLabel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel4.setBounds(new Rectangle(15, 401, 121, 16));
		jLabel4.setText("Reasons for Resubs");
		jLabel3 = new JLabel();
		jLabel3.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel3.setBounds(new Rectangle(15, 369, 106, 16));
		jLabel3.setText("No. of Resubs");
		jLabel1111 = new JLabel();
		jLabel1111.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel1111.setBounds(new Rectangle(15, 339, 95, 17));
		jLabel1111.setText("Checker");
		jLabel111 = new JLabel();
		jLabel111.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel111.setBounds(new Rectangle(15, 305, 91, 20));
		jLabel111.setText("Sub");
		jLabel11 = new JLabel();
		jLabel11.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel11.setBounds(new Rectangle(15, 182, 121, 16));
		jLabel11.setText("Additional Reporting");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(14, 84, 76, 16));
		jLabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel1.setText("Co-Author");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(15, 15, 86, 16));
		jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel.setText("News Event");
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		this.add(jLabel6, null);
		this.add(jLabel111, null);
		this.add(jLabel1111, null);
		this.add(jLabel3, null);
		this.add(jLabel4, null);
		
		this.add(getJScrollNewsEvent(), null);
		this.add(getJScrollResubReason(), null);		
		this.add(getJCmbCopyright(), null);
		this.add(getJCmbSub(), null);
		this.add(getJCmbChecker(), null);
		this.add(getJCmbNumResub(), null);		
		this.add(getJScrollCoAuthor(), null);
		this.add(getJScrollAddlReport(), null);
		
        //Group the radio buttons.
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(getJRadPrint());
        radioButtonGroup.add(getJRadOnline());		
		this.add(getJRadPrint(), null);
		this.add(getJRadOnline(), null);
		// check "Print" initially
		getJRadPrint().setSelected(true);
		// init check boxes
		InitCheckBoxes(getJRadPrint().getText());
		
		this.add(getJChkPrintCommentary(), null);
		this.add(getJChkPrintFeature(), null);
		this.add(getJChkPrintSidebar(), null);
		this.add(getJChkPrintOwn(), null);
		this.add(getJChkPrintInfographics(), null);
		this.add(getJChkPrintWire(), null);
		this.add(getJChkPrintDiary(), null);		
		this.add(getJChkOnlineDiary(), null);
		this.add(getJChkOnlineOwn(), null);
		this.add(getJChkOnlineTweet(), null);
		this.add(getJChkOnlineFirstPhoto(), null);
		this.add(getJChkOnlineFirstVideo(), null);
		this.add(getJChkOnlineVideoPackage(), null);
		this.add(getJChkOnlineBlog(), null);
	}
	
	private void InitCheckBoxes(String mode) {
		boolean onlineMode = 
			(mode.equalsIgnoreCase("Online") ? true : false);

		// online items		
		getJChkOnlineDiary().setEnabled(onlineMode);
		getJChkOnlineOwn().setEnabled(onlineMode);
		getJChkOnlineTweet().setEnabled(onlineMode);
		getJChkOnlineFirstPhoto().setEnabled(onlineMode);
		getJChkOnlineFirstVideo().setEnabled(onlineMode);
		getJChkOnlineVideoPackage().setEnabled(onlineMode);
		getJChkOnlineBlog().setEnabled(onlineMode);
		// print items
		getJChkPrintCommentary().setEnabled(!onlineMode);
		getJChkPrintFeature().setEnabled(!onlineMode);
		getJChkPrintSidebar().setEnabled(!onlineMode);
		getJChkPrintOwn().setEnabled(!onlineMode);
		getJChkPrintInfographics().setEnabled(!onlineMode);
		getJChkPrintWire().setEnabled(!onlineMode);
		getJChkPrintDiary().setEnabled(!onlineMode);
		
		// clear disabled checkboxes
		if (onlineMode) {
			getJChkPrintCommentary().setSelected(false);
			getJChkPrintFeature().setSelected(false);
			getJChkPrintSidebar().setSelected(false);
			getJChkPrintOwn().setSelected(false);
			getJChkPrintInfographics().setSelected(false);
			getJChkPrintWire().setSelected(false);
			getJChkPrintDiary().setSelected(false);
		}
		else {
			getJChkOnlineDiary().setSelected(false);
			getJChkOnlineOwn().setSelected(false);
			getJChkOnlineTweet().setSelected(false);
			getJChkOnlineFirstPhoto().setSelected(false);
			getJChkOnlineFirstVideo().setSelected(false);
			getJChkOnlineVideoPackage().setSelected(false);
			getJChkOnlineBlog().setSelected(false);		
		}
	}
	
	private void SetComponentValues() 
			throws XPathExpressionException {
		// text areas
		jTextNewsEvent.setText(metadata.get(config.GetMetadataName("newsEvent")));
		jTextResubReason.setText(metadata.get(config.GetMetadataName("resubReason")));

		// radio/check boxes
		jChkPrintDiary.setSelected(metadata.get(config.GetMetadataName("printDiary")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintCommentary.setSelected(metadata.get(config.GetMetadataName("printCommentary")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintFeature.setSelected(metadata.get(config.GetMetadataName("printFeature")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintSidebar.setSelected(metadata.get(config.GetMetadataName("printSidebar")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintOwn.setSelected(metadata.get(config.GetMetadataName("printOwn")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintInfographics.setSelected(metadata.get(config.GetMetadataName("printInfographics")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintWire.setSelected(metadata.get(config.GetMetadataName("printWire")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineDiary.setSelected(metadata.get(config.GetMetadataName("onlineDiary")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineOwn.setSelected(metadata.get(config.GetMetadataName("onlineOwn")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineTweet.setSelected(metadata.get(config.GetMetadataName("onlineTweet")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineFirstPhoto.setSelected(metadata.get(config.GetMetadataName("onlineFirstPhoto")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineFirstVideo.setSelected(metadata.get(config.GetMetadataName("onlineFirstVideo")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineVideoPackage.setSelected(metadata.get(config.GetMetadataName("onlineVideoPackage")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineBlog.setSelected(metadata.get(config.GetMetadataName("onlineBlog")).equalsIgnoreCase(Constants.TRUE));
		// radio button setting
		if (jChkOnlineDiary.isSelected() || jChkOnlineOwn.isSelected() || jChkOnlineTweet.isSelected() ||
			jChkOnlineFirstPhoto.isSelected() || jChkOnlineFirstVideo.isSelected() ||
			jChkOnlineVideoPackage.isSelected() || jChkOnlineBlog.isSelected()) {
			getJRadOnline().setSelected(true);
			getJRadPrint().setSelected(false);
			InitCheckBoxes(getJRadOnline().getText());
		}
		else {
			getJRadOnline().setSelected(false);
			getJRadPrint().setSelected(true);
			InitCheckBoxes(getJRadPrint().getText());
		}
		
		// combo boxes
		jCmbCopyright.setSelectedItem(metadata.get(config.GetMetadataName("copyright")));
		jCmbSub.setSelectedItem(metadata.get(config.GetMetadataName("sub")));
		jCmbChecker.setSelectedItem(metadata.get(config.GetMetadataName("checker")));
		jCmbNumResub.setSelectedItem(metadata.get(config.GetMetadataName("numResub")));
		
		// checkbox lists
		cbListCoAuthor.setSelectedFromListString(metadata.get(config.GetMetadataName("coAuthor")));			
		cbListAddlReport.setSelectedFromListString(metadata.get(config.GetMetadataName("addlReport")));		
	}
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();
		
		// text areas
		retMetadata.put(config.GetMetadataName("newsEvent"), jTextNewsEvent.getText());
		retMetadata.put(config.GetMetadataName("resubReason"), jTextResubReason.getText());
		
		// radio/check boxes
		retMetadata.put(config.GetMetadataName("printDiary"), jChkPrintDiary.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printCommentary"), jChkPrintCommentary.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printFeature"), jChkPrintFeature.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printSidebar"), jChkPrintSidebar.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printOwn"), jChkPrintOwn.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printInfographics"), jChkPrintInfographics.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printWire"), jChkPrintWire.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineDiary"), jChkOnlineDiary.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineOwn"), jChkOnlineOwn.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineTweet"), jChkOnlineTweet.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineFirstPhoto"), jChkOnlineFirstPhoto.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineFirstVideo"), jChkOnlineFirstVideo.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineVideoPackage"), jChkOnlineVideoPackage.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineBlog"), jChkOnlineBlog.isSelected() ? Constants.TRUE : Constants.FALSE);
		
		// combo boxes
		retMetadata.put(config.GetMetadataName("copyright"), (String) jCmbCopyright.getSelectedItem());
		retMetadata.put(config.GetMetadataName("sub"), (String) jCmbSub.getSelectedItem());
		retMetadata.put(config.GetMetadataName("checker"), (String) jCmbChecker.getSelectedItem());
		retMetadata.put(config.GetMetadataName("numResub"), (String) jCmbNumResub.getSelectedItem());
		
		// checkbox lists
	    retMetadata.put(config.GetMetadataName("coAuthor"), cbListCoAuthor.getSelectedListString());		
	    retMetadata.put(config.GetMetadataName("addlReport"), cbListAddlReport.getSelectedListString());		    
	    
		return retMetadata;
	}

}  //  @jve:decl-index=0:visual-constraint="9,4"
