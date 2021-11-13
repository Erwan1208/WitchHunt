import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e2d04145-fc2e-4acf-b251-f84a5e97a67d")
public class Identite {
    @objid ("6a31f8a4-d540-47ea-8662-b345dcdbcd81")
    private String personnage;

    @objid ("7351efad-c8fc-4681-8788-048a5030f2dc")
    private boolean idRevelee;

    @objid ("ad91a7ff-39a7-4263-b3db-a9dc66a39481")
    public void revelerIdentite() {
    }

    @objid ("ab5a7852-cfde-4a9a-9cf7-740ac6446042")
    void setPersonnage(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.personnage = value;
    }

    @objid ("b070d682-e4fa-4389-9efe-cb336f0e0e31")
    boolean isIdRevelee() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.idRevelee;
    }

    @objid ("85eabbe4-3271-49b2-b8f6-e2392cbc179f")
    void setIdRevelee(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.idRevelee = value;
    }

}
