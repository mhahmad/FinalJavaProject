package InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.Border;

import Model.SmallParcel;
import javafx.scene.Group;

import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class AddParcel extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddParcel frame = new AddParcel();
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
	public AddParcel() {
		setBounds(100, 100, 887, 931);
		getContentPane().setLayout(null);
		
		JLabel lblParcel = new JLabel("Parcel  ID : ");
		lblParcel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblParcel.setBounds(79, 184, 164, 54);
		getContentPane().add(lblParcel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(290, 193, 264, 46);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton largeButton = new JRadioButton("Large Parcel");
		largeButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		largeButton.setBounds(290, 324, 177, 31);
		getContentPane().add(largeButton);
		
		JRadioButton smallButton = new JRadioButton("Small Parcel");
		smallButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		smallButton.setBounds(491, 324, 177, 31);
		getContentPane().add(smallButton);
		
		JLabel lblParceSize = new JLabel("Parce Size :");
		lblParceSize.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblParceSize.setBounds(79, 320, 164, 38);
		getContentPane().add(lblParceSize);
		
		JCheckBox autogenerate = new JCheckBox("Auto-generate ");
		autogenerate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		autogenerate.setBounds(575, 196, 193, 34);
		getContentPane().add(autogenerate);
		autogenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(autogenerate.isSelected())
					textField.setEnabled(false);
				else 
					textField.setEnabled(true);
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(largeButton);
		group.add(smallButton);
		group.setSelected(largeButton.getModel(), true);
		
		JLabel lblAddParcelTo = new JLabel("Add Parcel to a Receiver:");
		lblAddParcelTo.setForeground(Color.BLUE);
		lblAddParcelTo.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblAddParcelTo.setBounds(79, 40, 300, 46);
		getContentPane().add(lblAddParcelTo);
		
		JButton btnNewButton = new JButton("Add Parcel");
	
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(322, 768, 187, 66);
		getContentPane().add(btnNewButton);
		
		JLabel errorLabel1 = new JLabel("Must contain numbers only !");
		errorLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorLabel1.setForeground(Color.RED);
		errorLabel1.setBounds(322, 239, 242, 19);
		getContentPane().add(errorLabel1);
		
		JLabel emptyField = new JLabel("Empty Field !");
		emptyField.setForeground(Color.RED);
		emptyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emptyField.setBounds(380, 240, 87, 16);
		getContentPane().add(emptyField);
		
		JLabel lengthError = new JLabel("Maximum length is 10 digits !");
		lengthError.setForeground(Color.RED);
		lengthError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lengthError.setBounds(323, 240, 203, 19);
		getContentPane().add(lengthError);
		lengthError.setVisible(false);
		errorLabel1.setVisible(false);
		emptyField.setVisible(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel1.setVisible(false);
				emptyField.setVisible(false);
				lengthError.setVisible(false);
				textField.setBorder(new JTextField().getBorder());
				if(!autogenerate.isSelected() && textField.getText().isEmpty()) {
					Border border =BorderFactory.createLineBorder(Color.RED,1);
					textField.setBorder(border);
					emptyField.setVisible(true);
				}
				else if (!autogenerate.isSelected() && !textField.getText().matches("[0-9]+")) {
					Border border =BorderFactory.createLineBorder(Color.RED,1);
					textField.setBorder(border);
					errorLabel1.setVisible(true);
				}
				else if (!autogenerate.isSelected() && textField.getText().length()>10) {
					Border border = BorderFactory.createLineBorder(Color.RED, 1);
					textField.setBorder(border);
					lengthError.setVisible(true);
				}
				else { 
					if(group.isSelected(smallButton.getModel()))
						JOptionPane.showMessageDialog(null, "Small parcel has been successfuly generated! ","Successful" , 0,new ImageIcon(getClass().getResource("/correct.png")));
					else
						JOptionPane.showMessageDialog(null, "Large parcel has been successfuly generated! ","Successful" , 0,new ImageIcon(getClass().getResource("/correct.png")));
				}
			}
		});
		this.getRootPane().setDefaultButton(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 452, 674, 300);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "FIRSTNAME", "LASTNAME", "EMAIL", "BIRTHDATE", "ADDRESS"
			}
		));
		
		JLabel lblChooseAReceiver = new JLabel("Choose a receiver to the parcel :");
		lblChooseAReceiver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChooseAReceiver.setBounds(79, 420, 289, 22);
		getContentPane().add(lblChooseAReceiver);
		table.setVisible(true);
		DefaultTableModel model = new DefaultTableModel();
		Object [] columns= { "ID","FIRSTNAME","LASTNAME","EMAIL","BIRTHDATE","ADDRESS"};
		model.setColumnIdentifiers(columns);
		
	}
}
