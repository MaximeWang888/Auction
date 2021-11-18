package encheres.interfaces;

/**
 * L'interface d'une condition en general.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public interface ICondition {

    /**
     * Permet de verifier si la condition est respectee
     * @return True si la condition est respectee, False dans le cas contraire
     */
    boolean isConditionRespected(IBien bien, double montant);

}
