package InternalFrames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Utils.Constants;
import Utils.E_Cities;
import gui.Datei;
import gui.HintTextField;
import gui.OnlyLettersException;
import javax.swing.JPasswordField;

public class AddReceiver extends JInternalFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReceiver frame = new AddReceiver();
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
	public AddReceiver() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 640, 850);
		allCities = Utils.E_Cities.values();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 13, 624, 814);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID number :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(31, 111, 109, 21);
		panel.add(lblNewLabel);
		
		JLabel lblRegisterPageFor = new JLabel("Register Page for recievers");
		lblRegisterPageFor.setForeground(Color.BLUE);
		lblRegisterPageFor.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblRegisterPageFor.setBounds(31, 13, 215, 21);
		panel.add(lblRegisterPageFor);
		JLabel wrongIdVal = new JLabel("Only Numbers!");
		wrongIdVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wrongIdVal.setForeground(Color.RED);
		wrongIdVal.setBounds(327, 114, 102, 16);
		panel.add(wrongIdVal);
		wrongIdVal.setVisible(false);
		textField = new JTextField();
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
		textField.setBounds(152, 108, 172, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFirstName.setBounds(31, 167, 109, 21);
		panel.add(lblFirstName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(152, 167, 172, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLastName.setBounds(31, 225, 109, 21);
		panel.add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(152, 222, 172, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(52, 280, 88, 21);
		panel.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(152, 277, 172, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("Birthdate :");
		lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBirthdate.setBounds(31, 404, 109, 21);
		panel.add(lblBirthdate);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(152, 401, 172, 29);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCity.setBounds(52, 463, 60, 21);
		panel.add(lblCity);
		
		JComboBox comboBox = new JComboBox(allCities);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(152, 463, 172, 22);
		panel.add(comboBox);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStreet.setBounds(52, 521, 88, 16);
		panel.add(lblStreet);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(152, 516, 172, 29);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House Number :");
		lblHouseNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHouseNumber.setBounds(12, 568, 138, 16);
		panel.add(lblHouseNumber);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(152, 563, 172, 29);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblZipCode = new JLabel("ZIP Code :");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZipCode.setBounds(31, 629, 109, 16);
		panel.add(lblZipCode);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(152, 624, 80, 29);
		panel.add(textField_7);
		textField_7.setColumns(10);
		JLabel emptyFieldLabel = new JLabel("There is an empty Field!");
		emptyFieldLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		emptyFieldLabel.setForeground(Color.RED);
		emptyFieldLabel.setBounds(164, 752, 138, 16);
		panel.add(emptyFieldLabel);
		emptyFieldLabel.setVisible(false);
		JLabel exceptionLabel1 = new JLabel("");
		exceptionLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exceptionLabel1.setForeground(Color.RED);
		exceptionLabel1.setBounds(31, 751, 409, 16);
		panel.add(exceptionLabel1);
		exceptionLabel1.setVisible(false);
		JLabel zipLabel = new JLabel("Wrong ZIP Code");
		zipLabel.setForeground(Color.RED);
		zipLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zipLabel.setBounds(244, 630, 109, 16);
		panel.add(zipLabel);
		zipLabel.setVisible(false);
		JLabel housenumberLabel = new JLabel("Wrong number format");
		housenumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		housenumberLabel.setForeground(Color.RED);
		housenumberLabel.setBounds(327, 570, 143, 16);
		panel.add(housenumberLabel);
		housenumberLabel.setVisible(false);
		JLabel emailLabel = new JLabel("Wrong email format");
		emailLabel.setForeground(Color.RED);
		emailLabel.setBounds(330, 284, 131, 16);
		panel.add(emailLabel);
		emailLabel.setVisible(false);
		JLabel birthLabel = new JLabel("Invalid birthdate");
		birthLabel.setForeground(Color.RED);
		birthLabel.setBounds(330, 408, 102, 16);
		panel.add(birthLabel);
		birthLabel.setVisible(false);
		JButton registerButton = new JButton("Register");
		JLabel lblPasswordLengthMust = new JLabel("Password length must be 8 or more");
		lblPasswordLengthMust.setForeground(Color.RED);
		lblPasswordLengthMust.setBounds(327, 345, 253, 16);
		panel.add(lblPasswordLengthMust);
		lblPasswordLengthMust.setVisible(false);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exceptionLabel1.setVisible(false);
				zipLabel.setVisible(false);
				housenumberLabel.setVisible(false);
				emailLabel.setVisible(false);
				birthLabel.setVisible(false);
				lblPasswordLengthMust.setVisible(false);
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
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() ||
						textField_4.getText().isEmpty() || textField_5.getText().isEmpty()|| textField_6.getText().isEmpty()|| textField_7.getText().isEmpty()) {
			
					if(textField.getText().isEmpty()) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_1.getText().isEmpty() ) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_1.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_2.getText().isEmpty() ) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_2.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_3.getText().isEmpty() ) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_3.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(passwordField.getPassword().length==0) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					passwordField.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);
				}
				if(textField_4.getText().isEmpty() ) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_4.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_5.getText().isEmpty()) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_5.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_6.getText().isEmpty()) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_6.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
				if(textField_7.getText().isEmpty()) {
					Border emptyBorder = BorderFactory.createLineBorder(Color.RED, 1);
					textField_7.setBorder(emptyBorder);
					emptyFieldLabel.setVisible(true);

				}
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
				else if(passwordField.getPassword().length < 8) {
					lblPasswordLengthMust.setVisible(true);

				}
				else if(textField_4.getText().length()!=10 || !checkValidDate(textField_4.getText())||!textField_4.getText().matches("[0-3]\\d/[01]\\d/\\d{4}")) {
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
				}
					
			}
		});
		registerButton.setBackground(Color.BLUE);
		registerButton.setForeground(Color.WHITE);
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		registerButton.setBounds(152, 698, 158, 41);
		panel.add(registerButton);
		this.getRootPane().setDefaultButton(registerButton);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(38, 341, 102, 21);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(152, 339, 172, 29);
		panel.add(passwordField);
		
		
		ImageIcon imageicon = new ImageIcon(getClass().getResource("/regbackground.png"));
		for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).getNorthPane().getMouseListeners()){
			((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).getNorthPane().removeMouseListener(listener);
			}
	}
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
