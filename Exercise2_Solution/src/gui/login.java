package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon image1;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Delivery");
		
		frame.setBounds(100, 100, 675, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		image1 = new ImageIcon (this.getClass().getResource("/new.png")) ;
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(27, 166, 115, 33);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(34, 212, 108, 26);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(154, 165, 206, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 211, 206, 33);
		frame.getContentPane().add(passwordField);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(image1);
		lblNewLabel.setBounds(372, 44, 285, 382);
		frame.getContentPane().add(lblNewLabel);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ImageIcon image4=new ImageIcon(this.getClass().getResource("/log.png"));
		JLabel lblDasd = new JLabel("");
		lblDasd.setIcon(image4);
		lblDasd.setBounds(60, 45, 272, 59);
		frame.getContentPane().add(lblDasd);
		frame.setLocation(600, 250);
		ImageIcon image3 = new ImageIcon(this.getClass().getResource("/a1.jpg"));
		btnNewButton.setBounds(207, 268, 115, 41);
		frame.getContentPane().add(btnNewButton);
		JLabel lim = new JLabel ("");
		lim.setBounds(0, 0,	675, 473);
		lim.setIcon(image3);
		frame.getContentPane().add(lim);
		
		
		

		

	}
}
