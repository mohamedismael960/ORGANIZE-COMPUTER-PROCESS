import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_3 {

	JFrame frame3;
	String s[][];
	int s2[][];
	int s3[][];
	
	String[] a2={"NUM","Calculation","Result"};
	String[][]a1;
	String[][]a11;
	String[][]a111;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_3 window = new GUI_3();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public GUI_3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(new Color(240, 248, 255));
		frame3.setBounds(100, 100, 873, 562);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ObjectInputStream input =null;
		try {
			input =new ObjectInputStream(new FileInputStream("files\\table"));
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		try {
		s= (String[][]) input.readObject();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not Read");
		}
		s2=new int [s.length][4];
		s3=new int [s.length][4];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < 4; j++) {
				s2[i][j]=Integer.parseInt(s[i][j]);
				s3[i][j]=Integer.parseInt(s[i][j]);
				
			}
		}
		frame3.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 831, 141);
		scrollPane.setBackground(new Color(255, 240, 245));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame3.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(240, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		
		int sum_of_burst_time=0;
		int mini_arrival_time=Integer.parseInt(s[0][3]);
		for (int i = 0; i < s.length; i++) {
			sum_of_burst_time+=Integer.parseInt(s[i][2]);
			if(Integer.parseInt(s[i][3])<mini_arrival_time)
			{
				mini_arrival_time=Integer.parseInt(s[i][3]);
			}
		}
		
		ArrayList<int[]> gant = new ArrayList<>();
		int []arr=new int[2];
		int priority_of_process_who_enter=0;
		int Num_of_process_who_enter=0;
		int oi=sum_of_burst_time;
		for (int i = 0; i <oi;i++) {    // al for loop bta3t al gantchar
			
			for (int j = 0; j < s2.length; j++) {
				if(s2[j][1]>priority_of_process_who_enter &&s2[j][3]<=i && s2[j][2] !=0)
				{
					priority_of_process_who_enter=s2[j][1];
					Num_of_process_who_enter=s2[j][0];
				}
			}
			arr[0]=Num_of_process_who_enter;
			if(Num_of_process_who_enter==0) oi++;
			arr[1]=i;
			
			gant.add(arr);
			
			if(Num_of_process_who_enter!=0)
			s2[Num_of_process_who_enter-1][2]--;
			
			priority_of_process_who_enter=0;
			Num_of_process_who_enter=0;
			arr=new int[2];
		}
	
		
		int []array1=new int [2];
		array1=gant.get(0);
		int y2=array1[0];
			for (int i =1; i <gant.size(); i++) {
				
				array1=gant.get(i);
				
				if(array1[0]==y2)
				{
					gant.remove(i);
					i--;
				}
				y2=array1[0];
						
			}
		ArrayList<JLabel> lblNewLabel=new ArrayList<>();
		ArrayList<JLabel> lblNewLabel2=new ArrayList<>();
		
		int x=0;
		int y=0;
		int []array4=new int [2];
		for (int i = 0; i < gant.size(); i++) {
			array4=gant.get(i);
			if(array4[0]==0)
				lblNewLabel.add( new JLabel("-"));
			else
				lblNewLabel.add( new JLabel("p"+(array4[0])));
			
				lblNewLabel.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.get(i).setFont(new Font("Verdana", Font.BOLD, 23));
				lblNewLabel.get(i).setForeground(new Color(0, 0, 0));
				if (i%2==0)
				{
					lblNewLabel.get(i).setBackground(new Color(255, 228, 225));
				} else {
					lblNewLabel.get(i).setBackground(new Color(250, 250, 217));
				}
				
				lblNewLabel.get(i).setOpaque(true);
				
				if(i==0)
				{
					lblNewLabel.get(i).setBounds(0, 0, 150, 76);
				}
				else
				{
					lblNewLabel.get(i).setBounds(x=x+150, 0, 150, 76);
				}
				lblNewLabel2.add(new JLabel(""+(array4[1]))) ;
				lblNewLabel2.get(i).setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel2.get(i).setFont(new Font("Verdana", Font.BOLD, 12));
				lblNewLabel2.get(i).setForeground(new Color(0, 0, 0));	
				
				
				if(i==0)
				{
					lblNewLabel2.get(i).setBounds(0, 80, 150, 20);
					
				}
				else
				{
					lblNewLabel2.get(i).setBounds(y+=150, 80, 150, 20);
				}
				
				
				panel_1.add(lblNewLabel.get(i));
				panel_1.add(lblNewLabel2.get(i));
				
				if (i==(gant.size()-1))
				{
					
					lblNewLabel2.add( new JLabel(""+oi));
				
					lblNewLabel2.get(i+1).setHorizontalAlignment(SwingConstants.LEFT);
					lblNewLabel2.get(i+1).setFont(new Font("Verdana", Font.BOLD, 12));
					lblNewLabel2.get(i+1).setForeground(new Color(0, 0, 0));			
					lblNewLabel2.get(i+1).setBounds(y=y+115, 80, 150, 20);
					panel_1.add(lblNewLabel2.get(i+1));
				}		
				
		}
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, x+150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 222, 257, 141);
		scrollPane_1.setBackground(new Color(240, 248, 255));
		frame3.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		///////////////////////////////

		//////////////////////////////
		// calculation response time
		ArrayList<int[]> gant2 = new ArrayList<>();
		gant2 = (ArrayList<int[]>)gant.clone();
		
		int []arr1=new int [2];
		arr1=gant2.get(0);
		int t1=arr1[0];
			for (int i =1; i <gant2.size(); i++) {
				
				arr1=gant2.get(i);
				
				for (int j = i; j < gant2.size(); j++) {
					arr1=gant2.get(j);
					
					if(arr1[0]==t1)
					{
						gant2.remove(j);
					}
					
				}
				arr1=gant2.get(i);
				t1=arr1[0];
			}
			
			/////////////////////////////////
			int []arr7=new int [2];
			
			
			
				for (int i =0; i <gant2.size(); i++) {
					
					arr7=gant2.get(i);
					if(arr7[0]==0)
					{
						gant2.remove(i);
					}
				}
			int []arr6=new int [6];
			a1 =new String[gant2.size()][3];
			int u;
			for (int i = 0; i <gant2.size(); i++) {
				arr6=gant2.get(i);
				/////////////////////////////////////////////
				
				for (u = 0; u < s3.length; u++) {
					
						if(arr6[0]==s3[u][0])
						{
							break;
						}
						
					
				}
				
				/////////////////////////////////////////////
				for (int j = 0; j < 3; j++) {
					if(j==0)
					{
						a1[i][j]=""+("P"+arr6[0]);
					}
					if(j==1)
					{
						a1[i][j]=""+(arr6[1])+"-"+(s3[u][3]);
					}
					if(j==2)
					{
						a1[i][j]=""+(arr6[1]-s3[u][3]);
					}
				}
			}
			
			table = new JTable(a1,a2);
			table.setRowHeight(30);
			table.setEnabled(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			table.getColumnModel().getColumn(2).setPreferredWidth(15);
			table.setForeground(new Color(255,50,50));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for (int i = 0; i < 3; i++) {
				table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
			table.setFont(new Font("Tahoma", Font.BOLD , 12));
			 table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD,12));
			scrollPane_1.setViewportView(table);
			
			JLabel lblNewLabel_1 = new JLabel("Response Time");
			lblNewLabel_1.setBounds(12, 177, 257, 42);
			lblNewLabel_1.setFocusable(false);
			lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
			lblNewLabel_1.setBackground(new Color(255, 250, 250));
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			frame3.getContentPane().add(lblNewLabel_1);
			String p;
			int sum2=0;
			for (int i = 0; i < table.getRowCount(); i++) {
				p=(String) table.getValueAt(i,2);
				sum2=sum2+Integer.parseInt(p);
			}
			
			float avg = (float) 0.1;
			avg=(float) sum2/table.getRowCount();
			JLabel lblNewLabel_2 = new JLabel("Average = "+avg);
			lblNewLabel_2.setBounds(12, 383, 257, 47);
			lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD, 15));
			frame3.getContentPane().add(lblNewLabel_2);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(303, 222, 257, 141);
			scrollPane_2.setBackground(new Color(240, 248, 255));
			frame3.getContentPane().add(scrollPane_2);
			
			table_1 = new JTable();
			scrollPane_2.setViewportView(table_1);
			
			// calculation turn around time and waiting time
			ArrayList<int[]> gant3 = new ArrayList<>();
			gant3 = (ArrayList<int[]>)gant.clone();
			
			ArrayList<int[]> gant4 = new ArrayList<>();
			int []ar1=new int [2];
			int []ar2=new int [2];
			for (int i = 0; i < gant3.size()-1; i++) {
				ar1=gant3.get(i);
				ar2=gant3.get(i+1);
				ar1[1]=ar2[1];
				gant4.add(ar1);
				ar1=new int [2];
				ar2=new int [2];
				if(i+1==gant3.size()-1)
					{
					ar1=gant3.get(i+1);
					
					ar1[1]=oi;
					gant4.add(ar1);
					}
			}
			
			
			
			
			int []arr2=new int [2];
			arr2=gant4.get(gant4.size()-1);
			int t2=arr2[0];
				for (int i =gant4.size()-2; i>=0; i--) {
					
					arr2=gant4.get(i);
					
					for (int j = i; j>=0; j--) {
						arr2=gant4.get(j);
						
						if(arr2[0]==t2)
						{
							gant4.remove(j);
						}
						
					}
					arr2=gant4.get(i);
					t2=arr2[0];
				}
				
				
				
				int []arr8=new int [2];
				for (int i =0; i <gant4.size(); i++) {
					
					arr8=gant4.get(i);
					if(arr8[0]==0)
					{
						gant4.remove(i);
					}
				}
				
			
				
				
				//1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111//
				
				int []arr12=new int [6];
				a11 =new String[gant4.size()][3];
				a111 =new String[gant4.size()][3];
				int u3;
				for (int i = 0; i <gant4.size(); i++) {
					arr12=gant4.get(i);
					/////////////////////////////////////////////
					
					for (u3 = 0; u3 < s3.length; u3++) {
						
							if(arr12[0]==s3[u3][0])
							{
								break;
							}
							
						
					}
					
					/////////////////////////////////////////////
					for (int j = 0; j < 3; j++) {
						if(j==0)
						{
							a11[i][j]=""+("P"+arr12[0]);
							a111[i][j]=""+("P"+arr12[0]);
						}
						if(j==1)
						{
							a11[i][j]=""+(arr12[1])+"-"+(s3[u3][3]);
							a111[i][j]=""+(arr12[1])+"-"+s3[u3][2]+"-"+(s3[u3][3]);
						}
						if(j==2)
						{
							a11[i][j]=""+(arr12[1]-s3[u3][3]);
							a111[i][j]=""+(arr12[1]-s3[u3][2]-s3[u3][3]);
							
						}
					}
				}
				/*int []array3=new int [2];
				for (int i = 0; i < gant4.size(); i++) {
					array3=gant4.get(i);
					System.out.println(array3[0]+"--"+array3[1]);
				}*/
				
				table_1 = new JTable(a11,a2);
				table_1.setRowHeight(30);
				table_1.setEnabled(false);
				table_1.getColumnModel().getColumn(0).setPreferredWidth(15);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(15);
				table_1.setForeground(new Color(255,50,50));
				DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
				centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
				for (int i = 0; i < 3; i++) {
					table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer1 );
				}
				table_1.setFont(new Font("Tahoma", Font.BOLD , 12));
				table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD,12));
				
				scrollPane_2.setViewportView(table_1);
				
				JLabel label = new JLabel("Turn Around Time");
				label.setBounds(303, 177, 257, 42);
				label.setOpaque(true);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
				label.setBackground(new Color(255, 250, 250));
				frame3.getContentPane().add(label);
				
				String p2;
				int sum3=0;
				for (int i = 0; i < table_1.getRowCount(); i++) {
					p2=(String) table_1.getValueAt(i,2);
					sum3=sum3+Integer.parseInt(p2);
				}
				
				float avg2= (float) 0.1;
				
				avg2=(float) sum3/table_1.getRowCount();
				
				JLabel label_1 = new JLabel("Average = "+avg2);
				label_1.setBounds(315, 383, 257, 47);
				label_1.setFont(new Font("Wide Latin", Font.BOLD, 15));
				frame3.getContentPane().add(label_1);
				
				JLabel lblWaitingTime = new JLabel("Waiting Time");
				lblWaitingTime.setBounds(584, 177, 259, 42);
				lblWaitingTime.setOpaque(true);
				lblWaitingTime.setHorizontalAlignment(SwingConstants.CENTER);
				lblWaitingTime.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
				lblWaitingTime.setBackground(new Color(255, 250, 250));
				frame3.getContentPane().add(lblWaitingTime);
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(584, 222, 259, 141);
				scrollPane_3.setBackground(new Color(240, 255, 255));
				frame3.getContentPane().add(scrollPane_3);

				table_2 = new JTable(a111,a2);
				
				
				
				table_2.setRowHeight(30);
				table_2.setEnabled(false);
				table_2.getColumnModel().getColumn(0).setPreferredWidth(15);
				table_2.getColumnModel().getColumn(2).setPreferredWidth(15);
				table_2.setForeground(new Color(255,50,50));
				DefaultTableCellRenderer centerRenderer11 = new DefaultTableCellRenderer();
				centerRenderer11.setHorizontalAlignment( JLabel.CENTER );
				for (int i = 0; i < 3; i++) {
					table_2.getColumnModel().getColumn(i).setCellRenderer( centerRenderer11 );
				}
				table_2.setFont(new Font("Tahoma", Font.BOLD , 12));
				table_2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD,12));
				
				
				scrollPane_3.setViewportView(table_2);
				
				String p3;
				int sum4=0;
				for (int i = 0; i < table_2.getRowCount(); i++) {
					p3=(String) table_2.getValueAt(i,2);
					sum4=sum4+Integer.parseInt(p3);
				}
				
				float avg3= (float) 0.1;
				
				avg3=(float) sum4/table_2.getRowCount();
				
				JLabel label_2 = new JLabel("Average = "+avg3);
				label_2.setBounds(586, 383, 257, 47);
				label_2.setFont(new Font("Wide Latin", Font.BOLD, 15));
				frame3.getContentPane().add(label_2);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setBounds(758, 446, 97, 56);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						frame3.setVisible(false);
						GUI_1 x=new GUI_1();
						x.getFrame().setVisible(true);
						
					}
				});
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.setFocusPainted(false);
				btnNewButton.setFocusable(false);
				btnNewButton.setFocusTraversalKeysEnabled(false);
				btnNewButton.setDefaultCapable(false);
				btnNewButton.setBorderPainted(false);
				btnNewButton.setContentAreaFilled(false);
				btnNewButton.setOpaque(false);
				btnNewButton.setIcon(new ImageIcon("img\\Computer-Hardware-Restart-icon.png"));
				frame3.getContentPane().add(btnNewButton);
	}
}