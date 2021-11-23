import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import game_WitchHunt.Partie;

public class Defausse {

    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();


    public void defausserCarte(Rumeur card) {
    	
    	this.rumeur.add(card);
    }


    public Rumeur piocherCarte(Rumeur card) {
    	Random r = new Random();
        int n = r.nextInt(12);
        //ajouter un getter dans partie
        return Partie.getlistRumeurs[n];
    }

}
