package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * Modélise une condition de l'enchere d'un bien
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class IsMontantValidHabitation implements ICondition {

    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        if (bien.getSurencheresEnregistrees().isEmpty())
            return montant >= bien.getMontantD();
        else
            return montant > bien.getMontant() * 1.1;
    }

}
