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
import java.awt.Font;

public class Supprimer_adherent  extends JFrame{
	
	
	
	
	 private static JTextField auteur;
	    private  JLabel jLabel1;
	    private  JButton annuler;
	    private  JButton supp;
	    private static  JTextField CIN;
	 
  
	public Supprimer_adherent (){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      getContentPane().setLayout(null);
      
       
      this.getContentPane().setLayout(new BorderLayout(5,5));
      
      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 10, 10);
      getContentPane().add(panel);
      panel.setLayout(null);
      
      
      jLabel1 = new JLabel();
      jLabel1.setBounds(64, 58, 41, 16);
      panel.add(jLabel1);
      
      
      
      jLabel1.setText("CIN :   ");
      
      CIN = new JTextField();
      CIN.setBounds(117, 54, 220, 24);
      panel.add(CIN);
      
CIN.setPreferredSize(new Dimension(220, 24 ));

     supp = new JButton("Supprimer");
     supp.setBounds(95, 107, 100, 30);
     panel.add(supp);
     
      
      supp.setPreferredSize(new Dimension(100, 30 ));
      annuler = new JButton("Annuler");
      annuler.setBounds(247, 107, 90, 30);
      panel.add(annuler);
      annuler.setPreferredSize(new Dimension(90, 30 ));
      
      
      
      
       
      annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CIN.setText("");
		      
              
		}
		});
      

       
       
      supp.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent arg0) {
      			
      			try{
      				  theQuery("delete from adherent where cin="+CIN.getText()) ; 
      				               }
      				               catch (Exception ex) {}
      		
      			
      			
      		

      			
        JOptionPane.showMessageDialog(null,"Adherent Supprimeé.","ok",JOptionPane.INFORMATION_MESSAGE);

      	}

      	});
	}
		 
		

		 
		 public void theQuery(String query){
			    Connection con=null ;
			    Statement st=null  ;
			    
			    try{
			    	 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");				       st=(Statement) con.createStatement();
			       Statement st1 = (Statement) con.createStatement();
			       st.executeUpdate(query) ;
			    }catch(Exception ex) {
			          JOptionPane.showMessageDialog(null,ex.getMessage()) ;
			          
			       
			    }
			}
		
		

	

	
	public static void main(String[] args) {
		Supprimer_adherent aj=new Supprimer_adherent ();
		aj.setSize(500,255);  
		   aj.setTitle("Supprimer un adherent");   
		   aj.setVisible(true);	


	}
}
