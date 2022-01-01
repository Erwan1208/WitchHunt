package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Modele.Interrupteur;

/**
 * Ce controleur surveille les �v�nements sur un objet graphique de la classe Button et en fonction de ces ev�nements, il d�clenche des m�thodes de l'objet associ�s de la classe Interrupteur.
 * @author nigro
 *
 */
public class Controleur {
	
	private MonInterface inter;
	private Joueur j;
	
	public Controleur (Joueur j, MonInterface inter){
		this.inter=inter;
		this.j=j;
		
		// L'appui sur le bouton
		unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'interrupteur: activation de "+unInterrupteur);
				unInterrupteur.appuyer();
			}
		});
	}
	
}
