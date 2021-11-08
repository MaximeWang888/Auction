package utilisateurs;

import biens.IBien;
import fabriques.IFabrique;

public class Employe extends AUtilisateur {
    private IFabrique fabrique;

    public Employe(String nomUtilisateur, IFabrique fabrique) {
        super(nomUtilisateur);
        this.fabrique = fabrique;
    }

    public IBien inscrireBien(String type, Object... attributs) {
        return fabrique.fabriqueBien(type, attributs);
    }
}
