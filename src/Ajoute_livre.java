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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ajoute_livre extends JFrame {

	
	 private static JTextField auteur;
	    private  JLabel jLabel1;
	    private  JLabel jLabel2;
	    private  JLabel jLabel3;
	    private  JButton annuler;
	    private  JButton enrg;
	    private static  JTextField code;
	    private  static JTextField titre;
	    private JPanel panel_1;
  
	public Ajoute_livre(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      getContentPane().setLayout(null);
      getContentPane().setLayout(null);
		       
		       panel_1 = new JPanel();
		       panel_1.setBounds(0, 0, 566, 405);
		       getContentPane().add(panel_1);
		       panel_1.setLayout(null);
		       jLabel3 = new JLabel();
		       jLabel3.setBounds(87, 13, 47, 16);
		       panel_1.add(jLabel3);
		       
		              jLabel3.setText("Auteur :");
		              code = new JTextField();
		              code.setBounds(144, 50, 220, 24);
		              panel_1.add(code);
		              
code.setPreferredSize(new Dimension(220, 24 ));
annuler = new JButton("Annuler");
annuler.setBounds(274, 191, 90, 30);
panel_1.add(annuler);
annuler.setPreferredSize(new Dimension(90, 30 ));
auteur= new JTextField();
auteur.setBounds(144, 9, 220, 24);
panel_1.add(auteur);
		auteur.setPreferredSize(new Dimension(220, 24 ));
		titre = new JTextField();
		titre.setBounds(144, 87, 220, 24);
		panel_1.add(titre);
		
		titre.setPreferredSize(new Dimension(220, 24 ));
		       jLabel1 = new JLabel();
		       jLabel1.setBounds(97, 54, 50, 16);
		       panel_1.add(jLabel1);
		       
		       jLabel1.setText("Code :   ");
		       enrg = new JButton("Enregister");
		       enrg.setBounds(144, 191, 100, 30);
		       panel_1.add(enrg);
		       
		       enrg.setPreferredSize(new Dimension(100, 30 ));
		       jLabel2 = new JLabel();
		       jLabel2.setBounds(98, 91, 36, 16);
		       panel_1.add(jLabel2);
		       
		              jLabel2.setText("Titre :");
		              
		              JComboBox comboBox = new JComboBox();
		              comboBox.setModel(new DefaultComboBoxModel(new String[] {"true", "false"}));
		              comboBox.setBounds(144, 124, 134, 22);
		              panel_1.add(comboBox);
		              
		              JLabel lblDisponibilite = new JLabel("Disponibilite :");
		              lblDisponibilite.setBounds(54, 127, 83, 16);
		              panel_1.add(lblDisponibilite);
      enrg.addActionListener(new ActionListener() {
		       		public void actionPerformed(ActionEvent arg0) {
		       			
		       			try{
		       				 theQuery("INSERT INTO livre VALUES ('"+code.getText()+"','"+titre.getText()+"','"+auteur.getText()+"',1)");
		       				 JOptionPane.showMessageDialog(null,"Livre Enregistre.","ok",JOptionPane.INFORMATION_MESSAGE);
		       				                }
		       				                catch (Exception ex) {} 
		       	}

		       	});
annuler.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		code.setText("");
      titre.setText("");
        auteur.setText("");
        
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
		Ajoute_livre aj=new Ajoute_livre();
		aj.setSize(300,255);  
		   aj.setTitle("Ajouter un Livre");   
		   aj.setVisible(true);	
	}
}