package InternalFrames;

import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conotroller.SysData;
import Model.Address;
import Model.Car;
import Model.Driver;
import Model.Parcel;
import Model.WareHouse;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DD_CoordinationCar extends JInternalFrame {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public DD_CoordinationCar(Driver driver , Car car) {
		
		
		getContentPane().setLayout(null);
		
		JButton btnSaveChanges = new JButton("Save Changes");
        btnSaveChanges.setEnabled(false);
		btnSaveChanges.setBounds(559, 274, 112, 31);
		getContentPane().add(btnSaveChanges);
		
		JLabel lblNewLabel = new JLabel("WareHouses To send to Receivers  : ");
		lblNewLabel.setBounds(44, 30, 183, 54);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 95, 452, 222);
		getContentPane().add(scrollPane);
		
		
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"WareHouse Id", "Region", "Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(208);
		scrollPane.setViewportView(table);
		
		JLabel EmptyWhlbl = new JLabel("WareHouses Are All Empty ! ");
		EmptyWhlbl.setForeground(Color.RED);
		EmptyWhlbl.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		EmptyWhlbl.setHorizontalAlignment(SwingConstants.CENTER);
		EmptyWhlbl.setBounds(248, 328, 213, 31);
		getContentPane().add(EmptyWhlbl);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 415, 378, 171);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "Address"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(15);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(311);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(451, 415, 318, 171);
		getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ParcelID", "Receiver ID", "Receiver Name"
			}
		));
		table_2.getColumnModel().getColumn(2).setPreferredWidth(113);
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblAddress = new JLabel("Destination Addresses ");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(141, 373, 130, 31);
		getContentPane().add(lblAddress);
		
		JLabel lblParcelsToBe = new JLabel("Parcels To Be Delivered !");
		lblParcelsToBe.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblParcelsToBe.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelsToBe.setBounds(542, 383, 151, 24);
		getContentPane().add(lblParcelsToBe);
		
		
		

		
		EmptyWhlbl.setVisible(false);		
		
		
           ArrayList<WareHouse> WhArray = new ArrayList<>();
           for(WareHouse w : SysData.getInstance().WareHouses()) {
        	   if(!w.getParcels().isEmpty()) {
        		WhArray.add(w) ;   
        	   }
           }
           
           
		if(!WhArray.isEmpty() ) {
			((DefaultTableModel) table.getModel()).setRowCount(0);
	for(WareHouse w :WhArray) {
			Object[] Row = new Object[3];
		
			Row[0] = w.getWarehouseId() ;
			Row[1]= w.getRegion() ;
			Row[2]= w.getAddress();
	      
			((DefaultTableModel) table.getModel()).addRow(Row);
			
		
	         
		}
	
	}else {
		// TODO - check this Massage !! 
		EmptyWhlbl.setVisible(true);	
	}
			
		
		   ArrayList<Parcel> Parray = new ArrayList<>() ;
		   ArrayList<Address> Addressarray = new ArrayList<>() ;
		
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 2) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			   //   int column = target.getSelectedColumn();
			      // do some action if appropriate column
			      ((DefaultTableModel) table_1.getModel()).setRowCount(0);
			      ((DefaultTableModel) table_2.getModel()).setRowCount(0);
			          WareHouse Wh =  WhArray.get(row);
               Parray.addAll((ArrayList<Parcel>) SysData.getInstance().sendParcelsToReceivers2(Wh.getWarehouseId(), car.getVin()) );
//   ArrayList<Address> Addressarray = new ArrayList<>();
   
   for(Parcel p : Parray) {
	   Addressarray.add(p.getReceiver().getAddress());
   }
               
   
	if(!Parray.isEmpty() ) {
		((DefaultTableModel) table_2.getModel()).setRowCount(0);
for(Parcel p  :Parray) {
		Object[] Row = new Object[3];
	
		Row[0] = p.getParcelId() ;
		Row[1]= p.getReceiver().getId() ;
		Row[2]= p.getReceiver().getFirstName()+" "+p.getReceiver().getSurname();
      
		((DefaultTableModel) table_2.getModel()).addRow(Row);
	       
	}

}else {
	// TODO - check this Massage !! 
	table_2.setVisible(false);	
}
	
	
	
	if(!Addressarray.isEmpty() ) {
		((DefaultTableModel) table_1.getModel()).setRowCount(0);
for(Address a :Addressarray) {
		Object[] Row = new Object[2];
	
		Row[0] = "*" ;
		Row[1]= a ;
		//Row[2]= w.getAddress();
      
		((DefaultTableModel) table_1.getModel()).addRow(Row);
		
	
         
	}

}else {
	// TODO - check this Massage !! 
	table_1.setVisible(false);	
}
	
	
      
			      
			    
			  }
			  }});
		
		
		
		// Button Save Changes !! 
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Object> temp =  new ArrayList<>(Addressarray) ;
				System.out.println("the error is here ~");
				/*
				Driver driver2 = driver ;
				driver2.setTo( temp );
				driver2.setFrom(WhArray);// maybr should change in the Sysdata 
				
				
			    SysData.getInstance().getAllDriversMap().replace(driver.getPassword(),driver, driver2);
			     SysData.getInstance().allDrivers().remove(driver);
			     SysData.getInstance().allDrivers().add(driver2) ;
         */
				
				
			}
		});
		
		
	
	}
}