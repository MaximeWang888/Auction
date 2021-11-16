package encheres.interfaces.fabriques;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * L'interface d'une fabrique d'une condition.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFabriqueCondition {

    /**
     * Permet de fabriquer une condition
     * @param type le type de condition
     * @param bien un bien en general
     * @param montant un montant
     * @return la condition souhaitant etre fabrique
     */
    ICondition fabriqueCondition(String type, IBien bien, double montant);

}
