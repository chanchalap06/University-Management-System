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
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.Component;
import java.sql.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.Component;


public class Login  extends JFrame implements ActionListener{
	private JTextField txtUsername;
	private JPasswordField passwordField;

	
	public Login(String log,JFrame p) {
        super("Shiv Nadar University");
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setBounds(91, 210, 63, 18);
		lblNewLabel.setFont(new Font("Menlo", Font.BOLD, 15));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(91, 289, 72, 18);
		lblNewLabel_1.setFont(new Font("Menlo", Font.BOLD, 12));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		getContentPane().add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(171, 191, 220, 57);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtUsername.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtUsername.setBorder(new CompoundBorder());
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setBounds(171, 441, 172, 57);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\key.png"));
		btnNewButton.setText("LOG IN");
		btnNewButton.setOpaque(true);
		btnNewButton.setToolTipText("");
		btnNewButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 165, 0));
		btnNewButton.setBackground(new Color(135, 206, 235));
		getContentPane().add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
		rdbtnNewRadioButton.setBounds(171, 332, 152, 39);
		rdbtnNewRadioButton.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\eye_open.png"));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				rdbtnNewRadioButton.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\eye_closed.png"));}
			
			if(!rdbtnNewRadioButton.isSelected()) {
				passwordField.setEchoChar('●');
		    	rdbtnNewRadioButton.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\eye_open.png"));}
			}
			
			
		});
		rdbtnNewRadioButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		rdbtnNewRadioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(399, 191, 57, 57);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\human.png"));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(399, 270, 57, 57);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\lock.png"));
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Forgot Password?");
		btnNewButton_1.setBounds(171, 402, 172, 29);
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 270, 220, 57);
		passwordField.setFont(new Font("Menlo", Font.PLAIN, 13));
		passwordField.setBorder(new CompoundBorder());
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(91, 50, 113, 113);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ilaan\\Desktop\\Project\\src\\project\\icons\\faculty.png"));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("LOGIN");
		lblNewLabel_5.setBounds(206, -389, 1000, 972);
		lblNewLabel_5.setFont(new Font("Menlo", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_5.setForeground(new Color(135, 206, 235));
	    getContentPane().add(lblNewLabel_5);
            
	    
		
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					Boolean status = false;
					try {
						conn con = new conn();
						String sql = "select * from "+ log +" where username=? and password=?";
						PreparedStatement st = con.c.prepareStatement(sql);
						
						st.setString(1, txtUsername.getText());
						st.setString(2, passwordField.getText());
						
						ResultSet rs = st.executeQuery();
						if(rs.next()) {
							
							 p.setVisible(true);
                                                        setVisible(false);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Login");
						}
						
					}
					catch(Exception e2){
						System.out.println(e2);
					}
				}
			}
		});
		getContentPane().setBackground(new Color(255, 228, 181));

	        setVisible(true);
	        setSize(550,550);
	        setLocation(100,100);
	}
      private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

