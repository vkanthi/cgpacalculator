package com.malaviji.fxcgpa;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



/**
 *
 * @author Mala and Renganayagi
 */
public class CalculationScreen extends JFrame {

    //Creating String arrays used for populating into Panel Labels, pull down menus
    String[] letterGrades = {"Select a Grade", "O", "A+", "A", "B+", "B", "RA"};

    //Creating String arrays used for populating Names for all the 8 tabs.
    String[] semesterNames = {"SEM01", "SEM02", "SEM03", "SEM04", "SEM05", "SEM06", "SEM07", "SEM08"};


    //Creating String arrays used subjects that can be used to create subject labels
    String[] sem01Subjects = {"ENGLISH FOR PROFESSIONAL COMMUNICATION", "MATRICES AND CALCULUS", "PHYSICS FOR INFORMATION SCIENCE", "CHEMISTRY FOR INFORMATION SCIENCE", "PYTHON PROGRAMMING", "ENGINEERING GRAPHICS", "PHYSICS AND CHEMISTRY LABORATORY", "PYTHON PROGRAMMING LABORATORY"};
    String[] sem02Subjects = {"TECHNICAL COMMUNICATION", "VECTOR CALCULUS AND TRANSFORMS", "BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING", "C PROGRAMMING", "ELECTRICAL AND ELECTRONICS LABORATORY", "C PROGRAMMING LABORATORY", "COMPUTER HARDWARE AND SOFTWARE TOOLS (computer workshop)", "FUNDAMENTALS OF COMPUTATIONAL BIOLOGY"};
    String[] sem03Subjects = {"PROBABILITY AND QUEUEING THEORY", "DIGITAL SYSTEMS", "DATA STRUCTURES", "SOFTWARE ENGINEERING", "OBJECT ORIENTED PROGRAMMING SYSTEMS", "DATA STRUCTURES LABORATORY", "OBJECT ORIENTED PROGRAMMING SYSTEMS LABORATORY", "COMMUNICATION AND SOFT SKILLS"};
    String[] sem04Subjects = {"DISCRETE MATHEMATICS", "DATABASE MANAGEMENT SYSTEMS", "OPERATING SYSTEM CONCEPTS", "DESIGN AND ANALYSIS OF ALGORITHMS", "COMPUTER ARCHITECTURE", "MICRO PROCESSORS AND MICRO CONTROLLERS", "DATABASE MANAGEMENT SYSTEMS LABORATORY", "INTERPERSONAL SKILLS-LISTENING AND SPEAKING", "ENVIRONMENTAL SCIENCE AND ENGINEERING"};
    String[] sem05Subjects = {"THEORY OF COMPUTATION", "COMPUTER NETWORKS", "ELECTIVE I", "ELECTIVE II", "OPEN ELECTIVE-I", "SYSTEM ANALYSIS AND DESIGN LABORATORY", "COMPUTER NETWORKS LABORATORY", "LIFE SKILLS : APTITUDE"};
    String[] sem06Subjects = {"COMPILER DESIGN", "CRYPTOGRAPHY AND NETWORK SECURITY", "ARTIFICIAL INTELLIGENCE AND MACHINE LEARNING", "ELECTIVE III", "ELECTIVE IV", "OPEN ELECTIVE - II", "MOBILE APPLICATION DEVELOPMENT LABORATORY", "MINI PROJECT", "LIFE SKILLS : COMPETITIVE EXAMS"};
    String[] sem07Subjects = {"PROFESSIONAL ETHICS FOR ENGINEERS", "GRAPHICS AND MULTIMEDIA", "SOFTWARE AND PROJECT MANAGEMENT", "ELECTIVE V", "ELECTIVE VI", "OPEN ELECTIVE - III", "GRAPHICS AND MULTIMEDIA LABORATORY", "TECHNICAL SEMINAR"};
    String[] sem08Subjects = {"ELECTIVE VII", "ELECTIVE VIII", "OPEN ELECTIVE - IV", "PROJECT WORK","DUMMY SUBJECT I", "DUMMY SUBJECT II", "DUMMY SUBJECT III", "DUMMY SUBJECT IV"};

    //Creating a Hashmap to store letterGradesMap and results into it.
    private HashMap<String, Double> letterGradeMap = new HashMap<>();
    HashMap<String, HashMap<String, Double>> perSemesterSubjectCredits = new HashMap<>();
    HashMap<String, HashMap<String, Double>> resultsCGPA = new HashMap<>();
    HashMap<String, Double> creditsMap = new HashMap<>();

  public void CalculationScreen() {

    // Populating HashMap with String and Value Array for grades
    letterGradeMap.put("Select a Grade", 0.001);
    letterGradeMap.put("O", 10.0);
    letterGradeMap.put("A+", 9.0);
    letterGradeMap.put("A", 8.0);
    letterGradeMap.put("B+", 7.0);
    letterGradeMap.put("B", 6.0);
    letterGradeMap.put("RA", 0.0);

    HashMap<String, Double> sem1Map = new HashMap<>();
    sem1Map.put("ENGLISH FOR PROFESSIONAL COMMUNICATION", 3.0);
    sem1Map.put("MATRICES AND CALCULUS", 4.0);
    sem1Map.put("PHYSICS FOR INFORMATION SCIENCE", 3.0);
    sem1Map.put("CHEMISTRY FOR INFORMATION SCIENCE", 3.0);
    sem1Map.put("PYTHON PROGRAMMING", 3.0);
    sem1Map.put("ENGINEERING GRAPHICS", 3.0);
    sem1Map.put("PHYSICS AND CHEMISTRY LABORATORY", 2.0);
    sem1Map.put("PYTHON PROGRAMMING LABORATORY", 2.0);
    perSemesterSubjectCredits.put("SEM01", sem1Map);

    HashMap<String, Double> sem2Map = new HashMap<>();
    sem2Map.put("TECHNICAL COMMUNICATION", 2.0);
    sem2Map.put("VECTOR CALCULUS AND TRANSFORMS", 4.0);
    sem2Map.put("BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING", 3.0);
    sem2Map.put("C PROGRAMMING", 3.0);
    sem2Map.put("ELECTRICAL AND ELECTRONICS LABORATORY", 2.0);
    sem2Map.put("C PROGRAMMING LABORATORY", 2.0);
    sem2Map.put("COMPUTER HARDWARE AND SOFTWARE TOOLS (computer workshop)", 2.0);
    sem2Map.put("FUNDAMENTALS OF COMPUTATIONAL BIOLOGY", 0.0);
    perSemesterSubjectCredits.put("SEM02", sem2Map);

    HashMap<String, Double> sem3Map = new HashMap<>();
    sem3Map.put("PROBABILITY AND QUEUEING THEORY", 4.0);
    sem3Map.put("DIGITAL SYSTEMS", 3.0);
    sem3Map.put("DATA STRUCTURES", 3.0);
    sem3Map.put("SOFTWARE ENGINEERING", 3.0);
    sem3Map.put("OBJECT ORIENTED PROGRAMMING SYSTEMS", 3.0);
    sem3Map.put("DATA STRUCTURES LABORATORY", 2.0);
    sem3Map.put("OBJECT ORIENTED PROGRAMMING SYSTEMS LABORATORY", 2.0);
    sem3Map.put("COMMUNICATION AND SOFT SKILLS", 0.0);
    perSemesterSubjectCredits.put("SEM03", sem3Map);

    HashMap<String, Double> sem4Map = new HashMap<>();
    sem4Map.put("DISCRETE MATHEMATICS", 4.0);
    sem4Map.put("DATABASE MANAGEMENT SYSTEMS", 3.0);
    sem4Map.put("OPERATING SYSTEM CONCEPTS", 3.0);
    sem4Map.put("DESIGN AND ANALYSIS OF ALGORITHMS", 3.0);
    sem4Map.put("COMPUTER ARCHITECTURE", 3.0);
    sem4Map.put("MICRO PROCESSORS AND MICRO CONTROLLERS", 3.0);
    sem4Map.put("DATABASE MANAGEMENT SYSTEMS LABORATORY", 2.0);
    sem4Map.put("INTERPERSONAL SKILLS-LISTENING AND SPEAKING", 2.0);
    sem4Map.put("ENVIRONMENTAL SCIENCE AND ENGINEERING", 0.0);
    perSemesterSubjectCredits.put("SEM04", sem4Map);

    HashMap<String, Double> sem5Map = new HashMap<>();
    sem5Map.put("THEORY OF COMPUTATION", 3.0);
    sem5Map.put("COMPUTER NETWORKS", 3.0);
    sem5Map.put("ELECTIVE I", 3.0);
    sem5Map.put("ELECTIVE II", 3.0);
    sem5Map.put("OPEN ELECTIVE-I", 3.0);
    sem5Map.put("SYSTEM ANALYSIS AND DESIGN LABORATORY", 2.0);
    sem5Map.put("COMPUTER NETWORKS LABORATORY", 2.0);
    sem5Map.put("LIFE SKILLS : APTITUDE", 0.0);
    perSemesterSubjectCredits.put("SEM05", sem5Map);

    HashMap<String, Double> sem6Map = new HashMap<>();
    sem6Map.put("COMPILER DESIGN", 3.0);
    sem6Map.put("CRYPTOGRAPHY AND NETWORK SECURITY", 3.0);
    sem6Map.put("ARTIFICIAL INTELLIGENCE AND MACHINE LEARNING", 3.0);
    sem6Map.put("ELECTIVE III", 3.0);
    sem6Map.put("ELECTIVE IV", 3.0);
    sem6Map.put("OPEN ELECTIVE - II", 3.0);
    sem6Map.put("MOBILE APPLICATION DEVELOPMENT LABORATORY", 2.0);
    sem6Map.put("MINI PROJECT", 2.0);
    sem6Map.put("LIFE SKILLS : COMPETITIVE EXAMS", 0.0);
    perSemesterSubjectCredits.put("SEM06", sem6Map);

    HashMap<String, Double> sem7Map = new HashMap<>();
    sem7Map.put("PROFESSIONAL ETHICS FOR ENGINEERS", 3.0);
    sem7Map.put("GRAPHICS AND MULTIMEDIA", 3.0);
    sem7Map.put("SOFTWARE AND PROJECT MANAGEMENT", 3.0);
    sem7Map.put("ELECTIVE V", 3.0);
    sem7Map.put("ELECTIVE VI", 3.0);
    sem7Map.put("OPEN ELECTIVE - III", 3.0);
    sem7Map.put("GRAPHICS AND MULTIMEDIA LABORATORY", 2.0);
    sem7Map.put("TECHNICAL SEMINAR", 1.0);
    perSemesterSubjectCredits.put("SEM07", sem7Map);

    HashMap<String, Double> sem8Map = new HashMap<>();
    sem8Map.put("ELECTIVE VII", 3.0);
    sem8Map.put("ELECTIVE VIII", 3.0);
    sem8Map.put("OPEN ELECTIVE - IV", 3.0);
    sem8Map.put("PROJECT WORK", 10.0);
    perSemesterSubjectCredits.put("SEM08", sem8Map);

    Font font = new Font("Courier", Font.BOLD, 16);

      // Creating calculate GPA and CGPA buttons for all tabs.
      JButton[] calculateGPA = new JButton[8];
      JButton[] calculateCGPA = new JButton[8];
      JButton[] Reset8GPA = new JButton[6];
      JButton[] Reset9GPA = new JButton[2];
      JButton[] closeProgram = new JButton[8];
      Border myRaisedBorder = (BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.RED));
      for (int m = 0; m < 8; m++) {
          calculateGPA[m] = new JButton("Calculate GPA");
          calculateGPA[m].setFont(font);
          calculateGPA[m].setForeground(Color.WHITE);
          calculateGPA[m].setBackground(Color.BLUE);
          calculateGPA[m].setOpaque(true);
          calculateGPA[m].setBorder(myRaisedBorder);

          calculateCGPA[m] = new JButton("Calculate CGPA");
          calculateCGPA[m].setFont(font);
          calculateCGPA[m].setForeground(Color.GREEN);
          calculateCGPA[m].setBackground(Color.DARK_GRAY);
          calculateCGPA[m].setOpaque(true);
          calculateCGPA[m].setBorder(myRaisedBorder);



          closeProgram[m] = new JButton("Close CGPA Calculator");
          closeProgram[m].setFont(font);
          closeProgram[m].setForeground(Color.BLUE);
          closeProgram[m].setBackground(Color.YELLOW);
          closeProgram[m].setOpaque(true);
          closeProgram[m].setBorder(myRaisedBorder);
      }
    for (int m = 0; m < 6; m++) {
      Reset8GPA[m] = new JButton("Reset Grade Points");
      Reset8GPA[m].setFont(font);
      Reset8GPA[m].setForeground(Color.BLUE);
      Reset8GPA[m].setBackground(Color.YELLOW);
      Reset8GPA[m].setOpaque(true);
      Reset8GPA[m].setBorder(myRaisedBorder);
    }
    for (int m = 0; m < 2; m++) {
      Reset9GPA[m] = new JButton("Reset Grade Points");
      Reset9GPA[m].setFont(font);
      Reset9GPA[m].setForeground(Color.BLUE);
      Reset9GPA[m].setBackground(Color.YELLOW);
      Reset9GPA[m].setOpaque(true);
      Reset9GPA[m].setBorder(myRaisedBorder);
    }
    JButton Reset8thSemesterGPA = new JButton("Reset Grade Points");
    Reset8thSemesterGPA.setFont(font);
    Reset8thSemesterGPA.setForeground(Color.BLUE);
    Reset8thSemesterGPA.setBackground(Color.YELLOW);
    Reset8thSemesterGPA.setOpaque(true);
    Reset8thSemesterGPA.setBorder(myRaisedBorder);

    // creating comboBox arrays and populating letterGrades into it
    JComboBox[] sem01cb = new JComboBox[sem1Map.size()];
    JComboBox[] sem02cb = new JComboBox[sem2Map.size()];
    JComboBox[] sem03cb = new JComboBox[sem3Map.size()];
    JComboBox[] sem04cb = new JComboBox[sem4Map.size()];
    JComboBox[] sem05cb = new JComboBox[sem5Map.size()];
    JComboBox[] sem06cb = new JComboBox[sem6Map.size()];
    JComboBox[] sem07cb = new JComboBox[sem7Map.size()];
    JComboBox[] sem08cb = new JComboBox[sem8Map.size()];

    // Creating Array list for ComboBox
    ArrayList<JComboBox[]> allSemesters8 = new ArrayList<>();
    allSemesters8.add(sem01cb);
    allSemesters8.add(sem02cb);
    allSemesters8.add(sem03cb);
    allSemesters8.add(sem05cb);
    allSemesters8.add(sem07cb);
    ArrayList<JComboBox[]> allSemesters9 = new ArrayList<>();
    allSemesters9.add(sem04cb);
    allSemesters9.add(sem06cb);
    ArrayList<JComboBox[]> semester8 = new ArrayList<>();
    semester8.add(sem08cb);

    ArrayList<JComboBox[]> all8Semesters = new ArrayList<>();
    all8Semesters.add(sem01cb);
    all8Semesters.add(sem02cb);
    all8Semesters.add(sem03cb);
    all8Semesters.add(sem05cb);
    all8Semesters.add(sem07cb);

    ArrayList<JComboBox[]> all9Semesters = new ArrayList<>();
    all9Semesters.add(sem04cb);
    all9Semesters.add(sem06cb);
    ArrayList<JComboBox[]> Semesters8 = new ArrayList<>();
    Semesters8.add(sem08cb);

    JLabel[] sem01PaperLabel = new JLabel[8];
    JLabel[] sem02PaperLabel = new JLabel[8];
    JLabel[] sem03PaperLabel = new JLabel[8];
    JLabel[] sem04PaperLabel = new JLabel[9];
    JLabel[] sem05PaperLabel = new JLabel[8];
    JLabel[] sem06PaperLabel = new JLabel[9];
    JLabel[] sem07PaperLabel = new JLabel[8];
    JLabel[] sem08PaperLabel = new JLabel[4];

    JPanel sem01 = new JPanel();
    GridLayout sem01Layout = new GridLayout(10, 3);
    sem01.setLayout(sem01Layout);
    sem01.setName(semesterNames[0]);

    JPanel sem02 = new JPanel();
    GridLayout sem02Layout = new GridLayout(10, 3);
    sem02.setLayout(sem02Layout);
    sem02.setName(semesterNames[1]);

    JPanel sem03 = new JPanel();
    GridLayout sem03Layout = new GridLayout(10, 3);
    sem03.setLayout(sem03Layout);
    sem03.setName(semesterNames[2]);

    JPanel sem04 = new JPanel();
    GridLayout sem04Layout = new GridLayout(11, 3);
    sem04.setLayout(sem04Layout);
    sem04.setName(semesterNames[3]);

    JPanel sem05 = new JPanel();
    GridLayout sem05Layout = new GridLayout(10, 3);
    sem05.setLayout(sem05Layout);
    sem05.setName(semesterNames[4]);

    JPanel sem06 = new JPanel();
    GridLayout sem06Layout = new GridLayout(11, 3);
    sem06.setLayout(sem06Layout);
    sem06.setName(semesterNames[5]);

    JPanel sem07 = new JPanel();
    GridLayout sem07Layout = new GridLayout(10, 3);
    sem07.setLayout(sem07Layout);
    sem07.setName(semesterNames[6]);

    JPanel sem08 = new JPanel();
    GridLayout sem08Layout = new GridLayout(10, 3);
    sem08.setLayout(sem08Layout);
    sem08.setName(semesterNames[7]);

    for (int i = 0; i < sem1Map.size(); i++) {
      sem01cb[i] = new JComboBox(letterGrades);
      sem01cb[i].setName(sem01Subjects[i]);
      sem01cb[i].setFont(font);
      sem01PaperLabel[i] = new JLabel(sem01Subjects[i]);
      sem01PaperLabel[i].setFont(font);
      sem01.add(sem01PaperLabel[i]);
      sem01.add(sem01cb[i]);

    }
    sem01.add(calculateGPA[0]);
    sem01.add(calculateCGPA[0]);
    sem01.add(Reset8GPA[0]);
    sem01.add(closeProgram[0]);

    for (int i = 0; i < sem2Map.size(); i++) {
      sem02cb[i] = new JComboBox(letterGrades);
      sem02cb[i].setName(sem02Subjects[i]);
      sem02cb[i].setFont(font);
      sem02PaperLabel[i] = new JLabel(sem02Subjects[i]);
      sem02PaperLabel[i].setFont(font);
      sem02.add(sem02PaperLabel[i]);
      sem02.add(sem02cb[i]);
    }
    sem02.add(calculateGPA[1]);
    sem02.add(calculateCGPA[1]);
    sem02.add(Reset8GPA[1]);
    sem02.add(closeProgram[1]);


    for (int i = 0; i < sem3Map.size(); i++) {
      sem03cb[i] = new JComboBox(letterGrades);
      sem03cb[i].setName(sem03Subjects[i]);
      sem03cb[i].setFont(font);
      sem03PaperLabel[i] = new JLabel(sem03Subjects[i]);
      sem03PaperLabel[i].setFont(font);
      sem03.add(sem03PaperLabel[i]);
      sem03.add(sem03cb[i]);
    }
    sem03.add(calculateGPA[2]);
    sem03.add(calculateCGPA[2]);
    sem03.add(Reset8GPA[2]);
    sem03.add(closeProgram[2]);


    for (int i = 0; i < sem4Map.size(); i++) {
      sem04cb[i] = new JComboBox(letterGrades);
      sem04cb[i].setName(sem04Subjects[i]);
      sem04cb[i].setFont(font);
      sem04PaperLabel[i] = new JLabel(sem04Subjects[i]);
      sem04PaperLabel[i].setFont(font);
      sem04.add(sem04PaperLabel[i]);
      sem04.add(sem04cb[i]);
    }
    sem04.add(calculateGPA[3]);
    sem04.add(calculateCGPA[3]);
    sem04.add(Reset9GPA[0]);
    sem04.add(closeProgram[3]);


    for (int i = 0; i < sem5Map.size(); i++) {
      sem05cb[i] = new JComboBox(letterGrades);
      sem05cb[i].setName(sem05Subjects[i]);
      sem05cb[i].setFont(font);
      sem05PaperLabel[i] = new JLabel(sem05Subjects[i]);
      sem05PaperLabel[i].setFont(font);
      sem05.add(sem05PaperLabel[i]);
      sem05.add(sem05cb[i]);
    }
    sem05.add(calculateGPA[4]);
    sem05.add(calculateCGPA[4]);
    sem05.add(Reset8GPA[3]);
    sem05.add(closeProgram[4]);


    for (int i = 0; i < sem6Map.size(); i++) {
      sem06cb[i] = new JComboBox(letterGrades);
      sem06cb[i].setName(sem06Subjects[i]);
      sem06cb[i].setFont(font);
      sem06PaperLabel[i] = new JLabel(sem06Subjects[i]);
      sem06PaperLabel[i].setFont(font);
      sem06.add(sem06PaperLabel[i]);
      sem06.add(sem06cb[i]);
    }
    sem06.add(calculateGPA[5]);
    sem06.add(calculateCGPA[5]);
    sem06.add(Reset9GPA[1]);
    sem06.add(closeProgram[5]);


    for (int i = 0; i < sem7Map.size(); i++) {
      sem07cb[i] = new JComboBox(letterGrades);
      sem07cb[i].setName(sem07Subjects[i]);
      sem07cb[i].setFont(font);
      sem07PaperLabel[i] = new JLabel(sem07Subjects[i]);
      sem07PaperLabel[i].setFont(font);
      sem07.add(sem07PaperLabel[i]);
      sem07.add(sem07cb[i]);
    }
    sem07.add(calculateGPA[6]);
    sem07.add(calculateCGPA[6]);
    sem07.add(Reset8GPA[4]);
    sem07.add(closeProgram[6]);


    for (int i = 0; i < sem8Map.size(); i++) {
      sem08cb[i] = new JComboBox(letterGrades);
      sem08cb[i].setName(sem08Subjects[i]);
      sem08cb[i].setFont(font);
      sem08PaperLabel[i] = new JLabel(sem08Subjects[i]);
      sem08PaperLabel[i].setFont(font);
      sem08.add(sem08PaperLabel[i]);
      sem08.add(sem08cb[i]);
    }
    sem08.add(calculateGPA[7]);
    sem08.add(calculateCGPA[7]);
    sem08.add(Reset8thSemesterGPA);
    sem08.add(closeProgram[7]);

    // Creating an array of CGPA and GPA Buttons.
    ArrayList<JButton[]> allSemestersGPAButton = new ArrayList<>();
    allSemestersGPAButton.add(calculateGPA);
    ArrayList<JButton[]> allSemestersCGPAButton = new ArrayList<>();
    allSemestersCGPAButton.add(calculateCGPA);
    ArrayList<JButton[]> allSemesters8GPAResetButton = new ArrayList<>();
    allSemesters8GPAResetButton.add(Reset8GPA);
    ArrayList<JButton[]> allSemesters9GPAResetButton = new ArrayList<>();
    allSemesters9GPAResetButton.add(Reset9GPA);
    ArrayList<JButton[]> allSemestersCloseButton = new ArrayList<>();
    allSemestersCloseButton.add(closeProgram);

    // Creating ArrayList for all the semester panels.
    ArrayList<JPanel> allSemesterPanels = new ArrayList<>();
    allSemesterPanels.add(sem01);
    allSemesterPanels.add(sem02);
    allSemesterPanels.add(sem03);
    allSemesterPanels.add(sem04);
    allSemesterPanels.add(sem05);
    allSemesterPanels.add(sem06);
    allSemesterPanels.add(sem07);
    allSemesterPanels.add(sem08);

    // Creating an Action Listener for all the pull down menus.
    for (JComboBox[] sem : allSemesters8) {
      for (int i = 0; i < 8; i++) {
        sem[i].addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {

                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String gradeSelection = (String) combo.getSelectedItem();
                String semesterName = combo.getParent().getName();
                String subjectName = combo.getName();
                Double intGrade = letterGradeMap.get(gradeSelection);
                HashMap<String, Double> semGrades =
                    resultsCGPA.getOrDefault(semesterName, new HashMap<>());
                semGrades.put(subjectName, intGrade);
                resultsCGPA.putIfAbsent(semesterName, semGrades);
              }
            });
      }
    }
    for (JComboBox[] sem : allSemesters9) {
      for (int i = 0; i < 9; i++) {
        sem[i].addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {

                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String gradeSelection = (String) combo.getSelectedItem();
                String semesterName = combo.getParent().getName();
                String subjectName = combo.getName();
                Double intGrade = letterGradeMap.get(gradeSelection);
                HashMap<String, Double> semGrades =
                    resultsCGPA.getOrDefault(semesterName, new HashMap<>());
                semGrades.put(subjectName, intGrade);
                resultsCGPA.putIfAbsent(semesterName, semGrades);
              }
            });
      }
    }
    for (JComboBox[] sem : semester8) {
      for (int i = 0; i < 4; i++) {
        sem[i].addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {

                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String gradeSelection = (String) combo.getSelectedItem();
                String semesterName = combo.getParent().getName();
                String subjectName = combo.getName();
                Double intGrade = letterGradeMap.get(gradeSelection);
                HashMap<String, Double> semGrades =
                    resultsCGPA.getOrDefault(semesterName, new HashMap<>());
                semGrades.put(subjectName, intGrade);
                resultsCGPA.putIfAbsent(semesterName, semGrades);
              }
            });
      }
    }

    // Creating an Action Listener for GPA Button.
    for (JButton[] cgp : allSemestersGPAButton) {
      for (int i = 0; i <= 7; i++) {
        cgp[i].addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {

                JButton currentButton = (JButton) event.getSource();
                String semesterName = currentButton.getParent().getName();
                HashMap<String, Double> semGrades = resultsCGPA.get(semesterName);
                // semGrades.values().forEach(semesterSubjectsGradeMap.get(sem01Subjects));
                HashMap<String, Double> semGradesMax = perSemesterSubjectCredits.get(semesterName);
                Double sumOfGrades = 0d;
                for (Map.Entry<String, Double> entry : semGrades.entrySet()) {
                  sumOfGrades += semGradesMax.get(entry.getKey()) * entry.getValue();
                }

                Double maxCreditsForSem = semGradesMax.values().stream().reduce(0d, Double::sum);
                Double gpa = sumOfGrades / maxCreditsForSem;
                long roundedInt = Math.round(gpa * 100);
                double result = (double) roundedInt / 100;
                currentButton.setText(
                    "(Click to Calculate again) Your GPA for this semester ="
                        + String.valueOf(result));
              }
            });
      }
    }

    // Creating an Action Listener for CGPA Button.
    for (JButton[] cgpa : allSemestersCGPAButton) {
      for (int i = 0; i <= 7; i++) {
        cgpa[i].addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {

                JButton currentButton = (JButton) event.getSource();
                Double sumOfGradesReceived = 0d;
                Double totalCredits = 0d;
                for (String semCompleted : resultsCGPA.keySet()) {
                  HashMap<String, Double> semGrades = resultsCGPA.get(semCompleted);

                  HashMap<String, Double> semGradesMax =
                      perSemesterSubjectCredits.get(semCompleted);

                  totalCredits += semGradesMax.values().stream().reduce(0d, Double::sum);
                  for (Map.Entry<String, Double> entry : semGrades.entrySet()) {
                    sumOfGradesReceived += semGradesMax.get(entry.getKey()) * entry.getValue();
                  }
                }

                Double cgpa = sumOfGradesReceived / totalCredits;
                long roundedInt = Math.round(cgpa * 100);
                double result = (double) roundedInt / 100;
                currentButton.setText(
                    "(Click to Calculate again)Your CGPA for this semester ="
                        + String.valueOf(result));
              }
            });
      }
    }
    // System.out.println(perSemesterSubjectCredits.keySet ().size ());

    // Creating an Action Listener for Reset GPA Button.
    for (JButton[] reset8all : allSemesters8GPAResetButton) {
      for (int i=0; i<6; i++) {
        {
          reset8all[i].addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  for (JComboBox[] sem : all8Semesters) {
                    for (int i = 0; i <=7; i++) {
                      sem[i].setSelectedIndex(0);
                      resultsCGPA.clear();
                      for (JButton[] cgp : allSemestersGPAButton) {
                        for (int l = 0; l <= 7; l++) {
                          cgp[l].setText("Calculate GPA");
                        }
                        for (JButton[] ccgp : allSemestersCGPAButton) {
                          for (int m = 0; m <= 7; m++) {
                            ccgp[m].setText("Calculate CGPA");
                          }
                        }
                      }
                    }
                  }
                }
              });
        }
      }
      for (JButton[] reset9all : allSemesters9GPAResetButton) {
        for (int i=0; i<2; i++) {

          reset9all[i].addActionListener(
                  new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                      for (JComboBox[] sem : all9Semesters) {
                        for (int i = 0; i < 9; i++) {
                          sem[i].setSelectedIndex(0);
                          resultsCGPA.clear();
                          for (JButton[] cgp : allSemestersGPAButton) {
                            for (int l = 0; l <8; l++) {
                              cgp[l].setText("Calculate GPA");
                            }
                            for (JButton[] ccgp : allSemestersCGPAButton) {
                              for (int m = 0; m <8; m++) {
                                ccgp[m].setText("Calculate CGPA");
                              }
                            }
                          }
                        }
                      }
                    }
                  });
        }
      }
      Reset8thSemesterGPA.addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  for (JComboBox[] sem : Semesters8) {
                    for (int i = 0; i < 4; i++) {
                      sem[i].setSelectedIndex(0);
                      resultsCGPA.clear();
                      for (JButton[] cgp : allSemestersGPAButton) {
                        for (int l = 0; l <8; l++) {
                          cgp[l].setText("Calculate GPA");
                        }
                        for (JButton[] ccgp : allSemestersCGPAButton) {
                          for (int m = 0; m <8; m++) {
                            ccgp[m].setText("Calculate CGPA");
                          }
                        }
                      }
                    }
                  }
                }
              });






      // Creating an Action Listener for Close Button.
      for (JButton[] close : allSemestersCloseButton) {
        for (int i = 0; i <= 7; i++) {
          close[i].addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  System.exit(0);
                }
              });
        }
      }

      JTabbedPane semesterPane =
          new JTabbedPane(JTabbedPane.TOP) {
            {
              addTab(semesterNames[0], null, sem01, null);
              addTab(semesterNames[1], null, sem02, null);
              addTab(semesterNames[2], null, sem03, null);
              addTab(semesterNames[3], null, sem04, null);
              addTab(semesterNames[4], null, sem05, null);
              addTab(semesterNames[5], null, sem06, null);
              addTab(semesterNames[6], null, sem07, null);
              addTab(semesterNames[7], null, sem08, null);
              setBounds(0, 0, 517, 291);
              setBackground(Color.YELLOW);
            }
          };
      getContentPane().add(semesterPane);
      setSize(1700, 500);
      setTitle("CGPA Calculation Screen");
      setLocationRelativeTo(null);
      // pack ();
      setResizable(true);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        }
}


