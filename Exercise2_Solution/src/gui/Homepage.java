package gui;

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

public class Homepage extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 450, 300);
		
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
		
		JMenuItem mntmAddTruck = new JMenuItem("Add truck");
		mntmAddTruck.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(mntmAddTruck);
		JMenuItem mntmAddCar = new JMenuItem("Add car");
		mntmAddCar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(mntmAddCar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		contentPane.setLayout(new CardLayout(0, 0));
//		switchPanel.setLayout(cl);
//		panelHome.add(addButton);
//		this.add(switchPanel);
//		panelAddTruck.add(backButton);
//		switchPanel.add(panelHome , "1");
//		switchPanel.add(panelAddTruck , "2");
//		cl.show(switchPanel, "1");
//		addButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				cl.show(switchPanel, "2");
//				
//			}
//		});
//		backButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cl.show(switchPanel, "1");
//			}
//			
//		});
		ImageIcon logo = new ImageIcon(this.getClass().getResource("/delivery2-512.png"));
		this.setIconImage(logo.getImage());
		ImageIcon image1 = new ImageIcon(this.getClass().getResource("/homep.png"));
		JLabel background = new JLabel("");
		background.setIcon(image1);
		this.getContentPane().add(background, "name_87963586766537");

	}
}
