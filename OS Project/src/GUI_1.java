import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
public class GUI_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_1 window = new GUI_1();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setPreferredSize(new Dimension(20, 20));
		getFrame().getContentPane().setBounds(new Rectangle(2, 2, 2, 2));
		getFrame().getContentPane().setBackground(new Color(240, 248, 255));
		getFrame().getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		getFrame().setBounds(100, 100, 628, 298);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JLabel lblOperatingSystemProject = new JLabel("Operating System Project");
		lblOperatingSystemProject.setForeground(new Color(255, 0, 0));
		lblOperatingSystemProject.setBounds(new Rectangle(20, 20, 20, 20));
		lblOperatingSystemProject.setDisplayedMnemonicIndex(2);
		lblOperatingSystemProject.setDoubleBuffered(true);
		lblOperatingSystemProject.setFocusTraversalPolicyProvider(true);
		lblOperatingSystemProject.setFocusCycleRoot(true);
		lblOperatingSystemProject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOperatingSystemProject.setAutoscrolls(true);
		lblOperatingSystemProject.setAlignmentY(Component.TOP_ALIGNMENT);
		lblOperatingSystemProject.setBackground(new Color(0, 128, 128));
		lblOperatingSystemProject.setFont(new Font("Wide Latin", Font.PLAIN, 23));
		lblOperatingSystemProject.setBounds(48, 13, 511, 86);
		getFrame().getContentPane().add(lblOperatingSystemProject);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon("img\\Windows-Turn-Off-icon.png"));
		btnNewButton.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(255, 99, 71), new Color(250, 128, 114), new Color(255, 0, 255)), new LineBorder(new Color(255, 0, 255))));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().setVisible(false);
				GUI_2 x=new GUI_2();
				x.frame2.setVisible(true);
			}
		});
		btnNewButton.setBounds(256, 140, 70, 70);
		getFrame().getContentPane().add(btnNewButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
