package Vue;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;
import Modele.Interrupteur;
import Modele.Lampe;

public class VueTexte implements Observer, Runnable {

    public static String QUITTER = "Quit";
    public static String COMMUTER = "C";
    public static String PROMPT = ">";

    private Interrupteur interrupteur;

    public VueTexte(Interrupteur inter) {
	this.interrupteur = inter;

	Lampe[] lampes = interrupteur.getCommutateur().getLampes();

	for (int i = 0; i < lampes.length; i++) {
	    lampes[i].addObserver(this);
	}
	Thread t = new Thread(this);
	t.start();
    }

    public void run() {

	String saisie = null;
	boolean quitter = false;

	System.out.println("Taper " + VueTexte.COMMUTER + " pour commuter ; " + VueTexte.QUITTER + " pour quitter.");

	do {
	    saisie = this.lireChaine();

	    if (saisie != null) {
		if (saisie.equals(VueTexte.COMMUTER) == true) {
		    interrupteur.appuyer();
		} else if (saisie.equals(VueTexte.QUITTER) == true) {
		    quitter = true;		    
		} else {
		    System.out.println("Commande non reconnue...");
		}		
	    }
	} while (quitter == false);
	System.exit(0);
    }

    private String lireChaine() {
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	String resultat = null;
	try {
	    System.out.print(VueTexte.PROMPT);
	    resultat = br.readLine();
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	}
	return resultat;	
    }

    @Override
    public void update(Observable arg0, Object arg1) {
	if (arg0 instanceof Lampe) {
	    Lampe lampe = (Lampe) arg0;
	    System.out.print("Lampe " + lampe.getPuissance() + " est ");
	    if (lampe.isAllumee()) {
		System.out.println("allumée.");
	    } else {
		System.out.println("éteinte.");
	    }
	    
	} else {
	    System.err.println("Objet observable non reconnu !");
	}
    }

}
