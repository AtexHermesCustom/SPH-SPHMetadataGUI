package com.atex.h11.sph.metadata.online;

import java.util.HashMap;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.xml.xpath.XPathExpressionException;
import com.atex.h11.sph.metadata.common.ConfigModel;
//import com.atex.h11.sph.metadata.common.Constants;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MetadataPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ConfigModel config = null;
	private HashMap<String, String> metadata = null;
	private JLabel jLabel112 = null;
	private JLabel jLabel1121 = null;
	private JComboBox<String> jCmbST = null;
	private JComboBox<String> jCmbSuntimes = null;
	private JComboBox<String> jCmbLife = null;
	private JComboBox<String> jCmbLifestyle = null;
	private JComboBox<String> jCmbOthers = null;
	private JComboBox<String> jCmbMyp = null;
	private JRadioButton jRadioButtonST = null;
	private JRadioButton jRadioButtonSut = null;
	private JRadioButton jRadioButtonLife = null;
	private JRadioButton jRadioButtonLifestyle = null;
	private JRadioButton jRadioButtonOthers = null;
	private JLabel jLabelLife = null;
	private JLabel jLabelLifestyle = null;
	private JLabel jLabelOthers = null;
	private JLabel jLabelFrame = null;
	private JRadioButton jRadioButtonMyp = null;
	private JLabel jLabelMyp = null;
	private JComboBox<String> jCmbCopyright = null;
	private JLabel jLabelpri = null;
	private JComboBox<String> jCmbDigitalLife = null;
	private JComboBox<String> jCmbUrban = null;
	private JComboBox<String> jCmbMyb = null;
	private JLabel jLabelDigitalLife = null;
	private JLabel jLabelUrban = null;
	private JRadioButton jRadioButtonDigitalLife = null;
	private JRadioButton jRadioButtonUrban = null;
	private JLabel jLabelFrame1 = null;
	private JTextArea jTextWebCatA = null;
	
	/**
	 * This method initializes jTextWebCatA	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextWebCatA() {
		if (jTextWebCatA == null) {
			jTextWebCatA = new JTextArea();
			jTextWebCatA.setBounds(new Rectangle(166, 13, 243, 16));
			jTextWebCatA.setWrapStyleWord(true);
			jTextWebCatA.setLineWrap(true);
			jTextWebCatA.setVisible(false);
		}
		return jTextWebCatA;
	}
	
	/**
	 * This method initializes jCmbCopyright
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbCopyright() throws XPathExpressionException {
		if (jCmbCopyright == null) {
			jCmbCopyright = new JComboBox<String>();
			jCmbCopyright.setBounds(new Rectangle(511, 37, 127, 21));
			jCmbCopyright.setMaximumRowCount(10);
			jCmbCopyright.setFont(new Font("Dialog", Font.PLAIN, 12));
			jCmbCopyright.setName("");
			config.InitComboBox(jCmbCopyright, "copyright");
		}
		return jCmbCopyright;
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
			jCmbST.setBounds(new Rectangle(156, 40, 196, 21));
			jCmbST.setName("");
			jCmbST.setMaximumRowCount(20);
			jCmbST.setEnabled(false);			
			config.InitComboBox(jCmbST, "webcat1");
		}
		return jCmbST;
	}

	/**
	 * This method initializes jCmbSuntimes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbSuntimes() throws XPathExpressionException {
		if (jCmbSuntimes == null) {
			jCmbSuntimes = new JComboBox<String>();
			jCmbSuntimes.setName("");
			jCmbSuntimes.setSize(new Dimension(196, 21));
			jCmbSuntimes.setEnabled(false);
			jCmbSuntimes.setMaximumRowCount(20);
			jCmbSuntimes.setLocation(new Point(156, 88));
			config.InitComboBox(jCmbSuntimes, "webcat2");
		}
		return jCmbSuntimes;
	}

	/**
	 * This method initializes jCmbLife	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbLife() throws XPathExpressionException {
		if (jCmbLife == null) {
			jCmbLife = new JComboBox<String>();
			jCmbLife.setName("");
			jCmbLife.setSize(new Dimension(196, 21));
			jCmbLife.setEnabled(false);
			jCmbLife.setMaximumRowCount(20);
			jCmbLife.setLocation(new Point(156, 136));
			config.InitComboBox(jCmbLife, "webcat3");

		}
		return jCmbLife;
	}

	/**
	 * This method initializes jCmbLifestyle	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbLifestyle() throws XPathExpressionException {
		if (jCmbLifestyle == null) {
			jCmbLifestyle = new JComboBox<String>();
			jCmbLifestyle.setName("");
			jCmbLifestyle.setSize(new Dimension(196, 21));
			jCmbLifestyle.setEnabled(false);
			jCmbLifestyle.setMaximumRowCount(20);
			jCmbLifestyle.setLocation(new Point(156, 184));
			config.InitComboBox(jCmbLifestyle, "webcat4");
		}
		return jCmbLifestyle;
	}

	/**
	 * This method initializes jCmbOthers	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbOthers() throws XPathExpressionException {
		if (jCmbOthers == null) {
			jCmbOthers = new JComboBox<String>();
			jCmbOthers.setName("");
			jCmbOthers.setSize(new Dimension(196, 21));
			jCmbOthers.setEnabled(false);
			jCmbOthers.setMaximumRowCount(20);
			jCmbOthers.setLocation(new Point(156, 232));
			config.InitComboBox(jCmbOthers, "webcat5");
		}
		return jCmbOthers;
	}

	/**
	 * This method initializes jCmbMyp	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbMyp() throws XPathExpressionException {
		if (jCmbMyp == null) {
			jCmbMyp = new JComboBox<String>();
			jCmbMyp.setBounds(new Rectangle(155, 280, 198, 22));
			jCmbMyp.setName("");
			jCmbMyp.setMaximumRowCount(20);
			jCmbMyp.setEnabled(false);
			config.InitComboBox(jCmbMyp, "webcat6");
		}
		return jCmbMyp;
	}

	/**
	 * This method initializes jCmbDigitalLife	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbDigitalLife() throws XPathExpressionException {
		if (jCmbDigitalLife == null) {
			jCmbDigitalLife = new JComboBox<String>();
			jCmbDigitalLife.setBounds(new Rectangle(155, 331, 198, 22));
			jCmbDigitalLife.setName("");
			jCmbDigitalLife.setMaximumRowCount(20);
			jCmbDigitalLife.setEnabled(false);
			config.InitComboBox(jCmbDigitalLife, "webcat7");
		}
		return jCmbDigitalLife;
	}

	/**
	 * This method initializes jCmbUrban	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbUrban() throws XPathExpressionException {
		if (jCmbUrban == null) {
			jCmbUrban = new JComboBox<String>();
			jCmbUrban.setBounds(new Rectangle(155, 378, 198, 22));
			jCmbUrban.setName("");
			jCmbUrban.setMaximumRowCount(20);
			jCmbUrban.setEnabled(false);
			config.InitComboBox(jCmbUrban, "webcat8");
		}
		return jCmbUrban;
	}

	/**
	 * This method initializes jCmbMyb	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbMyb() throws XPathExpressionException {
		if (jCmbMyb == null) {
			jCmbMyb = new JComboBox<String>();
			jCmbMyb.setBounds(new Rectangle(511, 92, 196, 21));
			jCmbMyb.setName("");
			jCmbMyb.setFont(new Font("Dialog", Font.PLAIN, 12));
			jCmbMyb.setMaximumRowCount(20);
			//jCmbMyb.setEnabled(false);
			config.InitComboBox(jCmbMyb, "catb");
		}
		return jCmbMyb;
	}

	
	
	/**
	 * This method initializes jRadioButtonST	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonST() {
		if (jRadioButtonST == null) {
			jRadioButtonST = new JRadioButton();
			jRadioButtonST.setBounds(new Rectangle(32, 36, 21, 24));
			jRadioButtonST.setText("ST");			
			jRadioButtonST.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonST.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
		}
		return jRadioButtonST;
	}

	/**
	 * This method initializes jRadioButtonSut	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonSut() {
		if (jRadioButtonSut == null) {
			jRadioButtonSut = new JRadioButton();
			jRadioButtonSut.setBounds(new Rectangle(32, 89, 21, 24));
			jRadioButtonSut.setText("SUT");			
			jRadioButtonSut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonSut.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
		}
		return jRadioButtonSut;
	}

	/**
	 * This method initializes jRadioButtonLife	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonLife() {
		if (jRadioButtonLife == null) {
			jRadioButtonLife = new JRadioButton();
			jRadioButtonLife.setBounds(new Rectangle(32, 138, 21, 24));
			jRadioButtonLife.setText("LIFE");			
			jRadioButtonLife.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonLife.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
		}
		return jRadioButtonLife;
	}

	/**
	 * This method initializes jRadioButtonLifestyle	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonLifestyle() {
		if (jRadioButtonLifestyle == null) {
			jRadioButtonLifestyle = new JRadioButton();
			jRadioButtonLifestyle.setBounds(new Rectangle(32, 186, 21, 24));
			jRadioButtonLifestyle.setText("LIFESTYLE");			
			jRadioButtonLifestyle.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonLifestyle.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
		}
		return jRadioButtonLifestyle;
	}

	/**
	 * This method initializes jRadioButtonOthers	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonOthers() {
		if (jRadioButtonOthers == null) {
			jRadioButtonOthers = new JRadioButton();
			jRadioButtonOthers.setBounds(new Rectangle(32, 234, 21, 24));
			jRadioButtonOthers.setText("OTHERS");			
			jRadioButtonOthers.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonOthers.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
		}
		return jRadioButtonOthers;
	}

	/**
	 * This method initializes jRadioButtonMyp	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMyp() {
		if (jRadioButtonMyp == null) {
			jRadioButtonMyp = new JRadioButton();
			jRadioButtonMyp.setBounds(new Rectangle(33, 281, 18, 24));
			jRadioButtonMyp.setText("MYP");
			jRadioButtonMyp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonMyp.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
		}
		return jRadioButtonMyp;
	}

	/**
	 * This method initializes jRadioButtonDigitalLife	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonDigitalLife() {
		if (jRadioButtonDigitalLife == null) {
			jRadioButtonDigitalLife = new JRadioButton();
			jRadioButtonDigitalLife.setBounds(new Rectangle(33
					, 329, 18, 24));
			jRadioButtonDigitalLife.setText("DIGITALLIFE");
			jRadioButtonDigitalLife.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonDigitalLife.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
				
		}
		return jRadioButtonDigitalLife;
	}

	/**
	 * This method initializes jRadioButtonUrban	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonUrban() {
		if (jRadioButtonUrban == null) {
			jRadioButtonUrban = new JRadioButton();
			jRadioButtonUrban.setBounds(new Rectangle(33, 377, 18, 24));
			jRadioButtonUrban.setText("URBAN");
			jRadioButtonUrban.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InitCheckBoxes(jRadioButtonUrban.getText());
					} catch (XPathExpressionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});			
				
		}
		return jRadioButtonUrban;
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
		jLabelFrame1 = new JLabel();
		jLabelFrame1.setBounds(new Rectangle(386, 87, 119, 28));
		jLabelFrame1.setText("Web Category B");
		jLabelFrame1.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelFrame1.setName("");
		jLabelUrban = new JLabel();
		jLabelUrban.setBounds(new Rectangle(58, 380, 80, 20));
		jLabelUrban.setText("DigitalLife");
		jLabelUrban.setVerticalAlignment(SwingConstants.TOP);
		jLabelUrban.setVerticalTextPosition(SwingConstants.TOP);
		jLabelUrban.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelDigitalLife = new JLabel();
		jLabelDigitalLife.setBounds(new Rectangle(58, 332, 80, 20));
		jLabelDigitalLife.setText("Lifestyle");
		jLabelDigitalLife.setVerticalAlignment(SwingConstants.TOP);
		jLabelDigitalLife.setVerticalTextPosition(SwingConstants.TOP);
		jLabelDigitalLife.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelpri = new JLabel();
		jLabelpri.setBounds(new Rectangle(386, 38, 88, 21));
		jLabelpri.setText("Copyright");
		jLabelpri.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelpri.setName("");
		jLabelMyp = new JLabel();
		jLabelMyp.setBounds(new Rectangle(58, 282, 80, 20));
		jLabelMyp.setText("Asia");
		jLabelMyp.setVerticalAlignment(SwingConstants.TOP);
		jLabelMyp.setVerticalTextPosition(SwingConstants.TOP);
		jLabelMyp.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelFrame = new JLabel();
		jLabelFrame.setName("");
		jLabelFrame.setBounds(new Rectangle(27, 5, 139, 21));
		jLabelFrame.setFont(new Font("Dialog", Font.BOLD, 12));
		jLabelFrame.setForeground(Color.red);
		jLabelFrame.setText("Web Category A*");
		jLabelOthers = new JLabel();
		jLabelOthers.setBounds(new Rectangle(58, 236, 80, 20));
		jLabelOthers.setText("Opinion");
		jLabelOthers.setVerticalAlignment(SwingConstants.TOP);
		jLabelOthers.setVerticalTextPosition(SwingConstants.TOP);
		jLabelOthers.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelLifestyle = new JLabel();
		jLabelLifestyle.setBounds(new Rectangle(58, 188, 80, 20));
		jLabelLifestyle.setText("World");
		jLabelLifestyle.setVerticalAlignment(SwingConstants.TOP);
		jLabelLifestyle.setVerticalTextPosition(SwingConstants.TOP);
		jLabelLifestyle.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabelLife = new JLabel();
		jLabelLife.setBounds(new Rectangle(58, 140, 80, 20));
		jLabelLife.setText("Sport");
		jLabelLife.setVerticalAlignment(SwingConstants.TOP);
		jLabelLife.setVerticalTextPosition(SwingConstants.TOP);
		jLabelLife.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel1121 = new JLabel();
		jLabel1121.setBounds(new Rectangle(55, 90, 87, 20));
		jLabel1121.setText("Business");
		jLabel1121.setVerticalAlignment(SwingConstants.TOP);
		jLabel1121.setVerticalTextPosition(SwingConstants.TOP);
		jLabel1121.setFont(new Font("Dialog", Font.PLAIN, 14));
		jLabel112 = new JLabel();
		jLabel112.setBounds(new Rectangle(57, 39, 82, 20));
		jLabel112.setText("Singapore");
		jLabel112.setVerticalAlignment(SwingConstants.TOP);
		jLabel112.setVerticalTextPosition(SwingConstants.TOP);
		jLabel112.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.setLayout(null);
		this.setSize(720, 470);

		this.setFont(new Font("Dialog", Font.PLAIN, 14));
        //Group the web cat radio buttons.
        ButtonGroup radioButtonGroup1 = new ButtonGroup();
        radioButtonGroup1.add(getJRadioButtonST());
        radioButtonGroup1.add(getJRadioButtonSut());				
        radioButtonGroup1.add(getJRadioButtonLife());				
        radioButtonGroup1.add(getJRadioButtonLifestyle());				
        radioButtonGroup1.add(getJRadioButtonOthers());				
        radioButtonGroup1.add(getJRadioButtonMyp());				
        radioButtonGroup1.add(getJRadioButtonDigitalLife());				
        radioButtonGroup1.add(getJRadioButtonUrban());				
		// check "Positive" initially
//		getJRadioButtonST().setSelected(true);
		// init check boxes
//		InitCheckBoxes(getJRadioButtonST().getText());		
		
		// lists
		this.add(getJCmbST(), null);
		this.add(jLabel112, null);
		this.add(jLabel1121, null);
		this.add(getJCmbSuntimes(), null);
		this.add(getJCmbLife(), null);
		this.add(getJCmbLifestyle(), null);
		this.add(getJCmbOthers(), null);
		this.add(getJRadioButtonST(), null);
		this.add(getJRadioButtonSut(), null);
		this.add(getJRadioButtonLife(), null);
		this.add(getJRadioButtonLifestyle(), null);
		this.add(getJRadioButtonOthers(), null);
		this.add(jLabelLife, null);
		this.add(jLabelLifestyle, null);
		this.add(jLabelOthers, null);
		this.add(jLabelFrame, null);
		this.add(getJRadioButtonMyp(), null);
		this.add(getJCmbMyp(), null);
		this.add(jLabelMyp, null);
		this.add(getJCmbCopyright(), null);
		this.add(jLabelpri, null);
		this.add(getJCmbDigitalLife(), null);
		this.add(getJCmbUrban(), null);
		this.add(getJCmbMyb(), null);
		this.add(jLabelDigitalLife, null);
		this.add(jLabelUrban, null);
		this.add(getJRadioButtonDigitalLife(), null);
		this.add(getJRadioButtonUrban(), null);
		this.add(jLabelFrame1, null);
		this.add(getJTextWebCatA(), null);
	}

	private void InitCheckBoxes(String mode) throws XPathExpressionException {
		boolean sut =
		(mode.equalsIgnoreCase("SUT") ? true : false);
		boolean life =
			(mode.equalsIgnoreCase("LIFE") ? true : false);
		boolean lifestyle =
			(mode.equalsIgnoreCase("LIFESTYLE") ? true : false);
		boolean others =
			(mode.equalsIgnoreCase("OTHERS") ? true : false);
		boolean myp =
			(mode.equalsIgnoreCase("MYP") ? true : false);
		boolean digitallife =
			(mode.equalsIgnoreCase("DIGITALLIFE") ? true : false);
		boolean urban =
			(mode.equalsIgnoreCase("URBAN") ? true : false);
	
		getJCmbST().setEnabled(true);
		getJCmbSuntimes().setEnabled(false);
		getJCmbLife().setEnabled(false);
		getJCmbLifestyle().setEnabled(false);
		getJCmbOthers().setEnabled(false);
		getJCmbMyp().setEnabled(false);
		getJCmbDigitalLife().setEnabled(false);
		getJCmbUrban().setEnabled(false);
		getJCmbDigitalLife().setEnabled(false);				
		
		// clear disabled checkboxes
		if (sut) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");				
			getJCmbSuntimes().setEnabled(true);
		}
		if (life) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");				
			getJCmbLife().setEnabled(true);
		}	
		if (lifestyle) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");				
			getJCmbLifestyle().setEnabled(true);
		}	
		if (others) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");				
			getJCmbOthers().setEnabled(true);
		}	
		if (myp) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");
			getJCmbMyp().setEnabled(true);
		}
		if (digitallife) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
			getJCmbDigitalLife().setEnabled(true);
		}
		if (urban) {
			getJCmbST().setEnabled(false);
			getJCmbST().setSelectedItem("");
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");
			getJCmbUrban().setEnabled(true);
		}
		else {
			getJCmbSuntimes().setSelectedItem("");
			getJCmbLife().setSelectedItem("");
			getJCmbLifestyle().setSelectedItem("");
			getJCmbOthers().setSelectedItem("");
			getJCmbMyp().setSelectedItem("");
			getJCmbDigitalLife().setSelectedItem("");
			getJCmbUrban().setSelectedItem("");
		}
	}	
	
	private void SetComponentValues() 
			throws XPathExpressionException {
		
		// init check boxes

//		getJRadioButtonST().setSelected(true);
//		getJRadPrint().setSelected(false);
//		InitCheckBoxes(getJRadioButtonST().getText());		
		
		// text areas
//		jTextNewsEvent.setText(metadata.get(config.GetMetadataName("newsEvent")));
		
		
		// combo boxes
		jCmbST.setSelectedItem(metadata.get(config.GetMetadataName("webcat1")));
		jCmbSuntimes.setSelectedItem(metadata.get(config.GetMetadataName("webcat2")));
		jCmbLife.setSelectedItem(metadata.get(config.GetMetadataName("webcat3")));
		jCmbLifestyle.setSelectedItem(metadata.get(config.GetMetadataName("webcat4")));
		jCmbOthers.setSelectedItem(metadata.get(config.GetMetadataName("webcat5")));
		jCmbMyp.setSelectedItem(metadata.get(config.GetMetadataName("webcat6")));
		jCmbDigitalLife.setSelectedItem(metadata.get(config.GetMetadataName("webcat7")));
		jCmbUrban.setSelectedItem(metadata.get(config.GetMetadataName("webcat8")));
		jCmbMyb.setSelectedItem(metadata.get(config.GetMetadataName("catb")));
		jCmbCopyright.setSelectedItem(metadata.get(config.GetMetadataName("copyright")));
	}
	
	public boolean isReady() {
		// put any required validation here
		return true;
	}	
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();

		// radio/check boxes
//		retMetadata.put(config.GetMetadataName("onlineBlog"), jRadioButtonST.isSelected() ? Constants.TRUE : Constants.FALSE);
		
		// text areas
//		retMetadata.put(config.GetMetadataName("newsEvent"), jTextNewsEvent.getText());

		
		// combo boxes
		retMetadata.put(config.GetMetadataName("webcat1"), (String) jCmbST.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat2"), (String) jCmbSuntimes.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat3"), (String) jCmbLife.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat4"), (String) jCmbLifestyle.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat5"), (String) jCmbOthers.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat6"), (String) jCmbMyp.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat7"), (String) jCmbDigitalLife.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat8"), (String) jCmbUrban.getSelectedItem());
		retMetadata.put(config.GetMetadataName("catb"), (String) jCmbMyb.getSelectedItem());
		retMetadata.put(config.GetMetadataName("copyright"), (String) jCmbCopyright.getSelectedItem());

		String webcat1 = (String) jCmbST.getSelectedItem();
		String webcat2 = (String) jCmbSuntimes.getSelectedItem();
		String webcat3 = (String) jCmbLife.getSelectedItem();
		String webcat4 = (String) jCmbLifestyle.getSelectedItem();
		String webcat5 = (String) jCmbOthers.getSelectedItem();
		String webcat6 = (String) jCmbMyp.getSelectedItem();
		String webcat7 = (String) jCmbDigitalLife.getSelectedItem();
		String webcat8 = (String) jCmbUrban.getSelectedItem();
		String catb = (String) jCmbMyb.getSelectedItem();

		String value = "";

		// SPH;Singapore@Courts & Crime:
		if(webcat1 != null && !webcat1.isEmpty())
		{value = "Singapore@" + webcat1;}
		if(webcat2 != null && !webcat2.isEmpty())
		{value = "Business@" + webcat2;}
		if(webcat3 != null && !webcat3.isEmpty())
		{value = "Sport@" + webcat3;}
		if(webcat4 != null && !webcat4.isEmpty())
		{value = "World@" + webcat4;}
		if(webcat5 != null && !webcat5.isEmpty())
		{value = "Opinion@" + webcat5;}
		if(webcat6 != null && !webcat6.isEmpty())
		{value = "Asia@" + webcat6;}
		if(webcat7 != null && !webcat7.isEmpty())
		{value = "Lifestyle@" + webcat7;}
		if(webcat8 != null && !webcat8.isEmpty())
		{value = "DigitalLife@" + webcat8;}

		value = value + ":" + catb;
		
		retMetadata.put(config.GetMetadataName("webcata"), value);
		
		return retMetadata;
	}

}  //  @jve:decl-index=0:visual-constraint="10,9"
