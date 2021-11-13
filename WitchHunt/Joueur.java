import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("425f7bd5-8964-4bf0-ad27-430b14ad84dd")
public class Joueur {
    @objid ("2d1bf747-3ec7-4c2e-9563-abc690687072")
    private int points;

    @objid ("f77a5cb7-0782-4111-ac7a-bf4a1ed81932")
    private String pseudo;

    @objid ("7fb02718-63a8-43f7-95b3-2096f6d76d1c")
    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();

    @objid ("6e638f07-459f-41b6-9002-d8e40d208214")
    public List<Identite> identite = new ArrayList<Identite> ();

    @objid ("3e7446c7-01e2-43a7-87b0-51e518ba139c")
    public void accuserJoueur() {
    }

    @objid ("f5a533f4-660a-47db-afc9-2ed10a59ae1d")
    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }

    @objid ("60f16799-1163-4f63-bd10-76e57f9b3633")
    public void jouer() {
    }

}
