package InternalFrames;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conotroller.SysData;
import Model.Car;
import Model.Item;
import Model.Truck;
import Model.Vehicle;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Receiver_ItemList extends JInternalFrame {
	private JTable table;
	public Receiver_ItemList() {
		getContentPane().setLayout(null);
		
		JLabel itemsList = new JLabel("Items Bought");
		itemsList.setForeground(new Color(153, 0, 204));
		itemsList.setFont(new Font("Yu Gothic Medium", Font.BOLD, 34));
		itemsList.setBounds(101, 38, 234, 56);
		getContentPane().add(itemsList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 118, 687, 299);
		getContentPane().add(scrollPane);
		
		table = new JTable() {
			public boolean isCellEditable(int row, int column) {                
                return false;   
			}
			};
		table.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
		table.setFont(new Font("Sylfaen", Font.BOLD, 12));
		table.setForeground(new Color(0, 0, 102));
		table.setRowHeight(30);	
		table.setBackground(new Color(153, 204, 204));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CatalogID", "Item Name", "Price", "Free Shipped", "itemWeight"
			}
		));
		
		
		if(!SysData.getInstance().getReceiverItems((long)2222221).isEmpty()  ) {
			((DefaultTableModel) table.getModel()).setRowCount(0);
			Car car = null ;
			Truck tt = null ; 
		for(Item i :SysData.getInstance().getReceiverItems((long) 2222221)) {
			Object[] Row = new Object[5];
			
	     	Row[0] = i.getCatalogID();
	     	Row[1]= i.getItemName() ;
			Row[2] = i.getPrice() ;
			Row[3]=i.isHasFreeShipping() ;
	  		Row[4]=i.getItemWeight() ;
		/**
			Row[0] = "123245" ;
			Row[1]= "red";
			Row[2]=Utils.E_ModelType.BMW ;
			Row[3]="11111111" ;
			Row[4]=true ;
			*/	
	  		
			((DefaultTableModel) table.getModel()).addRow(Row);
		
		}
			
		
		}else{
			JOptionPane.showMessageDialog(null, "No Items Found To Displpay !!!","OOPs" , 0,new ImageIcon(getClass().getResource("/Ops.png")));
			//dispose();
			}
		
		
		scrollPane.setViewportView(table);
	}
}