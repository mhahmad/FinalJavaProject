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
import Model.Driver;
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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

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
			
			JButton SubmitButton = new JButton("Sumbit");
			SubmitButton.setEnabled(false);
			
			//String[] numbers = {"1","2","3","4"};
	
			SubmitButton.setBounds(641, 273, 89, 34);
			getContentPane().add(SubmitButton);
			
			JRadioButton rdbtnCars = new JRadioButton("Cars");
		
		
			rdbtnCars.setBackground(new Color(255, 51, 51));
			rdbtnCars.setBounds(0, 7, 94, 23);
			vehicleSelection.add(rdbtnCars);
			
			JRadioButton rdbtnTrucks =new JRadioButton("Trucks");
		
			rdbtnTrucks.setBackground(new Color(255, 153, 153));
			rdbtnTrucks.setBounds(0, 38, 94, 23);
			vehicleSelection.add(rdbtnTrucks);
			
			JRadioButton rdbtnAllVehicles = new JRadioButton("All Vehicles");
			
			rdbtnAllVehicles.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent ar) {
					table_1.setCellSelectionEnabled(false); // dont know for sure !!!
				SubmitButton.setEnabled(false);
					table_1.setRowSelectionAllowed(false);
					if(rdbtnAllVehicles.isSelected()) {
						
						if(!SysData.getInstance().getVehicles().isEmpty()) {
							((DefaultTableModel) table_1.getModel()).setRowCount(0);
							Car car = null ;
							Truck tt = null ; 
						for(Vehicle v :SysData.getInstance().getVehicles()) {
							Object[] Row = new Object[5];
							if(v instanceof Car) {
						    car = (Car)v ;
					     	Row[0] = car.getVin() ;
							Row[1]= car.getColor() ;
						    Row[2]=car.getType() ;
			    			Row[3]=car.getDriver().getId() ;
					  		Row[4]=car.isHybrid() ;
						/**
							Row[0] = "123245" ;
							Row[1]= "red";
							Row[2]=Utils.E_ModelType.BMW ;
							Row[3]="11111111" ;
							Row[4]=true ;
							*/	
					  		
							((DefaultTableModel) table_1.getModel()).addRow(Row);
						
						}
							
							if(v instanceof Truck) {
								tt = (Truck)v ;
								Row[0] = tt.getVin() ;
								Row[1]= tt.getColor() ;
								Row[2]=tt.getType() ;
					        	Row[3]=tt.getDriver().getId() ;
						         Row[4]=tt.getTypeTrunk() ;
							/**
								Row[0] = "123245" ;
								Row[1]= "red";
								Row[2]=Utils.E_ModelType.BMW ;
								Row[3]="11111111" ;
								Row[4]=Utils.E_TypeTruck.MINIVAN ;
									*/
								((DefaultTableModel) table_1.getModel()).addRow(Row);
						
							}

						  }
							
						
						}else{
							JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Cars to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
							}
						
							}else {
							
							((DefaultTableModel) table_1.getModel()).setRowCount(0);
						}
							
						}
					
				
		});
			//-------------------------------------------------------------------------
			rdbtnAllVehicles.setBackground(new Color(255, 204, 204));
			rdbtnAllVehicles.setBounds(0, 70, 94, 23);
			vehicleSelection.add(rdbtnAllVehicles);
			
			ButtonGroup vehiclegroup  = new ButtonGroup() ;
			vehiclegroup.add(rdbtnCars);
			vehiclegroup.add(rdbtnTrucks);
			vehiclegroup.add(rdbtnAllVehicles);
			//rdbtnAllVehicles.setSelected(true)
			
			
			//String[] drivers = {"max","fof","john","michel"};
			
			//String[] vehicles = {"honda","mazda","lambo","Range"};
			
			
			JScrollPane VehiclesTable = new JScrollPane();
			VehiclesTable.setBounds(122, 87, 490, 219);
			getContentPane().add(VehiclesTable);
			
			table_1 = new JTable()  {
				public boolean isCellEditable(int row, int column) {                
                return false;               
        }
				};
				
			table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			table_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 0, 128), null));
			table_1.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
			table_1.setBackground(new Color(204, 204, 255));
			
			
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Vin", "Color", "Type", "DriverID", "TruckType/Hybryd"
				}
							
					
					
					));
			
		
			/**
			table_1.setModel( new DefaultTableModel() {
				 @Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
			
			});
			*/
			table_1.getColumnModel().getColumn(4).setPreferredWidth(125);
			VehiclesTable.setViewportView(table_1);
			//---------------------------------------------------------------------------------------
			rdbtnCars.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg) {
					table_1.setRowSelectionAllowed(true);
				Car car = null ;
				if(rdbtnCars.isSelected()) {
				if(!SysData.getInstance().getVehicles().isEmpty()) {
					((DefaultTableModel) table_1.getModel()).setRowCount(0);
				for(Vehicle v :SysData.getInstance().getVehicles()) {
					Object[] Row = new Object[5];
					if(v instanceof Car) {
						
				    car = (Car)v ;
				    
				    if(!car.isInUse()) {
			     	Row[0] = car.getVin() ;
					Row[1]= car.getColor() ;
				    Row[2]=car.getType() ;
	    			Row[3]=car.getDriver().getId() ;
			  		Row[4]=car.isHybrid() ;
				/**
					Row[0] = "123245" ;
					Row[1]= "red";
					Row[2]=Utils.E_ModelType.BMW ;
					Row[3]="11111111" ;
					Row[4]=true ;
					*/	
			  		
					((DefaultTableModel) table_1.getModel()).addRow(Row);
					
				    }else continue ;
				
				}
				  }
					
				
				}else{
					JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Cars to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
					}
				
					}else {
					
					((DefaultTableModel) table_1.getModel()).setRowCount(0);
				}
					
				}
			});
			
			//-------------------------------------------------------------------------------------
			rdbtnTrucks.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent a) {
					Truck tt = null ; 
					table_1.setRowSelectionAllowed(true);
					if(rdbtnTrucks.isSelected() ) {
						
						if(!SysData.getInstance().getVehicles().isEmpty() ) {
							((DefaultTableModel) table_1.getModel()).setRowCount(0);
					for(Vehicle v :SysData.getInstance().getVehicles()) {
							Object[] Row = new Object[5];
							if(v instanceof Truck) {
							tt = (Truck)v ;
							if(!tt.isInUse()) {
							Row[0] = tt.getVin() ;
							Row[1]= tt.getColor() ;
							Row[2]=tt.getType() ;
				        	Row[3]=tt.getDriver().getId() ;
					         Row[4]=tt.getTypeTrunk() ;
					         
						/**
							Row[0] = "123245" ;
							Row[1]= "red";
							Row[2]=Utils.E_ModelType.BMW ;
							Row[3]="11111111" ;
							Row[4]=Utils.E_TypeTruck.MINIVAN ;
								*/
							((DefaultTableModel) table_1.getModel()).addRow(Row);
							
							}else continue ;
					
						}
					         
						}
					}else {
						// TODO - check this Massage !! 
						JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Trucks to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
					}
							
						}else {
							
							((DefaultTableModel) table_1.getModel()).setRowCount(0);
						//	((DefaultTableModel) table_1.getModel())
						}
					
				}
			});
			
			
			JScrollPane DriversTable = new JScrollPane();
			DriversTable.setBounds(122, 364, 490, 204);
			getContentPane().add(DriversTable);
			
			table_2 = new JTable() {
				   public boolean isCellEditable(int row, int column) {                
		                return false;               
		        }
			} ;
			
			table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "LastName", "SurName", "HasValidLicense"
				}
			));
			
			table_2.getColumnModel().getColumn(3).setPreferredWidth(106);
			DriversTable.setViewportView(table_2);
			
			JPanel PickDriverspanel = new JPanel();
			PickDriverspanel.setBackground(new Color(30, 144, 255));
			PickDriverspanel.setBounds(10, 386, 102, 88);
			getContentPane().add(PickDriverspanel);
			PickDriverspanel.setLayout(null);
			ButtonGroup Drivergroup  = new ButtonGroup() ;
			
			JRadioButton AvaliableDrivers = new JRadioButton("Avaliable");
			AvaliableDrivers.setBackground(new Color(0, 255, 255));
			AvaliableDrivers.addItemListener(new ItemListener() {
				
				
				public void itemStateChanged(ItemEvent e) {
				//	table_2.setCellSelectionEnabled(false); // dont know for sure
					if(AvaliableDrivers.isSelected()) {
						if(!SysData.getInstance().allDrivers().isEmpty() ) {
							((DefaultTableModel) table_2.getModel()).setRowCount(0);
							table_2.setRowSelectionAllowed(true);
					for(Driver driver :SysData.getInstance().allDrivers()) {
					
							Object[] Row = new Object[4];
						
							Driver temp = (Driver) driver ;
							if(temp.getHasValidLicense() && !temp.isDriverInUse()) {
					
							Row[0] = temp.getId() ;
							Row[1]= temp.getFirstName() ;
							Row[2]=temp.getSurname() ;
				        	Row[3]=temp.getHasValidLicense() ;
					       
						/**
							Row[0] = "123245" ;
							Row[1]= "red";
							Row[2]=Utils.E_ModelType.BMW ;
							Row[3]="11111111" ;
							Row[4]=Utils.E_TypeTruck.MINIVAN ;
								*/
							((DefaultTableModel) table_2.getModel()).addRow(Row);
					
							
							}else continue ;   
						}
					}else {
						// TODO - check this Massage !! 
						JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Trucks to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
					}
							
						}else {
							
							((DefaultTableModel) table_2.getModel()).setRowCount(0);
						//	((DefaultTableModel) table_1.getModel())
						}
						
					}
				
					
					
				
			});
			AvaliableDrivers.setBounds(0, 7, 102, 23);
			PickDriverspanel.add(AvaliableDrivers);
			
			JRadioButton AllDrivers = new JRadioButton("All Drivers");
			AllDrivers.setBackground(new Color(0, 191, 255));
			AllDrivers.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				
					if(AllDrivers.isSelected()) {
						// SubmitButton.setEnabled(false);
						table_2.setRowSelectionAllowed(false);
						table_2.setCellSelectionEnabled(false);
						if(!SysData.getInstance().allDrivers().isEmpty() ) {
							((DefaultTableModel) table_2.getModel()).setRowCount(0);
					for(Driver driver :SysData.getInstance().allDrivers()) {
							Object[] Row = new Object[4];
						
							Driver temp = (Driver) driver ;
							Row[0] = temp.getId() ;
							Row[1]= temp.getFirstName() ;
							Row[2]=temp.getSurname() ;
				        	Row[3]=temp.getHasValidLicense() ;
					       
						/**
							Row[0] = "123245" ;
							Row[1]= "red";
							Row[2]=Utils.E_ModelType.BMW ;
							Row[3]="11111111" ;
							Row[4]=Utils.E_TypeTruck.MINIVAN ;
								*/
							((DefaultTableModel) table_2.getModel()).addRow(Row);
							
						
					         
						}
					}else {
						// TODO - check this Massage !! 
						JOptionPane.showInternalConfirmDialog(null, "there is not Avaiable Trucks to Display"," " , 0,JOptionPane.ERROR_MESSAGE);		
					}
							
						}else {
							
							((DefaultTableModel) table_2.getModel()).setRowCount(0);
						//	((DefaultTableModel) table_1.getModel())
						}
						
					}
				
			});
			AllDrivers.setBounds(0, 39, 102, 23);
			PickDriverspanel.add(AllDrivers);
			
			Drivergroup.add(AvaliableDrivers);
			Drivergroup.add(AllDrivers);
			
			JLabel PickBoth = new JLabel("Select Both A Driver & A Vehicle To Submit ! ");
			//PickBoth.setEnabled(false);
		     PickBoth.setVisible(false);
			PickBoth.setForeground(new Color(255, 0, 0));
			PickBoth.setFont(new Font("Tahoma", Font.BOLD, 10));
			PickBoth.setBounds(529, 318, 242, 26);
			getContentPane().add(PickBoth);
			
			table_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SubmitButton.setEnabled(false);
	if(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() != -1) {
	if((rdbtnTrucks.isSelected() || rdbtnCars.isSelected()) &&(AvaliableDrivers.isSelected()))	{				
						SubmitButton.setEnabled(true);
						
	}
}else if((table_1.getSelectedRow() == -1 && table_2.getSelectedRow() != -1)||(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() == -1)||(table_1.getSelectedRow() == -1 && table_2.getSelectedRow() == -1) ){
						SubmitButton.setEnabled(false);
					}
					
				}
			});
			
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SubmitButton.setEnabled(false);
					if(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() != -1) {
						if((rdbtnTrucks.isSelected() || rdbtnCars.isSelected()) &&(AvaliableDrivers.isSelected()))	{	
						SubmitButton.setEnabled(true);
						}
					}else if((table_1.getSelectedRow() == -1 && table_2.getSelectedRow() != -1)||(table_1.getSelectedRow() == -1 && table_2.getSelectedRow() == -1) ||(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() == -1) ){
						SubmitButton.setEnabled(false);
					}
					
					
				}
			});
			
			SubmitButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
			// if(Drivergroup.isSelected(rdbtnAllVehicles.getModel()) && !AllDrivers.isSelected()) {
						if((table_1.getSelectedRow() == -1 && table_2.getSelectedRow() != -1)||(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() == -1)) {
							PickBoth.setVisible(true);
						}
			if(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() != -1) {
				PickBoth.setVisible(false);
			
			Car car = null ;
			Truck truck = null ;
			System.out.println();
			
			Vehicle V = SysData.getInstance().getVehicles().get(table_1.getSelectedRow()) ;
			if(V instanceof Car) {
				car = (Car)V ;
				if(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() != -1){
				
				Driver driver1= SysData.getInstance().allDrivers().get(table_2.getSelectedRow()) ;
				
				
				((Car)SysData.getInstance().getVehicles().get(table_1.getSelectedRow())).setDriver(driver1)  ;
				(SysData.getInstance().getVehicles().get(table_1.getSelectedRow())).setInUse(true);
				
				SysData.getInstance().allDrivers().get(table_2.getSelectedRow()).setDriverInUse(true);
				System.out.println("the selected row in table 2 - Drivers :  : "+table_2.getSelectedRow());
				System.out.println("the selected row in table 1 : is : "+table_1.getSelectedRow());

				System.out.println(driver1);
				System.out.println(car);
				
				((DefaultTableModel) table_1.getModel()).removeRow(table_1.getSelectedRow());
				((DefaultTableModel) table_2.getModel()).removeRow(table_2.getSelectedRow());

				}
			}
			if(V instanceof Truck ) {
				truck  = (Truck )V ;
				if(table_1.getSelectedRow() != -1 && table_2.getSelectedRow() != -1){
				
				
                  Driver driver2 = SysData.getInstance().allDrivers().get(table_2.getSelectedRow()) ;
                 
				((Truck)SysData.getInstance().getVehicles().get(table_1.getSelectedRow())).setDriver(driver2 ) ;
				(SysData.getInstance().getVehicles().get(table_1.getSelectedRow())).setInUse(true);
				 SysData.getInstance().allDrivers().get(table_2.getSelectedRow()).setDriverInUse(true);
				
				System.out.println("the selected row in table 2 - drivers : : "+table_2.getSelectedRow());
				System.out.println("the selected row in table 1 : is : "+table_1.getSelectedRow());
				System.out.println(driver2);
				System.out.println(truck);
				((DefaultTableModel) table_1.getModel()).removeRow(table_1.getSelectedRow());
				((DefaultTableModel) table_2.getModel()).removeRow(table_2.getSelectedRow());

				}
			}
			 }				
				}					
				
			});
	
			//addTruck(String vin, String color, E_ModelType type, long driverId, E_TypeTruck typeTrunk)
			//addCar(String vin, String color, E_ModelType type,long driverId,boolean hybryd)
			DefaultTableModel modell = new DefaultTableModel();
		
		}
	}