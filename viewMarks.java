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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewMarks extends JFrame{

   JTextArea t1;
   JPanel p1;
   
   
   viewMarks(String str){
       setSize(500,400);
       setLayout(new BorderLayout());
       
       p1 = new JPanel();

       t1 = new JTextArea(50,15);
       t1.setEnabled(false);
       t1.setDisabledTextColor(Color.blue);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(jsp,"Center");
       
       setLocation(200,100);
       mark(str);
   }
   
   public void mark(String s){
    try{
           conn c = new conn();
           
           t1.setText("\tResult of Examination\n\nSubject\n");
           
           ResultSet rs1 = c.s.executeQuery("select * from marks where rollno="+s);
           
           if(rs1.next()){
               t1.append("\n\t"+rs1.getString("Subject1"));
               t1.append("\n\t"+rs1.getString("Subject2"));
               t1.append("\n\t"+rs1.getString("Subject3"));
               t1.append("\n\t"+rs1.getString("Subject4"));
               t1.append("\n\t"+rs1.getString("Subject5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }
           
           ResultSet rs2 = c.s.executeQuery("select * from marks where rollno="+s);
           
           if(rs2.next()){
               t1.append("\nMarks\n\n\t"+rs2.getString("Marks1"));
               t1.append("\n\t"+rs2.getString("Marks2"));
               t1.append("\n\t"+rs2.getString("Marks3"));
               t1.append("\n\t"+rs2.getString("Marks4"));
               t1.append("\n\t"+rs2.getString("Marks5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }
         
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   
}
