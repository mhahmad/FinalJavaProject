package InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AddParcel extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddParcel frame = new AddParcel();
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
	public AddParcel() {
		setBounds(100, 100, 450, 300);

	}

}
