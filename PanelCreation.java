package com.malaviji.fxcgpa;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mala and Renganayagi
 */
public class PanelCreation extends JPanel {

    PanelCreation ( int rows, int cols, String SemesterName){
        new JPanel();
        setLayout ( new GridLayout (rows, cols) );
        setName ( SemesterName );

    }


}
