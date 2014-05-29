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
import com.atex.h11.sph.metadata.common.Constants;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
	private JComboBox<String> jCmbPriority = null;
	private JLabel jLabelpri = null;

	/**
	 * This method initializes jCmbPriority	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJCmbPriority() throws XPathExpressionException {
		if (jCmbPriority == null) {
			jCmbPriority = new JComboBox<String>();
			jCmbPriority.setBounds(new Rectangle(444, 41, 127, 25));
			jCmbPriority.setName("");
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
			jCmbST.setBounds(new Rectangle(149, 44, 254, 21));
			jCmbST.setName("");
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
			jCmbSuntimes.setSize(new Dimension(254, 21));
			//jCmbSuntimes.setEnabled(false);
			jCmbSuntimes.setLocation(new Point(149, 104));
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
			jCmbLife.setSize(new Dimension(254, 21));
			//jCmbLife.setEnabled(false);
			jCmbLife.setLocation(new Point(149, 164));
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
			jCmbLifestyle.setSize(new Dimension(254, 21));
			//jCmbLifestyle.setEnabled(false);
			jCmbLifestyle.setLocation(new Point(149, 224));
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
			jCmbOthers.setSize(new Dimension(254, 21));
			//jCmbOthers.setEnabled(false);
			jCmbOthers.setLocation(new Point(149, 284));
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
			jCmbMyp.setBounds(new Rectangle(149, 344, 256, 22));
			jCmbMyp.setName("");
			//jCmbMyp.setEnabled(false);
			config.InitComboBox(jCmbMyp, "mywebcat");
		}
		return jCmbMyp;
	}
	
	/**
	 * This method initializes jRadioButtonST	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonST() {
		if (jRadioButtonST == null) {
			jRadioButtonST = new JRadioButton();
			jRadioButtonST.setBounds(new Rectangle(30, 44, 21, 21));
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
			jRadioButtonSut.setBounds(new Rectangle(30, 103, 21, 21));
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
			jRadioButtonLife.setBounds(new Rectangle(30, 166, 21, 21));
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
			jRadioButtonLifestyle.setBounds(new Rectangle(30, 228, 21, 21));
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
			jRadioButtonOthers.setBounds(new Rectangle(30, 288, 21, 21));
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
			jRadioButtonMyp.setBounds(new Rectangle(30, 348, 18, 24));
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
		jLabelpri = new JLabel();
		jLabelpri.setBounds(new Rectangle(444, 20, 80, 16));
		jLabelpri.setText("Priority");
		jLabelpri.setName("");
		jLabelMyp = new JLabel();
		jLabelMyp.setBounds(new Rectangle(60, 349, 79, 16));
		jLabelMyp.setText("My Paper");
		jLabelMyp.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelFrame = new JLabel();
		jLabelFrame.setName("");
		jLabelFrame.setBounds(new Rectangle(27, 16, 80, 16));
		jLabelFrame.setText("Web Category");
		jLabelOthers = new JLabel();
		jLabelOthers.setBounds(new Rectangle(60, 289, 79, 16));
		jLabelOthers.setText("Others");
		jLabelOthers.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelLifestyle = new JLabel();
		jLabelLifestyle.setBounds(new Rectangle(60, 229, 79, 16));
		jLabelLifestyle.setText("Lifestyle");
		jLabelLifestyle.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelLife = new JLabel();
		jLabelLife.setBounds(new Rectangle(60, 169, 79, 16));
		jLabelLife.setText("Life");
		jLabelLife.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel1121 = new JLabel();
		jLabel1121.setBounds(new Rectangle(60, 104, 87, 21));
		jLabel1121.setText("Sunday Times");
		jLabel1121.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabel112 = new JLabel();
		jLabel112.setBounds(new Rectangle(60, 44, 82, 16));
		jLabel112.setText("Straits Times");
		jLabel112.setFont(new Font("Dialog", Font.PLAIN, 12));
		this.setLayout(null);
		this.setSize(720, 470);

        //Group the web cat radio buttons.
        ButtonGroup radioButtonGroup1 = new ButtonGroup();
        radioButtonGroup1.add(getJRadioButtonST());
        radioButtonGroup1.add(getJRadioButtonSut());				
        radioButtonGroup1.add(getJRadioButtonLife());				
        radioButtonGroup1.add(getJRadioButtonLifestyle());				
        radioButtonGroup1.add(getJRadioButtonOthers());				
        radioButtonGroup1.add(getJRadioButtonMyp());				
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
		this.add(getJCmbPriority(), null);
		this.add(jLabelpri, null);
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

		getJCmbST().setEnabled(true);
		getJCmbSuntimes().setEnabled(false);
		getJCmbLife().setEnabled(false);
		getJCmbLifestyle().setEnabled(false);
		getJCmbOthers().setEnabled(false);
		getJCmbMyp().setEnabled(false);
		
		// clear disabled checkboxes
		if (sut) {
			getJCmbST().setEnabled(false);
			getJCmbSuntimes().setEnabled(true);
		}
		if (life) {
			getJCmbST().setEnabled(false);
			getJCmbLife().setEnabled(true);
		}	
		if (lifestyle) {
			getJCmbST().setEnabled(false);
			getJCmbLifestyle().setEnabled(true);
		}	
		if (others) {
			getJCmbST().setEnabled(false);
			getJCmbOthers().setEnabled(true);
		}	
		if (myp) {
			getJCmbST().setEnabled(false);
			getJCmbMyp().setEnabled(true);
		}	
	}	
	
	
	private void SetComponentValues() 
			throws XPathExpressionException {
		
		// init check boxes

		getJRadioButtonST().setSelected(true);
//		getJRadPrint().setSelected(false);
		InitCheckBoxes(getJRadioButtonST().getText());		
		
		// combo boxes
		jCmbST.setSelectedItem(metadata.get(config.GetMetadataName("webcat1")));
		jCmbSuntimes.setSelectedItem(metadata.get(config.GetMetadataName("webcat2")));
		jCmbLife.setSelectedItem(metadata.get(config.GetMetadataName("webcat3")));
		jCmbLifestyle.setSelectedItem(metadata.get(config.GetMetadataName("webcat4")));
		jCmbOthers.setSelectedItem(metadata.get(config.GetMetadataName("webcat5")));
		jCmbMyp.setSelectedItem(metadata.get(config.GetMetadataName("mywebcat")));
		jCmbPriority.setSelectedItem(metadata.get(config.GetMetadataName("priority")));
	}
	
	public HashMap<String,String> GetMetadataValues() 
			throws XPathExpressionException {
		HashMap<String,String> retMetadata = new HashMap<String,String>();

		// radio/check boxes
//		retMetadata.put(config.GetMetadataName("onlineBlog"), jRadioButtonST.isSelected() ? Constants.TRUE : Constants.FALSE);
		
		
		// combo boxes
		retMetadata.put(config.GetMetadataName("webcat1"), (String) jCmbST.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat2"), (String) jCmbSuntimes.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat3"), (String) jCmbLife.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat4"), (String) jCmbLifestyle.getSelectedItem());
		retMetadata.put(config.GetMetadataName("webcat5"), (String) jCmbOthers.getSelectedItem());
		retMetadata.put(config.GetMetadataName("mywebcat"), (String) jCmbMyp.getSelectedItem());
		retMetadata.put(config.GetMetadataName("priority"), (String) jCmbPriority.getSelectedItem());

		return retMetadata;
	}

}  //  @jve:decl-index=0:visual-constraint="10,9"
