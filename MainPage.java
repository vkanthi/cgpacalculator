package com.malaviji.fxcgpa;
import javax.swing.SwingUtilities;

/**
 * The Main page to enter into CGPA Calculator.
 * @author Mala and Renganayagi
 */
public class MainPage {

    /**
     * The entry point of application.
     */
public static void main(String[] args) {
    
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage();
            }
        });
    }
}
