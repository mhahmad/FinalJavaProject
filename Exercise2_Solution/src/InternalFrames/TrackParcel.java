package InternalFrames;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class TrackParcel extends JInternalFrame {
	public TrackParcel() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 288, 786, 315);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel track1 = new JLabel("");
		track1.setIcon(new ImageIcon(TrackParcel.class.getResource("/4445.png")));
		track1.setBounds(20, 11, 134, 176);
		panel.add(track1);
		
		JLabel track2 = new JLabel("");
		track2.setIcon(new ImageIcon(TrackParcel.class.getResource("/4445.png")));
		track2.setBounds(209, 11, 134, 176);
		panel.add(track2);
		
		JLabel track3 = new JLabel("");
		track3.setIcon(new ImageIcon(TrackParcel.class.getResource("/4445.png")));
		track3.setBounds(410, 11, 125, 176);
		panel.add(track3);
		
		JLabel track4 = new JLabel("");
		track4.setIcon(new ImageIcon(TrackParcel.class.getResource("/4445.png")));
		track4.setBounds(606, 11, 116, 183);
		panel.add(track4);
		
		JLabel MWlabel = new JLabel("Main WareHouse");
		MWlabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		MWlabel.setHorizontalAlignment(SwingConstants.CENTER);
		MWlabel.setBounds(10, 198, 125, 27);
		panel.add(MWlabel);
		
		JLabel Shippedlabel = new JLabel("Shipped");
		Shippedlabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		Shippedlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Shippedlabel.setBounds(219, 198, 69, 21);
		panel.add(Shippedlabel);
		
		JLabel NWlabel = new JLabel("Nearest WareHouse");
		NWlabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		NWlabel.setBounds(387, 193, 163, 37);
		panel.add(NWlabel);
		
		JLabel lblDelivered = new JLabel("Delivered");
		lblDelivered.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblDelivered.setBounds(631, 204, 82, 14);
		panel.add(lblDelivered);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(269, 111, 173, 26);
		getContentPane().add(comboBox);
		
		JLabel ChooseParcel = new JLabel("Select Parcel :");
		ChooseParcel.setFont(new Font("Traditional Arabic", Font.BOLD, 21));
		ChooseParcel.setHorizontalAlignment(SwingConstants.CENTER);
		ChooseParcel.setBounds(75, 100, 200, 44);
		getContentPane().add(ChooseParcel);
		
		JLabel lblStatus = new JLabel("Status  :");
		lblStatus.setForeground(new Color(51, 0, 153));
		lblStatus.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(39, 155, 129, 30);
		getContentPane().add(lblStatus);
		
		JLabel lblstatus1 = new JLabel("Main WareHouse ");
		lblstatus1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		lblstatus1.setVerticalAlignment(SwingConstants.TOP);
		lblstatus1.setBounds(175, 160, 254, 55);
		getContentPane().add(lblstatus1);
		
		JLabel lblstatus2 = new JLabel("Shipped - on the Way to Your Closest WareHouse");
		lblstatus2.setBounds(178, 154, 243, 61);
		getContentPane().add(lblstatus2);
		
		JLabel lblstatus3 = new JLabel("Your Town's WareHouse - Wating to Be Delivered");
		lblstatus3.setBounds(186, 154, 243, 61);
		getContentPane().add(lblstatus3);
		
		JLabel lblstatus4 = new JLabel("Delivered");
		lblstatus4.setBounds(178, 155, 282, 55);
		getContentPane().add(lblstatus4);
		
		JLabel lbltrackHead = new JLabel("Tracking your Parcel");
		lbltrackHead.setForeground(new Color(255, 0, 0));
		lbltrackHead.setHorizontalAlignment(SwingConstants.CENTER);
		lbltrackHead.setFont(new Font("Vivaldi", Font.BOLD, 32));
		lbltrackHead.setBounds(137, 11, 371, 55);
		getContentPane().add(lbltrackHead);
		
		JLabel lblNewLabel = new JLabel("Parcel's  Current  Location : ");
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 23));
		lblNewLabel.setBounds(39, 221, 259, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCurrentLocation = new JLabel("XXXXXXXXXXX");
		lblCurrentLocation.setBounds(324, 232, 91, 25);
		getContentPane().add(lblCurrentLocation);
	}
}