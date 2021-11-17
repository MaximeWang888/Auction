package encheres.interfaces.fabriques;

import encheres.interfaces.ICondition;

import java.util.List;

/**
 * L'interface d'une fabrique d'une condition.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFabriqueCondition {

    /**
     * Permet de fabriquer une condition
     * @param type le type de condition
     * @return la condition souhaitant etre fabrique
     */
    List<ICondition> fabriqueCondition(String type);

}
