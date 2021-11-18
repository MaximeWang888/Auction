package encheres.interfaces.fabriques;

import encheres.interfaces.IFraisGestion;

/**
 * L'interface d'une fabrique d'un frais de gestion.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFabriqueFraisGestion {

    /**
     * Permet de fabriquer un frais de gestion
     * @param type le type de frais de gestion souhaitant etre fabrique
     * @return le frais de gestion souhaitant etre fabrique
     */
    IFraisGestion fabriqueFraisGestion(String type);

}
