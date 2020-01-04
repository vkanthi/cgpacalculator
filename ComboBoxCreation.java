package com.malaviji.fxcgpa;

import javax.swing.*;
import java.awt.*;

/** @author Mala and Renganaygi */
public class ComboBoxCreation extends JComboBox {

  ComboBoxCreation(JComboBox name, String semesterSubjects) {

    new JComboBox();
    insertItemAt("Select a Grade", 0);
    insertItemAt("O", 1);
    insertItemAt("A+", 2);
    insertItemAt("A", 3);
    insertItemAt("A", 4);
    insertItemAt("B+", 5);
    insertItemAt("B", 6);
    insertItemAt("RA", 7);
    setSelectedIndex(0);
    setName(semesterSubjects);


  }
}




