package Vue;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

//import com.sun.java.swing.plaf.windows.resources.windows;

import Controleur.ControleurInterrupteur;
import Modele.Commutateur;
import Modele.Interrupteur;
import Modele.Lampe;
import game_WitchHunt.Joueur;
import game_WitchHunt.Partie;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.util.*;

public class MonInterface implements Observer {
	
	// Les propriétés de la classe
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
    
    
	// Le Update est déclenché quand une lampe ou le commutateur change
	public void update(Observable instanceObservable, Object arg1){
		
		
	}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Construction des objets du Modèle
		// Création de l'interrupteur qui crée le commutateur qui crée les lampes
		Partie p = new Partie();
		
		// Création du thread qui crée l'interface graphique	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface window = new MonInterface(p);
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Création de la console - Texte
		VueTexte maConsoleText = new VueTexte(p); 
	}

	/**
	 * Create the application.
	 */
	public MonInterface(Partie p) {

		initialize();
		
		//notifie que l'Interface graphique Observe les lampes et le commutateur
		this.Partie = p;
		Joueur[] joueurs = Partie.joueurs;
		for (int i = 0; i < joueurs.length; i++) {
		    joueurs[i].addObserver(this);
		}
		p.addObserver(this);

		// * Création du Controleur de l'interrupteur: lien entre le Modéle et la Vue
		new Controleur(joueurs, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int cartesParJoueurs = (int) 12/Partie.joueurs.size();
		for(int i=0;i<cartesParJoueurs;i++ ){
			JButton boutonCarte= new JButton("XXX");
			boutonCarte.setBounds(10+i*10, 10, 25, 100);
			frame.getContentPane().add(boutonCarte);
			this.boutonscartes.add(boutonCarte);
		}
		
		labelPropriete = new JLabel("Propriété");
		labelPropriete.setBounds(10, 20, 40, 10);
		frame.getContentPane().add(labelPropriete);
		
		textPropriete = new JTextArea();
		textPropriete.setBounds(10, 20, 40, 10);
		frame.getContentPane().add(textPropriete);
		
		labelEffetHunt = new JLabel("Effet Hunt");
		labelEffetHunt.setBounds(10, 30, 40, 10);
		frame.getContentPane().add(labelEffetHunt);
		
		textEffetHunt = new JTextArea("Effet Hunt");
		textEffetHunt.setBounds(10, 40, 40, 10);
		frame.getContentPane().add(textEffetHunt);
		
		checkEffetHunt = new JCheckBox("Effet Hunt");
		checkEffetHunt.setBounds(80, 40, 10, 10);
		frame.getContentPane().add(checkEffetHunt);
		
		labelEffetHunt = new JLabel("Effet Hunt");
		labelEffetHunt.setBounds(10, 30, 40, 10);
		frame.getContentPane().add(labelEffetHunt);
		
		textEffetHunt = new JTextArea("Effet Hunt");
		textEffetHunt.setBounds(10, 40, 40, 10);
		frame.getContentPane().add(textEffetHunt);
		
		checkEffetHunt = new JCheckBox("Effet Hunt");
		checkEffetHunt.setBounds(80, 40, 10, 10);
		frame.getContentPane().add(checkEffetHunt);
		
		checkAccuser = new JCheckBox("Accuser");
		checkAccuser.setBounds(40,60, 172, 18);
		frame.getContentPane().add(checkAccuser);
		
		buttonJouer = new JButton("Jouer");
		buttonJouer.setBounds(147, 105, 172, 18);
		frame.getContentPane().add(buttonJouer);
		
		
	}
}

