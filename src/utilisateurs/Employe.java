package utilisateurs;

import biens.BiensDeApplication;
import encheres.interfaces.IBien;
import encheres.interfaces.fabriques.IFabriqueBien;

public class Employe extends AUtilisateur {
    private final IFabriqueBien fabrique;

    public Employe(String nomUtilisateur, IFabriqueBien fabrique) {
        super(nomUtilisateur);
        this.fabrique = fabrique;
    }

    @Override
    public IBien inscrireBien(String type, Object... attributs) {
        IBien bienCreer = fabrique.fabriqueBien(type, attributs);

        BiensDeApplication.setBien(bienCreer);

        return bienCreer;
    }

    @Override
    public double consulterFraisGestion(IBien bien) {
        throw new RuntimeException("L'employe ne peut pas consulter les frais de gestion.");
    }

}
