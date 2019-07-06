package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import javafx.scene.control.PasswordField;

import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		ImageIcon logo = new ImageIcon(this.getClass().getResource("/delivery2-512.png"));
		frame.setIconImage(logo.getImage());
		frame.setBounds(100, 100, 675, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		image1 = new ImageIcon (this.getClass().getResource("/new.png")) ;
		
		JLabel lblUsername = new JLabel("ID number  :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(22, 166, 130, 33);
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
		JLabel registerLabel = new JLabel(">>No Account ? Create one ");
		Border greyBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
		registerLabel.setBorder(greyBorder);
		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Border borderLabel = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE);
				registerLabel.setBorder(borderLabel);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				registerLabel.setBorder(greyBorder);
			}
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterPage repage = new RegisterPage();
				repage.setVisible(true);
				
			}
		});
		registerLabel.setForeground(Color.BLUE);
		registerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerLabel.setBounds(154, 400, 216, 26);
		frame.getContentPane().add(registerLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 211, 206, 33);
		frame.getContentPane().add(passwordField);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(image1);
		lblNewLabel.setBounds(372, 44, 285, 382);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblIncorrectEmailOr = new JLabel("Incorrect Email or Password.");
		lblIncorrectEmailOr.setVisible(false);
		lblIncorrectEmailOr.setForeground(Color.RED);
		lblIncorrectEmailOr.setBackground(Color.WHITE);
		lblIncorrectEmailOr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIncorrectEmailOr.setBounds(165, 322, 205, 16);
		frame.getContentPane().add(lblIncorrectEmailOr);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		JLabel lblEmpty = new JLabel("Empty!");
		lblEmpty.setForeground(Color.RED);
		lblEmpty.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmpty.setBounds(365, 164, 77, 41);
		lblEmpty.setVisible(false);
		frame.getContentPane().add(lblEmpty);
		JLabel lblEmpty_1 = new JLabel("Empty!");
		lblEmpty_1.setForeground(Color.RED);
		lblEmpty_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmpty_1.setBounds(365, 212, 63, 26);
		lblEmpty_1.setVisible(false);
		frame.getContentPane().add(lblEmpty_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblEmpty.setVisible(false);
				lblEmpty_1.setVisible(false);
				textField.setBorder(new JTextField().getBorder());
				passwordField.setBorder(new JTextField().getBorder());
				String password = new String (passwordField.getPassword());
				if(textField.getText().isEmpty() || password.isEmpty()) {
					
					if(textField.getText().isEmpty()) {
					Border border = BorderFactory.createLineBorder(Color.RED,1);
					textField.setBorder(border);
					lblEmpty.setVisible(true);
					}
					if(password.isEmpty()) {
						Border border1 = BorderFactory.createLineBorder(Color.RED,1);
						passwordField.setBorder(border1);
						lblEmpty_1.setVisible(true);
					}
				}
				else if(!textField.getText().equals("Admin") || !password.equals("Admin")) {
				lblIncorrectEmailOr.setVisible(true);
				}
				else if(textField.getText().equals("Admin") && password.equals("Admin")) {
					Homepage home = new Homepage();
					home.setVisible(true);
					frame.dispose();
				}
			}
		});
		ImageIcon image4=new ImageIcon(this.getClass().getResource("/log.png"));
		JLabel lblDasd = new JLabel("");
		lblDasd.setIcon(image4);
		lblDasd.setBounds(60, 45, 272, 59);
		frame.getContentPane().add(lblDasd);
		frame.setLocationRelativeTo(null);
		ImageIcon image3 = new ImageIcon(this.getClass().getResource("/a1.jpg"));
		btnNewButton.setBounds(207, 268, 115, 41);
		frame.getContentPane().add(btnNewButton);
		JLabel lim = new JLabel ("");
		lim.setBounds(0, 0,	675, 473);
		lim.setIcon(image3);
		frame.getContentPane().add(lim);
		frame.setResizable(false);
		frame.getRootPane().setDefaultButton(btnNewButton);
		

	}
	public JFrame getJframe() {
		return frame;
	}
}
