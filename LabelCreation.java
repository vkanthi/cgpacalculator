package com.malaviji.fxcgpa;

import javax.swing.*;
import java.awt.*;

/** @author Mala and Renganaygi */

public class LabelCreation extends JLabel {

    Font font = new Font("Courier", Font.BOLD, 16);

    public LabelCreation(JLabel Name, String semesterSubjects) {
        new JLabel();
        setText ( semesterSubjects );
        setFont(font);

    }

}
