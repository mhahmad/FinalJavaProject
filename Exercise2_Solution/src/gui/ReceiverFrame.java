package gui;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.border.SoftBevelBorder;

import Conotroller.SysData;
import InternalFrames.Receiver_ItemList;
import InternalFrames.TrackParcel;
import gui.Homepage;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiverFrame extends JFrame {
	private JButton ListButton;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverFrame frame = new ReceiverFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ReceiverFrame() {
		

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		
		getContentPane().setBackground(new Color(204, 204, 255));
		getContentPane().setLayout(null);
	 
	
	    Receiver_ItemList itemList = new Receiver_ItemList();
	    itemList.setVisible(false);
	    itemList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 153, 0), null, null, new Color(255, 153, 0)));
	    itemList.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	  //  itemList.setVisible(false);
	    itemList.setBounds(416,0,1506,994);
		getContentPane().add(itemList);
	 
		
		
		JPanel Centerpanel = new JPanel();
		Centerpanel.setBounds(263, 94, 701, 453);
		getContentPane().add(Centerpanel);
		Centerpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Show Clock-Day-Taree5");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 35, 394, 224);
		Centerpanel.add(lblNewLabel);
		
			    TrackParcel trackparcel = new TrackParcel();
			    trackparcel.setBounds(416,0,1506,994);
			    trackparcel.setVisible(false);
			    getContentPane().add(trackparcel);
			     trackparcel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 153, 0), null, null, new Color(255, 153, 0)));
			     trackparcel.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblWelcome = new JLabel("Welcome , ");
		lblWelcome.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblWelcome.setForeground(new Color(47, 79, 79));
		lblWelcome.setBackground(new Color(244, 164, 96));
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(96, 32, 108, 26);
		getContentPane().add(lblWelcome);
		
		JLabel lblName = new JLabel(SysData.getInstance().getReceiversMap().get(login.idUser).getFirstName() + " " + SysData.getInstance().getReceiversMap().get(login.idUser).getSurname());
		lblName.setBounds(197, 35, 108, 26);
		getContentPane().add(lblName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 153, 0), new Color(255, 153, 0), new Color(255, 153, 0), new Color(255, 153, 0)));
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(10, 109, 211, 283);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		ListButton = new JButton("Item History");
		ListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemList.setVisible(true);
				Centerpanel.setVisible(false);
				trackparcel.dispose();
			}
		});
		
		
		
		
		panel_1.add(ListButton);
		ListButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		ListButton.setBackground(new Color(102, 0, 204));
		ListButton.setBounds(10, 23, 189, 53);
		
		JButton btnNewButton = new JButton("Track Parcel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Centerpanel.setVisible(false);
				trackparcel.setVisible(true);
				itemList.dispose();
			}
		});
		
		
		btnNewButton.setBackground(new Color(102, 51, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 99, 189, 53);
		panel_1.add(btnNewButton);
		
		JButton Homebtn = new JButton("Home");
		Homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Centerpanel.setVisible(true);
				//Centerpanel.setBounds(70, 70, 1200, 850);
				trackparcel.dispose();
				itemList.dispose();
				
			}
		});
		
		
		Homebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Homebtn.setBackground(new Color(153, 0, 255));
		Homebtn.setBounds(10, 181, 189, 53);
		panel_1.add(Homebtn);
		
		JInternalFrame inFrame = new JInternalFrame("New JInternalFrame");
		inFrame.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 153, 0), null, null, new Color(255, 153, 0)));
		inFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		inFrame.setVisible(false);
		inFrame.setBounds(155, 78, 583, 515);
		getContentPane().add(inFrame);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 204, 102));
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		JMenuItem mntmLogout = new JMenuItem("LogOut");
		mntmLogout.setHorizontalAlignment(SwingConstants.CENTER);
		FileMenu.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		FileMenu.add(mntmExit);
		
		JMenu mnNavigate = new JMenu("Navigate");
		menuBar.add(mnNavigate);
		
		JMenuItem mntmDisplayItemHistory = new JMenuItem("Display Item History");
		mntmDisplayItemHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemList.setVisible(true);
				Centerpanel.setVisible(false);
				trackparcel.dispose();
			}
		});
		
		
		
		mnNavigate.add(mntmDisplayItemHistory);
		
		JMenuItem mntmParcelTracking = new JMenuItem("Parcel Tracking");
		mntmParcelTracking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Centerpanel.setVisible(false);
				trackparcel.setVisible(true);
				itemList.dispose();
			}
		});
		mnNavigate.add(mntmParcelTracking);
	}
}