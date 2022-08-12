package project;
import java.awt.*;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilaan
 */
public class Project extends JFrame implements ActionListener{
    Project(){
        super(" Shiv Nadar University");
    setSize(1900,1040);
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\SNU-NCR-IMG.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 1040,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

    JLabel l1=new JLabel();
    l1.setIcon(i3);
    setLayout(new BorderLayout(10, 10));
    add(l1,BorderLayout.WEST);

     JPanel p1=new JPanel();
     p1.setLayout(new GridLayout(2, 3));
     
     JButton b1=new JButton("Student Attendance");
     b1.setFont(new Font("Default", Font.BOLD, 8));
    
     ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\StudentAttendance.png"));
     Image i7 = i4.getImage().getScaledInstance(110, 110,Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i7);

     b1.setIcon(i6);
     b1.setHorizontalTextPosition(AbstractButton.CENTER);
        b1.setVerticalTextPosition(AbstractButton.BOTTOM);
        
     p1.add(b1);
     JButton b2=new JButton("Academic Calendar");
     b2.setFont(new Font("Default", Font.BOLD, 10));
     ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\AcademicCalendar.jpg"));
     
     Image i8 = i5.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        b2.setIcon(i9);
     b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
     p1.add(b2);
     JButton b3=new JButton("Add Marks");
     ImageIcon j1= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\addmarks.jpg"));
     Image j2 = j1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon j3= new ImageIcon(j2);

     b3.setIcon(j3);
     b3.setHorizontalTextPosition(AbstractButton.CENTER);
        b3.setVerticalTextPosition(AbstractButton.BOTTOM);
        
     p1.add(b3);
     JButton b5=new JButton("View result");
     ImageIcon j4= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\viewresult.png"));
     Image j5 = j4.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon j6= new ImageIcon(j5);

     b5.setIcon(j6);
     b5.setHorizontalTextPosition(AbstractButton.CENTER);
        b5.setVerticalTextPosition(AbstractButton.BOTTOM);
        
     p1.add(b5);
     JButton b6=new JButton("Pay fee");
     ImageIcon j7= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\fee.png"));
     Image j8 = j7.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon j9= new ImageIcon(j8);

     b6.setIcon(j9);
     b6.setHorizontalTextPosition(AbstractButton.CENTER);
        b6.setVerticalTextPosition(AbstractButton.BOTTOM);
        
     p1.add(b6);
     JButton b7=new JButton("Book hostel");
     ImageIcon k1= new ImageIcon(ClassLoader.getSystemResource("project\\icons\\hostel.png"));
     Image  k2= k1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon k3= new ImageIcon(k2);

     b7.setIcon(k3);
     b7.setHorizontalTextPosition(AbstractButton.CENTER);
        b7.setVerticalTextPosition(AbstractButton.BOTTOM);
        
     p1.add(b7);
     
     add(p1,BorderLayout.CENTER);
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     b5.addActionListener(this);
     b6.addActionListener(this);
     b7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String b = e.getActionCommand();
    if(b.equals("Student Attendance"))new Login("teacher",new StudentAttendance());
    if(b.equals("Academic Calendar"))new Login("student",new AcademicCalendar());
    if(b.equals("Add Marks"))new Login("teacher",new AddMarks());
    if(b.equals("View result"))new Login("student",new viewResults());
    if(b.equals("Pay fee"))new Login("student",new FeeStructure());
    if(b.equals("Book hostel"))new Login("student",new Hostel());
    } 
    
}