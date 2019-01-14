import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;



public class Adherent extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Adherent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1= new JPanel();
		panel1.setBounds(0, 0, 725, 74);
		contentPane.add(panel1);

		JLabel titre=new JLabel("Adherents");
		panel1.add(titre);
		titre.setForeground(Color.BLACK);
		titre.setFont(new Font("Times New Roman", Font.BOLD, 50));
		
		JScrollPane pane=new JScrollPane();
		pane.setBounds(90, 90, 520, 260);
		contentPane.add(pane);
		
		JTable table=new JTable ();
		pane.setViewportView(table);

		JPanel panel2= new JPanel();
		panel2.setBorder(null);
		panel2.setBounds(30, 360, 625, 85);
		contentPane.add(panel2);
		
		JButton ajout=new JButton("Ajouter");
		ajout.setPreferredSize(new Dimension(90, 40));
		panel2.add(ajout);
		ajout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
              
              Ajoute_adherent aj=new Ajoute_adherent();
               aj.setVisible(true);
                aj.setSize(500, 300);
                
               
			}
		});
		JButton supp=new JButton("Supprimer");
		supp.setPreferredSize(new Dimension(100, 40));
		panel2.add(supp);
		supp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supprimer_adherent aj=new Supprimer_adherent();
	               aj.setVisible(true);
	                aj.setSize(400, 300);
			   		
			
		}
		});
	
		JButton modif=new JButton("Modifier");
		modif.setPreferredSize(new Dimension(90, 40));
		panel2.add(modif);
	modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Modifier_adherent aj=new Modifier_adherent();
	               aj.setVisible(true);
	                aj.setSize(500, 300);	
		}
		});

		JButton cons=new JButton("Consulter");
		cons.setPreferredSize(new Dimension(90, 40));
		panel2.add(cons);
		cons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="select * from adherent";
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");	
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (SQLException e){
					e.printStackTrace();					
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}

		
		});
		JButton retour=new JButton("Retour");
		retour.setPreferredSize(new Dimension(90, 40));
		panel2.add(retour);
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
              
				Gestion c=new  Gestion();
			       c.setSize(700, 470);  			       
			      c.setVisible(true);
			      dispose();
                
               
		}
		});
		

		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adherent frame = new Adherent();
					frame.setTitle("Gestion Des Adherents"); 
					frame.setSize(700, 470); 
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
