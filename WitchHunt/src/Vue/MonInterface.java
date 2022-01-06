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

	public JFrame frame = new JFrame();
	
	public Joueur accusateur;
	public Joueur accusé;
	
	public Rumeur carteJouee;
	
	public List<JToggleButton> boutonscartes;
	
	public JLabel labelEffetHunt;
	public JTextPane textEffetHunt;
	public JLabel labelEffetWitch;
	public JTextPane textEffetWitch;

	public JButton btnJouer;
	public JButton btnEffet;
	public JToggleButton btnCarte1; 
	public JToggleButton btnCarte2;
	public JToggleButton btnCarte3;
	public JToggleButton btnCarte4; 
	public JToggleButton btnCarte5;
	public JToggleButton btnCarte6;
	
	
	
	public JCheckBox checkAccuser;
	
	public static Partie p;
    
	public void update(Observable instanceObservable, Object arg1) {
		
		if(instanceObservable instanceof Joueur && arg1 instanceof Rumeur) {
			
			//Effet Hunt
			
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
				textEffetHunt.setText(textEffetHunt.getText()+"Reveal your Identity. \nWitch: Player to your left takes next turn ; \nVillager : you take next turn");
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
			
			//Effet Witch
			textEffetWitch.setText("");
			if (((Rumeur)arg1).witch.faireDefausserCarte){
				textEffetWitch.setText(textEffetWitch.getText()+"The player who accused you discards a random card");
			}
			if (((Rumeur)arg1).witch.defausserCarte){
				textEffetWitch.setText(textEffetWitch.getText()+"Discard a card from your hand");
			}
			if (((Rumeur)arg1).witch.jouerProchain){
				textEffetWitch.setText(textEffetWitch.getText()+"Take next turn");
			}
			if (((Rumeur)arg1).witch.piocherPropreCarteRumeur){
				textEffetWitch.setText(textEffetWitch.getText()+"Take one of your own revealed rumour cards into your hand");
			}
			if (((Rumeur)arg1).witch.piocherCarteAcusateur){
				textEffetWitch.setText(textEffetWitch.getText()+"Take one card from the hand of the player who accused you");
			}
			if (((Rumeur)arg1).witch.choisiProchainJoueur){
				textEffetWitch.setText(textEffetWitch.getText()+"Choose next player");
			}
			if (((Rumeur)arg1).witch.faireAccuserAutreJoueur){
				textEffetWitch.setText(textEffetWitch.getText()+"Choose next player. On their turn they must accuse a player other than you.");
			}
		}
		
		if(instanceObservable instanceof Joueur && arg1 instanceof ArrayList) {
			
			for(int i=0; i< ((ArrayList)arg1).size();i++) {
				Rumeur carteI = ((ArrayList<Rumeur>)arg1).get(i);
				String nomCarteI=carteI.nom;
				JToggleButton btnassocie =this.boutonscartes.get(i);
				btnassocie.setText(nomCarteI);
			}
			
			//Reveler identite
			this.btnJouer.setText("Accuser un joueur");
			ActionListener[] listActions1 = btnJouer.getActionListeners();
			for(ActionListener a : listActions1) {
				btnJouer.removeActionListener(a);
			}
			btnJouer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					p.afficherJoueursVivants("AccuserJoueur");
					accusateur= (Joueur)instanceObservable;
				}
			});
			
			this.btnEffet.setText("Jouer Hunt");
			ActionListener[] listActions2 = btnEffet.getActionListeners();
			for(ActionListener a : listActions2) {
				btnEffet.removeActionListener(a);
			}
			btnEffet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accusateur= (Joueur)instanceObservable;
					p.afficherJoueursVivants("HuntAccusation");
					for(JToggleButton b : boutonscartes) {
						
						if(b.isSelected()){
							carteJouee=null;
							for(Rumeur rumeur : ((Joueur)instanceObservable).rumeurs) {
								if(rumeur.nom.equals(b.getText())) {
									carteJouee = rumeur;
									System.out.println(carteJouee.nom);
								}
							}
							
							
						}
					}
					
				}
			});
			
		}
		
		if(instanceObservable instanceof Joueur && arg1 instanceof String) {
			if(arg1.equals("PageAccuse")) {
				
				System.out.println("PageRepAccuse");
				//Reveler identite
				this.btnJouer.setText("Reveler Identite");
				for(ActionListener a : btnJouer.getActionListeners()) {
					btnJouer.removeActionListener(a);
				}
				btnJouer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						((Joueur)instanceObservable).id.revelerIdentite(); //A developper
					}
				});
				
				//Jouer Witch
				this.btnEffet.setText("Jouer Witch");
				
				for(ActionListener a : btnEffet.getActionListeners()) {
					btnEffet.removeActionListener(a);
				}
				btnEffet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						p.afficherJoueursVivants("WitchAccusation"); //pageWitchAccusation
						
						
					}
				});
				
			}
		}
		
		
		if(instanceObservable instanceof Partie && arg1 instanceof String) {
			System.out.println(arg1);
			if(arg1.equals("AccuserJoueur")) {
				
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.revalidate();
				int y=25;
				for(int i=0;i<p.joueurs.size();i++) {
					Joueur j = p.joueurs.get(i);
					if(j.id.isIdRevelee()==false) {
						JButton btnJoueur = new JButton(j.pseudo);
						btnJoueur.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();
								frame.revalidate();
								frame.repaint();
								initialize();
								j.montrerMain();
								j.pageRepAcusation();
								accusé = j;
							}
						});	
						btnJoueur.setBounds(50, y, 600, 75);
						frame.getContentPane().add(btnJoueur);
					}
					y=y+100;
				}
			}
			if(arg1.equals("WitchAccusation")) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.revalidate();
				int y=25;
				for(int i=0;i<p.joueurs.size();i++) {
					Joueur j = p.joueurs.get(i);
					if(j.id.isIdRevelee()==false) {
						JButton btnJoueur = new JButton(j.pseudo);
						btnJoueur.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("JouerWitch");
								accusé.jouerWitch(carteJouee,accusateur);
								frame.getContentPane().removeAll();
								frame.revalidate();
								frame.repaint();
								initialize();
								accusé.montrerMain();
								accusateur = null;
								accusé = null;
								
							
								
							}
						});	
						btnJoueur.setBounds(50, y, 600, 75);
						frame.getContentPane().add(btnJoueur);
					}
					y=y+100;
				}
			}
			if(arg1.equals("HuntAccusation")) {
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.revalidate();
				int y=25;
				for(int i=0;i<p.joueurs.size();i++) {
					Joueur j = p.joueurs.get(i);
					if(j.id.isIdRevelee()==false) {
						JButton btnJoueur = new JButton(j.pseudo);
						btnJoueur.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.getContentPane().removeAll();
								frame.revalidate();
								frame.repaint();
								initialize();
								j.montrerMain();
								accusateur.jouerHunt(carteJouee, j.pseudo);
								accusateur=null;
							
								
							}
						});	
						btnJoueur.setBounds(50, y, 600, 75);
						frame.getContentPane().add(btnJoueur);
					}
					y=y+100;
				}
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
		
		VueTexte maConsoleText = new VueTexte(p); 
	}

	/**
	 * Create the application.
	 */
	public MonInterface() {
		
		this.p = new Partie();
		p.commencerRound();
		initialize();
		
		//notifie que l'Interface graphique Observe les lampes et le commutateur
		List<Joueur> joueurs = p.joueurs;
		for (Joueur j : joueurs) {
		    j.addObserver(this);	
		    }
		p.addObserver(this);

				// * Création du Controleur de l'interrupteur: lien entre le Modéle et la Vue
		joueurs.get(0).montrerMain();
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		boutonscartes= new ArrayList<JToggleButton>();
		
		frame.setBounds(100, 100, 728, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCarte1 = new JToggleButton("Carte1");
		btnCarte1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarte1.setBounds(24, 21, 76, 123);
		frame.getContentPane().add(btnCarte1);
		boutonscartes.add(btnCarte1);
		
		btnCarte2 = new JToggleButton("Carte2");
		btnCarte2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarte2.setBounds(144, 21, 81, 123);
		frame.getContentPane().add(btnCarte2);
		boutonscartes.add(btnCarte2);
		
		btnCarte3 = new JToggleButton("Carte3");
		btnCarte3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarte3.setBounds(272, 21, 76, 123);
		frame.getContentPane().add(btnCarte3);
		boutonscartes.add(btnCarte3);
		
		
		btnCarte4 = new JToggleButton("Carte4");
		btnCarte4.setBounds(400, 21, 76, 123);
		frame.getContentPane().add(btnCarte4);
		boutonscartes.add(btnCarte4);
		
		btnCarte5 = new JToggleButton("Carte5");
		btnCarte5.setBounds(520, 21, 76, 123);
		frame.getContentPane().add(btnCarte5);
		boutonscartes.add(btnCarte5);
		
		btnCarte6 = new JToggleButton("Carte6");
		btnCarte6.setBounds(640, 21, 76, 123);
		frame.getContentPane().add(btnCarte6);
		boutonscartes.add(btnCarte6);
		
		
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
		
		
		for(Joueur j : this.p.joueurs) {
			new Controleur(j, this);
		}
	}
	
	

		
	
		
}


	







