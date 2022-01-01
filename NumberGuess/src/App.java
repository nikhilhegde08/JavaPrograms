/**
 * Application Driver
 * @author: Nikhil Hegde
 */

import javax.swing.*;

public class App implements Runnable {
    
    
    public static void main(String[] args) throws Exception {
        
        //Constructing GUI on dispatcher thread
        SwingUtilities.invokeLater(new App());
    }

    //Run Method to Construct the GUI
    @Override
    public void run(){
        var ui = new UserInterface();
        ui.makeGUI();
    }
}
