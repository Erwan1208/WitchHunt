import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Joueur {

    public int points;


    public String pseudo;
    

    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();


    public List<Identite> identite = new ArrayList<Identite> ();


    public int accuserJoueur() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Quel joueur accuser ?");
    	int Joueur_accuse = scanner.nextInt();
    	return Joueur_accuse;
    }

    public Joueur(String username, int Nombre_points) {
    	this.pseudo = username;
    	this.points = Nombre_points;
    }
    
    public Joueur(int Nombre_points) {
    	this.points = Nombre_points;
    }

    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }


    public void jouer() {
    	System.out.println("--- Trois formes de jeu possibles ---\n");
    	System.out.println("Quel type de cartes jouer ? Identité / Rumeur \n");
    	Scanner scanner = new Scanner(System.in);
    	String Type_cartes = scanner.nextInt();
    	//révéler sa carte identité
    	// révéler une carte rumeur 
    	
    }
    

    
    public static void main(String args[]) { 
    	// création du scanner
    	Scanner scanner = new Scanner(System.in);
    	
    	// création d'un tableau d'objets joueurs de type joueur
    	Joueur[] Liste_joueurs = new Joueur[6];
    	
    	// Initialisation du nombre de joueurs	
    	System.out.println("Entrez le nombre de joueurs : \n");
    	int Nb_joueurs = scanner.nextInt();
    	
    	for (int i=0; i<Nb_joueurs; i++) {
    		System.out.println("Entrez le nom du joueur : "+i+"\n");
    		String pseudo = scanner.nextInt();
    		Liste_joueurs[i].setPseudo(pseudo);
    	}
    	
    }
    
    
    
    
    
    
    
}