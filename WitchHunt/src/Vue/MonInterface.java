package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

import Modele.Joueur;
import Modele.Partie;
import Controleur.Controleur;
//import com.sun.java.swing.plaf.windows.resources.windows;



import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.util.*;

public class MonInterface implements Observer{

	private JFrame frame;
	
	
	public List<JButton> boutonscartes = new ArrayList<JButton>();
	public JLabel labelPropriete;
	public JTextArea textPropriete;
	public JLabel labelEffetHunt;
	public JTextArea textEffetHunt;
	public JCheckBox checkEffetHunt;
	public JLabel labelEffetWitch;
	public JTextArea textEffetWitch;
	public JCheckBox checkEffetWitch;
	public JButton buttonJouer;
	
	public JCheckBox checkAccuser;
	
	public Partie Partie;
    
	public void update(Observable instanceObservable, Object arg1) {
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Partie p = new Partie();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface window = new MonInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//VueTexte maConsoleText = new VueTexte(p); 
	}

	/**
	 * Create the application.
	 */
	public MonInterface() {
		initialize();
		
		//notifie que l'Interface graphique Observe les lampes et le commutateur
		Partie p = new Partie();
		this.Partie = p;
		List<Joueur> joueurs = Partie.joueurs;
		for (Joueur j : joueurs) {
		    j.addObserver(this);	
		    }
		p.addObserver(this);

				// * Création du Controleur de l'interrupteur: lien entre le Modéle et la Vue
		for(Joueur j : joueurs) {
			new Controleur(j, this);
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Carte1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(24, 21, 76, 123);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Carte2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(144, 21, 81, 123);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Carte2");
		btnNewButton_1_1.setBounds(272, 21, 76, 123);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(24, 180, 314, 37);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(24, 278, 314, 37);
		frame.getContentPane().add(textPane_1);
		
		JLabel lblNewLabel = new JLabel("Effet Hunt");
		lblNewLabel.setBounds(24, 155, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Effet Witch");
		lblNewLabel_1.setBounds(24, 253, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Jouer Hunt");
		btnNewButton_2.setBounds(411, 186, 123, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Accuser un Joueur");
		btnNewButton_3.setBounds(411, 278, 123, 37);
		frame.getContentPane().add(btnNewButton_3);
	}
	
	

		
	
		
}


	







