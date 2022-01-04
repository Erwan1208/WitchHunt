package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

import Modele.Joueur;
import Modele.Partie;
import Modele.Rumeur;
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
	
	public Partie p;
    
	public void update(Observable instanceObservable, Object arg1) {
		
		if(instanceObservable instanceof Joueur && arg1 instanceof Rumeur) {
			textEffetHunt.setText("");
			
			if(((Rumeur)arg1).hunt.piocherCarteDefausse) {
				textEffetHunt.setText(textEffetHunt.getText()+"Add one discarded card to your hand, then discard this card");
			}
			if(((Rumeur)arg1).hunt.faireRevelerIdentite) {
				textEffetHunt.setText(textEffetHunt.getText()+"Reveal another player's Identity. Witch: You gain 2 points. You take next turn; Villager: You lose 2 points. They take next turn ");
			}
			if(((Rumeur)arg1).hunt.choisiProchainJoueur) {
				textEffetHunt.setText(textEffetHunt.getText()+"Choose Next Player");
			}
			if(((Rumeur)arg1).hunt.regarderIdentite) {
				textEffetHunt.setText(textEffetHunt.getText()+"Before their turn, secretely look at their identity");
			}
			if(((Rumeur)arg1).hunt.piocherPropreCarteRumeur) {
				textEffetHunt.setText(textEffetHunt.getText()+"Take one of your own revealed Rumor cards into your hand");
			}
			if(((Rumeur)arg1).hunt.volerCarte) {
				textEffetHunt.setText(textEffetHunt.getText()+"Before their turn, take a random card from their hand at add it to your hand");
			}
			if(((Rumeur)arg1).hunt.faireRevelerOuDefausser) {
				textEffetHunt.setText(textEffetHunt.getText()+"Choose a player. They must reveal their identity or discard a card from their hand.\n Witch: You gain 1 point.You take next turn;\nVillager: You lose 1 point. They take next turn. \nDiscard: They take next turn. ");
			}
			if(((Rumeur)arg1).hunt.revelerPropreIdentite) {
				textEffetHunt.setText(textEffetHunt.getText()+"Reveal your Identity. \n Witch: Player to your left takes next turn ; \n Villager : you take next turn");
			}
			if(((Rumeur)arg1).hunt.faireAccuserAutreJoueur) {
				textEffetHunt.setText(textEffetHunt.getText()+"On their turn they must accuse a player other than you.");
			}
			if(((Rumeur)arg1).hunt.piocherAutreCarteRumeur) {
				textEffetHunt.setText(textEffetHunt.getText()+"Take a revelaed Rumour card from any other player");
			}
			if(((Rumeur)arg1).hunt.blackCat) {
				textEffetHunt.setText(textEffetHunt.getText()+"Add one discarded card from your hand and than discard this one. Take next turn.");
			}
		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
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
		List<Joueur> joueurs = p.joueurs;
		for (Joueur j : joueurs) {
		    j.addObserver(this);	
		    }
		p.addObserver(this);

				// * Cr�ation du Controleur de l'interrupteur: lien entre le Mod�le et la Vue
		for(Joueur j : joueurs) {
			new Controleur(j, this);
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		p = new Partie();
		p.commencerRound();
		
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


	






