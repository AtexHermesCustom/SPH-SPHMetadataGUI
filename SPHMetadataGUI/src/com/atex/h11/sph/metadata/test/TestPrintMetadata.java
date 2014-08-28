package com.atex.h11.sph.metadata.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.unisys.media.commonservices.dialogs.metadata.view.ICustomMetadataPanel;
import com.atex.h11.sph.metadata.print.CustomMetadataPanel;

public class TestPrintMetadata {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		final ICustomMetadataPanel customPane = new CustomMetadataPanel();
		final HashMap<String, String> metadata = new HashMap<String, String>();
		
		// sample metadata
		metadata.put("PRIMARYCAT", "Top Stories");
		metadata.put("SECONDARYCAT", "none");
		metadata.put("SECONDARY", "true");
		metadata.put("PRIORITY", "1");
		metadata.put("PREMIUM", "true");
		metadata.put("SUB", "sub 3");
		
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (customPane.canActionBePerformed(ICustomMetadataPanel.OK_BUTTON)) {
					printHashMap(customPane.getMetadataValues());
					System.exit(0);
				}
			}
		});
		
		try {
			JPanel panel = new JPanel();
			// args: inspector=null, metadata hashmap, readonly=false
			panel.add(customPane.getPanel(null, metadata, false));
			panel.add(okButton);
			
			jFrame.add(panel);
			jFrame.setTitle(customPane.getTitle());
			jFrame.pack();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error:" + e.toString());
		}		

		jFrame.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent e) {
			}

			public void windowClosed(WindowEvent e) {
				System.out.println("End of main()");
				printHashMap(customPane.getMetadataValues());
				System.exit(0);
			}

			public void windowClosing(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowOpened(WindowEvent e) {
			}
		});
		
		jFrame.setVisible(true);
	}
	
	public static void printHashMap(HashMap<String, String> map) {
		// sort map by key
		Map<String, String> treeMap = new TreeMap<String, String>(map);
		
		System.out.println("printHashMap:");
		System.out.println("'<key>' = '<value>'");
		for (String s : treeMap.keySet()) {
			System.out.println("'" + s + "' = '" + treeMap.get(s) + "'");
		};
		System.out.println("--end--");
	}	

}
