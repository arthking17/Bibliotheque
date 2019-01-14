import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


public class Modifier_adherent extends JFrame{
	
	
	
	 private static JTextField nom;
	    private  JLabel jLabel1;
	    private  JLabel jLabel2;
	    private  JLabel jLabel3;
	    private  JButton annuler;
	    private  JButton mod;
	    private static  JTextField cin;
	    private  static JTextField prenom;
	    private JPanel panel;
   
	public Modifier_adherent(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       this.getContentPane().setLayout(new BorderLayout(5,5));
		        
		        panel = new JPanel();
		        panel.setBounds(0, 0, 10, 10);
		        getContentPane().add(panel);
        panel.setLayout(null);
		        
		        
        jLabel1 = new JLabel();
        jLabel1.setBounds(35, 13, 41, 16);
        panel.add(jLabel1);
        
        jLabel1.setText("CIN :   ");
        cin = new JTextField();
        cin.setBounds(88, 9, 220, 24);
        panel.add(cin);
        
cin.setPreferredSize(new Dimension(220, 24 ));
jLabel2 = new JLabel();
jLabel2.setBounds(13, 79, 53, 16);
panel.add(jLabel2);

        jLabel2.setText("Prenom :");
        prenom= new JTextField();
        prenom.setBounds(88, 46, 220, 24);
        panel.add(prenom);
        
		prenom.setPreferredSize(new Dimension(200, 24 ));
		jLabel3 = new JLabel();
		jLabel3.setBounds(31, 50, 35, 16);
		panel.add(jLabel3);
		
		        jLabel3.setText("Nom :");
		        nom= new JTextField();
		        nom.setBounds(88, 79, 220, 24);
		        panel.add(nom);
		        
		        nom.setPreferredSize(new Dimension(220, 24 ));
		        mod = new JButton("Modifier");
		        mod.setBounds(88, 116, 100, 30);
		        panel.add(mod);
		        
		        mod.setPreferredSize(new Dimension(100, 30 ));
		        annuler = new JButton("Annuler");
		        annuler.setBounds(214, 116, 90, 30);
		        panel.add(annuler);
		        annuler.setPreferredSize(new Dimension(90, 30 ));
		        
		         
		        annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cin.setText("");
		      nom.setText("");
		        prenom.setText("");
		                
		}
		});
		        

        
        
       mod.addActionListener(new ActionListener() {
		        		public void actionPerformed(ActionEvent arg0) {
		        			 Connection con=null;
		        			    Statement st=null  ;
		        			try{
		        			  con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		        				String sql="select * from adherent where cin='"+cin.getText()+"'";
		        				PreparedStatement ps=con.prepareStatement(sql);
		        				ResultSet rs=ps.executeQuery();
		        					st=(Statement) con.createStatement();
		        				    st.executeUpdate("update adherent set prenom= '"+prenom.getText()+"',nom='"+nom.getText()+"' where cin='"+cin.getText()+"'") ;
		        				    JOptionPane.showMessageDialog(null,"Adherent Modifier.","ok",JOptionPane.INFORMATION_MESSAGE);}

		                       
		                       catch (Exception ex) {} 
		        		
		        		

		        			
		          

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
		Modifier_adherent aj=new Modifier_adherent();
		aj.setSize(500,255);  
		   aj.setTitle("Modifier Adherent");   
		   aj.setVisible(true);	


	}

}