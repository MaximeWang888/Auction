package encheres.interfaces;

/**
 * L'interface representant les frais de gestion en general.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFraisGestion {

    /**
     * Permet de connaître les frais de gestion actuel de ce bien
     * @param bien le bien ou l'on veut connaître les frais de gestion
     * @return le montant correspondant au frais de gestion de ce bien
     */
    double fraisGestionActuel(IBien bien);

}
