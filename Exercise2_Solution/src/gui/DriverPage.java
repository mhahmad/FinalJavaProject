package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conotroller.SysData;
import InternalFrames.UNLOAD;
import Model.Car;
import Model.Driver;
import Model.Parcel;
import Model.Truck;
import Model.Vehicle;

import javax.swing.JButton;
import java.awt.Font;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DriverPage extends JFrame {

	private JPanel contentPane;
	private Truck truck = null;
	private Driver driver = null;

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
		
		JLabel jobLabel = new JLabel("You have no job for today , ");
		jobLabel.setForeground(new Color(253, 245, 230));
		jobLabel.setFont(new Font("Sitka Small", Font.PLAIN, 35));
		jobLabel.setBounds(22, 110, 635, 129);
		panel.add(jobLabel);
		
		
		Car car = null;
		if(login.idUser  != null)
			 driver = SysData.getInstance().getAllDriversMap().get(login.idUser);
		
		if(driver != null) {
			label.setText(driver.getFirstName() + " " + driver.getSurname());
		for(Map.Entry<String, Vehicle> ridenV : SysData.getInstance().getVehclesMap().entrySet()) {
			if(ridenV instanceof Truck) {
				if(ridenV.getValue().getDriver().equals(driver)) {
					truck = (Truck)ridenV.getValue(); 
					if(truck!= null && truck.getDestinationWareHouse() !=null) 
						jobLabel.setText(" You are Driving : " + truck.getVin() + " for today ,\n" + "the truck load should be unloaded in Warehouse : " + truck.getDestinationWareHouse().getWarehouseId());
				}
				else
				jobLabel.setText("You have no job for today , ");
			}
			if(ridenV instanceof Car) {
				if(ridenV.getValue().getDriver().equals(driver)) {
					car = (Car)ridenV.getValue();
				}
			}
		}
		}
		
		
		
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
			jobLabel.setText(" You are Driving : " + truck.getVin() + " for today ,\n" + "the truck load should be unloaded in Warehouse : " + truck.getDestinationWareHouse().getWarehouseId());
			
		}
		
		JCheckBox checked = new JCheckBox("Destination reached.");
		checked.setForeground(Color.WHITE);
		checked.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		checked.setBounds(403, 339, 254, 41);
		panel.add(checked);
		checked.setOpaque(false);
		
		JLabel lblUnloadedSuccessfuly = new JLabel("UNLOADED SUCCESSFULY !");
		lblUnloadedSuccessfuly.setForeground(new Color(0, 255, 0));
		lblUnloadedSuccessfuly.setFont(new Font("Verdana Pro", Font.PLAIN, 25));
		lblUnloadedSuccessfuly.setBounds(352, 518, 383, 55);
		panel.add(lblUnloadedSuccessfuly);
		lblUnloadedSuccessfuly.setVisible(false);
		
		
		JButton btnUnload = new JButton("UNLOAD");
		btnUnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UNLOAD dialog = new UNLOAD();
				dialog.setVisible(true);
				Object newData[] = new Object[1];
				DefaultTableModel model = (DefaultTableModel)dialog.getTable().getModel();
				model.setRowCount(0);
				if(truck!=null)
					for(Parcel parcel : truck.getParcels()) {
						newData[0] = parcel.getParcelId();
						model.addRow(newData);
				}
				
				dialog.getBtnNewButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.getFailedLabel().setVisible(false);
						lblUnloadedSuccessfuly.setVisible(false);
						if(driver != null && truck != null) {
							if(SysData.getInstance().sendTruckToWareHouse(truck.getVin())) {
								dialog.dispose();
								lblUnloadedSuccessfuly.setVisible(true);
								jobLabel.setText("You have no job for today , ");
								
							}
							else
							{
								dialog.getFailedLabel().setVisible(true);
							}
							
						}
					}
				});
				
			}
		});
		btnUnload.setBackground(Color.ORANGE);
		btnUnload.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		btnUnload.setBounds(434, 389, 178, 55);
		panel.add(btnUnload);
		btnUnload.setEnabled(false);
		
		checked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checked.isSelected())
					btnUnload.setEnabled(true);
				else
					btnUnload.setEnabled(false);
			}
		});
		
		
		this.setLocation(getLocation());
		
		
		JLabel background = new JLabel("");
		background.setBounds(79, 178, 56, 16);
		panel.add(background);
		background.setIcon(new ImageIcon(getClass().getResource("/blue.jpg")) );
		background.setBounds(0, 0, 1057, 648);
		
		
		setLocationRelativeTo(null);
		setResizable(false);
		
	
		
	}
	public Driver getDriver() {
		return driver;
	}
	public Truck getTruck() {
		return truck;
	}
}
