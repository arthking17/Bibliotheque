
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
public class supprimer_livre extends JFrame{
	
	
	
	
	 private static JTextField auteur;
	    private  JLabel jLabel1;
	    private  JButton annuler;
	    private  JButton supp;
	    private static  JTextField code;
	   
   
	public supprimer_livre(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       
        
       this.getContentPane().setLayout(new BorderLayout(5,5));
		 
		 
        jLabel1 = new JLabel();
        jLabel1.setBounds(5, 12, 50, 16);
        
         code = new JTextField();
         code.setBounds(60, 8, 220, 24);
         
code.setPreferredSize(new Dimension(220, 24 ));



jLabel1.setText("Code :   ");

       
		
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 432, 40);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		panel1.add(jLabel1);
		panel1.add(code);
		
      supp = new JButton("Supprimer");
      supp.setBounds(60, 45, 100, 30);
      panel1.add(supp);
      
       
       supp.setPreferredSize(new Dimension(100, 30 ));
       annuler = new JButton("Annuler");
       annuler.setBounds(190, 45, 90, 30);
       panel1.add(annuler);
       annuler.setPreferredSize(new Dimension(90, 30 ));
       
        
       annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code.setText("");
		      
               
		}
		});
       

       
       
       supp.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent arg0) {
       			
       			try{
       				  theQuery("delete from livre where id="+code.getText()) ; 
       				               }
       				               catch (Exception ex) {}
       		
       			
       			
       		

       			
         JOptionPane.showMessageDialog(null,"Livre Supprimer.","ok",JOptionPane.INFORMATION_MESSAGE);

       	}

       	});
	}
		 
		

		 
		 public void theQuery(String query){
			    Connection con=null ;
			    Statement st=null  ;
			    
			    try{
			    	 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");	
			       st=(Statement) con.createStatement();
			       Statement st1 = (Statement) con.createStatement();
			       st.executeUpdate(query) ;
			    }catch(Exception ex) {
			          JOptionPane.showMessageDialog(null,ex.getMessage()) ;
			          
			       
			    }
			}
		
		

	

	
	public static void main(String[] args) {
		supprimer_livre aj=new supprimer_livre();
		aj.setSize(400,255);  
		    
		   aj.setVisible(true);	


	}

}

