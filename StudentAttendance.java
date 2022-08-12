/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author ilaan
 */
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentAttendance extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;
    JComboBox cb1, cb2;
    static JPanel p1;
    JFrame f1;
    JDateChooser jDateChooser1;

    StudentAttendance() {
        super("Student Attendance");
        setBounds(200, 100, 1000, 500);
        
        JTabbedPane tab = new JTabbedPane();
        tab.setBounds(0, 0, 500, 450);
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        
        
        
        setLayout(new BorderLayout(10, 10));
        JLabel l1 = new JLabel("Student Attendance Recording Portal");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Default", Font.BOLD, 20));
        l1.setBounds(50, 0, 400, 100);
        p1.add(l1);
        JLabel l2 = new JLabel("Roll Number");
        l2.setBounds(40, 100, 200, 22);
        l2.setFont(new Font("Default", Font.BOLD, 15));
        p1.add(l2);
        t1 = new JTextField();
        t1.setBounds(170, 100, 200, 22);
        p1.add(t1);
        JLabel l3 = new JLabel("Course Name" + "");
        l3.setBounds(30, 250, 200, 22);
        l3.setFont(new Font("Default", Font.BOLD, 15));
        p1.add(l3);
        String arr[] = {"CSD205", "CSD211", "CSD213" , "EED206", "ESD201", "ECO101", "DOM304"};
        cb1 = new JComboBox(arr);
        cb1.setBounds(170, 250, 200, 22);
        cb1.setSelectedIndex(-1);
        p1.add(cb1);
        JLabel l4 = new JLabel("Attendance");
        l4.setBounds(40, 150, 100, 22);
        l4.setFont(new Font("Menlo", Font.BOLD, 15));
        p1.add(l4);
        String arr1[] = {"Present", "Absent", "Late"};
        cb2 = new JComboBox(arr1);
        cb2.setBounds(170, 150, 200, 22);
        cb2.setSelectedIndex(-1);
        p1.add(cb2);
        JLabel l5 = new JLabel("Date");
        l5.setBounds(60, 200, 150, 22);
        l5.setFont(new Font("Menlo", Font.BOLD, 15));
        p1.add(l5);
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setBounds(170, 200, 200, 22);
        p1.add(jDateChooser1);
        b1 = new JButton("Submit");
        b1.setBounds(100, 300, 150, 40);
        b1.setFont(new Font("Helvetica", Font.BOLD, 15));
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        p1.add(b1);
        b2 = new JButton("Exit");
        b2.setBounds(260, 300, 150, 40);
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Helvetica", Font.BOLD, 15));
        b2.addActionListener(this);
        p1.add(b2);
        b3 = new JButton("View attendance");
        b3.setBounds(100,350,310,40);
        b3.setFont(new Font("Helvetica", Font.BOLD, 15));
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        p1.add(b3);
        tab.add("Student Attendance", p1);
        add(tab);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project\\icons\\StudentAttendance.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel();
        l6.setIcon(i3);
        add(l6, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        if (e.getSource() == b1) {
            String rno = t1.getText();
            java.util.Date jud = jDateChooser1.getDate();
            long t = jud.getTime();
            java.sql.Date sqd = new java.sql.Date(t);
            String attendance = (String) cb2.getSelectedItem();
            String courseName = (String) cb1.getSelectedItem();
            conn c = new conn();
            
            try {
                c.s.executeUpdate("insert into attendance_students (rollno,Attendance,Date,Course_Name) values(" + "'" + t1.getText() + "'" + "," + "'" + attendance + "'" + "," + "'" + sqd + "'" + "," + "'" + courseName +"'"+");");
            } catch (SQLException ex) {
                Logger.getLogger(StudentAttendance.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Attendance updated in database");
            

        }
        if (e.getSource() == b2) {
            System.exit(0);
        }
        
        if (e.getSource() == b3) {
            ViewStudentAttendance stad = new ViewStudentAttendance();
            stad.setVisible(true);
        }

    }

    
}