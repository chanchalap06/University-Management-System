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
import com.mysql.cj.xdevapi.Statement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewResults extends JFrame {
    JButton b1,b2;
    JComboBox c1;
    JTextField t3,t2;
    viewResults(){
    super("viewResults");
     setBounds(200, 100, 500, 450);
     JTabbedPane t1 =new JTabbedPane();
     t1.setBounds(0, 0, 500, 450);
   JPanel p1=new JPanel();
   p1.setLayout(null);
   setLayout(new BorderLayout(10, 10));
   JLabel l1=new JLabel("Get results");
   l1.setForeground(Color.blue);
  l1.setFont(new Font("Default",Font.BOLD,20));
  l1.setBounds(200, 0, 200, 100);
  p1.add(l1);
  JLabel l3=new JLabel("Name");
  l3.setBounds(70, 100, 100, 22);
  l3.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l3);
   t2=new JTextField();
   t2.setBounds(170,100, 200, 22);
    p1.add(t2);
    JLabel l4=new JLabel("Roll No.");
  l4.setBounds(70, 150, 100, 22);
  l4.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l4);
   JTextField t3=new JTextField();
   t3.setBounds(170,150, 200, 22);
    p1.add(t3);
    JLabel l5=new JLabel("Email ID");
  l5.setBounds(70, 200, 100, 22);
  l5.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l5);
   JTextField t4=new JTextField();
   t4.setBounds(170,200, 200, 22);
    p1.add(t4); 
 
  b1=new JButton("Get Results");
    b1.setBounds(100, 300, 150, 40);
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
             String s=t3.getText();
                new viewMarks(s).setVisible(true);
              setVisible(false);
        }
    
    
    });
    p1.add(b1);
     b2=new JButton("Exit");
     
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
    b2.setBounds(260, 300, 150, 40);
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    
    p1.add(b2);
  t1.add("Book Room",p1);
   add(t1);
   
   
   
    }

    

    
    

        
    }

