package utilisateurs;

import encheres.interfaces.IBien;

public class Responsable extends AUtilisateur {

    public Responsable(String nomUtilisateur) {
        super(nomUtilisateur);
    }

    public double consulterFraisGestion(IBien bien) {
        return bien.consulterFraisGestion();
    }

}
