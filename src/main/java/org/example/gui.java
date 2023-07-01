package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class gui extends JPanel {
    private JButton Info;
    private JButton submit;
    private JTextArea display;
    private JLabel nemis;
    private JTextField classtext;
    private JTextField attendancetext;
    private JTextField nemistext;
    private JLabel class1;
    private JLabel Attndeance;

    public gui() {
        //construct components
        Info = new JButton ("INFO");
        submit = new JButton ("SUBMIT");
        display = new JTextArea (5, 5);
        nemis = new JLabel ("NEMIS_NO");
        classtext = new JTextField (5);
        attendancetext = new JTextField (5);
        nemistext = new JTextField (5);
        class1 = new JLabel ("CLASS_ID");
        Attndeance = new JLabel ("ATTENDANCE");

        //adjust size and set layout
        setPreferredSize (new Dimension (752, 425));
        setLayout (null);

        //add components
        add (Info);
        add (submit);
        add (display);
        add (nemis);
        add (classtext);
        add (attendancetext);
        add (nemistext);
        add (class1);
        add (Attndeance);
        Info.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                StringBuilder dis = new StringBuilder();
                dis.append("Attendance Marker. \n");
                dis.append(" \n");
                dis.append("\n Kindly enter the requirement data \n");
                display.setText(dis.toString());
            }

        });
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    StringBuilder dis = new StringBuilder();
                    String nemis =  nemistext.getText().toUpperCase();
                    int class1 = Integer.parseInt(classtext.getText());
                    String atte = attendancetext.getText().toUpperCase();

                    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                    Session session = sessionFactory.openSession();
                    session.beginTransaction();
                    Mark mark = new Mark(nemis.toUpperCase(),class1, atte.toUpperCase());
                    session.save(mark);                          //comments are reserved

                    session.getTransaction().commit();
                    session.close();
                   
                    dis.append("\n1. Updated Nemis: " + nemis + "\n");
                    dis.append("2. From Class_Id: " + class1 + "\n");
                    dis.append("3. Attendance(Present): " + atte + "\n");
                    display.setText(dis.toString());

                } catch (Exception e1) {
                    StringBuilder out = new StringBuilder();

                    out.append(" kindly enter correct values \n");
                    out.append(" \n Or values already entered. \n");
                    display.setText(out.toString());
                }
            }

        });

        //set component bounds (only needed by Absolute Positioning)
        Info.setBounds (190, 305, 100, 20);
        submit.setBounds (510, 300, 140, 20);
        display.setBounds (25, 40, 365, 190);
        nemis.setBounds (565, 75, 100, 25);
        classtext.setBounds (450, 120, 100, 25);
        attendancetext.setBounds (450, 165, 100, 25);
        nemistext.setBounds (450, 74, 100, 25);
        class1.setBounds (565, 120, 100, 25);
        Attndeance.setBounds (565, 165, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("ATTENDANCE");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new gui());
        frame.pack();
        frame.setVisible (true);
    }
}

