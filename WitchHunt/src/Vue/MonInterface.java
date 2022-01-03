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
	
	public JLabel labelEffetHunt;
	public JTextPane textEffetHunt;
	public JLabel labelEffetWitch;
	public JTextPane textEffetWitch;

	public JButton btnJouer;
	public JButton btnEffet;
	public JButton btnCarte1;
	public JButton btnCarte2;
	public JButton btnCarte3;
	
	
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
		frame.setBounds(100, 100, 728, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCarte1 = new JButton("Carte1");
		btnCarte1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarte1.setBounds(24, 21, 76, 123);
		frame.getContentPane().add(btnCarte1);
		boutonscartes.add(btnCarte1);
		
		btnCarte2 = new JButton("Carte2");
		btnCarte2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarte2.setBounds(144, 21, 81, 123);
		frame.getContentPane().add(btnCarte2);
		boutonscartes.add(btnCarte2);
		
		btnCarte3 = new JButton("Carte3");
		btnCarte3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarte3.setBounds(272, 21, 76, 123);
		frame.getContentPane().add(btnCarte3);
		boutonscartes.add(btnCarte3);
		
		textEffetHunt = new JTextPane();
		textEffetHunt.setBounds(24, 180, 314, 37);
		frame.getContentPane().add(textEffetHunt);
		
		textEffetWitch = new JTextPane();
		textEffetWitch.setBounds(24, 278, 314, 37);
		frame.getContentPane().add(textEffetWitch);
		
		labelEffetHunt = new JLabel("Effet Hunt");
		labelEffetHunt.setBounds(24, 155, 81, 14);
		frame.getContentPane().add(labelEffetHunt);
		
		labelEffetWitch = new JLabel("Effet Witch");
		labelEffetWitch.setBounds(24, 253, 81, 14);
		frame.getContentPane().add(labelEffetWitch);
		
		btnEffet = new JButton("Jouer Hunt");
		btnEffet.setBounds(411, 186, 123, 31);
		frame.getContentPane().add(btnEffet);
		
		btnJouer = new JButton("Accuser un Joueur");
		btnJouer.setBounds(411, 278, 123, 37);
		frame.getContentPane().add(btnJouer);
	}
	
	

		
	
		
}


	







