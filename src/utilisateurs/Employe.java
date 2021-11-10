package utilisateurs;

import biens.BiensDeApplication;
import encheres.interfaces.IBien;
import encheres.interfaces.IFabrique;

public class Employe extends AUtilisateur {
    private IFabrique fabrique;

    public Employe(String nomUtilisateur, IFabrique fabrique) {
        super(nomUtilisateur);
        this.fabrique = fabrique;
    }

    public IBien inscrireBien(String type, Object... attributs) {
        IBien bienCreer = fabrique.fabriqueBien(type, attributs);

        BiensDeApplication.setBien(bienCreer);

        return bienCreer;
    }

}
