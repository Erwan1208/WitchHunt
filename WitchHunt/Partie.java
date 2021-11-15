import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class Partie {
   
    private String gagnant;


    private int round;


    private boolean terminee;


    private int nbJoueurs;

 
    private int nbIdentitesRevelees;

  
    private static  Partie instance;

    
    public List<Joueur> joueur = new ArrayList<Joueur> ();

  
    public List<Defausse> defausse = new ArrayList<Defausse> ();

   
    public void terminerPartie() {
    }


    public void commencerRound() {
    }


    public void afficherPointsJoueurs() {
    }

  
   
    public void changerPoints() {
    }

   
    public static Partie getInstance() {
    	
    	if(instance == null) {
    		instance=new Partie();
    	}
        // Automatically generated method. Please delete this comment before entering specific code.
        return instance;
    }

    private Partie() {
    	this.terminee=false;
    	this.round=1;
    	this.nbIdentitesRevelees=0;
    	System.out.println("Combien de joueur voulez-vous? ");
    	Scanner sc= new Scanner(System.in);
    	int nbJoueurs = sc.nextInt();
    	System.out.println("Il y a " + nbJoueurs + " joueurs");
    	this.nbJoueurs=nbJoueurs;
    	sc.close();
    	for(int i=0;i<nbJoueurs;i++) {
    		Joueur nouvJoueur=new Joueur();
    		this.joueur.add(nouvJoueur);
    	}
    	
    }
    
    public static void main(String[] args) {
    	
    }

}
