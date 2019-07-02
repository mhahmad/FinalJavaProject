package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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

public class Homepage extends JFrame {

	private JPanel contentPane;

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
		ImageIcon logo = new ImageIcon(this.getClass().getResource("/delivery2-512.png"));
		this.setIconImage(logo.getImage());
		ImageIcon image1 = new ImageIcon(this.getClass().getResource("/homep.png"));
		JLabel background = new JLabel("");
		background.setIcon(image1);
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
			public void actionPerformed(ActionEvent e)
	        {
	            System.exit(0);
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.getContentPane().add(background);
	}

}
