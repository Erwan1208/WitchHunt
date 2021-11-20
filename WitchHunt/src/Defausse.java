import java.util.ArrayList;
import java.util.List;

public class Defausse {

    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();


    public void defausserCarte(Rumeur card) {
    	this.rumeur.add(card);
    }


    public void piocherCarte(Rumeur card) {
    	this.rumeur.remove(card);
    }

}
