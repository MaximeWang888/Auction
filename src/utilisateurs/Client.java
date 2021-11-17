package utilisateurs;

import encheres.interfaces.IBien;

/**
 * Modelise un client.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class Client extends AUtilisateur {

    /**
     * Constructeur d'un client à partir d'un nom de client
     * @param nomUtilisateur le nom du client
     */
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
