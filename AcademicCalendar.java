/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author ilaan
 */
public class AcademicCalendar extends JFrame implements ActionListener{

	JPanel panel;
	
	JLabel calendar;
	JLabel choose;
	
	ButtonGroup group;
	JRadioButton monsoon2020;
	JRadioButton spring2021;
	JRadioButton monsoon2021;

	
	public AcademicCalendar() {

        getContentPane().setBackground(new Color(75, 0, 130));
        getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setBackground(new Color(204, 153, 204));
        panel.setBounds(6, 6, 838, 627);
        panel.setLayout(null);
        getContentPane().add(panel);
        

        calendar = new JLabel("ACADEMIC CALENDAR");
        calendar.setForeground(new Color(255, 255, 255));
        calendar.setFont(new Font("Menlo", Font.BOLD, 65));
        calendar.setOpaque(true);
        calendar.setBackground(new Color(216, 191, 216));
        calendar.setHorizontalTextPosition(SwingConstants.CENTER);
        calendar.setHorizontalAlignment(SwingConstants.CENTER);
        calendar.setBounds(6, 87, 826, 473);
        panel.add(calendar);
        
        
        choose = new JLabel("Choose the respective semester:");
        choose.setForeground(new Color(255, 255, 255));
        choose.setHorizontalAlignment(SwingConstants.CENTER);
        choose.setHorizontalTextPosition(SwingConstants.CENTER);
        choose.setFont(new Font("Menlo", Font.BOLD, 16));
        choose.setBounds(234, 6, 393, 33);
        panel.add(choose);
        
        
        group = new ButtonGroup();
        
        
        monsoon2020 = new JRadioButton("MONSOON 2020");
        monsoon2020.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(monsoon2020.isSelected()) {
        			calendar.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\academic_calendar_monsoon2020.png"));
        			calendar.setText(" ");
        		}
        	}
        });
        monsoon2020.setForeground(Color.black);
        monsoon2020.setFont(new Font("Menlo", Font.BOLD, 13));
        monsoon2020.setBounds(222, 51, 132, 24);
        monsoon2020.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        panel.add(monsoon2020);
        
        
        spring2021 = new JRadioButton("SPRING 2021");
        spring2021.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(spring2021.isSelected()) {
        			calendar.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\academic_calendar_spring2021.png"));
        			calendar.setText(" ");
        		}
        	}
        });
        spring2021.setFont(new Font("Menlo", Font.BOLD, 13));
        spring2021.setForeground(Color.black);
        spring2021.setBounds(359, 51, 120, 23);
        
        panel.add(spring2021);
        
        
        monsoon2021 = new JRadioButton("MONSOON 2021");
        monsoon2021.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(monsoon2021.isSelected()) {
        			calendar.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\academic_calendar_monsoon2021.png"));
        			calendar.setText(" ");
        		}
        	}
        });
        monsoon2021.setFont(new Font("Menlo", Font.BOLD, 13));
        monsoon2021.setForeground(Color.black);
        monsoon2021.setBounds(491, 51, 136, 23);
        panel.add(monsoon2021);
        
        
        group.add(monsoon2020);
        group.add(spring2021);
        group.add(monsoon2021);
        
        
       
		
		setTitle("ACADEMIC CALENDAR");
		
		setResizable(false);
		setSize(850,667);
        setLocation(100,100);

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

