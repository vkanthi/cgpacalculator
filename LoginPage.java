package com.malaviji.fxcgpa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 * The type Login page.
 *
 * @author Mala and Renganayagi
 */
public class LoginPage extends JFrame {

  private final JTextField loginField = new JTextField(10);
  private final JButton loginButton = new JButton("Login");
  private final JButton cancelButton = new JButton("Cancel");
  private final JPasswordField passwordField = new JPasswordField(10);
  private final JLabel usernameLabel = new JLabel("Username");
  private final JLabel passwordLabel = new JLabel("Password");
  private final JPanel loginPanel = new JPanel(new BorderLayout());
  private Statement statement;
  private ResultSet resultSet;
  private Connection dbConnection;

  /** Below is the code where driver, database file located in resource Folder, statement are assigned */
  private void connectDB() {

    try {
      Class.forName("org.sqlite.JDBC");
      String db = "jdbc:sqlite::resource:GCPACalculator.db";
      Connection dbConnection = DriverManager.getConnection(db);
      statement = dbConnection.createStatement();
    } catch (Exception e) {

    }
  }

  private void close() {
    this.setVisible(false);
  }

  /** Instantiates of a new Login page. */
  LoginPage() {
    super("CGPA Calculator Login");
    connectDB();

    JPanel loginLabelPanel = new JPanel(new GridLayout(2, 1));
    loginLabelPanel.add(usernameLabel);
    loginLabelPanel.add(loginField);

    JPanel loginFieldPanel = new JPanel(new GridLayout(2, 1));
    loginLabelPanel.add(passwordLabel);
    loginLabelPanel.add(passwordField);

    JPanel loginTotalPanel = new JPanel();
    loginTotalPanel.add(loginLabelPanel);
    loginTotalPanel.add(loginFieldPanel);

    JPanel loginButtonPanel = new JPanel(new GridLayout(1, 1));
    loginButtonPanel.add(cancelButton);
    loginButtonPanel.add(loginButton);

    JPanel loginImagePanel = new JPanel(new GridLayout(1, 1));
    loginImagePanel.add(
        new JLabel(new ImageIcon(getClass().getClassLoader().getResource("FXCollegeLogo.png"))),
        BorderLayout.NORTH);

    loginPanel.add(loginButtonPanel, BorderLayout.CENTER);

    setLayout(new BorderLayout());
    add(loginImagePanel, BorderLayout.NORTH);
    add(loginTotalPanel, BorderLayout.CENTER);
    add(loginButtonPanel, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(300, 350);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);

    /** Action listener created below when Login button gets clicked */
    loginButton.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              String user = loginField.getText().trim();
              String sql =
                  "select username,password from LoginTable where username = '"
                      + user
                      + "'and password = '"
                      + String.valueOf(passwordField.getPassword())
                      + "'";
              resultSet = statement.executeQuery(sql);
              int count = 0;
              while (resultSet.next()) {
                count = count + 1;
              }
              if (count == 1) {
                close();
                CalculationScreen cgpaCalculationScreen = new CalculationScreen ();
                cgpaCalculationScreen.CalculationScreen();

              } else if (count > 1) {
                JOptionPane.showMessageDialog(null, "Duplicate user, Access Denied");
              } else {
                JOptionPane.showMessageDialog(null, "User does not exist");
              }
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });

    /** Action listener created below when cancel button gets clicked */
    cancelButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            setVisible(false);
            // LoginPage.dispose();
            System.exit(0);
          }
        });
  }
}
