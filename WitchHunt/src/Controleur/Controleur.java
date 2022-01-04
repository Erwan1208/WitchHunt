package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.*;


import Modele.Joueur;
import Modele.Rumeur;
import Vue.MonInterface;

/**
 * Ce controleur surveille les évènements sur un objet graphique de la classe Button et en fonction de ces evènements, il déclenche des méthodes de l'objet associés de la classe Interrupteur.
 * @author nigro
 *
 */
public class Controleur {
	
	public MonInterface inter;
	public Joueur joueur;
	
	public Controleur (Joueur j, MonInterface inter){
		this.inter=inter;
		this.joueur=j;
		
		for(int i=0; i < inter.boutonscartes.size();i++) {
			JButton b = inter.boutonscartes.get(i);
			Rumeur carteLie = joueur.rumeurs.get(i);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					joueur.afficherCarte(carteLie);
				}
			
		
		
		
		
		});
		}
		
		JFrame frame = inter.frame;
		
		frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
				joueur.montrerMain();
			}
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
}
	


