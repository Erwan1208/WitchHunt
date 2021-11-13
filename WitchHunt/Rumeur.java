import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("16c267b3-bad5-431a-a61b-bc4a1e0f8b33")
public class Rumeur {
    @objid ("792ae7a8-2c74-493d-8400-e9469a8ee511")
    private String nom;

    @objid ("78f36f62-8477-4126-bd02-bd2d6eeb8ae2")
    public List<Effet Hunt> effet Hunt = new ArrayList<Effet Hunt> ();

    @objid ("e973151b-4a97-41ad-b231-9d64e8743574")
    public List<Effet Witch> effet Witch = new ArrayList<Effet Witch> ();

    @objid ("cf804039-6806-4dd7-9db6-bce6a2b5805c")
    public void jouerHunt() {
    }

    @objid ("48e64d37-a7cd-46a9-96b1-7543ff5eed47")
    public void jouerWitch() {
    }

}
