package utilisateurs;

import encheres.interfaces.IBien;

public class Client extends AUtilisateur {

    public Client(String nomUtilisateur) {
        super(nomUtilisateur);
    }

    @Override
    public IBien inscrireBien(String type, Object... attributs) {
        throw new RuntimeException("Le client ne peut pas inscrire de bien.");
    }

    @Override
    public double consulterFraisGestion(IBien bien) {
        throw new RuntimeException("Le client ne peut pas consulter les frais de gestion.");
    }

}
