import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ajoute_adherent extends JFrame{
	
	 private  JTextField prenom;
	    private  JLabel jLabel1;
	    private  JLabel jLabel2;
	    private  JLabel jLabel3;
	    private  JButton annuler;
	    private  JButton enrg;
	    private  JTextField cin;
	    private  JTextField nom;
	    private JPanel panel;
   
	public Ajoute_adherent(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
       getContentPane().setLayout(null);
       
        
       this.getContentPane().setLayout(new BorderLayout(5,5));
		 
		 panel = new JPanel();
		 panel.setBounds(0, 0, 432, 40);
		 getContentPane().add(panel);
                panel.setLayout(null);
                jLabel1 = new JLabel();
                jLabel1.setBounds(56, 9, 37, 16);
                panel.add(jLabel1);
                jLabel1.setText("CIN:   ");
                cin = new JTextField();
                cin.setBounds(98, 5, 220, 24);
                panel.add(cin);
                
                cin.setPreferredSize(new Dimension(220, 24 ));
                jLabel2 = new JLabel();
                jLabel2.setBounds(33, 67, 53, 16);
                panel.add(jLabel2);
                jLabel2.setText("Prenom :");
                prenom = new JTextField();
                prenom.setBounds(96, 34, 222, 24);
                panel.add(prenom);
                
                prenom.setPreferredSize(new Dimension(200, 24 ));				
                jLabel3 = new JLabel();
                jLabel3.setBounds(49, 38, 35, 16);
                panel.add(jLabel3);
                jLabel3.setText("Nom :");		
                nom= new JTextField();
                nom.setBounds(98, 63, 220, 24);
                panel.add(nom);
                nom.setPreferredSize(new Dimension(220, 24 ));
                enrg = new JButton("Enregister");
                enrg.setBounds(98, 100, 100, 30);
                panel.add(enrg);
                
                enrg.setPreferredSize(new Dimension(100, 30 ));
                annuler = new JButton("Annuler");
                annuler.setBounds(228, 100, 90, 30);
                panel.add(annuler);
                annuler.setPreferredSize(new Dimension(90, 30 ));
                
                
       annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cin.setText("");
                    
                       prenom.setText("");
                       nom.setText("");
                       
		}
		});
                
       enrg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{	
					Connection con=null ;
				    Statement st=null  ;
				    
				    try{
				       con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				       st=(Statement) con.createStatement();
				       st.executeUpdate("INSERT INTO adherent VALUES ('"+cin.getText()+"','"+prenom.getText()+"','"+nom.getText()+"')") ;
				    }
				    catch(Exception ex) {
				          JOptionPane.showMessageDialog(null,ex.getMessage()) ;
				    }
					                }
					                catch (Exception ex) {} 
				JOptionPane.showMessageDialog(null,"Adherent Enregistre.","ok",JOptionPane.INFORMATION_MESSAGE);

		}

		});
	}
	 
	public static void main(String[] args) {
		Ajoute_adherent aj=new Ajoute_adherent();
		aj.setSize(300,255);  
		   aj.setTitle("Ajouter un Adhérent");   
		   aj.setVisible(true);		

	}

}
