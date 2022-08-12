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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;

public class AddMarks extends JFrame implements ActionListener{
	
	private JTextField rollno;
	private JLabel lblRollNo;
	
	private JLabel lblSubjects;
	private JTextField subject1;
	private JTextField subject2;
	private JTextField subject3;
	private JTextField subject4;
	private JTextField subject5;

	private JLabel lblMarks;
	private JTextField marks1;
	private JTextField marks2;
	private JTextField marks3;
	private JTextField marks4;
	private JTextField marks5;
	
	private JLabel lblAddMarksImage;
	private JLabel lblGrade;
	
	private JButton btnCalculateGrade;
	private JButton btnUpdateMarks;
	private JButton resetButton;
	private JRadioButton rdbtnNewRadioButton;

	
	public AddMarks() {
		

        getContentPane().setBackground(new Color(255, 228, 225));
        getContentPane().setLayout(null);
        
        
        lblRollNo = new JLabel("ENTER ROLL NO. OF STUDENT");
        lblRollNo.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        lblRollNo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblRollNo.setHorizontalAlignment(SwingConstants.CENTER);
        lblRollNo.setFont(new Font("Menlo", Font.PLAIN, 14));
        lblRollNo.setBounds(27, 31, 218, 41);
        getContentPane().add(lblRollNo);
        
        rollno = new JTextField();
        rollno.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(245, 255, 250), new Color(245, 255, 250)));
        rollno.setHorizontalAlignment(SwingConstants.CENTER);
        rollno.setBackground(new Color(255, 255, 255));
        rollno.setColumns(10);
        rollno.setBounds(257, 31, 218, 41);
        getContentPane().add(rollno);
        
        
        lblSubjects = new JLabel("SUBJECTS");
        lblSubjects.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubjects.setHorizontalTextPosition(SwingConstants.CENTER);
        lblSubjects.setFont(new Font("Menlo", Font.PLAIN, 16));
        lblSubjects.setBounds(27, 84, 218, 41);
        getContentPane().add(lblSubjects);
        
        lblMarks = new JLabel("MARKS RECEIVED");
        lblMarks.setFont(new Font("Menlo", Font.PLAIN, 16));
        lblMarks.setHorizontalTextPosition(SwingConstants.CENTER);
        lblMarks.setHorizontalAlignment(SwingConstants.CENTER);
        lblMarks.setBounds(257, 84, 218, 41);
        getContentPane().add(lblMarks);
        
        
        subject1 = new JTextField();
        subject1.setHorizontalAlignment(SwingConstants.CENTER);
        subject1.setColumns(10);
        subject1.setBackground(new Color(255, 248, 220));
        subject1.setBounds(27, 137, 218, 41);
        getContentPane().add(subject1);
        
        subject2 = new JTextField();
        subject2.setHorizontalAlignment(SwingConstants.CENTER);
        subject2.setBackground(new Color(255, 248, 220));
        subject2.setBounds(27, 183, 218, 41);
        getContentPane().add(subject2);
        subject2.setColumns(10);
        

        subject3 = new JTextField();
        subject3.setHorizontalAlignment(SwingConstants.CENTER);
        subject3.setBackground(new Color(255, 248, 220));
        subject3.setBounds(27, 236, 218, 41);
        getContentPane().add(subject3);
        subject3.setColumns(10);
        
        subject4 = new JTextField();
        subject4.setHorizontalAlignment(SwingConstants.CENTER);
        subject4.setBackground(new Color(255, 248, 220));
        subject4.setBounds(27, 289, 218, 41);
        getContentPane().add(subject4);
        subject4.setColumns(10);
        
        subject5 = new JTextField();
        subject5.setHorizontalAlignment(SwingConstants.CENTER);
        subject5.setBackground(new Color(255, 248, 220));
        subject5.setBounds(27, 342, 218, 41);
        getContentPane().add(subject5);
        subject5.setColumns(10);
      
        
        marks1 = new JTextField();
        marks1.setHorizontalAlignment(SwingConstants.CENTER);
        marks1.setColumns(10);
        marks1.setBackground(new Color(230, 230, 250));
        marks1.setBounds(257, 137, 218, 41);
        getContentPane().add(marks1);
        
        marks2 = new JTextField();
        marks2.setHorizontalAlignment(SwingConstants.CENTER);
        marks2.setBackground(new Color(230, 230, 250));
        marks2.setColumns(10);
        marks2.setBounds(257, 183, 218, 41);
        getContentPane().add(marks2);
        
        marks3 = new JTextField();
        marks3.setHorizontalAlignment(SwingConstants.CENTER);
        marks3.setBackground(new Color(230, 230, 250));
        marks3.setColumns(10);
        marks3.setBounds(257, 236, 218, 41);
        getContentPane().add(marks3);
        
        marks4 = new JTextField();
        marks4.setHorizontalAlignment(SwingConstants.CENTER);
        marks4.setBackground(new Color(230, 230, 250));
        marks4.setColumns(10);
        marks4.setBounds(257, 289, 218, 41);
        getContentPane().add(marks4);
        
        marks5 = new JTextField();
        marks5.setHorizontalAlignment(SwingConstants.CENTER);
        marks5.setBackground(new Color(230, 230, 250));
        marks5.setColumns(10);
        marks5.setBounds(257, 342, 218, 41);
        getContentPane().add(marks5);
      
        
        btnUpdateMarks = new JButton("ADD/UPDATE MARKS");
        btnUpdateMarks.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    
                   conn c1 = new conn();

	                
	                String s2 = "insert into marks values('"+rollno.getText()+"','"+subject1.getText()+"','"+marks1.getText()+"','"+subject2.getText()+"','"+marks2.getText()+"','"+subject3.getText()+"','"+marks3.getText()+"','"+subject4.getText()+"','"+marks4.getText()+"','"+subject5.getText()+"','"+marks5.getText()+"')";
                    try {
                        c1.s.executeUpdate(s2);
                    } catch (SQLException ex) {
                        Logger.getLogger(AddMarks.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            JOptionPane.showMessageDialog(null,"Marks Updated!");
	                setVisible(false);  
                }  
                });
                
        	
     
        btnUpdateMarks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateMarks.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250), new Color(192, 192, 192), new Color(192, 192, 192)));
        btnUpdateMarks.setFont(new Font("Menlo", Font.PLAIN, 16));
        btnUpdateMarks.setBackground(new Color(255, 228, 225));
        btnUpdateMarks.setBounds(140, 448, 218, 41);
        getContentPane().add(btnUpdateMarks);
        
        
        btnCalculateGrade = new JButton("CALCULATE GPA\n");
        btnCalculateGrade.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		double m1, m2, m3, m4, m5;
        		
        		m1 = Double.parseDouble(marks2.getText());
        		m2 = Double.parseDouble(marks3.getText());
        		m3 = Double.parseDouble(marks4.getText());
        		m4 = Double.parseDouble(marks5.getText());
        		m5 = Double.parseDouble(marks1.getText());
        		
        		double grade = ((m1+m2+m3+m4+m5)/50);
        	
       			 lblGrade.setText(Double.toString(grade));
       			
        	}
        });
        btnCalculateGrade.setOpaque(true);
        btnCalculateGrade.setFont(new Font("Menlo", Font.PLAIN, 14));
        btnCalculateGrade.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250), new Color(192, 192, 192), new Color(192, 192, 192)));
        btnCalculateGrade.setBackground(new Color(255, 248, 220));
        btnCalculateGrade.setBounds(27, 395, 218, 41);
        getContentPane().add(btnCalculateGrade);
        
        lblGrade = new JLabel("-");
        lblGrade.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        lblGrade.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), null, null, null));
        lblGrade.setFont(new Font("Menlo", Font.PLAIN, 16));
        lblGrade.setOpaque(true);
        lblGrade.setHorizontalTextPosition(SwingConstants.CENTER);
        lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
        lblGrade.setBackground(new Color(230, 230, 250));
        lblGrade.setBounds(257, 395, 218, 41);
        getContentPane().add(lblGrade);
       
        
        lblAddMarksImage = new JLabel("");
        lblAddMarksImage.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\addmarks.png"));
        lblAddMarksImage.setBounds(433, -13, 438, 615);
        getContentPane().add(lblAddMarksImage);
        
        resetButton = new JButton("RESET ALL");
        resetButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		subject1.setText(null);
        		subject2.setText(null);
        		subject3.setText(null);
        		subject4.setText(null);
        		subject5.setText(null);
        		
        		marks1.setText(null);
        		marks2.setText(null);
        		marks3.setText(null);
        		marks4.setText(null);
        		marks5.setText(null);
        		
        		rollno.setText(null);
        		
        		lblGrade.setText(null);
        		
        	}
        });
        resetButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(255, 248, 220), new Color(255, 248, 220)));
        resetButton.setHorizontalTextPosition(SwingConstants.CENTER);
        resetButton.setFont(new Font("Menlo", Font.PLAIN, 13));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.setBounds(189, 501, 117, 29);
        getContentPane().add(resetButton);
        
        
        
		
		setTitle("ADD/ UPDATE MARKS");
		
		setResizable(false);
		setBounds(200, 100, 850, 570);

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
               
               
		 try{
	            if(e.getSource() == btnUpdateMarks){
	               
	                
	               
	                
	                

	            }
	        }catch(Exception ex){}
		
	}
}
