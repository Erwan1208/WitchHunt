import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("75464ea2-8a6e-4346-a248-6d7ca659ebc5")
public class Partie {
    @objid ("46f8a6db-6e81-435a-ba3e-2f001ccbd45c")
    private String gagnant;

    @objid ("4c81e71a-d6b6-4abe-af6d-b0323df83f7b")
    private int round;

    @objid ("7fabf782-c7ba-42f4-93fe-e1b037456cbf")
    private boolean terminee;

    @objid ("8d0421eb-422f-4b10-93c6-54413989100b")
    private int nbJoueurs;

    @objid ("cdd57d8f-4091-4519-abac-d950f8d964d1")
    private int nbIdentitesRevelees;

    @objid ("9ca8ea27-3587-4fe9-820b-251e8770e121")
    private Partie instance;

    @objid ("fc1edd42-d0d9-4f66-b79c-b61f509e2f63")
    public List<Joueur> joueur = new ArrayList<Joueur> ();

    @objid ("d2cc0a6d-a6ed-4283-8c0f-2cbcde62b583")
    public List<Defausse> défausse = new ArrayList<Defausse> ();

    @objid ("41446381-905f-43a2-9602-71cdea34f75e")
    public void terminerPartie() {
    }

    @objid ("e164758d-3fa6-4ae9-9311-1c7c02e61259")
    public void commencerRound() {
    }

    @objid ("1e02a7ea-af95-4dfa-8272-e05ef0daca96")
    public void afficherPointsJoueurs() {
    }

    @objid ("1df3fe04-c9c9-4cf5-85a1-14899a229091")
    void setNbJoueurs(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nbJoueurs = value;
    }

    @objid ("1265bbc7-046f-4fa9-8940-df441686c384")
    public void changerPoints() {
    }

    @objid ("16a33833-cdb1-4062-9956-24084dc07263")
    Partie getInstance() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.instance;
    }

    @objid ("44d166d8-d153-4d9a-9b91-3c2dc33c4429")
    private void Partie() {
    }

}
