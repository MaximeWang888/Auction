package utilisateurs;

import encheres.interfaces.IBien;

public class Responsable extends AUtilisateur {

    public Responsable(String nomUtilisateur) {
        super(nomUtilisateur);
    }

    public double consulterFraisGestion(IBien bien) {
        return bien.consulterFraisGestion();
    }

    @Override
    public IBien inscrireBien(String type, Object... attributs) {
        throw new RuntimeException("Le lardon ne peut pas inscrire de bien.");
    }

}
