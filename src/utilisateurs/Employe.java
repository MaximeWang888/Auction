package utilisateurs;

import appli.BiensDeApplication;
import encheres.interfaces.IBien;
import encheres.interfaces.fabriques.IFabriqueBien;

/**
 * Modelise un employe.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class Employe extends AUtilisateur {

    /**
     * Represente une fabrique de bien car l'employe a la possibilite de mettre un bien dans l'app
     */
    private IFabriqueBien fabrique;

    /**
     * Constructeur d'un employe à partir d'un nom d'employe et d'une fabrique de bien
     * @param nomUtilisateur le nom de l'employe
     * @param fabrique la fabrique correspondant a la fabrique de bien
     */
    public Employe(String nomUtilisateur, IFabriqueBien fabrique) {
        super(nomUtilisateur);
        this.fabrique = fabrique;
    }

    @Override
    public IBien inscrireBien(String type, Object... attributs) {
        IBien bienCreer = fabrique.fabriqueBien(type, attributs);

        BiensDeApplication.ajouterBien(bienCreer);

        return bienCreer;
    }

    @Override
    public double consulterFraisGestion(IBien bien) {
        throw new RuntimeException("L'employe ne peut pas consulter les frais de gestion.");
    }

}
