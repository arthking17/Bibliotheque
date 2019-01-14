import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ajout_emprunt extends JFrame{
	    private  JLabel jLabel1;
	    private  JLabel jLabel2;
	    private  JButton annuler;
	    private  JTextField cin;
	    private  JTextField code;
	    private JLabel lblNewLabel;
	    private JLabel lblNewLabel_1;
	    private JTextField textField;
	    private JTextField textField_1;
	    private JButton btnAjouter;
	    
   
	public ajout_emprunt(){
		setTitle("L ajoute d un emprunt");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       
        
       this.getContentPane().setLayout(new BorderLayout(5,5));
		 
		 
        jLabel1 = new JLabel();
        jLabel1.setBounds(67, 9, 37, 16);
        cin = new JTextField();
        cin.setBounds(116, 5, 220, 24);
        
cin.setPreferredSize(new Dimension(220, 24 ));

jLabel1.setText("CIN:   ");

JPanel panel1=new JPanel();
panel1.setBounds(0, 62, 432, 191);
getContentPane().add(panel1);
panel1.setLayout(null);

panel1.add(jLabel1);
panel1.add(cin);
jLabel2 = new JLabel();
jLabel2.setBounds(55, 46, 38, 16);
panel1.add(jLabel2);

        jLabel2.setText("Code :");
        code = new JTextField();
        code.setBounds(116, 42, 220, 24);
        panel1.add(code);
        
        code.setPreferredSize(new Dimension(200, 24 ));
        annuler = new JButton("Annuler");
        annuler.setBounds(246, 149, 90, 30);
        panel1.add(annuler);
        annuler.setPreferredSize(new Dimension(90, 30 ));
        
        
       annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cin.setText("");
		     
		       code.setText("");
		       textField.setText("");
               textField_1.setText("");
		}
		});
                
                lblNewLabel = new JLabel("Date emprunt :");
                lblNewLabel.setBounds(7, 83, 90, 16);
                panel1.add(lblNewLabel);
                
                lblNewLabel_1 = new JLabel("Date retour : ");
                lblNewLabel_1.setBounds(17, 117, 86, 16);
                panel1.add(lblNewLabel_1);
                
                textField = new JTextField();
                textField.setBounds(116, 80, 220, 22);
                panel1.add(textField);
                textField.setColumns(10);
                
                textField_1 = new JTextField();
                textField_1.setBounds(116, 114, 220, 22);
                panel1.add(textField_1);
                textField_1.setColumns(10);
                
                btnAjouter = new JButton("Ajouter");
                btnAjouter.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		Connection con=null ;
                	    Statement st=null  ;

       				 try{
       				     Class.forName("com.mysql.cj.jdbc.Driver");
    			        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    			    	st=(Statement) con.createStatement();
    				       st.executeUpdate("insert into emprunt values('"+cin.getText()+"','"+code.getText()+"','"+textField.getText()+"','"+textField_1.getText()+"')") ; 
    				       JOptionPane.showMessageDialog(null," Emprunte Ajoutée") ;
    			    } catch (Exception ex) {	         
    			    	JOptionPane.showMessageDialog(null,ex.getMessage()) ;
} 
       				 
                	}
                });
                btnAjouter.setBounds(126, 152, 97, 25);
                panel1.add(btnAjouter);
				 
		 
   
       }
	
	
		
	public static void main(String[] args) {
		ajout_emprunt aj=new ajout_emprunt();
		aj.setSize(500,255);  
		   aj.setTitle("Ajouter un emprunt");   
		   aj.setVisible(true);		

	}
}