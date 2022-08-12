/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author ilaan
 */
public class Hostel extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4;
    JComboBox c1,c2;
    JTextField t2,n1,t3,r1;
    Hostel(){
    super("Hostel");
     setBounds(200, 100, 1000, 450);
     JTabbedPane t1 =new JTabbedPane();
     JTabbedPane k=new JTabbedPane();
     t1.setBounds(0, 0, 500, 450);
   JPanel p1=new JPanel();
   JPanel p2=new JPanel();
   p1.setLayout(null);
   p2.setLayout(null);
   setLayout(new BorderLayout(10, 10));
   JLabel l1=new JLabel("Book Room");
   l1.setForeground(Color.blue);
  l1.setFont(new Font("Default",Font.BOLD,20));
  l1.setBounds(200, 0, 200, 100);
  p1.add(l1);
  JLabel k1=new JLabel("Find room");
   k1.setForeground(Color.blue);
  k1.setFont(new Font("Default",Font.BOLD,20));
  k1.setBounds(200, 0, 200, 100);
  p2.add(k1);
  JLabel l3=new JLabel("Name");
  l3.setBounds(70, 100, 100, 22);
  l3.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l3);
  JLabel n=new JLabel("Name");
  n.setBounds(70, 100, 100, 40);
  n.setFont(new Font("Default",Font.BOLD,15));
  p2.add(n);
   t2=new JTextField();
   t2.setBounds(170,100, 200, 22);
    p1.add(t2);
    n1=new JTextField();
   n1.setBounds(170,100, 200, 40);
    p2.add(n1);
    JLabel l4=new JLabel("Roll No.");
  l4.setBounds(70, 150, 100, 22);
  l4.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l4);
   JLabel r=new JLabel("Roll No.");
  r.setBounds(70, 150, 100, 40);
  r.setFont(new Font("Default",Font.BOLD,15));
  p2.add(r);
    t3=new JTextField();
   t3.setBounds(170,150, 200, 22);
    p1.add(t3);
     r1=new JTextField();
   r1.setBounds(170,150, 200, 40);
    p2.add(r1);
    JLabel l5=new JLabel("Email ID");
  l5.setBounds(70, 200, 100, 22);
  l5.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l5);
   JTextField t4=new JTextField();
   t4.setBounds(170,200, 200, 22);
    p1.add(t4);
    JLabel l6=new JLabel("Gender");
  l6.setBounds(70, 250, 100, 22);
  l6.setFont(new Font("Default",Font.BOLD,15));
  p1.add(l6);
  String arr[]={"Male","Female"};
  c1=new JComboBox(arr);
  c1.setBounds(170,250, 200, 22);
  c1.setSelectedIndex(-1);
    p1.add(c1);
    JLabel g=new JLabel("Gender");
  g.setBounds(70, 200, 100, 40);
  g.setFont(new Font("Default",Font.BOLD,15));
  p2.add(g);
  
  c2=new JComboBox(arr);
  c2.setBounds(170,200, 200, 40);
  c2.setSelectedIndex(-1);
    p2.add(c2);
  b1=new JButton("Book Room");
    b1.setBounds(100, 300, 150, 40);
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    b1.addActionListener(this);
    p1.add(b1);
     b2=new JButton("Exit");
    b2.setBounds(260, 300, 150, 40);
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    b2.addActionListener(this);
    p1.add(b2);
    b3=new JButton("Find room");
    b3.setBounds(100, 300, 150, 40);
    b3.setBackground(Color.black);
    b3.setForeground(Color.white);
    b3.addActionListener(this);
    p2.add(b3);
     b4=new JButton("Exit");
    b4.setBounds(260, 300, 150, 40);
    b4.setBackground(Color.black);
    b4.setForeground(Color.white);
    b4.addActionListener(this);
    p2.add(b4);
  t1.add("Book Room",p1);
  t1.add("Find room",p2);
   add(t1);
   
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project\\icons\\room.PNG"));
   Image i2=i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
  JLabel l2=new JLabel();
  
  l2.setIcon(i3);
  add(l2,BorderLayout.EAST);
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           if(e.getSource()==b1){
           try{
           conn c=new conn();
           String gender=(String)c1.getSelectedItem();
       
        String rollno=t3.getText();
           if(gender.equals("Male"))gender="boysHostel";
           else gender="girlsHostel";
           ResultSet rs=c.s.executeQuery("select * from "+gender);
           while(rs.next()){
           String status=rs.getString("status");
           if(status.equals("closed"))continue;
           else {
           String p1=rs.getString("Person1");
           if(p1.equals("empty")){
           String name=t2.getText();
           String room=rs.getString("room");
           c.p.executeUpdate("UPDATE "+gender+ " SET Person1='"+name+"' where room="+room);
           c.q.executeUpdate("UPDATE "+gender+ " SET Person1rollno='"+rollno+"' where room="+room);
           }
           else{
           String name=t2.getText();
           String room=rs.getString("room");
           String per1=rs.getString("Person1");
          c.r.executeUpdate("UPDATE "+gender+ " SET Person2='"+name+"' where room="+room);
          c.s.executeUpdate("UPDATE "+gender+ " SET Person2rollno='"+rollno+"' where room="+room);
          c.t.executeUpdate("UPDATE "+gender+ " SET status='closed' where room="+room);
           }
           JOptionPane.showMessageDialog(null, "Room Booked successfully ");
           break;
           }
           }
           
           
           }catch(Exception e2){System.out.println(e2); }
           
           
           }
           if(e.getSource()==b2)setVisible(false);
           if(e.getSource()==b3){
           try{
           conn c=new conn();
           String gender=(String)c2.getSelectedItem();
            String name=n1.getText();
        String rollno=r1.getText();
           if(gender.equals("Male"))gender="boysHostel";
           else gender="girlsHostel";
           ResultSet rs=c.s.executeQuery("select * from "+gender);
           int count=0;
           while(rs.next()){
           String p1=rs.getString("Person1");
           String p1r=rs.getString("Person1rollno");
           String p2=rs.getString("Person2");
           String p2r=rs.getString("Person2rollno");
           if((p1.equals(name)&& p1r.equals(rollno))|| (p2.equals(name)&& p2r.equals(rollno))){ String room=rs.getString("room");JOptionPane.showMessageDialog(null, "You are in room "+room);count+=1;break;}
           else continue; 
           }
           if(count==0)JOptionPane.showMessageDialog(null, "You are not in any room");
           }catch(Exception e3){System.out.println(e3); }
           } if(e.getSource()==b4)setVisible(false);
       }catch(Exception e1){System.out.println(e1); }
           }
    
}
