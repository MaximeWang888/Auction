package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * Modélise une condition de l'enchere d'un vehicule
 * permettant la verification du mantant a ne pas exceder
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class IsMontantMaxValidVehicule implements ICondition {

    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        return montant <= bien.getMontant() * 1.25;
    }

}
