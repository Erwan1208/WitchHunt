package jeuWitchHunt;
import java.util.ArrayList;
import java.util.List;



public class Defausse {
    
    public List<Rumeur> listRumeur = new ArrayList<Rumeur> ();

   
    public void defausserCarte(Rumeur carte) {
    	this.listRumeur.add(carte);
    }
    
    public Defausse() {
    	
    }

}
