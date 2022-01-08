/**
 * User Interface Module
 * @author: Nikhil Hegde
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UserInterface  implements ActionListener {

    private JFrame frm;
    private JButton btn;
    private JLabel lbl;
    private JTextField fld;
    private GridLayout gl;
    private NumberGuess ng;
    
    public UserInterface(){
        
        // Initialize Number guess module
        ng = new NumberGuess();

        // Use Grid Layout with one column
        gl = new GridLayout(0,1);

        // App Header
        frm = new JFrame("Simple Number Guessing Game in Java");
        
        // App Label
        lbl = new JLabel("Number is between 0 and 100");

        // App Button
        btn = new JButton("Test");

        // App Input Box
        fld = new JTextField();

    }

    public void makeGUI(){
        
        // Use Grid layout
        frm.setLayout(null);

        // Frame Size
        frm.setSize(700,500);

        // Component Size
        // lbl.setSize(200,50);
        // btn.setSize(100,50);
        // fld.setSize(200, 70);

        lbl.setBounds(100, 100, 250 , 30);
        fld.setBounds(100, 150, 150, 30);
        btn.setBounds(100, 200, 150 , 30);
        
        frm.add(lbl);
        frm.add(fld);
        frm.add(btn);
        frm.setResizable(false);

        btn.addActionListener(this);
        frm.setVisible(true);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        int number;

        try
        {
        // Get the number from input box
        number = Integer.parseInt(fld.getText());
        // Compare the number with generated number
        Result rs = ng.testNumber(number);

        // Shown the output result
        lbl.setBounds(150, 100, 250 , 30);
        lbl.setText(rs.response);

        if(rs.status == true){

            // Remove input box and button on correct input
            frm.remove(btn);
            frm.remove(fld);
            frm.repaint();

            // Display number correct label
            var lbl1 = new JLabel("Now You can close the window!!!");
            lbl1.setBounds(150, 150, 400, 50);
            frm.add(lbl1);
        }        
        
        }
        catch(Exception exception){
            lbl.setBounds(150, 100, 400 , 30);
            lbl.setText("Exception Occurred!! "+ exception.toString());
            
        }



        
    }
}
