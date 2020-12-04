import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class GUI_2 {

	protected static final String NULL = null;
	 JFrame frame2;
	private JTextField txtNum;

	private JTable table;
	private JScrollPane scrollPane;
	String[] a2={"NUM","Priority","Burst Time","Arrival Time"};
	String[][]a1;
	private JButton btnNext;
	int Num_Of_process;
	private JButton button;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_2 window = new GUI_2();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI_2() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame2.getContentPane().setBackground(new Color(230, 230, 250));
		frame2.setBounds(100, 100, 668, 495);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number Of Process");
		lblEnterNumberOf.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 24));
		lblEnterNumberOf.setBounds(37, 44, 304, 50);
		frame2.getContentPane().add(lblEnterNumberOf);
		
		txtNum = new JTextField();
		txtNum.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtNum.setBounds(376, 45, 68, 50);
		frame2.getContentPane().add(txtNum);
		txtNum.setColumns(10);
		txtNum.setHorizontalAlignment(JTextField.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.setBounds(22, 131, 595, 177);
		frame2.getContentPane().add(scrollPane);
		
		JButton btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon("img\\Ok-icon.png"));
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setVerifyInputWhenFocusTarget(false);
		btnSubmit.setRolloverEnabled(false);
		btnSubmit.setRequestFocusEnabled(false);
		btnSubmit.setOpaque(false);
		btnSubmit.setFocusTraversalKeysEnabled(false);
		btnSubmit.setFocusable(false);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setDefaultCapable(false);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					Num_Of_process=Integer.parseInt(txtNum.getText());
					a1=new String[Num_Of_process][4];
					for (int i = 0; i <Num_Of_process ; i++) {
						
						a1[i][0]=Integer.toString(i+1);	
					}
					table = new JTable(a1,a2);
					table.setRowHeight(30);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getColumnModel().getColumn(0).setPreferredWidth(55);
					table.getColumnModel().getColumn(1).setPreferredWidth(176);
					table.getColumnModel().getColumn(2).setPreferredWidth(176);
					table.getColumnModel().getColumn(3).setPreferredWidth(176);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer.setHorizontalAlignment( JLabel.CENTER );
					for (int i = 0; i < 4; i++) {
						table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
					}
					table.setForeground(new Color(255,50,50));
					table.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 18));
					 table.getTableHeader().setFont(new Font("Showcard Gothic", Font.BOLD,17));
					scrollPane.setViewportView(table);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Input Valid Number");
				}		
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSubmit.setBounds(495, 45, 51, 50);
		frame2.getContentPane().add(btnSubmit);
		btnNext = new JButton("");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFocusable(false);
		btnNext.setFocusTraversalKeysEnabled(false);
		btnNext.setFocusPainted(false);
		btnNext.setDefaultCapable(false);
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnNext.setBorder(null);
		btnNext.setIcon(new ImageIcon("img\\Button-Next-icon.png"));
		btnNext.setBackground(new Color(240, 248, 255));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// validation
				String s;
				int check=0;
				try {
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < 4; j++) {
							s=(String) table.getValueAt(i,j);
							if(Integer.parseInt(s)<0)
							{
								check=-1;
							}
						}
					}
					if(check==-1)
					{
						JOptionPane.showMessageDialog(null,"Input Vaild Number");
					}
					else
					{
						try {
							ObjectOutputStream output =null;
							output =new ObjectOutputStream(new FileOutputStream("files\\table"));
							output.writeObject(a1);
							output.close();
							GUI_3 y=new GUI_3();
							y.frame3.setVisible(true);
							frame2.setVisible(false);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null,"Not Saved");
						}
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Correct! Tyr Agin");
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNext.setBounds(263, 354, 78, 64);
		frame2.getContentPane().add(btnNext);
		
		button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
				GUI_1 x=new GUI_1();
				x.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("img\\Computer-Hardware-Restart-icon.png"));
		button.setOpaque(false);
		button.setFocusable(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setDefaultCapable(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(582, 364, 68, 56);
		frame2.getContentPane().add(button);
	}
}