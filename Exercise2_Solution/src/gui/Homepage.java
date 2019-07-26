package gui;
import InternalFrames.AddCoordinator;
import InternalFrames.AddDriver;
import InternalFrames.AddItem;
import InternalFrames.AddItemToParcel;
import InternalFrames.AddParcel;
import InternalFrames.AddReceiver;
import InternalFrames.AddVehicle;
import InternalFrames.AddWarehouse;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.Timer;
import javax.swing.UIManager;

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
		
		setTitle("Delivery");
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
		ClockPane clock = new ClockPane();
		clock.setBounds(500, 400, 900, 100);
		this.add(clock);
		JMenu mnActions = new JMenu("Actions");
		mnActions.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnActions);
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 417, 994);
		getContentPane().add(label);
		label.setIcon(new ImageIcon(getClass().getResource("/welcomeAdmin.png")));
		label.setVisible(true);
		JLabel label2 = new JLabel();
		getContentPane().add(label2);
		label2.setBounds(0, 0, 417, 994);
		label2.setIcon(new ImageIcon(getClass().getResource("/whatup.png")));
		label2.setVisible(false);
		JMenuItem vehicleButtonMenu = new JMenuItem("Add Vehicle");
		vehicleButtonMenu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(vehicleButtonMenu);
		
		JMenuItem menuAddItem = new JMenuItem("Add Item");
		menuAddItem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(menuAddItem);
		
		JMenuItem menuAddParcel = new JMenuItem("Add Parcel");
		
		menuAddParcel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(menuAddParcel);
			
		AddItemToParcel frame8 = new AddItemToParcel();
		frame8.setBounds(416, 0, 1506, 994);
		getContentPane().add(frame8);
			JMenuItem mntmAddWarehouse = new JMenuItem("Add Warehouse");
			mntmAddWarehouse.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			mnActions.add(mntmAddWarehouse);
			
			AddVehicle frame1 = new AddVehicle();
			this.getContentPane().add(frame1);
		    frame1.setBounds(416, 0, 1506, 994);	
		    AddReceiver frame2 = new AddReceiver();
			getContentPane().add(frame2);
		    frame2.setBounds(416, 0, 1506, 994);
		    AddItem frame3 = new AddItem();
		    getContentPane().add(frame3);
		    frame3.setBounds(416, 0, 1506, 994);
		    AddParcel frame4 = new AddParcel();
		    getContentPane().add(frame4);
		    frame4.setBounds(416,0,1506,994);
		    AddDriver frame5 = new AddDriver();
		    getContentPane().add(frame5);
		    frame5.setBounds(416, 0, 1506, 994);
		    AddCoordinator frame6 = new AddCoordinator();
		    getContentPane().add(frame6);
		    AddWarehouse frame7 = new AddWarehouse();
		    getContentPane().add(frame7);
		    frame7.setBounds(416, 0, 1506, 994);
		    frame6.setBounds(416,0,1506,994);
			JMenuItem mntmAddDriver = new JMenuItem("Add driver");
			mntmAddDriver.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			mnActions.add(mntmAddDriver);
			mntmAddDriver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame5.setVisible(true);
					frame1.dispose();
					frame2.dispose();
					frame3.dispose();			
					frame4.dispose();
					frame6.dispose();
					frame7.dispose();
					frame8.dispose();
					label2.setVisible(true);
					label.setVisible(false);
				}
			});
		
			JMenuItem menuReceiver = new JMenuItem("Add Receiver");
			menuReceiver.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			mnActions.add(menuReceiver);
			
			menuReceiver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame2.setVisible(true);
					frame1.dispose();
					frame3.dispose();
					frame4.dispose();
					frame5.dispose();
					frame6.dispose();
					frame7.dispose();
					frame8.dispose();
					label2.setVisible(true);
					label.setVisible(false);
				}
			});
		
		JMenuItem mntmAddCoordinator = new JMenuItem("Add Coordinator");
		mntmAddCoordinator.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(mntmAddCoordinator);
		
		JMenuItem addItemtoParcelMenu = new JMenuItem("Add Item to Parcel");
		addItemtoParcelMenu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnActions.add(addItemtoParcelMenu);

		ImageIcon logo = new ImageIcon(this.getClass().getResource("/delivery2-512.png"));
		this.setIconImage(logo.getImage());
		getContentPane().setLayout(null);
		
		
		mntmAddCoordinator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(true);
				frame1.dispose();
				frame2.dispose();
				frame3.dispose();
				frame4.dispose();
				frame5.dispose();
				frame7.dispose();
				frame8.dispose();
				label2.setVisible(true);
				label.setVisible(false);
			}
		});
		vehicleButtonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(true);
				frame2.dispose();
				frame3.dispose();
				frame4.dispose();
				frame5.dispose();
				frame6.dispose();
				frame7.dispose();
				frame8.dispose();
				label2.setVisible(true);
				label.setVisible(false);
			}
		});
		
		menuAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(true);
				frame1.dispose();
				frame2.dispose();
				frame4.dispose();
				frame5.dispose();
				frame6.dispose();
				frame7.dispose();
				frame8.dispose();
				label2.setVisible(true);
				label.setVisible(false);
			}
		});
		menuAddParcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame4.setVisible(true);
				frame3.dispose();
				frame2.dispose();
				frame1.dispose();
				frame5.dispose();
				frame6.dispose();
				frame7.dispose();
				frame8.dispose();
				label2.setVisible(true);
				label.setVisible(false);
			}
		});
		mntmAddWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame7.setVisible(true);
				frame3.dispose();
				frame2.dispose();
				frame1.dispose();
				frame5.dispose();
				frame6.dispose();
				frame4.dispose();
				frame8.dispose();
				label2.setVisible(true);
				label.setVisible(false);
			}
		});
		addItemtoParcelMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame8.setVisible(true);
				frame3.dispose();
				frame2.dispose();
				frame1.dispose();
				frame5.dispose();
				frame6.dispose();
				frame4.dispose();
				frame7.dispose();
				label2.setVisible(true);
				label.setVisible(false);
			}
		});
		JLabel background = new JLabel();
		getContentPane().add(background);
		background.setVisible(true);
		background.setIcon(new ImageIcon(getClass().getResource("/theBackground.png")));
		background.setBounds(0, 0, 1920, 980);
		

	}
    public class ClockPane extends JPanel {

        private JLabel clock;

        public ClockPane() {
            setLayout(new BorderLayout());
            clock = new JLabel();
//            setOpaque( false ) ;
            clock.setHorizontalAlignment(JLabel.CENTER);
            clock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 72f));
            tickTock();
            add(clock);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tickTock();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.setInitialDelay(0);
            timer.start();
        }

        public void tickTock() {
            clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
        }
    }
}
