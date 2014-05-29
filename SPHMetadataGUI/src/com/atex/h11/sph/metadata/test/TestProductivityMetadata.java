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
import com.atex.h11.sph.metadata.common.Constants;
import com.atex.h11.sph.metadata.productivity.CustomMetadataPanel;

public class TestProductivityMetadata {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		final ICustomMetadataPanel customPane = new CustomMetadataPanel();
		final HashMap<String, String> metadata = new HashMap<String, String>();
		
		// sample metadata
		metadata.put("NEWS_EVENT", "News Event: the quick brown fox jumped");
		metadata.put("REASONS_FOR_RESUBS", "This is the reason for the resub");
		metadata.put("PRINT_DIARY", Constants.FALSE);
		metadata.put("PRINT_OWN", Constants.FALSE);
		metadata.put("PRINT_COMMENTARY", Constants.FALSE);
		metadata.put("PRINT_FEATURE", Constants.FALSE);
		metadata.put("PRINT_SIDEBAR", Constants.FALSE);
		metadata.put("PRINT_INFOGRAPHICS", Constants.FALSE);
		metadata.put("PRINT_WIRE", Constants.FALSE);
		metadata.put("ONLINE_DIARY", Constants.TRUE);
		metadata.put("ONLINE_OWN", Constants.FALSE);
		metadata.put("ONLINE_TWEETS", Constants.TRUE);
		metadata.put("ONLINE_FIRST_PHOTOS", Constants.FALSE);
		metadata.put("ONLINE_FIRST_VIDEOS", Constants.TRUE);
		metadata.put("ONLINE_VIDEO_PACKAGE", Constants.FALSE);
		metadata.put("ONLINE_BLOG", Constants.TRUE);
		metadata.put("COAUTHOR", "co Author 2,co Author 6");
		metadata.put("ADDITIONAL_REPORTING", "addl Report 2,addl Report 6");
		metadata.put("COPYRIGHT", "copyright a");
		metadata.put("SUB", "sub 3");
		metadata.put("CHECKER", "checker c");
		metadata.put("NO_OF_RESUBS", "num resub 1");
		metadata.put("PRIORITY", "priority ii");
		metadata.put("WEB_CAT1", "web cat 1 - a");
		metadata.put("WEB_CAT2", "web cat 2 - c");
		
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
