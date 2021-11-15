import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Joueur {
    
    private int points;

    
    private String pseudo;

  
    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();

   
    public List<Identite> identite = new ArrayList<Identite> ();

   
    public void accuserJoueur() {
    }

    public Joueur() {
    	
    }
    
    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }


    public void jouer() {
    }

}
