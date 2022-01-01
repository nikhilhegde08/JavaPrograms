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
        frm = new JFrame("---Number Guessing Game---");
        
        // App Label
        lbl = new JLabel("Number is between 0 and 100");

        // App Button
        btn = new JButton("Test");

        // App Input Box
        fld = new JTextField();

    }

    public void makeGUI(){
        
        // Use Grid layout
        frm.setLayout(gl);

        // Frame Size
        frm.setSize(700,500);

        // Component Size
        lbl.setSize(200,50);
        btn.setSize(100,50);
        fld.setSize(200, 70);

        
        frm.add(lbl);
        frm.add(fld);
        frm.add(btn);

        btn.addActionListener(this);
        frm.setVisible(true);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Get the number from input box
        int number = Integer.parseInt(fld.getText());

        // Compare the number with generated number
        Result rs = ng.testNumber(number);

        // Shown the output result
        lbl.setText(rs.response);

        if(rs.status == true){

            // Remove input box and button on correct input
            frm.remove(btn);
            frm.remove(fld);

            // Display number correct label
            var lbl1 = new JLabel("Now You can close the window!!!");
            lbl1.setBounds(30, 110, 400, 50);
            frm.add(lbl1);
        }
        
    }
}
