package com.atex.h11.sph.metadata.print;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import javax.swing.JButton;
import java.io.*;

/**
 * An example on how to use the {@link AutoCompleteDocument}.
 * 
 * @see AutoCompleteDocument
 * @see CompletionService
 * 
 * @author Samuel Sjoberg, http://samuelsjoberg.com
 * @version 1.0.0
 */
public class CompletionSample implements Runnable {

    /**
     * Create the GUI and display it to the world.
     */
    public void run() {
        // Create the completion service.
        NameService nameService = new NameService();

        // Create the input field.
        JTextField input = new JTextField();

        
        // Create the auto completing document model with a reference to the
        // service and the input field.
        Document autoCompleteDocument = new AutoCompleteDocument(nameService,
                input);

        // Set the auto completing document as the document model on our input
        // field.
        input.setDocument(autoCompleteDocument);
        

        // Below we just create a frame and display the GUI.

        JFrame frame = new JFrame("Autocompletion sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel description = new JLabel();

        description.setText("<html><b>Autocompletion sample for the most<br>"
//                + " popular baby names (2008)</b><br><br>");
                + " popular baby names (2008)</b><br><br>"
               + nameService.toString().replace("\n", "<br>") + "<br>");

        JComponent contentPane = (JComponent) frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(input, BorderLayout.SOUTH);
        contentPane.add(description, BorderLayout.CENTER);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.pack();
        frame.setVisible(true);

}

    /**
     * Application entry point.
     * 
     * @param args
     *            not in use
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CompletionSample());
    }

    /**
     * A simple {@link CompletionService} providing completion for most popular
     * baby names 2008.
     */
    private static class NameService implements CompletionService<String> {

        /** Our name data. */
        private List<String> data;

        /**
         * Create a new <code>NameService</code> and populate it.
         */
        public NameService() {
/*        	
        	data = Arrays.asList("Jacob", "Emma", "Michael", "Isabella",
                    "Ethan", "Emily", "Joshua", "Madison", "Daniel", "Ava",
                    "Alexander", "Olivia", "Anthony", "Sophia", "William",
                    "Abigail", "Christopher", "Elizabeth", "Matthew", "Chloe", "Alibaba");
*/        	
       	   // create an array of strings read from a file
//       	   String a[] = new String[]{"abc","klm","xyz","pqr"};
  
            System.out.println("Reading File from Java code");
        	//Name of the file
//            String fileName="C:/thetextfile.txt";
            String fileName="C:/thetextfile1.txt";
            try{

            //Create object of FileReader
//            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
//            BufferedReader bufferReader = new BufferedReader(inputFile);

            // create token1
            String token1 = "";            
            // create Scanner inFile1
//            Scanner inFile1 = new Scanner(new File(fileName)).useDelimiter(",\\s*");
            Scanner inFile1 = new Scanner(new File(fileName)).useDelimiter("\n");
            List<String> temps = new LinkedList<String>();
            // while loop
            while (inFile1.hasNext()) {
              // find next line
              token1 = inFile1.next();
              temps.add(token1);
            }
            inFile1.close();

            String[] tempsArray = temps.toArray(new String[0]);
            
            data = Arrays.asList(tempsArray);
            
            // Read file line by line and print on the console
//            while ((line = bufferReader.readLine()) != null)   {
//            	full+=line+"\n";
//            	data = Arrays.asList(full);        	
//                    System.out.println(line);
//            }

            //Close the buffer reader
//            bufferReader.close();
            }catch(Exception e){
                    System.out.println("Error while reading file line by line:" 
                    + e.getMessage());                      
            }
        }

        /** {@inheritDoc} */
        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            for (String o : data) {
                b.append(o).append("\n");
            }
            return b.toString();
        }

        /** {@inheritDoc} */
        public String autoComplete(String startsWith) {
            // Naive implementation, but good enough for the sample
            String hit = null;
            for (String o : data) {
                if (o.startsWith(startsWith)) {
                    // CompletionService contract states that we only
                    // should return completion for unique hits.
                    if (hit == null) {
                        hit = o;
                    } else {
                        hit = null;
                        break;
                    }
                }
            }
            return hit;
        }

    }
}
