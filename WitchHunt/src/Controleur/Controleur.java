package Controleur;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.*;


import Modele.Joueur;
import Modele.Rumeur;
import Vue.MonInterface;


public class Controleur {
	
	public MonInterface inter;
	public Joueur joueur;
	
	public Controleur (Joueur j, MonInterface inter){
		this.inter=inter;
		this.joueur=j;
		
		for(int i=0; i < inter.boutonscartes.size();i++) {
			JToggleButton b = inter.boutonscartes.get(i);
			Rumeur carteLie = joueur.rumeurs.get(i);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					joueur.afficherCarte(carteLie);
				}});
		}
		
		
		JButton btnJouer = inter.btnJouer;
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inter.p.afficherJoueursVivants("AccuserJoueur");
				
			}
		
		
		});
		
		/*JButton btnEffet = inter.btnEffet;
		btnEffet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inter.p.afficherJoueursVivants("AccuserJoueur");
				System.out.println("Controleur");
				
			}
		
		
		});*/
		
}
}
	


