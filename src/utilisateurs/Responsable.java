package utilisateurs;

import encheres.interfaces.IBien;

/**
 * Modelise un responsable.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class Responsable extends AUtilisateur {

    /**
     * Constructeur d'un responsable à partir d'un nom de responsable
     * @param nomUtilisateur le nom du responsable
     */
    public Responsable(String nomUtilisateur) {
        super(nomUtilisateur);
    }

    @Override
    public double consulterFraisGestion(IBien bien) {
        return bien.consulterFraisGestion();
    }

    @Override
    public IBien inscrireBien(String type, Object... attributs) {
        throw new RuntimeException("Le lardon ne peut pas inscrire de bien.");
    }

}
