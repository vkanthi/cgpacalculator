package com.malaviji.fxcgpa;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Mala and Renganayagi
 */
public class ButtonCreation extends JButton {
    Font cgpaFont = new Font("Courier", Font.BOLD, 36);
    Border myRaisedBorder = (BorderFactory.createBevelBorder( BevelBorder.RAISED, Color.PINK, Color.RED));
    ButtonCreation (String text){
        new JButton ( );
        setText ( text );
        setFont ( cgpaFont );
        setPreferredSize(new Dimension(10, 10));
        setForeground(Color.GREEN);
        setBackground(Color.DARK_GRAY);
        setOpaque(true);
        setBorder(myRaisedBorder);

    }
    ButtonCreation (String text, Font font){
        new JButton ();
        setText ( text );
        setFont ( font );
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        setOpaque(true);
        setBorder(myRaisedBorder);

    }

    ButtonCreation (String text, Font font, String Name){
        new JButton ();
        setText ( text );
        setFont ( font );
        setName (Name);
        setForeground(Color.WHITE);
        setBackground(Color.BLUE);
        setOpaque(true);
        setBorder(myRaisedBorder);

    }
}
