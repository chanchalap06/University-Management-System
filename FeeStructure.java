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
import java.util.logging.Level;
import java.util.logging.Logger;


public class FeeStructure extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    JComboBox cb1;
    JPanel p1;
    JFrame f1;
    FeeStructure(){
        super("Fee Payment");
        setBounds(200, 100, 1000, 450);
        JTabbedPane tab =new JTabbedPane();
        tab.setBounds(0, 0, 500, 450);
        JPanel p1=new JPanel();
        p1.setLayout(null);
         
        setLayout(new BorderLayout(10, 10));
        JLabel l1=new JLabel("Fee Payment Portal");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Default",Font.BOLD,20));
        l1.setBounds(200, 0, 200, 100);
        p1.add(l1);
        JLabel l2=new JLabel("Name of Student");
        l2.setBounds(40, 100, 200, 22);
        l2.setFont(new Font("Default",Font.BOLD,15));
        p1.add(l2);
        t1=new JTextField();
        t1.setBounds(170,100, 200, 22);
        p1.add(t1);
        JLabel l3=new JLabel("Year of Graduation"
                + "");
        l3.setBounds(30, 200, 200, 22);
        l3.setFont(new Font("Default",Font.BOLD,15));
         p1.add(l3);
        String arr[]={"2022", "2023", "2024", "2025"};
        cb1=new JComboBox(arr);
        cb1.setBounds(170,200, 200, 22);
        cb1.setSelectedIndex(-1);
        p1.add(cb1);
        JLabel l4=new JLabel("Roll No.");
        l4.setBounds(70, 150, 100, 22);
        l4.setFont(new Font("Default",Font.BOLD,15));
        p1.add(l4);
        t2 = new JTextField();
        t2.setBounds(170,150, 200, 22);
        p1.add(t2);
        JLabel l5 = new JLabel("Amount to pay");
        l5.setBounds(60,250,150,22);
        l5.setFont(new Font("Default",Font.BOLD,15));
        p1.add(l5);
        t3=new JTextField();
        t3.setBounds(170,250, 200, 22);
        p1.add(t3);
        b1=new JButton("Pay Fee");
        b1.setBounds(100, 300, 150, 40);
        b1.setFont(new Font("Helvetica",Font.BOLD,15));
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        p1.add(b1);
        b2=new JButton("Exit");
        b2.setBounds(260, 300, 150, 40);
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Helvetica",Font.BOLD,15));
        b2.addActionListener(this);
        p1.add(b2);
        b3 = new JButton("View payments");
        b3.setBounds(100,350,310,40);
        b3.setFont(new Font("Helvetica", Font.BOLD, 15));
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        p1.add(b3);
        tab.add("Fee Payment Portal",p1);
        add(tab);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project\\icons\\fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel();
        l6.setIcon(i3);
        add(l6,BorderLayout.EAST);
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        if(e.getSource()==b1)
        {
               String a = t2.getText();
               String b = t1.getText();
               conn c=new conn();
               String year=(String)cb1.getSelectedItem();  
            try {
                c.s.executeUpdate("insert into fees values("+ "'"+ a +"'" +","+ "'"+ b+"'"+","+"'"+ year+"'"+");");
            } catch (SQLException ex) {
                Logger.getLogger(FeeStructure.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Payment Successful! Details updated in database");
   
        }
        if(e.getSource()==b2)setVisible(false);
        if (e.getSource() == b3) {
            
            ViewPayment vpay = new ViewPayment();
            vpay.setVisible(true);
        }
        
    }
    
    }