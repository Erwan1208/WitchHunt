import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.lang.String;


public class Joueur {
	
	public Partie jeu;

    public int points;


    public String pseudo;


    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();


    public Identite id;
    
    public Joueur(Partie jeuWitchHunt) {
    	this.jeu=jeuWitchHunt;
    }

    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }
    
    public void changerPoints() {
    	
    }

    public boolean decideAccuser() {
    	System.out.println("Veux-tu accuser un joueur?\n");
    	System.out.println("Ecrit O pour oui et N pour non\n");
    	Scanner sc = new Scanner(System.in);
    	String reponse=sc.next();
    	if(reponse=="O") {
    		return true;
    	}
    	else return false;
    	
    	
    }
    
    public String choisirNomAccuse() {
    	System.out.println("Donner le pseudo de la personne que vous voulez accuser!\n");
    	Scanner sc = new Scanner(System.in);
    	String nomAccuse = sc.next();
    	return nomAccuse;
    	
    }
    
    public boolean choisirRevelerIdentite() {
    	System.out.println("Veux-tu réveler ton identité?\n");
    	System.out.println("Ecrit O pour oui et N pour non\n");
    	Scanner sc = new Scanner(System.in);
    	String reponse= sc.next();
    	if(reponse=="O") {
    		return true;
    	}
    	else return false;
    	
    }
    public void jouerTour() {
    	if(this.decideAccuser()) {
			//Selection de l'accusé
			jeu.afficherJoueursVivants();
			String nomAccuse=this.choisirNomAccuse();
			
			//Recherche de l'accusé
			Iterator<Joueur> itAcc=jeu.joueurs.iterator();
			while(itAcc.hasNext()) {
				Joueur playerSearch=itAcc.next();
				if(playerSearch.pseudo==nomAccuse) {
					
					//Choix Réponse de l'accusé
					if(playerSearch.choisirRevelerIdentite()) {
						playerSearch.id.revelerIdentite();		
					}
					else {
						playerSearch.jouerWitch();
					}
				}
			}
		}
		else {
			this.jouerHunt();
		}
    }
    
    

    public void jouerHunt() {
    	
    	//Choisir quelle carte hunt jouer + la jouer
    }


    public void jouerWitch() {
    	//Choisir quelle Carte Witch jouer + la jouer
    }
    
   
}