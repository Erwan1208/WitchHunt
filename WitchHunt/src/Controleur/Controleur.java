package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import Modele.Joueur;
import Vue.MonInterface;

/**
 * Ce controleur surveille les évènements sur un objet graphique de la classe Button et en fonction de ces evènements, il déclenche des méthodes de l'objet associés de la classe Interrupteur.
 * @author nigro
 *
 */
public class Controleur {
	
	private MonInterface inter;
	private Joueur joueur;
	
	public Controleur (Joueur j, MonInterface inter){
		this.inter=inter;
		this.joueur=j;
		
		// L'appui sur le bouton
		for(JButton b : inter.boutonscartes ) {
			b.addActionListener(new ActionListener() {
				public void actionPerformed() {
					System.out.println("Test");
				}
			});
		}
		
		
		
		
	}
	
}

