package com.malaviji.fxcgpa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/** @author Mala and Renganayagi */
public class CalculationScreen extends JFrame {

  /** Creating String arrays used for populating Names for all the 8 tabs. */
  String[] tabNamePanelName = {
    "SEM01", "SEM02", "SEM03", "SEM04", "SEM05", "SEM06", "SEM07", "SEM08", "GPA"
  };

  /** Creating String arrays used subjects that can be used to create subject labels */
  private String[] sem01Subjects = {
    "ENGLISH FOR PROFESSIONAL COMMUNICATION",
    "MATRICES AND CALCULUS",
    "PHYSICS FOR INFORMATION SCIENCE",
    "CHEMISTRY FOR INFORMATION SCIENCE",
    "PYTHON PROGRAMMING",
    "ENGINEERING GRAPHICS",
    "PHYSICS AND CHEMISTRY LABORATORY",
    "PYTHON PROGRAMMING LABORATORY"
  };

  private String[] sem02Subjects = {
    "TECHNICAL COMMUNICATION",
    "VECTOR CALCULUS AND TRANSFORMS",
    "BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING",
    "C PROGRAMMING",
    "ELECTRICAL AND ELECTRONICS LABORATORY",
    "C PROGRAMMING LABORATORY",
    "COMPUTER HARDWARE AND SOFTWARE TOOLS (computer workshop)",
    "FUNDAMENTALS OF COMPUTATIONAL BIOLOGY"
  };
  private String[] sem03Subjects = {
    "PROBABILITY AND QUEUEING THEORY",
    "DIGITAL SYSTEMS",
    "DATA STRUCTURES",
    "SOFTWARE ENGINEERING",
    "OBJECT ORIENTED PROGRAMMING SYSTEMS",
    "DATA STRUCTURES LABORATORY",
    "OBJECT ORIENTED PROGRAMMING SYSTEMS LABORATORY",
    "COMMUNICATION AND SOFT SKILLS"
  };
  private String[] sem04Subjects = {
    "DISCRETE MATHEMATICS",
    "DATABASE MANAGEMENT SYSTEMS",
    "OPERATING SYSTEM CONCEPTS",
    "DESIGN AND ANALYSIS OF ALGORITHMS",
    "COMPUTER ARCHITECTURE",
    "MICRO PROCESSORS AND MICRO CONTROLLERS",
    "DATABASE MANAGEMENT SYSTEMS LABORATORY",
    "INTERPERSONAL SKILLS-LISTENING AND SPEAKING",
    "ENVIRONMENTAL SCIENCE AND ENGINEERING"
  };
  private String[] sem05Subjects = {
    "THEORY OF COMPUTATION",
    "COMPUTER NETWORKS",
    "ELECTIVE I",
    "ELECTIVE II",
    "OPEN ELECTIVE-I",
    "SYSTEM ANALYSIS AND DESIGN LABORATORY",
    "COMPUTER NETWORKS LABORATORY",
    "LIFE SKILLS : APTITUDE"
  };
  private String[] sem06Subjects = {
    "COMPILER DESIGN",
    "CRYPTOGRAPHY AND NETWORK SECURITY",
    "ARTIFICIAL INTELLIGENCE AND MACHINE LEARNING",
    "ELECTIVE III",
    "ELECTIVE IV",
    "OPEN ELECTIVE - II",
    "MOBILE APPLICATION DEVELOPMENT LABORATORY",
    "MINI PROJECT",
    "LIFE SKILLS : COMPETITIVE EXAMS"
  };
  private String[] sem07Subjects = {
    "PROFESSIONAL ETHICS FOR ENGINEERS",
    "GRAPHICS AND MULTIMEDIA",
    "SOFTWARE AND PROJECT MANAGEMENT",
    "ELECTIVE V",
    "ELECTIVE VI",
    "OPEN ELECTIVE - III",
    "GRAPHICS AND MULTIMEDIA LABORATORY",
    "TECHNICAL SEMINAR"
  };
  private String[] sem08Subjects = {
    "ELECTIVE VII",
    "ELECTIVE VIII",
    "OPEN ELECTIVE - IV",
    "PROJECT WORK",
    "DUMMY SUBJECT I",
    "DUMMY SUBJECT II",
    "DUMMY SUBJECT III",
    "DUMMY SUBJECT IV"
  };

  /** Creating a Hashmap to store components and results into it. */
  HashMap<String, Double> letterGradeMap = new HashMap<>();

  HashMap<String, HashMap<String, Double>> perSemesterSubjectCredits = new HashMap<>();
  HashMap<String, JComboBox[]> allComboBoxes = new HashMap<String, JComboBox[]>();
  HashMap<String, HashMap<String, Double>> resultsCGPA = new HashMap<>();
  // HashMap<String, Double> creditsMap = new HashMap<>();
  HashMap<String, JButton> cgpaButtons = new HashMap<String, JButton>();

  Font font = new Font("Courier", Font.BOLD, 16);

  public void calculationScreen() {

    /** Populating HashMap with String and Value Array for grades */
    letterGradeMap.put("Select a Grade", 0.001);
    letterGradeMap.put("O", 10.0);
    letterGradeMap.put("A+", 9.0);
    letterGradeMap.put("A", 8.0);
    letterGradeMap.put("B+", 7.0);
    letterGradeMap.put("B", 6.0);
    letterGradeMap.put("RA", 0.0);

    HashMap<String, Double> sem1Map = new HashMap<>(sem01Subjects.length);
    sem1Map.put("ENGLISH FOR PROFESSIONAL COMMUNICATION", 3.0);
    sem1Map.put("MATRICES AND CALCULUS", 4.0);
    sem1Map.put("PHYSICS FOR INFORMATION SCIENCE", 3.0);
    sem1Map.put("CHEMISTRY FOR INFORMATION SCIENCE", 3.0);
    sem1Map.put("PYTHON PROGRAMMING", 3.0);
    sem1Map.put("ENGINEERING GRAPHICS", 3.0);
    sem1Map.put("PHYSICS AND CHEMISTRY LABORATORY", 2.0);
    sem1Map.put("PYTHON PROGRAMMING LABORATORY", 2.0);
    perSemesterSubjectCredits.put("SEM01", sem1Map);

    HashMap<String, Double> sem2Map = new HashMap<>(sem02Subjects.length);
    sem2Map.put("TECHNICAL COMMUNICATION", 2.0);
    sem2Map.put("VECTOR CALCULUS AND TRANSFORMS", 4.0);
    sem2Map.put("BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING", 3.0);
    sem2Map.put("C PROGRAMMING", 3.0);
    sem2Map.put("ELECTRICAL AND ELECTRONICS LABORATORY", 2.0);
    sem2Map.put("C PROGRAMMING LABORATORY", 2.0);
    sem2Map.put("COMPUTER HARDWARE AND SOFTWARE TOOLS (computer workshop)", 2.0);
    sem2Map.put("FUNDAMENTALS OF COMPUTATIONAL BIOLOGY", 0.0);
    perSemesterSubjectCredits.put("SEM02", sem2Map);

    HashMap<String, Double> sem3Map = new HashMap<>(sem03Subjects.length);
    sem3Map.put("PROBABILITY AND QUEUEING THEORY", 4.0);
    sem3Map.put("DIGITAL SYSTEMS", 3.0);
    sem3Map.put("DATA STRUCTURES", 3.0);
    sem3Map.put("SOFTWARE ENGINEERING", 3.0);
    sem3Map.put("OBJECT ORIENTED PROGRAMMING SYSTEMS", 3.0);
    sem3Map.put("DATA STRUCTURES LABORATORY", 2.0);
    sem3Map.put("OBJECT ORIENTED PROGRAMMING SYSTEMS LABORATORY", 2.0);
    sem3Map.put("COMMUNICATION AND SOFT SKILLS", 0.0);
    perSemesterSubjectCredits.put("SEM03", sem3Map);

    HashMap<String, Double> sem4Map = new HashMap<>(sem04Subjects.length);
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

    HashMap<String, Double> sem5Map = new HashMap<>(sem05Subjects.length);
    sem5Map.put("THEORY OF COMPUTATION", 3.0);
    sem5Map.put("COMPUTER NETWORKS", 3.0);
    sem5Map.put("ELECTIVE I", 3.0);
    sem5Map.put("ELECTIVE II", 3.0);
    sem5Map.put("OPEN ELECTIVE-I", 3.0);
    sem5Map.put("SYSTEM ANALYSIS AND DESIGN LABORATORY", 2.0);
    sem5Map.put("COMPUTER NETWORKS LABORATORY", 2.0);
    sem5Map.put("LIFE SKILLS : APTITUDE", 0.0);
    perSemesterSubjectCredits.put("SEM05", sem5Map);

    HashMap<String, Double> sem6Map = new HashMap<>(sem06Subjects.length);
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

    HashMap<String, Double> sem7Map = new HashMap<>(sem07Subjects.length);
    sem7Map.put("PROFESSIONAL ETHICS FOR ENGINEERS", 3.0);
    sem7Map.put("GRAPHICS AND MULTIMEDIA", 3.0);
    sem7Map.put("SOFTWARE AND PROJECT MANAGEMENT", 3.0);
    sem7Map.put("ELECTIVE V", 3.0);
    sem7Map.put("ELECTIVE VI", 3.0);
    sem7Map.put("OPEN ELECTIVE - III", 3.0);
    sem7Map.put("GRAPHICS AND MULTIMEDIA LABORATORY", 2.0);
    sem7Map.put("TECHNICAL SEMINAR", 1.0);
    perSemesterSubjectCredits.put("SEM07", sem7Map);

    HashMap<String, Double> sem8Map = new HashMap<>(sem08Subjects.length);
    sem8Map.put("ELECTIVE VII", 3.0);
    sem8Map.put("ELECTIVE VIII", 3.0);
    sem8Map.put("OPEN ELECTIVE - IV", 3.0);
    sem8Map.put("PROJECT WORK", 10.0);
    perSemesterSubjectCredits.put("SEM08", sem8Map);

    /** Creating Buttons. */
    JButton[] calculateGPA = new JButton[8];
    JButton[] ResetGPA = new JButton[8];
    ButtonCreation calculateCGPA = new ButtonCreation("Calculate CGPA");
    ButtonCreation resetAll = new ButtonCreation("Reset ALL");
    for (int i = 0; i < 8; i++) {
      calculateGPA[i] = new ButtonCreation("Calculate GPA", font, "CGPA");
      ResetGPA[i] = new ButtonCreation("Reset Grade Points", font);
    }

    /** Creating ComboBox Arrays. */
    JComboBox[] sem01cb = new JComboBox[sem1Map.size()];
    JComboBox[] sem02cb = new JComboBox[sem2Map.size()];
    JComboBox[] sem03cb = new JComboBox[sem3Map.size()];
    JComboBox[] sem04cb = new JComboBox[sem4Map.size()];
    JComboBox[] sem05cb = new JComboBox[sem5Map.size()];
    JComboBox[] sem06cb = new JComboBox[sem6Map.size()];
    JComboBox[] sem07cb = new JComboBox[sem7Map.size()];
    JComboBox[] sem08cb = new JComboBox[sem8Map.size()];

    allComboBoxes.put("SEM01", sem01cb);
    allComboBoxes.put("SEM02", sem02cb);
    allComboBoxes.put("SEM03", sem03cb);
    allComboBoxes.put("SEM04", sem04cb);
    allComboBoxes.put("SEM05", sem05cb);
    allComboBoxes.put("SEM06", sem06cb);
    allComboBoxes.put("SEM07", sem07cb);
    allComboBoxes.put("SEM08", sem08cb);

    /** Creating Subject Label Arrays. */
    JLabel[] sem01PaperLabel = new JLabel[8];
    JLabel[] sem02PaperLabel = new JLabel[8];
    JLabel[] sem03PaperLabel = new JLabel[8];
    JLabel[] sem04PaperLabel = new JLabel[9];
    JLabel[] sem05PaperLabel = new JLabel[8];
    JLabel[] sem06PaperLabel = new JLabel[9];
    JLabel[] sem07PaperLabel = new JLabel[8];
    JLabel[] sem08PaperLabel = new JLabel[4];

    /** Creating Arrays to perform actions. */
    ArrayList<JComboBox[]> allComboBoxesarray = new ArrayList<>();
    allComboBoxesarray.add(sem01cb);
    allComboBoxesarray.add(sem02cb);
    allComboBoxesarray.add(sem03cb);
    allComboBoxesarray.add(sem05cb);
    allComboBoxesarray.add(sem07cb);
    allComboBoxesarray.add(sem04cb);
    allComboBoxesarray.add(sem06cb);
    allComboBoxesarray.add(sem08cb);

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



    cgpaButtons.put("SEM01", calculateGPA[0]);
    cgpaButtons.put("SEM02", calculateGPA[1]);
    cgpaButtons.put("SEM03", calculateGPA[2]);
    cgpaButtons.put("SEM04", calculateGPA[3]);
    cgpaButtons.put("SEM05", calculateGPA[4]);
    cgpaButtons.put("SEM06", calculateGPA[5]);
    cgpaButtons.put("SEM07", calculateGPA[6]);
    cgpaButtons.put("SEM08", calculateGPA[7]);

    /** Creating ComboBox and adding those into panels along with Subject Labels. */
    for (String key : allComboBoxes.keySet()) {
      JComboBox[] entry = allComboBoxes.get(key);
      for (JComboBox boxes : entry) {
        for (int i = 0; i < entry.length; i++) {
          if ( "SEM01".equals( key )) {
            sem01cb[i] = new ComboBoxCreation(sem01cb[i], sem01Subjects[i]);
            sem01PaperLabel[i] = new LabelCreation(sem01PaperLabel[i], sem01Subjects[i]);
          } else {
            if ( "SEM02".equals( key )) {
              sem02cb[i] = new ComboBoxCreation(sem02cb[i], sem02Subjects[i]);
              sem02PaperLabel[i] = new LabelCreation(sem02PaperLabel[i], sem02Subjects[i]);
            } else {
              if ( "SEM03".equals( key )) {
                sem03cb[i] = new ComboBoxCreation(sem03cb[i], sem03Subjects[i]);
                sem03PaperLabel[i] = new LabelCreation(sem03PaperLabel[i], sem03Subjects[i]);
              } else {
                if ( "SEM04".equals( key )) {
                  sem04cb[i] = new ComboBoxCreation(sem04cb[i], sem04Subjects[i]);
                  sem04PaperLabel[i] = new LabelCreation(sem04PaperLabel[i], sem04Subjects[i]);

                } else {
                  if ( "SEM05".equals( key )) {
                    sem05cb[i] = new ComboBoxCreation(sem05cb[i], sem05Subjects[i]);
                    sem05PaperLabel[i] = new LabelCreation(sem05PaperLabel[i], sem05Subjects[i]);
                  } else {
                    if ( "SEM06".equals( key )) {
                      sem06cb[i] = new ComboBoxCreation(sem06cb[i], sem06Subjects[i]);
                      sem06PaperLabel[i] = new LabelCreation(sem06PaperLabel[i], sem06Subjects[i]);

                    } else {
                      if ( "SEM07".equals( key )) {
                        sem07cb[i] = new ComboBoxCreation(sem07cb[i], sem07Subjects[i]);
                        sem07PaperLabel[i] = new LabelCreation(sem07PaperLabel[i], sem07Subjects[i]);
                      } else {
                        if ( "SEM08".equals( key )) {
                          sem08cb[i] = new ComboBoxCreation(sem08cb[i], sem08Subjects[i]);
                          sem08PaperLabel[i] = new LabelCreation(sem08PaperLabel[i], sem08Subjects[i]);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }




    // Creating All Panels
    PanelCreation sem01 = new PanelCreation(9, 3, tabNamePanelName[0]);
    PanelCreation sem02 = new PanelCreation(9, 3, tabNamePanelName[1]);
    PanelCreation sem03 = new PanelCreation(9, 3, tabNamePanelName[2]);
    PanelCreation sem04 = new PanelCreation(10, 3, tabNamePanelName[3]);
    PanelCreation sem05 = new PanelCreation(9, 3, tabNamePanelName[4]);
    PanelCreation sem06 = new PanelCreation(10, 3, tabNamePanelName[5]);
    PanelCreation sem07 = new PanelCreation(9, 3, tabNamePanelName[6]);
    PanelCreation sem08 = new PanelCreation(9, 3, tabNamePanelName[7]);
    PanelCreation CGPA = new PanelCreation(1, 1, "CGPA");

    JTabbedPane semesterPane =
            new JTabbedPane(JTabbedPane.TOP) {
              {
                addTab(tabNamePanelName[0], null, sem01, null);
                addTab(tabNamePanelName[1], null, sem02, null);
                addTab(tabNamePanelName[2], null, sem03, null);
                addTab(tabNamePanelName[3], null, sem04, null);
                addTab(tabNamePanelName[4], null, sem05, null);
                addTab(tabNamePanelName[5], null, sem06, null);
                addTab(tabNamePanelName[6], null, sem07, null);
                addTab(tabNamePanelName[7], null, sem08, null);
                addTab(tabNamePanelName[8], null, CGPA, null);
                setBounds(0, 0, 517, 291);
                setBackground(Color.YELLOW);
              }
            };

    for (int i = 0; i < 8; i++) {
      sem01.add(sem01PaperLabel[i]);
      sem01.add(sem01cb[i]);
      sem02.add(sem02PaperLabel[i]);
      sem02.add(sem02cb[i]);
      sem03.add(sem03PaperLabel[i]);
      sem03.add(sem03cb[i]);
      sem05.add(sem05PaperLabel[i]);
      sem05.add(sem05cb[i]);
      sem07.add(sem07PaperLabel[i]);
      sem07.add(sem07cb[i]);
    }
    for (int i = 0; i < sem4Map.size(); i++) {
      // sem04cb[i] = new ComboBoxCreation(sem04cb[i], sem04Subjects[i]);
      sem04PaperLabel[i] = new LabelCreation(sem04PaperLabel[i], sem04Subjects[i]);
      sem04.add(sem04PaperLabel[i]);
      sem04.add(sem04cb[i]);
    }

    for (int i = 0; i < sem6Map.size(); i++) {
      sem06PaperLabel[i] = new LabelCreation(sem06PaperLabel[i], sem06Subjects[i]);
      sem06.add(sem06PaperLabel[i]);
      sem06.add(sem06cb[i]);
    }

    for (int i = 0; i < sem8Map.size(); i++) {
      sem08PaperLabel[i] = new LabelCreation(sem08PaperLabel[i], sem08Subjects[i]);
      sem08.add(sem08PaperLabel[i]);
      sem08.add(sem08cb[i]);
    }

    sem01.add(calculateGPA[0]);
    sem01.add(ResetGPA[0]);
    sem02.add(calculateGPA[1]);
    sem02.add(ResetGPA[1]);
    sem03.add(calculateGPA[2]);
    sem03.add(ResetGPA[2]);
    sem04.add(calculateGPA[3]);
    sem04.add(ResetGPA[3]);
    sem05.add(calculateGPA[4]);
    sem05.add(ResetGPA[4]);
    sem06.add(calculateGPA[5]);
    sem06.add(ResetGPA[5]);
    sem07.add(calculateGPA[6]);
    sem07.add(ResetGPA[6]);
    sem08.add(calculateGPA[7]);
    sem08.add(ResetGPA[7]);
    sem08.add(resetAll);
    CGPA.add(calculateCGPA);

    // Creating an array of CGPA and GPA Buttons.
    ArrayList<JButton[]> allSemestersGPAButton = new ArrayList<>();
    allSemestersGPAButton.add(calculateGPA);
    ArrayList<JButton> allSemestersCGPAButton = new ArrayList<>();
    allSemestersCGPAButton.add(calculateCGPA);
    ArrayList<JButton[]> ResetButton = new ArrayList<>();
    ResetButton.add(ResetGPA);

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
                // System.out.println(semesterName);
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
    for (JButton cgpa : allSemestersCGPAButton) {
      for (int i = 0; i <= 7; i++) {
        cgpa.addActionListener(
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
                    "Your CGPA is =" + String.valueOf(result) + " \n Click to Calculate again");
              }
            });
      }
    }

    // Creating an Action Listener for Reset ComboBoxes Button.
    for (JButton[] reset : ResetButton) {
      for (int i = 0; i < perSemesterSubjectCredits.entrySet().size(); i++) {
        {
          reset[i].addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  JButton currentButton = (JButton) event.getSource();
                  String semesterName = currentButton.getParent().getName();
                  String panelName = currentButton.getName();
                  for (JComboBox semesterComboBoxes : allComboBoxes.get(semesterName)) {
                    semesterComboBoxes.setSelectedIndex(0);
                    resultsCGPA.get(semesterName).keySet().clear();
                    cgpaButtons.get(semesterName).setText("Calculate GPA");
                  }
                }
              });
        }
      }

      resetAll.addActionListener(
          new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              for (Map.Entry<String, JComboBox[]> entry : allComboBoxes.entrySet()) {
                for(JComboBox boxes : entry.getValue ()){
                  boxes.setSelectedIndex ( 0 );
                }
              }
              resultsCGPA.clear();
                for (int i = 0; i <= perSemesterSubjectCredits.keySet().size(); i++) {
                  //semesterComboBoxes[i].setSelectedIndex(0);
                  resultsCGPA.clear();
                  for (JButton[] cgp : allSemestersGPAButton) {
                    for (int l = 0; l <= 7; l++) {
                      cgp[l].setText("Calculate GPA");
                    }
                    for (JButton ccgp : allSemestersCGPAButton) {
                      for (int m = 0; m <= 7; m++) {
                        ccgp.setText("Calculate CGPA");
                      }
                    }
                  }
                }
              }

          });

        // Creating a Tabbed Pane and adding all panels into it.
        getContentPane().add(semesterPane);
        setSize(1300, 500);
        setTitle("CGPA Calculation Screen");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    }
  }

