package encheres.interfaces.fabriques;

import encheres.interfaces.IBien;

/**
 * L'interface d'une fabrique d'un bien.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFabriqueBien {

    /**
     * Permet de fabriquer un bien
     * @param type le type de bien a fabrique
     * @param attributs les attributs de ce bien
     * @return le bien souhaitant etre fabrique
     */
    IBien fabriqueBien(String type, Object... attributs);

}
