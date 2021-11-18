package encheres.interfaces.fabriques;

import encheres.interfaces.ICondition;

import java.util.List;

/**
 * L'interface d'une fabrique de plusieurs conditions.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFabriqueCondition {

    /**
     * Permet de fabriquer une condition
     * @param type le type de condition
     * @return la condition souhaitant etre fabrique
     */
    List<ICondition> fabriqueCondition(String type, ICondition... attributs);

}
