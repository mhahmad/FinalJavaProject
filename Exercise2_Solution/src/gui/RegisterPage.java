package gui;
import Utils.Constants;
import Utils.E_Cities;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Receiver;
import javax.swing.DropMode;
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
		lblNewLabel.setBounds(31, 66, 109, 21);
		panel.add(lblNewLabel);
		
		JLabel lblRegisterPageFor = new JLabel("Register Page for recievers");
		lblRegisterPageFor.setForeground(Color.BLUE);
		lblRegisterPageFor.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblRegisterPageFor.setBounds(31, 13, 215, 21);
		panel.add(lblRegisterPageFor);
		JLabel wrongIdVal = new JLabel("Only Numbers!");
		wrongIdVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wrongIdVal.setForeground(Color.RED);
		wrongIdVal.setBounds(330, 70, 102, 16);
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
		textField.setBounds(152, 64, 172, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFirstName.setBounds(31, 126, 109, 21);
		panel.add(lblFirstName);
		
		textField_1 = new HintTextField("Enter your name");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(152, 124, 172, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLastName.setBounds(31, 190, 109, 21);
		panel.add(lblLastName);
		
		textField_2 = new HintTextField("Enter your last name");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(152, 188, 172, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(52, 255, 88, 21);
		panel.add(lblEmail);
		
		textField_3 = new HintTextField("email@hotmail.com");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(152, 253, 172, 29);
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
		
		textField_5 = new HintTextField("Enter street name");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(152, 426, 172, 29);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House Number :");
		lblHouseNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHouseNumber.setBounds(12, 491, 138, 16);
		panel.add(lblHouseNumber);
		
		textField_6 = new HintTextField("Only numbers");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(152, 487, 172, 29);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblZipCode = new JLabel("ZIP Code :");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZipCode.setBounds(31, 550, 109, 16);
		panel.add(lblZipCode);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(152, 545, 80, 29);
		panel.add(textField_7);
		textField_7.setColumns(10);
		JLabel emptyFieldLabel = new JLabel("There is an empty Field!");
		emptyFieldLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		emptyFieldLabel.setForeground(Color.RED);
		emptyFieldLabel.setBounds(162, 650, 138, 16);
		panel.add(emptyFieldLabel);
		emptyFieldLabel.setVisible(false);
		JLabel exceptionLabel1 = new JLabel("");
		exceptionLabel1.setForeground(Color.RED);
		exceptionLabel1.setBounds(83, 661, 356, 16);
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
		emailLabel.setBounds(330, 259, 131, 16);
		panel.add(emailLabel);
		emailLabel.setVisible(false);
		JLabel birthLabel = new JLabel("Invalid birthdate");
		birthLabel.setForeground(Color.RED);
		birthLabel.setBounds(330, 322, 102, 16);
		panel.add(birthLabel);
		birthLabel.setVisible(false);
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exceptionLabel1.setVisible(false);
				zipLabel.setVisible(false);
				housenumberLabel.setVisible(false);
				emailLabel.setVisible(false);
				birthLabel.setVisible(false);
				textField.setBorder(new JTextField().getBorder());
				textField_2.setBorder(new JTextField().getBorder());
				textField_1.setBorder(new JTextField().getBorder());
				textField_3.setBorder(new JTextField().getBorder());
				textField_4.setBorder(new JTextField().getBorder());
				textField_5.setBorder(new JTextField().getBorder());
				textField_6.setBorder(new JTextField().getBorder());
				textField_7.setBorder(new JTextField().getBorder());
				emptyFieldLabel.setVisible(false);

				if(textField.getText().isEmpty() || textField.getText().equals("Only Digits")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_1.getText().isEmpty() || textField_1.getText().equals("Enter your name")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_1.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_2.getText().isEmpty() || textField_2.getText().equals("Enter your last name")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_2.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_3.getText().isEmpty() || textField_3.getText().equals("email@hotmail.com")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_3.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_4.getText().isEmpty() || textField_4.getText().equals("dd/mm/yyyy")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_4.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_5.getText().isEmpty() || textField_5.getText().equals("Enter street name")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_5.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_6.getText().isEmpty() || textField_6.getText().equals("Only numbers")) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_6.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_7.getText().isEmpty()) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_7.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				else if(!textField.getText().matches("[0-9]+")) {
					wrongIdVal.setVisible(true);
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
				else if(textField_4.getText().length()!=10 || !checkValidDate(textField_4.getText())) {
					birthLabel.setVisible(true);
				}
				else if (!textField_7.getText().matches("[0-9]+") || textField_7.getText().length()!=7){
					zipLabel.setVisible(true);
				}
				else if (!textField_6.getText().matches("[0-9]+")){
					housenumberLabel.setVisible(true);

				}
				else {
					JOptionPane.showMessageDialog(null, "Your Registeration is successfully done !","Successful" , 0,new ImageIcon(getClass().getResource("/correct.png")));
					dispose();
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
		return Date.isValidDate(day, month, year);
		}catch(Exception e) {
			return false;
		}
	}
}
