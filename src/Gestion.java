import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Button;

public class Gestion extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) throws MalformedURLException {
		
       
       Gestion c=new  Gestion();
       c.setSize(872, 633);  
      c.setTitle("Gestion De Bibliotheque");   
      c.setVisible(true);
	}
	
	public Gestion() {
		
		 this.getContentPane().setLayout(new BorderLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			Button button = new Button("Gestion Documents");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Livre l = new Livre();
					l.setBounds(0, 0, 872, 633);
					l.setVisible(true);
					dispose();
				}
			});
			button.setForeground(new Color(0, 0, 0));
			button.setBackground(new Color(220, 220, 220));
			menuBar.add(button);
			
			Button button_1 = new Button("Gestion Adherents");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Adherent a = new Adherent();
					a.setBounds(0, 0, 725, 500);

					a.setVisible(true);
					dispose();
				}
			});
			button_1.setForeground(new Color(0, 0, 0));
			button_1.setBackground(new Color(220, 220, 220));
			menuBar.add(button_1);
			
			Button button_2 = new Button("Gestion Emprunts");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					emprunt e1 = new emprunt();
					 e1.setBounds(0, 0, 725, 500);
					e1.setVisible(true);
					dispose();
				}
			});
			button_2.setForeground(new Color(0, 0, 0));
			button_2.setBackground(new Color(220, 220, 220));
			menuBar.add(button_2);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5,15, 15));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\Yahya\\workspace\\MiniProjet\\Books.jpg"));
			label.setBounds(0, 0, 859, 569);
			contentPane.add(label);
	   }
		}

