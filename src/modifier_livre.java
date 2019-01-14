
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.*;

public class modifier_livre extends JFrame{
	
	
	
	 private static JTextField auteur;
	    private  JLabel jLabel1;
	    private  JLabel jLabel2;
	    private  JLabel jLabel3;
	    private  JButton annuler;
	    private  JButton mod;
	    private static  JTextField code;
	    private  static JTextField titre;
	    private JPanel panel;
   
	public modifier_livre(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       
        
       this.getContentPane().setLayout(new BorderLayout(5,5));
		
		panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
        panel.setLayout(null);
		
		
        jLabel1 = new JLabel();
        jLabel1.setBounds(37, 9, 50, 16);
        panel.add(jLabel1);
        
        jLabel1.setText("Code :   ");
        code = new JTextField();
        code.setBounds(113, 5, 220, 24);
        panel.add(code);
        
code.setPreferredSize(new Dimension(220, 24 ));
jLabel2 = new JLabel();
jLabel2.setBounds(37, 38, 36, 16);
panel.add(jLabel2);

        jLabel2.setText("Titre :");
        titre = new JTextField();
        titre.setBounds(113, 34, 220, 24);
        panel.add(titre);
        
        titre.setPreferredSize(new Dimension(220, 24 ));
        jLabel3 = new JLabel();
        jLabel3.setBounds(40, 74, 47, 16);
        panel.add(jLabel3);
        
                jLabel3.setText("Auteur :");
                auteur= new JTextField();
                auteur.setBounds(113, 70, 220, 24);
                panel.add(auteur);
                
		auteur.setPreferredSize(new Dimension(220, 24 ));
		mod = new JButton("Modifier");
		mod.setBounds(113, 135, 100, 30);
		panel.add(mod);
		
		mod.setPreferredSize(new Dimension(100, 30 ));
		annuler = new JButton("Annuler");
		annuler.setBounds(260, 135, 90, 30);
		panel.add(annuler);
		annuler.setPreferredSize(new Dimension(90, 30 ));
		
		 
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code.setText("");
		      titre.setText("");
		        auteur.setText("");
		        
		}
		});
		

        
        
       mod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try{
						 theQuery("update livre set  id= '"+code.getText()+"',titre= '"+titre.getText()+"',auteur='"+auteur.getText()+"' where code='"+code.getText()+"'") ;   
		               }
		               catch (Exception ex) {} 
				
				

					
		  JOptionPane.showMessageDialog(null,"Livre Modifier.","ok",JOptionPane.INFORMATION_MESSAGE);

			}

			});
	}
		 
		

		 
		 
		 public void theQuery(String query){
			    Connection con=null ;
			    Statement st=null  ;
			    
			    try{
			    	 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");				       st=(Statement) con.createStatement();
			       st=(Statement) con.createStatement();
			       Statement st1 = (Statement) con.createStatement();
			       st.executeUpdate(query) ;
			    }catch(Exception ex) {
			          JOptionPane.showMessageDialog(null,ex.getMessage()) ;
			          
			       
			    }
			}	
		

	

	
	public static void main(String[] args) {
		modifier_livre aj=new modifier_livre();
		aj.setSize(500,255);  
		     
		   aj.setVisible(true);	


	}

}

