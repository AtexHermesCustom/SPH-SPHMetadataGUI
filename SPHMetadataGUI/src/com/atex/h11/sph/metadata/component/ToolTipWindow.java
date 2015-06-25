package com.atex.h11.sph.metadata.component;

import java.awt.Color;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class ToolTipWindow extends JWindow {
  	private static final long serialVersionUID = 1L;
	
  	JLabel label = null;
    JPanel panel = null;
    
    String message = "";
    Point point;
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public ToolTipWindow() {		    
        label = new JLabel();
        panel = new JPanel();
        panel.add(label);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));            
	    add(panel);
    }
    
    public void showTip(String msg, Point point) {
    	setMessage(msg);
    	setPoint(point);
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    	    	//System.out.println("showTip: " + getMessage());
    	    	label.setText(getMessage());
                pack();        	 		    
                setVisible(true);             
                setLocation(getPoint().x, getPoint().y - getHeight());	    		    			
    		}
    	});
    }
    
    public void hideTip() {
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {	    	
		    	//System.out.println("hideTip");
		    	setVisible(false);
    		}
    	});
    }
}
