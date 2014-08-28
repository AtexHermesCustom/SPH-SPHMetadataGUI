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
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.KeyEvent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class MetadataPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ConfigModel config = null;
	private HashMap<String, String> metadata = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel11 = null;
	private JScrollPane jScrollNewsEvent = null;
	private JTextArea jTextNewsEvent = null;
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
	private JCheckBox jChkPrintContribution = null;
	private JLabel jLabelWhatsthis = null;
	private JCheckBox jChkOnlineWire = null;
	private JComboBox<String> jCmbCopyright = null;
	private JLabel jLabel6 = null;
	/**
	 * This method initializes jTextNewsEvent	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextNewsEvent() {
		if (jTextNewsEvent == null) {
			jTextNewsEvent = new JTextArea();
			jTextNewsEvent.setWrapStyleWord(true);
			jTextNewsEvent.setBackground(Color.white);
			jTextNewsEvent.setToolTipText("This is your daily news assignment, click on What's this? to see guidelines");
			jTextNewsEvent.setLineWrap(true);
		}
		return jTextNewsEvent;
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
			jScrollCoAuthor.setBounds(new Rectangle(134, 90, 240, 147));
			jScrollCoAuthor.setToolTipText("You can select more than one Co-Author");
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
			jScrollAddlReport.setBounds(new Rectangle(135, 255, 240, 147));
			jScrollAddlReport.setToolTipText("You can select more than one reporter");
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
			jRadPrint.setFont(new Font("Dialog", Font.PLAIN, 14));
			jRadPrint.setToolTipText("For Print story, select one item");
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
			jRadOnline.setFont(new Font("Dialog", Font.PLAIN, 14));
			jRadOnline.setToolTipText("For Online story, you may select more than one item");
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
			jChkPrintDiary.setVisible(true);

			jChkPrintDiary.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Diary");
				}
			});
			
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
			jChkPrintCommentary.setVisible(true);
			jChkPrintCommentary.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Commentary");
				}
			});			
			
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
			jChkPrintFeature.setVisible(true);
			jChkPrintFeature.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Feature");
				}
			});			
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
			jChkPrintSidebar.setVisible(true);
			jChkPrintSidebar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Sidebar");
				}
			});				
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
			jChkPrintOwn.setVisible(true);
			jChkPrintOwn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Own");
				}
			});				
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
			jChkPrintInfographics.setVisible(true);
			jChkPrintInfographics.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Infographics");
				}
			});				
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
			jChkPrintWire.setVisible(true);
			jChkPrintWire.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Wire");
				}
			});				
		}
		return jChkPrintWire;
	}

	/**
	 * This method initializes jChkPrintContribution	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkPrintContribution() {
		if (jChkPrintContribution == null) {
			jChkPrintContribution = new JCheckBox();
			jChkPrintContribution.setBounds(new Rectangle(405, 251, 138, 24));
			jChkPrintContribution.setText("Contribution");
			jChkPrintContribution.setFont(new Font("Dialog", Font.PLAIN, 12));
			jChkPrintContribution.setVisible(false);
			jChkPrintContribution.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InitCheckBoxes("Contribution");
				}
			});				
		}
		return jChkPrintContribution;
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
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(13, 422, 76, 19));
		jLabel6.setText("Copyright");
		jLabel6.setVerticalAlignment(SwingConstants.TOP);
		jLabel6.setVerticalTextPosition(SwingConstants.TOP);
		jLabel6.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelWhatsthis = new JLabel();
		jLabelWhatsthis.setBounds(new Rectangle(14, 33, 102, 19));
//		jLabelWhatsthis.setText("<html>"+ "<a href=\"file://C:/Hermes11/custommetadata/NewsEvents.html\" >"+ "What's this?" +"</a>" +"</html>");
		jLabelWhatsthis.setText("<html>"+ "<a href=\"file://U:/custommetadata/NewsEvents.html\" >"+ "What's this?" +"</a>" +"</html>");
		jLabelWhatsthis.setFont(new Font("Dialog", Font.ITALIC, 12));
		jLabelWhatsthis.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(Desktop.isDesktopSupported())
				{
				  try {
//					Desktop.getDesktop().browse(new URI("file:///C:/Hermes11/custommetadata/NewsEvents.html"));
					Desktop.getDesktop().browse(new URI("file:///U:/custommetadata/NewsEvents.html"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		this.setLayout(null);
		this.setSize(720, 478);
		this.setSize(new Dimension(720, 455));
		this.setVisible(true);
		
		jLabel11 = new JLabel();
		jLabel11.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel11.setBounds(new Rectangle(14, 257, 114, 37));
		jLabel11.setVerticalAlignment(SwingConstants.TOP);
		jLabel11.setVerticalTextPosition(SwingConstants.TOP);
		jLabel11.setComponentOrientation(ComponentOrientation.UNKNOWN);
		jLabel11.setToolTipText("You can select more than one reporter");
		jLabel11.setText("<html>"+"Additional Reporting"+"</html>");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(12, 92, 76, 16));
		jLabel1.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel1.setToolTipText("You can select more than one Co-Author");
		jLabel1.setText("Co-Author");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(15, 15, 103, 18));
		jLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel.setForeground(new Color(51, 51, 51));
		jLabel.setVerticalAlignment(SwingConstants.TOP);
		jLabel.setVerticalTextPosition(SwingConstants.TOP);
		jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jLabel.setToolTipText("This is your daily news assignment, click on What's this? to see guidelines");
		jLabel.setText("<html>Assignment</html>");
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel11, null);
		
		this.add(getJScrollNewsEvent(), null);
		this.add(getJScrollCoAuthor(), null);
		this.add(getJScrollAddlReport(), null);
		
	    //Group the radio buttons.
//        ButtonGroup radioButtonGroup = new ButtonGroup();
		
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
		this.add(getJChkPrintContribution(), null);
		this.add(jLabelWhatsthis, null);
		this.add(getJChkOnlineWire(), null);
		this.add(getJCmbCopyright(), null);
		this.add(jLabel6, null);
	}
	
	private void InitCheckBoxes(String mode) {
		boolean onlineMode = 
			(mode.equalsIgnoreCase("Online") ? true : false);

		boolean dia = 
			(mode.equalsIgnoreCase("Diary") ? true : false);

		boolean com = 
			(mode.equalsIgnoreCase("Commentary") ? true : false);
		
		boolean own = 
			(mode.equalsIgnoreCase("Own") ? true : false);
		
		boolean fea = 
			(mode.equalsIgnoreCase("Feature") ? true : false);
		
		boolean sid = 
			(mode.equalsIgnoreCase("Sidebar") ? true : false);
		
		boolean inf = 
			(mode.equalsIgnoreCase("Infographics") ? true : false);
		
		boolean wir = 
			(mode.equalsIgnoreCase("Wire") ? true : false);
		
		boolean con = 
			(mode.equalsIgnoreCase("Contribution") ? true : false);

		
		// online items		
		getJChkOnlineDiary().setEnabled(onlineMode);
		getJChkOnlineOwn().setEnabled(onlineMode);
		getJChkOnlineTweet().setEnabled(onlineMode);
		getJChkOnlineFirstPhoto().setEnabled(onlineMode);
		getJChkOnlineFirstVideo().setEnabled(onlineMode);
		getJChkOnlineVideoPackage().setEnabled(onlineMode);
		getJChkOnlineBlog().setEnabled(onlineMode);
		getJChkOnlineWire().setEnabled(onlineMode);
		// print items
		getJChkPrintCommentary().setEnabled(!onlineMode);
		getJChkPrintFeature().setEnabled(!onlineMode);
		getJChkPrintSidebar().setEnabled(!onlineMode);
		getJChkPrintOwn().setEnabled(!onlineMode);
		getJChkPrintInfographics().setEnabled(!onlineMode);
		getJChkPrintWire().setEnabled(!onlineMode);
		getJChkPrintDiary().setEnabled(!onlineMode);
		getJChkPrintContribution().setEnabled(!onlineMode);

		// clear disabled checkboxes
		if (onlineMode) {
			getJChkPrintCommentary().setSelected(false);
			getJChkPrintFeature().setSelected(false);
			getJChkPrintSidebar().setSelected(false);
			getJChkPrintOwn().setSelected(false);
			getJChkPrintInfographics().setSelected(false);
			getJChkPrintWire().setSelected(false);
			getJChkPrintDiary().setSelected(false);
			getJChkPrintContribution().setSelected(false);
		}
		else {
			getJChkOnlineDiary().setSelected(false);
			getJChkOnlineOwn().setSelected(false);
			getJChkOnlineTweet().setSelected(false);
			getJChkOnlineFirstPhoto().setSelected(false);
			getJChkOnlineFirstVideo().setSelected(false);
			getJChkOnlineVideoPackage().setSelected(false);
			getJChkOnlineBlog().setSelected(false);
			getJChkOnlineWire().setSelected(false);

			if (dia) {
				getJChkPrintDiary().setEnabled(true);
				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
//				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*				
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintOwn().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}

			if (own) {
				getJChkPrintOwn().setEnabled(true);				
				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
//				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}
			
			if (com) {
				getJChkPrintCommentary().setEnabled(true);				
//				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*
				getJChkPrintOwn().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}
		
			if (fea) {
				getJChkPrintFeature().setEnabled(true);
				getJChkPrintCommentary().setSelected(false);
//				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintOwn().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}
		
			if (sid) {
				getJChkPrintSidebar().setEnabled(true);
				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
//				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintOwn().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}
		
			if (inf) {
				getJChkPrintInfographics().setEnabled(true);
				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
//				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintOwn().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}

			if (wir) {
				getJChkPrintWire().setEnabled(true);
				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
//				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
				getJChkPrintContribution().setSelected(false);
/*				
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintOwn().setEnabled(false);
				getJChkPrintContribution().setEnabled(false);
*/
			}

			if (con) {
				getJChkPrintContribution().setEnabled(true);
				getJChkPrintCommentary().setSelected(false);
				getJChkPrintFeature().setSelected(false);
				getJChkPrintSidebar().setSelected(false);
				getJChkPrintOwn().setSelected(false);
				getJChkPrintInfographics().setSelected(false);
				getJChkPrintWire().setSelected(false);
				getJChkPrintDiary().setSelected(false);
//				getJChkPrintContribution().setSelected(false);
/*				
				getJChkPrintCommentary().setEnabled(false);
				getJChkPrintFeature().setEnabled(false);
				getJChkPrintSidebar().setEnabled(false);
				getJChkPrintDiary().setEnabled(false);
				getJChkPrintInfographics().setEnabled(false);
				getJChkPrintWire().setEnabled(false);
				getJChkPrintOwn().setEnabled(false);
*/
			}
		}
	}
	
	private void SetComponentValues() 
			throws XPathExpressionException {
		// text areas
		jTextNewsEvent.setText(metadata.get(config.GetMetadataName("newsEvent")));
//		jTextResubReason.setText(metadata.get(config.GetMetadataName("resubReason")));

		// radio/check boxes
		jChkPrintDiary.setSelected(metadata.get(config.GetMetadataName("printDiary")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintCommentary.setSelected(metadata.get(config.GetMetadataName("printCommentary")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintFeature.setSelected(metadata.get(config.GetMetadataName("printFeature")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintSidebar.setSelected(metadata.get(config.GetMetadataName("printSidebar")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintOwn.setSelected(metadata.get(config.GetMetadataName("printOwn")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintInfographics.setSelected(metadata.get(config.GetMetadataName("printInfographics")).equalsIgnoreCase(Constants.TRUE));
		jChkPrintWire.setSelected(metadata.get(config.GetMetadataName("printWire")).equalsIgnoreCase(Constants.TRUE));

		jChkPrintContribution.setSelected(metadata.get(config.GetMetadataName("printContribution")).equalsIgnoreCase(Constants.TRUE));

		jChkOnlineDiary.setSelected(metadata.get(config.GetMetadataName("onlineDiary")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineOwn.setSelected(metadata.get(config.GetMetadataName("onlineOwn")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineTweet.setSelected(metadata.get(config.GetMetadataName("onlineTweet")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineFirstPhoto.setSelected(metadata.get(config.GetMetadataName("onlineFirstPhoto")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineFirstVideo.setSelected(metadata.get(config.GetMetadataName("onlineFirstVideo")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineVideoPackage.setSelected(metadata.get(config.GetMetadataName("onlineVideoPackage")).equalsIgnoreCase(Constants.TRUE));
		jChkOnlineBlog.setSelected(metadata.get(config.GetMetadataName("onlineBlog")).equalsIgnoreCase(Constants.TRUE));
		
		if (metadata.containsKey(config.GetMetadataName("onlineWire"))) {
			jChkOnlineWire.setSelected(metadata.get(config.GetMetadataName("onlineWire")).equalsIgnoreCase(Constants.TRUE));
		}
		else {
			jChkOnlineWire.setSelected(false);
		}

		// radio button setting
		if (jChkOnlineDiary.isSelected() || jChkOnlineOwn.isSelected() || jChkOnlineTweet.isSelected() ||
			jChkOnlineFirstPhoto.isSelected() || jChkOnlineFirstVideo.isSelected() ||
//			jChkOnlineVideoPackage.isSelected() || jChkOnlineBlog.isSelected()) {
			jChkOnlineVideoPackage.isSelected() || jChkOnlineBlog.isSelected() || jChkOnlineWire.isSelected()) {
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
//		jCmbSub.setSelectedItem(metadata.get(config.GetMetadataName("sub")));
//		jCmbChecker.setSelectedItem(metadata.get(config.GetMetadataName("checker")));
//		jCmbNumResub.setSelectedItem(metadata.get(config.GetMetadataName("numResub")));
		
		// checkbox lists
		cbListCoAuthor.setSelectedFromListString(metadata.get(config.GetMetadataName("coAuthor")));			
		cbListAddlReport.setSelectedFromListString(metadata.get(config.GetMetadataName("addlReport")));
	
	}
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();
		
		// text areas
		retMetadata.put(config.GetMetadataName("newsEvent"), jTextNewsEvent.getText());
//		retMetadata.put(config.GetMetadataName("resubReason"), jTextResubReason.getText());
		
		// radio/check boxes
		retMetadata.put(config.GetMetadataName("printDiary"), jChkPrintDiary.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printCommentary"), jChkPrintCommentary.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printFeature"), jChkPrintFeature.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printSidebar"), jChkPrintSidebar.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printOwn"), jChkPrintOwn.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printInfographics"), jChkPrintInfographics.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printWire"), jChkPrintWire.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("printContribution"), jChkPrintContribution.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineDiary"), jChkOnlineDiary.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineOwn"), jChkOnlineOwn.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineTweet"), jChkOnlineTweet.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineFirstPhoto"), jChkOnlineFirstPhoto.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineFirstVideo"), jChkOnlineFirstVideo.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineVideoPackage"), jChkOnlineVideoPackage.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineBlog"), jChkOnlineBlog.isSelected() ? Constants.TRUE : Constants.FALSE);
		retMetadata.put(config.GetMetadataName("onlineWire"), jChkOnlineWire.isSelected() ? Constants.TRUE : Constants.FALSE);
		
		// combo boxes
		retMetadata.put(config.GetMetadataName("copyright"), (String) jCmbCopyright.getSelectedItem());
//		retMetadata.put(config.GetMetadataName("sub"), (String) jCmbSub.getSelectedItem());
//		retMetadata.put(config.GetMetadataName("checker"), (String) jCmbChecker.getSelectedItem());
//		retMetadata.put(config.GetMetadataName("numResub"), (String) jCmbNumResub.getSelectedItem());
		
		// checkbox lists
	    retMetadata.put(config.GetMetadataName("coAuthor"), cbListCoAuthor.getSelectedListString());		
	    retMetadata.put(config.GetMetadataName("addlReport"), cbListAddlReport.getSelectedListString());

		return retMetadata;
	}

	/**
	 * This method initializes jChkOnlineWire	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChkOnlineWire() {
		if (jChkOnlineWire == null) {
			jChkOnlineWire = new JCheckBox();
			jChkOnlineWire.setBounds(new Rectangle(555, 255, 128, 24));
			jChkOnlineWire.setText("Wire");
			jChkOnlineWire.setFont(new Font("Dialog", Font.PLAIN, 12));
		}
		return jChkOnlineWire;
	}

	/**
	 * This method initializes jCmbCopyright	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbCopyright() throws XPathExpressionException {
		if (jCmbCopyright == null) {
			jCmbCopyright = new JComboBox<String>();
			jCmbCopyright.setBounds(new Rectangle(135, 420, 111, 21));
			jCmbCopyright.setMaximumRowCount(8);
			jCmbCopyright.setName("");
			config.InitComboBox(jCmbCopyright, "copyright");			
		}
		return jCmbCopyright;
	}



}  //  @jve:decl-index=0:visual-constraint="16,4"
