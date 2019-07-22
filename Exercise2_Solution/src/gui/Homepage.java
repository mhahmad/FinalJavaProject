package gui;
import InternalFrames.AddItem;
import InternalFrames.AddParcel;
import InternalFrames.AddReceiver;
import InternalFrames.AddVehicle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Homepage extends JFrame {
	JPanel switchPanel = new JPanel();
	JPanel panelHome = new JPanel();
	JPanel panelAddTruck = new JPanel();
	JButton addButton = new JButton ("Add new truck");
	JButton backButton = new JButton ("Back");
	CardLayout cl = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
	        {
	            System.exit(0);
	        }
		});
		
		JMenuItem logout = new JMenuItem("Log out");
		logout.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile.add(logout);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				login logpage= new login();
				logpage.getJframe().setVisible(true);
				
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnActions = new JMenu("Actions");
		mnActions.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnActions);
		
		JMenuItem mntmAddDriver = new JMenuItem("Add driver");
		mntmAddDriver.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(mntmAddDriver);
		
		JMenuItem vehicleButtonMenu = new JMenuItem("Add Vehicle");
		vehicleButtonMenu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(vehicleButtonMenu);
	
		JMenuItem menuReceiver = new JMenuItem("Add Receiver");
		menuReceiver.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(menuReceiver);
		
		JMenuItem menuAddItem = new JMenuItem("Add Item");
		menuAddItem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(menuAddItem);
		
		JMenuItem menuAddParcel = new JMenuItem("Add Parcel");
		
		menuAddParcel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(menuAddParcel);

		ImageIcon logo = new ImageIcon(this.getClass().getResource("/delivery2-512.png"));
		this.setIconImage(logo.getImage());
		getContentPane().setLayout(null);
		
		AddVehicle frame1 = new AddVehicle();
		this.getContentPane().add(frame1);
	    frame1.setBounds(295, 0, 1627, 994);	
	    AddReceiver frame2 = new AddReceiver();
		getContentPane().add(frame2);
	    frame2.setBounds(295, 0, 1627, 994);
	    AddItem frame3 = new AddItem();
	    getContentPane().add(frame3);
	    frame3.setBounds(295, 0, 1627, 994);
	    AddParcel frame4 = new AddParcel();
	    getContentPane().add(frame4);
	    frame4.setBounds(295,0,1627,994);
		vehicleButtonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(true);
				frame2.dispose();
				frame3.dispose();
				frame4.dispose();
			}
		});
		
		menuReceiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(true);
				frame1.dispose();
				frame3.dispose();
				frame4.dispose();

			}
		});
		
		menuAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(true);
				frame1.dispose();
				frame2.dispose();
				frame4.dispose();
			}
		});
		menuAddParcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame4.setVisible(true);
				frame3.dispose();
				frame2.dispose();
				frame1.dispose();
			}
		});
		
	}
}
