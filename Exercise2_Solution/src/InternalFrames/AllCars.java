package InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Conotroller.SysData;
import Model.Car;
import Model.Truck;
import Model.Vehicle;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class AllCars extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllTrucks frame = new AllTrucks();
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
	public AllCars() {
		setBounds(100, 100, 1027, 712);
		getContentPane().setLayout(null);
		
		JLabel lblAllTrucksIn = new JLabel("All Cars in the System :");
		lblAllTrucksIn.setForeground(Color.BLUE);
		lblAllTrucksIn.setFont(new Font("Verdana Pro Cond Light", Font.BOLD, 26));
		lblAllTrucksIn.setBounds(51, 62, 362, 33);
		getContentPane().add(lblAllTrucksIn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 126, 825, 355);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"VIN ", "Color", "ModelType", "Hybrid", "Driver"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Object newData[] = new Object[5];
		for(Vehicle car : SysData.getInstance().getVehicles()) {
			if(car instanceof Car) {
				newData[0] = car.getVin();
				newData[1] = car.getColor();
				newData[2] = car.getType();
				if(((Car) car).isHybrid())
					newData[5] = "Yes" ;
				else
					newData[5] = "No" ;
				if(car.isInUse())
					newData[5] = "None";
				else
					newData[5] = car.getDriver().getFirstName() + " " + car.getDriver().getSurname();
				((DefaultTableModel)table.getModel()).addRow(newData);
			}
		}
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				for(Vehicle car : SysData.getInstance().getVehicles()) {
					if(car instanceof Car) {
						newData[0] = car.getVin();
						newData[1] = car.getColor();
						newData[2] = car.getType();
						if(((Car) car).isHybrid())
							newData[3] = "Yes" ;
						else
							newData[3] = "No" ;
						if(!car.isInUse())
							newData[4] = "None";
						else
							newData[4] = car.getDriver().getFirstName() + " " + car.getDriver().getSurname();
						((DefaultTableModel)table.getModel()).addRow(newData);
					}
				}
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefresh.setBounds(361, 67, 110, 33);
		getContentPane().add(btnRefresh);
		
		
		
	}
}
