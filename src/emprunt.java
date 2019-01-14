import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.*;
public class emprunt extends JFrame {
	 private JPanel contentPane;
	 
public emprunt(){
	
	
	 this.getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5,15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1= new JPanel();
		panel1.setBounds(0, 0, 725, 74);
		contentPane.add(panel1);

		JLabel titre=new JLabel("emprunts");
		panel1.add(titre);
		titre.setForeground(Color.BLACK);
		titre.setFont(new Font("Times New Roman", Font.BOLD, 50));
		
		JScrollPane pane=new JScrollPane();
		pane.setBounds(90, 90, 520, 260);
		contentPane.add(pane);
		
		JTable table=new JTable ();
		pane.setViewportView(table);

		
		
		JPanel panel2= new JPanel();
		panel2.setBounds(30, 360, 625, 974);
		contentPane.add(panel2);
		
		JButton ajout=new JButton("Ajouter");
		ajout.setPreferredSize(new Dimension(90, 40));
		panel2.add(ajout);
		ajout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
               ajout_emprunt aj=new ajout_emprunt();
               aj.setVisible(true);
                aj.setSize(450, 300); 
		}
		});
	
        
	
		JButton modif=new JButton("Modifier");
		modif.setPreferredSize(new Dimension(90, 40));
		panel2.add(modif);
	modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modifier_emprunt aj=new Modifier_emprunt();
				aj.setSize(450,255);  
				   aj.setVisible(true);

			
		}
		});
	
		JButton cons=new JButton("Consulter");
		cons.setPreferredSize(new Dimension(90, 40));
		panel2.add(cons);
		cons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				String sql="select * from emprunt";
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection  con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (SQLException e){
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}

		
		});
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supp_emprunt c=new  supp_emprunt();
			       c.setSize(450, 180);  
			       
			      c.setVisible(true);
             
			}
		});
		btnSupprimer.setPreferredSize(new Dimension(90, 40));
		panel2.add(btnSupprimer);
		
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
	

public static void main(String[] args){
	emprunt p=new emprunt();
    p.setSize(700, 470);  
   p.setTitle("Gestion De Bibliothque");   
   p.setVisible(true);
}
}

