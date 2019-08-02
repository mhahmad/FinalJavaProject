package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conotroller.SysData;
import Model.Car;
import Model.Driver;
import Model.Truck;
import Model.Vehicle;

import javax.swing.JButton;
import java.awt.Font;
import java.util.Map;

public class DriverPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverPage frame = new DriverPage();
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
	public DriverPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1057, 648);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Verdana Pro", Font.PLAIN, 40));
		lblWelcome.setBounds(12, 31, 204, 66);
		panel.add(lblWelcome);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana Pro", Font.PLAIN, 40));
		label.setBounds(228, 48, 288, 36);
		panel.add(label);
		
		Driver driver = null;
		if(login.idUser  != null)
			 driver = SysData.getInstance().getAllDriversMap().get(login.idUser);
		
		if(driver != null)
			label.setText(driver.getFirstName() + " " + driver.getSurname());
		
		JLabel lblYouHaveNo = new JLabel("You have no job for today , ");
		lblYouHaveNo.setForeground(new Color(253, 245, 230));
		lblYouHaveNo.setFont(new Font("Sitka Small", Font.PLAIN, 35));
		lblYouHaveNo.setBounds(22, 110, 635, 129);
		panel.add(lblYouHaveNo);
		
		Truck truck = null;
		Car car = null;
		if(driver != null)
			for(Map.Entry<String, Vehicle> temp : SysData.getInstance().getVehclesMap().entrySet()) {
				if(temp.getValue().getDriver().equals( driver)) {
					if(temp instanceof Truck)
						truck =(Truck) temp.getValue();
					else
						car =(Car) temp.getValue();
				}
		}
		
		if(truck!= null && truck.getDestinationWareHouse() !=null) {
			lblYouHaveNo.setText(" You are Driving : " + truck.getVin() + " for today ,\n" + "the truck load should be deployed in Warehouse : " + truck.getDestinationWareHouse().getWarehouseId());
			
		}
		JLabel background = new JLabel("");
		background.setBounds(79, 178, 56, 16);
		panel.add(background);
		background.setIcon(new ImageIcon(getClass().getResource("/blue.jpg")) );
		background.setBounds(0, 0, 1057, 648);
		
		
		
		
		
	
		
		
	
		
		
	}
}
