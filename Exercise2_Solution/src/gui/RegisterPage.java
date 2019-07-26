package gui;
import Utils.Constants;
import Utils.E_Cities;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import gui.Datei;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Conotroller.SysData;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Address;
import Model.Receiver;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	E_Cities[] allCities ;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private static DateFormat df;
	private static DateFormat dtf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		this.setTitle("Registeration Page");
		this.setIconImage(new ImageIcon(this.getClass().getResource("/delivery2-512.png")).getImage());
		allCities = Utils.E_Cities.values();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 473, 703);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID number :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(31, 47, 109, 21);
		panel.add(lblNewLabel);
		
		JLabel lblRegisterPageFor = new JLabel("Register Page for recievers");
		lblRegisterPageFor.setForeground(Color.BLUE);
		lblRegisterPageFor.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblRegisterPageFor.setBounds(31, 13, 215, 21);
		panel.add(lblRegisterPageFor);
		JLabel wrongIdVal = new JLabel("Only Numbers!");
		wrongIdVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wrongIdVal.setForeground(Color.RED);
		wrongIdVal.setBounds(332, 50, 102, 16);
		panel.add(wrongIdVal);
		wrongIdVal.setVisible(false);
		textField = new HintTextField("Only Digits");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				try {
					int i = Integer.parseInt(textField.getText());
					wrongIdVal.setVisible(false);
				}
				catch(NumberFormatException e) {
					wrongIdVal.setVisible(true);
				}
			}
		});
		textField.setBounds(152, 44, 172, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFirstName.setBounds(31, 96, 109, 21);
		panel.add(lblFirstName);
		
		textField_1 = new HintTextField("Enter your name");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(152, 93, 172, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLastName.setBounds(31, 150, 109, 21);
		panel.add(lblLastName);
		
		textField_2 = new HintTextField("Enter your last name");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(152, 147, 172, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(52, 213, 88, 21);
		panel.add(lblEmail);
		
		textField_3 = new HintTextField("email@hotmail.com");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(152, 210, 172, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("Birthdate :");
		lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBirthdate.setBounds(31, 318, 109, 21);
		panel.add(lblBirthdate);
		
		textField_4 = new HintTextField("dd/mm/yyyy");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(152, 316, 172, 29);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCity.setBounds(52, 378, 60, 21);
		panel.add(lblCity);
		
		JComboBox comboBox = new JComboBox(allCities);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(152, 379, 172, 22);
		panel.add(comboBox);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStreet.setBounds(52, 430, 88, 16);
		panel.add(lblStreet);
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(29, 270, 94, 21);
		panel.add(lblPassword);
		textField_5 = new HintTextField("Enter street name");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(152, 426, 172, 29);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House Number :");
		lblHouseNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHouseNumber.setBounds(12, 491, 138, 16);
		panel.add(lblHouseNumber);
		JLabel label = new JLabel("8 - 16 digits");
		label.setForeground(Color.RED);
		label.setBounds(332, 274, 94, 16);
		panel.add(label);
		label.setVisible(false);
		textField_6 = new HintTextField("Only numbers");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(152, 487, 172, 29);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblZipCode = new JLabel("ZIP Code :");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZipCode.setBounds(31, 550, 109, 16);
		panel.add(lblZipCode);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(152, 268, 172, 28);
		panel.add(passwordField);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(152, 545, 80, 29);
		panel.add(textField_7);
		textField_7.setColumns(10);
		JLabel emptyFieldLabel = new JLabel("There is an empty Field!");
		emptyFieldLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		emptyFieldLabel.setForeground(Color.RED);
		emptyFieldLabel.setBounds(141, 650, 204, 21);
		panel.add(emptyFieldLabel);
		emptyFieldLabel.setVisible(false);
		JLabel exceptionLabel1 = new JLabel("");
		exceptionLabel1.setForeground(Color.RED);
		exceptionLabel1.setBounds(78, 650, 356, 16);
		panel.add(exceptionLabel1);
		exceptionLabel1.setVisible(false);
		JLabel zipLabel = new JLabel("Wrong ZIP Code");
		zipLabel.setForeground(Color.RED);
		zipLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zipLabel.setBounds(244, 552, 109, 16);
		panel.add(zipLabel);
		zipLabel.setVisible(false);
		JLabel housenumberLabel = new JLabel("Wrong number format");
		housenumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		housenumberLabel.setForeground(Color.RED);
		housenumberLabel.setBounds(330, 492, 143, 16);
		panel.add(housenumberLabel);
		housenumberLabel.setVisible(false);
		JLabel emailLabel = new JLabel("Wrong email format");
		emailLabel.setForeground(Color.RED);
		emailLabel.setBounds(332, 217, 131, 16);
		panel.add(emailLabel);
		emailLabel.setVisible(false);
		JLabel birthLabel = new JLabel("Invalid birthdate");
		birthLabel.setForeground(Color.RED);
		birthLabel.setBounds(330, 322, 102, 16);
		panel.add(birthLabel);
		birthLabel.setVisible(false);
		JLabel lblMinimumAgeAllowed = new JLabel("Minimum age allowed is 12");
		lblMinimumAgeAllowed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMinimumAgeAllowed.setForeground(Color.RED);
		lblMinimumAgeAllowed.setBounds(141, 650, 196, 21);
		panel.add(lblMinimumAgeAllowed);
		JLabel lblTheGivenId = new JLabel("The given ID does already exist in our system !");
		lblTheGivenId.setForeground(Color.RED);
		lblTheGivenId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheGivenId.setBounds(12, 653, 345, 21);
		panel.add(lblTheGivenId);
		JLabel lblIdMustBe = new JLabel("ID must be 9 digits !");
		lblIdMustBe.setForeground(Color.RED);
		lblIdMustBe.setBounds(332, 51, 131, 16);
		panel.add(lblIdMustBe);
		lblIdMustBe.setVisible(false);
		lblTheGivenId.setVisible(false);
		lblMinimumAgeAllowed.setVisible(false);
		JButton registerButton = new JButton("Register");
		Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exceptionLabel1.setVisible(false);
				lblIdMustBe.setVisible(false);
				zipLabel.setVisible(false);
				housenumberLabel.setVisible(false);
				emailLabel.setVisible(false);
				birthLabel.setVisible(false);
				label.setVisible(false);
				lblTheGivenId.setVisible(false);
				lblMinimumAgeAllowed.setVisible(false);
				textField.setBorder(new JTextField().getBorder());
				textField_2.setBorder(new JTextField().getBorder());
				textField_1.setBorder(new JTextField().getBorder());
				textField_3.setBorder(new JTextField().getBorder());
				textField_4.setBorder(new JTextField().getBorder());
				textField_5.setBorder(new JTextField().getBorder());
				textField_6.setBorder(new JTextField().getBorder());
				textField_7.setBorder(new JTextField().getBorder());
				passwordField.setBorder(new JPasswordField().getBorder());
				emptyFieldLabel.setVisible(false);
				if(textField.getText().equals("Only Digits") || textField_1.getText().equals("Enter your name") || textField_2.getText().equals("Enter your last name") || textField_3.getText().equals("email@hotmail.com") ||
						textField_4.getText().equals("dd/mm/yyyy") || textField_5.getText().equals("Enter street name") || textField_6.getText().equals("Only numbers") || textField_7.getText().isEmpty() || passwordField.getPassword().length==0) {
			
					if(textField.getText().isEmpty() || textField.getText().equals("Only Digits")) {
					textField.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_1.getText().isEmpty() || textField_1.getText().equals("Enter your name")) {
					textField_1.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_2.getText().isEmpty() || textField_2.getText().equals("Enter your last name")) {
					textField_2.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_3.getText().isEmpty() || textField_3.getText().equals("email@hotmail.com")) {
					textField_3.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(passwordField.getPassword().length == 0) {
					passwordField.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);
					
				}
				if(textField_4.getText().isEmpty() || textField_4.getText().equals("dd/mm/yyyy")) {
					textField_4.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_5.getText().isEmpty() || textField_5.getText().equals("Enter street name")) {
					textField_5.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_6.getText().isEmpty() || textField_6.getText().equals("Only numbers")) {
					textField_6.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_7.getText().isEmpty()) {
					textField_7.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				}
				else if(!textField.getText().matches("[0-9]+")) {
					wrongIdVal.setVisible(true);
				}
				else if(textField.getText().length() != 9 ) {
					lblIdMustBe.setVisible(true);
				}
				else if(!textField_1.getText().matches("^[a-zA-Z]*$") || !textField_2.getText().matches("^[a-zA-Z]*$"))
					try {
					throw new OnlyLettersException ( "Firstname or Lastname should be written only in letters ");
					}catch(OnlyLettersException ex) {
						exceptionLabel1.setText(ex.getMessage());
						exceptionLabel1.setVisible(true);
					}
				else if (!checkEmailIsValid(textField_3.getText())) {
					emailLabel.setVisible(true);
				}
				else if(passwordField.getPassword().length < 8 || passwordField.getPassword().length > 16) {
						label.setVisible(true);
				}
				else if(textField_4.getText().length()!=10 || !checkValidDate(textField_4.getText())||!textField_4.getText().matches("[0-3]\\d/[01]\\d/\\d{4}")) {
					birthLabel.setVisible(true);
				}
				else if(textField_4.getText().length()==10 && Integer.parseInt(textField_4.getText().substring(6, 10)) > Datei.MAX_VALID_YR-12) {
					lblMinimumAgeAllowed.setVisible(true);
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_4.setBorder(emptyBorder);
				}
				else if (!textField_7.getText().matches("[0-9]+") || textField_7.getText().length()!=7){
					zipLabel.setVisible(true);
				}
				else if (!textField_6.getText().matches("[0-9]+")){
					housenumberLabel.setVisible(true);

				}
				else {
					df = new SimpleDateFormat("dd/MM/yyyy");
					dtf = new SimpleDateFormat("dd/MM/yyyy");
					Date dd = null;
					 try {
						 dd =	dtf.parse(textField_4.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} String strDate = df.format(dd);
					      String password = String.valueOf(passwordField.getPassword());
					if(SysData.getInstance().addReceiver(Long.parseLong(textField.getText()), textField_1.getText(), textField_2.getText(), dd, new Address((E_Cities)comboBox.getSelectedItem(),textField_5.getText(),Integer.parseInt(textField_6.getText()),textField_7.getText()), textField_3.getText(),password)) { 
						JOptionPane.showMessageDialog(null, "Your Registeration is successfully done !","Successful" , 0,new ImageIcon(getClass().getResource("/correct.png")));
						dispose();
						System.out.println(SysData.getInstance().getReceiversMap());
						}
						else
							lblTheGivenId.setVisible(true);

				}
					
			}
		});
		registerButton.setBackground(Color.BLUE);
		registerButton.setForeground(Color.WHITE);
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		registerButton.setBounds(152, 610, 158, 41);
		panel.add(registerButton);
		ImageIcon imageicon = new ImageIcon(getClass().getResource("/regbackground.png"));
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 485, 703);
		panel.add(background);
		background.setIcon(imageicon);
		this.getRootPane().setDefaultButton(registerButton);
		
	
		
		
		
		
		
	
		
		
		
		this.setResizable(false);
	}
	// helpful method
	public boolean checkEmailIsValid(String email) {
		// TODO 
		char c;
		String length="";
		boolean serverCorrectness=false;
		int pos=0;
		if (email.isEmpty())
			return false;
		for (int i=0 ; i<email.length(); i++){
			c=email.charAt(i);
			if (i==0 && c=='@')
				return false;
			/*reach to position of the ending email name*/
			else if (c=='@') {
				pos=i;
				break;
			}
		}
		/*inValid email*/
		if (pos==0) return false;
		else
		{
			/*Getting the server name*/
			String server=email.substring(pos+1,email.indexOf("."));
			for (String allow : Constants.ALLOWED_SERVER )
				if (server.equals(allow)){
					length=allow;
					serverCorrectness=true;
					break;
				}
			/*check if server match with one of the allowed option*/
			if (!serverCorrectness)return false;
			/*Check ending*/
			serverCorrectness=false;
			String end=email.substring(pos+1+length.length()+1, email.length());
			for (String allow : Constants.ALLOWED_ENDING_EMAIL )
				if (end.equals(allow)){
					serverCorrectness=true;
					break;
				}
			if (!serverCorrectness)return false;
		}
		return true;
	}
	
	public boolean checkValidDate(String date) {
		try {
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(3, 5));
		int year = Integer.parseInt(date.substring(6, 10));
		return Datei.isValidDate(day, month, year);
		}catch(Exception e) {
			return false;
		}
	}
}
