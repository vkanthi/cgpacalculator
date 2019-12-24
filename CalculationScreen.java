package com.malaviji.fxcgpa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


/**
 *
 * @author Mala and Renganayagi
 */
public class CalculationScreen extends JFrame {

    // Creating String arrays used for populating into Panel Labels, pull down menus
    String[] letterGrades = {"Select a Grade", "O", "A+", "A", "B+", "B", "RA"};

    //Creating String arrays used for populating Names for all the 8 tabs.
    String[] semesterNames = {"SEM01", "SEM02", "SEM03", "SEM04", "SEM05", "SEM06", "SEM07", "SEM08"};

    //Creating String arrays used subjects that can be used to create subject labels
    String[] sem01Subjects = {"ENGLISH FOR PROFESSIONAL COMMUNICATION", "MATRICES AND CALCULUS", "PHYSICS FOR INFORMATION SCIENCE", "CHEMISTRY FOR INFORMATION SCIENCE", "PYTHON PROGRAMMING", "ENGINEERING GRAPHICS", "PHYSICS AND CHEMISTRY LABORATORY", "PYTHON PROGRAMMING LABORATORY"};
    String[] sem02Subjects = {"TECHNICAL COMMUNICATION", "VECTOR CALCULUS AND TRANSFORMS", "BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING", "C PROGRAMMING", "ELECTRICAL AND ELECTRONICS LABORATORY", "C PROGRAMMING LABORATORY", "COMPUTER HARDWARE AND SOFTWARE TOOLS (computer workshop)", "FUNDAMENTALS OF COMPUTATIONAL BIOLOGY"};
    String[] sem03Subjects = {"PROBABILITY AND QUEUING THEORY", "DIGITAL SYSTEMS", "DATA STRUCTURES", "SOFTWARE ENGINEERING", "OBJECT ORIENTED PROGRAMMING SYSTEMS", "DATA STRUCTURES LABORATORY", "OBJECT ORIENTED PROGRAMMING SYSTEMS LABORATORY", "COMMUNICATION AND SOFT SKILLS"};
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

        //Populating HashMap with String and Value Array for grades
        letterGradeMap.put("Select a Grade", 0.001);
        letterGradeMap.put("O", 10.0);
        letterGradeMap.put("A+", 9.0);
        letterGradeMap.put("A", 8.0);
        letterGradeMap.put("B+", 7.0);
        letterGradeMap.put("B", 6.0);
        letterGradeMap.put("RA", 0.0);

        HashMap<String, Double> sem1Map = new HashMap<>();
        sem1Map.put("ENGLISH FOR PROFESSIONAL COMMUNICATION", 3.0);
        sem1Map.put("MATRICES AND CALCULUS", 3.0);
        sem1Map.put("PHYSICS FOR INFORMATION SCIENCE", 4.0);
        sem1Map.put("CHEMISTRY FOR INFORMATION SCIENCE", 4.0);
        sem1Map.put("PYTHON PROGRAMMING", 4.0);
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
        sem3Map.put("PROBABILITY AND QUEUING THEORY", 4.0);
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
        sem8Map.put("DUMMY SUBJECT I", 0.001);
        sem8Map.put("DUMMY SUBJECT II", 0.001);
        sem8Map.put("DUMMY SUBJECT III", 0.001);
        sem8Map.put("DUMMY SUBJECT IV", 0.001);
        perSemesterSubjectCredits.put("SEM08", sem8Map);

        ArrayList<HashMap<String, Double>> allSems = new ArrayList<>();
        allSems.add(sem1Map);
        allSems.add(sem2Map);
        allSems.add(sem3Map);
        allSems.add(sem4Map);
        allSems.add(sem5Map);
        allSems.add(sem6Map);
        allSems.add(sem7Map);
        allSems.add(sem8Map);

//        HashMap<String, ArrayList<JComboBox>> semBoxesAll = new HashMap<>();
//
//        perSemesterSubjectCredits.forEach((semName, semMap) -> {
//            JComboBox[] boxesArr = new JComboBox[semMap.size()];
//            ArrayList<JComboBox> list = new ArrayList<>();
//            Collections.addAll(list, boxesArr);
//            semBoxesAll.put(
//                    semName,
//                    list.stream()
//                            .map(box -> new JComboBox(letterGrades))//
//                            .collect(Collectors.toCollection(ArrayList::new))
//            );
//        });

//        allSems.stream().map(sem -> {
//
//            JComboBox[] boxesArr = new JComboBox[sem.size()];
//            ArrayList<JComboBox> list = new ArrayList<>();
//            Collections.addAll(list, boxesArr);
//            semBoxesAll.put(se list.stream().map(box -> new JComboBox(letterGrades)).collect(Collectors.toCollection(ArrayList::new));
//
//        })


//        ArrayList<String> semNamesList = new ArrayList<>();
//        Collections.addAll(semNamesList, semesterNames);
//
//        ArrayList<JPanel> panels = semNamesList.stream().map(semName -> {
//            HashMap<String, Double> semSubjects = perSemesterSubjectCredits.get(semName);
//            JPanel semJPanel = new JPanel();
//            GridLayout layout = new GridLayout(semSubjects.keySet().size() + 2, 2);
//            semJPanel.setLayout(layout);
//            semJPanel.setBackground(Color.YELLOW);
//            semJPanel.setName(semName);
//
//            ArrayList<JComboBox> semBoxes = semBoxesAll.get(semName);
//
//            semSubjects.keySet().stream().forEach(subject -> {
//
//                JLabel subjectLabel = new JLabel(subject);
//                semJPanel.add(subjectLabel);
//
//            });
//            return semJPanel;
//        }).collect(Collectors.toCollection(ArrayList::new));



        //creating comboBox arrays and populating letterGrades into it
        JComboBox[] sem01cb = new JComboBox[8];
        JComboBox[] sem02cb = new JComboBox[8];
        JComboBox[] sem03cb = new JComboBox[8];
        JComboBox[] sem04cb = new JComboBox[8];
        JComboBox[] sem05cb = new JComboBox[8];
        JComboBox[] sem06cb = new JComboBox[8];
        JComboBox[] sem07cb = new JComboBox[8];
        JComboBox[] sem08cb = new JComboBox[8];

        //Creating Array list for ComboBox
        ArrayList<JComboBox[]> allSemesters = new ArrayList<>();
        allSemesters.add(sem01cb);
        allSemesters.add(sem02cb);
        allSemesters.add(sem03cb);
        allSemesters.add(sem04cb);
        allSemesters.add(sem05cb);
        allSemesters.add(sem06cb);
        allSemesters.add(sem07cb);
        allSemesters.add(sem08cb);

        for (int i = 0; i < 8; i++) {
            sem01cb[i] = new JComboBox(letterGrades);
            sem02cb[i] = new JComboBox(letterGrades);
            sem03cb[i] = new JComboBox(letterGrades);
            sem04cb[i] = new JComboBox(letterGrades);
            sem05cb[i] = new JComboBox(letterGrades);
            sem06cb[i] = new JComboBox(letterGrades);
            sem07cb[i] = new JComboBox(letterGrades);
            sem08cb[i] = new JComboBox(letterGrades);

        }

        JPanel sem01 = new JPanel();
        GridLayout sem01Layout = new GridLayout(10, 2);
        sem01.setLayout(sem01Layout);
        sem01.setBackground(Color.YELLOW);
        sem01.setName(semesterNames[0]);

        JPanel sem02 = new JPanel();
        GridLayout sem02Layout = new GridLayout(10, 2);
        sem02.setLayout(sem02Layout);
        sem02.setBackground(Color.WHITE);
        sem02.setName(semesterNames[1]);

        JPanel sem03 = new JPanel();
        GridLayout sem03Layout = new GridLayout(10, 2);
        sem03.setLayout(sem03Layout);
        sem03.setBackground(Color.pink);
        sem03.setName(semesterNames[2]);

        JPanel sem04 = new JPanel();
        GridLayout sem04Layout = new GridLayout(10, 2);
        sem04.setLayout(sem04Layout);
        sem04.setBackground(Color.LIGHT_GRAY);
        sem04.setName(semesterNames[3]);

        JPanel sem05 = new JPanel();
        GridLayout sem05Layout = new GridLayout(10, 2);
        sem05.setLayout(sem05Layout);
        sem05.setBackground(Color.CYAN);
        sem05.setName(semesterNames[4]);

        JPanel sem06 = new JPanel();
        GridLayout sem06Layout = new GridLayout(10, 2);
        sem06.setLayout(sem06Layout);
        sem06.setBackground(Color.GREEN);
        sem06.setName(semesterNames[5]);

        JPanel sem07 = new JPanel();
        GridLayout sem07Layout = new GridLayout(10, 2);
        sem07.setLayout(sem07Layout);
        sem07.setBackground(Color.ORANGE);
        sem07.setName(semesterNames[6]);

        JPanel sem08 = new JPanel();
        GridLayout sem08Layout = new GridLayout(10, 2);
        sem08.setLayout(sem08Layout);
        sem08.setBackground(Color.YELLOW);
        sem08.setName(semesterNames[7]);

        JLabel[] sem01PaperLabel = new JLabel[8];
        JLabel[] sem02PaperLabel = new JLabel[8];
        JLabel[] sem03PaperLabel = new JLabel[8];
        JLabel[] sem04PaperLabel = new JLabel[8];
        JLabel[] sem05PaperLabel = new JLabel[8];
        JLabel[] sem06PaperLabel = new JLabel[8];
        JLabel[] sem07PaperLabel = new JLabel[8];
        JLabel[] sem08PaperLabel = new JLabel[8];


        //Creating each semester Labels with subject names, adding them into panels, setting the names for combo box and adding them into panel using for loop.
        for (int i = 0; i < 8; i++) {
            sem01PaperLabel[i] = new JLabel(sem01Subjects[i]);
            sem01.add(sem01PaperLabel[i]);
            sem01cb[i].setName(sem01Subjects[i]);
            sem01.add(sem01cb[i]);

            sem02PaperLabel[i] = new JLabel(sem02Subjects[i]);
            sem02.add(sem02PaperLabel[i]);
            sem02cb[i].setName(sem02Subjects[i]);
            sem02.add(sem02cb[i]);

            sem03PaperLabel[i] = new JLabel(sem03Subjects[i]);
            sem03.add(sem03PaperLabel[i]);
            sem03cb[i].setName(sem03Subjects[i]);
            sem03.add(sem03cb[i]);

            sem04PaperLabel[i] = new JLabel(sem04Subjects[i]);
            sem04.add(sem04PaperLabel[i]);
            sem04.add(sem04cb[i]);
            sem04cb[i].setName(sem04Subjects[i]);

            sem05PaperLabel[i] = new JLabel(sem05Subjects[i]);
            sem05.add(sem05PaperLabel[i]);
            sem05cb[i].setName(sem05Subjects[i]);
            sem05.add(sem05cb[i]);

            sem06PaperLabel[i] = new JLabel(sem06Subjects[i]);
            sem06.add(sem06PaperLabel[i]);
            sem06cb[i].setName(sem06Subjects[i]);
            sem06.add(sem06cb[i]);

            sem07PaperLabel[i] = new JLabel(sem07Subjects[i]);
            sem07.add(sem07PaperLabel[i]);
            sem07cb[i].setName(sem07Subjects[i]);
            sem07.add(sem07cb[i]);

            sem08PaperLabel[i] = new JLabel(sem08Subjects[i]);
            sem08.add(sem08PaperLabel[i]);
            sem08cb[i].setName(sem08Subjects[i]);
            sem08.add(sem08cb[i]);



        }


        //Creating calculate GPA and CGPA buttons for all tabs.
        JButton[] calculateGPA = new JButton[8];
        JButton[] calculateCGPA = new JButton[8];
        JButton [] ResetGPA = new JButton[8];
        for (int m = 0; m < 8; m++) {
            calculateGPA[m] = new JButton("Calculate GPA");
            calculateGPA[m].setBackground(Color.RED);
            calculateGPA[m].setOpaque(true);

            calculateCGPA[m] = new JButton("Calculate CGPA");
            calculateCGPA[m].setBackground(Color.BLUE);
            calculateCGPA[m].setOpaque(true);

            ResetGPA[m] = new JButton("Reset Grade Points");
            ResetGPA[m].setBackground(Color.ORANGE);
            ResetGPA[m].setOpaque(true);

        }

        //Adding CGPA and GPA buttons into each tab panels.

        sem01.add(calculateGPA[0]);
        sem01.add(calculateCGPA[0]);
        sem01.add(ResetGPA[0]);


        sem02.add(calculateGPA[1]);
        sem02.add(calculateCGPA[1]);
        sem02.add(ResetGPA[1]);


        sem03.add(calculateGPA[2]);
        sem03.add(calculateCGPA[2]);
        sem03.add(ResetGPA[2]);


        sem04.add(calculateGPA[3]);
        sem04.add(calculateCGPA[3]);
        sem04.add(ResetGPA[3]);


        sem05.add(calculateGPA[4]);
        sem05.add(calculateCGPA[4]);
        sem05.add(ResetGPA[4]);


        sem06.add(calculateGPA[5]);
        sem06.add(calculateCGPA[5]);
        sem06.add(ResetGPA[5]);


        sem07.add(calculateGPA[6]);
        sem07.add(calculateCGPA[6]);
        sem07.add(ResetGPA[6]);


        sem08.add(calculateGPA[7]);
        sem08.add(calculateCGPA[7]);
        sem08.add(ResetGPA[7]);


        //Creating an array of CGPA and GPA Buttons.
        ArrayList<JButton[]> allSemestersGPAButton = new ArrayList<>();
        allSemestersGPAButton.add(calculateGPA);
        ArrayList<JButton[]> allSemestersCGPAButton = new ArrayList<>();
        allSemestersCGPAButton.add(calculateCGPA);
        ArrayList<JButton[]> allSemestersGPAResetButton = new ArrayList<>();
        allSemestersGPAResetButton.add(ResetGPA);

        //Creating ArrayList for all the semester panels.
        ArrayList<JPanel> allSemesterPanels = new ArrayList<>();
        allSemesterPanels.add(sem01);
        allSemesterPanels.add(sem02);
        allSemesterPanels.add(sem03);
        allSemesterPanels.add(sem04);
        allSemesterPanels.add(sem05);
        allSemesterPanels.add(sem06);
        allSemesterPanels.add(sem07);
        allSemesterPanels.add(sem08);


//        semBoxesAll.forEach((semName, semBoxes) ->
//                semBoxes.forEach(box -> box.addActionListener(
//                        new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent event) {
//
//                                JComboBox<String> combo = (JComboBox<String>) event.getSource();
//                                String gradeSelection = (String) combo.getSelectedItem();
//                                String semesterName = combo.getParent().getName();
//                                String subjectName = combo.getName();
//                                Double intGrade = letterGradeMap.get(gradeSelection);
//                                HashMap<String, Double> semGrades = resultsCGPA.getOrDefault(semesterName, new HashMap<>());
//                                semGrades.put(subjectName, intGrade);
//                                resultsCGPA.putIfAbsent(semesterName, semGrades);
//
//                            }
//                        })
//                )
//        );

        //Creating an Action Listener for all the pull down menus.
        for (JComboBox[] sem : allSemesters) {
            for (int i = 0; i < perSemesterSubjectCredits.size(); i++) {
                sem[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {

                        JComboBox<String> combo = (JComboBox<String>) event.getSource();
                        String gradeSelection = (String) combo.getSelectedItem();
                        String semesterName = combo.getParent().getName();
                        String subjectName = combo.getName();
                        Double intGrade = letterGradeMap.get(gradeSelection);
                        HashMap<String, Double> semGrades = resultsCGPA.getOrDefault(semesterName, new HashMap<>());
                        semGrades.put(subjectName, intGrade);
                        resultsCGPA.putIfAbsent(semesterName, semGrades);

                    }

                });

            }

        }

        //Creating an Action Listener for GPA Button.
        for (JButton[] cgp : allSemestersGPAButton) {
            for (int i = 0; i <= 7; i++) {
                cgp[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {

                        JButton currentButton = (JButton) event.getSource();
                        String semesterName = currentButton.getParent().getName();
                        HashMap<String, Double> semGrades = resultsCGPA.get(semesterName);
                        //semGrades.values().forEach(semesterSubjectsGradeMap.get(sem01Subjects));
                        HashMap<String, Double> semGradesMax = perSemesterSubjectCredits.get(semesterName);
                        Double sumOfGrades =  0d ;
                        for(Map.Entry<String, Double> entry : semGrades.entrySet()) {
                            sumOfGrades += semGradesMax.get(entry.getKey()) * entry.getValue();

                        }

                        Double maxCreditsForSem = semGradesMax.values().stream().reduce(0d, Double::sum);
                        Double gpa = sumOfGrades / maxCreditsForSem;
                        long roundedInt = Math.round(gpa * 100);
                        double result = (double) roundedInt / 100;
                        currentButton.setText("(Click to Calculate again) Your GPA for this semester =" + String.valueOf(result));

                    }

                });

            }

        }

        //Creating an Action Listener for CGPA Button.
        for (JButton[] cgpa : allSemestersCGPAButton) {
            for (int i = 0; i <= 7; i++) {
                cgpa[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {

                        JButton currentButton = (JButton) event.getSource();
                        Double sumOfGradesReceived =  0d ;
                        Double totalCredits =  0d ;
                        for (String semCompleted : resultsCGPA.keySet()) {
                            HashMap<String, Double> semGrades = resultsCGPA.get(semCompleted);

                            HashMap<String, Double> semGradesMax = perSemesterSubjectCredits.get(semCompleted);

                            totalCredits += semGradesMax.values().stream().reduce(0d, Double::sum);
                            for(Map.Entry<String, Double> entry : semGrades.entrySet()) {
                                sumOfGradesReceived += semGradesMax.get(entry.getKey()) * entry.getValue();
                            }
                        }

                        Double cgpa = sumOfGradesReceived / totalCredits;
                        long roundedInt = Math.round(cgpa * 100);
                        double result = (double) roundedInt / 100;
                        currentButton.setText("(Click to Calculate again)Your CGPA for this semester =" + String.valueOf(result));
                    }
                });
            }
        }

        //Creating an Action Listener for Reset GPA Button.
        for (JButton[] resetall : allSemestersGPAResetButton) {
            for (int i = 0; i <= 7; i++) {
                resetall[i].addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent event) {
                                for (JComboBox[] sem : allSemesters) {
                                    for (int i = 0; i <= 7; i++) {
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


        JTabbedPane semesterPane = new JTabbedPane(JTabbedPane.TOP) {
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
            }
        };
        getContentPane().add(semesterPane);
        setSize(1800, 1800);
        setTitle("CGPA Calculation Screen");
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main (String[] args){
//        JFrame calculationScreen = new JFrame();
        CalculationScreen cgpaCalculationScreen = new CalculationScreen();
        cgpaCalculationScreen.CalculationScreen();

    }

}
