package InternalFrames;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Scrollbar;
import Conotroller.*;
import Model.Car;
import Model.Truck;
import Model.Vehicle;
import Utils.E_ModelType;
import Utils.E_TypeTruck;

import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class CoordinatorDV extends JInternalFrame {

	   JTable table = new JTable();
	   private JTable table_1;
	   private JTable table_2;
	  //  JTable table;
		public CoordinatorDV() {
			String[] columns = {"F.Name","L.Name","ID","Has A Valid License"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			setClosable(true);
			getContentPane().setLayout(null);
			
			JLabel lblVehicledriverCordination = new JLabel("Vehicle&Driver Cordination");
			lblVehicledriverCordination.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblVehicledriverCordination.setHorizontalAlignment(SwingConstants.CENTER);
			lblVehicledriverCordination.setBackground(new Color(204, 153, 204));
			lblVehicledriverCordination.setForeground(new Color(51, 51, 204));
			lblVehicledriverCordination.setBounds(210, 11, 242, 34);
			getContentPane().add(lblVehicledriverCordination);
			
			JLabel lblVehicles = new JLabel("Vehicles");
			lblVehicles.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblVehicles.setBounds(244, 66, 88, 14);
			getContentPane().add(lblVehicles);
			
			JLabel lblDrivers = new JLabel("Drivers");
			lblDrivers.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblDrivers.setBounds(258, 330, 94, 14);
			getContentPane().add(lblDrivers);
			
			JPanel vehicleSelection = new JPanel();
			vehicleSelection.setBackground(new Color(255, 102, 102));
			vehicleSelection.setBounds(18, 130, 94, 126);
			getContentPane().add(vehicleSelection);
			vehicleSelection.setLayout(null);
			
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Cars");
		
			rdbtnNewRadioButton.setBackground(new Color(255, 51, 51));
			rdbtnNewRadioButton.setBounds(0, 7, 94, 23);
			vehicleSelection.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnTrucks = new JRadioButton("Trucks");
		
			rdbtnTrucks.setBackground(new Color(255, 153, 153));
			rdbtnTrucks.setBounds(0, 38, 94, 23);
			vehicleSelection.add(rdbtnTrucks);
			
			JRadioButton rdbtnAllVehicles = new JRadioButton("All Vehicles");
			rdbtnAllVehicles.setBackground(new Color(255, 204, 204));
			rdbtnAllVehicles.setBounds(0, 70, 94, 23);
			vehicleSelection.add(rdbtnAllVehicles);
			
			ButtonGroup vehiclegroup  = new ButtonGroup() ;
			vehiclegroup.add(rdbtnNewRadioButton);
			vehiclegroup.add(rdbtnTrucks);
			vehiclegroup.add(rdbtnAllVehicles);
			
			
			String[] drivers = {"max","fof","john","michel"};
			
			String[] vehicles = {"honda","mazda","lambo","Range"};
			
			JButton btnNewButton_1 = new JButton("Sumbit");
			
			String[] numbers = {"1","2","3","4"};
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					model.addRow(numbers);
				}
			});
			btnNewButton_1.setBounds(639, 237, 89, 34);
			getContentPane().add(btnNewButton_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(122, 87, 490, 219);
			getContentPane().add(scrollPane);
			
			table_1 = new JTable();
			table_1.setBackground(new Color(204, 204, 255));
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Vin", "Color", "Type", "DriverID", "TruckType/Hybryd"
				}
			));
			table_1.getColumnModel().getColumn(4).setPreferredWidth(125);
			scrollPane.setViewportView(table_1);
			
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg) {
					//int size = SysData.getInstance().getvehicles().size();
				//Car car = null ; 
				if(!SysData.getInstance().getVehicles().isEmpty()) {
				//for(Vehicle v :SysData.getInstance().getvehicles()) {
					Object[] Row = new Object[5];
				//	if(v instanceof Car) {
				//	car = (Car)v ;
				//	Row[0] = car.getVin() ;
					//Row[1]= car.getColor() ;
				//	Row[2]=car.getType() ;
		//			Row[3]=car.getDriver().getId() ;
			//		Row[4]=car.isHybrid() ;
				
					Row[0] = "123245" ;
					Row[1]= "red";
					Row[2]=Utils.E_ModelType.BMW ;
					Row[3]="11111111" ;
					Row[4]=true ;
						
					((DefaultTableModel) table_1.getModel()).addRow(Row);
					
					
				
				//}
				//}
					
				}else{
					JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Cars to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
					}
					
				}
			});
			
			
			rdbtnTrucks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				Truck tt = null ; 
					if(!SysData.getInstance().getVehicles().isEmpty()) {
					//for(Vehicle v :SysData.getInstance().getvehicles()) {
						Object[] Row = new Object[5];
					//	if(v instanceof Car) {
					//	tt = (Truck)v ;
					//	Row[0] = tt.getVin() ;
						//Row[1]= tt.getColor() ;
					//	Row[2]=tt.getType() ;
			//			Row[3]=tt.getDriver().getId() ;
				        // Row[4]=tt.getTypeTrunk() ;
					
						Row[0] = "123245" ;
						Row[1]= "red";
						Row[2]=Utils.E_ModelType.BMW ;
						Row[3]="11111111" ;
						Row[4]=Utils.E_TypeTruck.MINIVAN ;
							
						((DefaultTableModel) table_1.getModel()).addRow(Row);
						
						
					
				
					//}
				}else {
					JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Trucks to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
				}
						
					}
				
			});
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(122, 364, 490, 204);
			getContentPane().add(scrollPane_1);
			
			table_2 = new JTable();
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "LastName", "SurName", "HasValidLicense"
				}
			));
			
			table_2.getColumnModel().getColumn(3).setPreferredWidth(106);
			scrollPane_1.setViewportView(table_2);
			
			//addTruck(String vin, String color, E_ModelType type, long driverId, E_TypeTruck typeTrunk)
			//addCar(String vin, String color, E_ModelType type,long driverId,boolean hybryd)
			DefaultTableModel modell = new DefaultTableModel();
		
		}
	}