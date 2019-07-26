package InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conotroller.SysData;
import Model.Receiver;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllReceivers extends JInternalFrame {
	private JTable table;
	public static DateFormat df;
	public static DateFormat dtf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllReceivers frame = new AllReceivers();
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
	public AllReceivers() {
		setBounds(100, 100, 1027, 712);
		getContentPane().setLayout(null);
		
		JLabel lblShowAllReceivers = new JLabel("Show all Receivers that are registered in the System :");
		lblShowAllReceivers.setBackground(Color.RED);
		lblShowAllReceivers.setForeground(Color.WHITE);
		lblShowAllReceivers.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblShowAllReceivers.setBounds(90, 65, 643, 41);
		getContentPane().add(lblShowAllReceivers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 153, 856, 383);
		getContentPane().add(scrollPane);
		df = new SimpleDateFormat("dd/MM/yyyy");
		dtf = new SimpleDateFormat("dd/MM/yyyy");
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"receiverID", "Firstname", "Lastname", "Email", "Birthdate", "Address"
			}
		));
		
		JButton btnRefresh = new JButton("Refresh");

		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh.setBounds(708, 78, 97, 25);
		getContentPane().add(btnRefresh);
		Object rowData[]=new Object[6];
		for(Map.Entry<String, Receiver> rec : SysData.getInstance().getReceiversMap().entrySet()) {
			String strDate = df.format(rec.getValue().getBirthDate());
			rowData[0] = rec.getValue().getId();
			rowData[1] = rec.getValue().getFirstName();
			rowData[2] = rec.getValue().getSurname();
			rowData[3] = rec.getValue().getEmail();
			rowData[4] = strDate;
			rowData[5]=rec.getValue().getAddress().getCity() +","+rec.getValue().getAddress().getStreet()+","+rec.getValue().getAddress().getHouseNumber()+","+rec.getValue().getAddress().getZipCode();
			((DefaultTableModel)table.getModel()).addRow(rowData);
		}
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				for(Map.Entry<String, Receiver> rec : SysData.getInstance().getReceiversMap().entrySet()) {
					String strDate = df.format(rec.getValue().getBirthDate());
					rowData[0] = rec.getValue().getId();
					rowData[1] = rec.getValue().getFirstName();
					rowData[2] = rec.getValue().getSurname();
					rowData[3] = rec.getValue().getEmail();
					rowData[4] = strDate;
					rowData[5]=rec.getValue().getAddress().getCity() +","+rec.getValue().getAddress().getStreet()+","+rec.getValue().getAddress().getHouseNumber()+","+rec.getValue().getAddress().getZipCode();
					((DefaultTableModel)table.getModel()).addRow(rowData);
			}
			}
		});
	}
}
