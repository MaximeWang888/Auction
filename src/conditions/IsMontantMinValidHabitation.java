package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * Modélise une condition de l'enchere d'une habitation
 * permettant la verification du mantant minimum pour un enrichissement
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class IsMontantMinValidHabitation implements ICondition {

    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        if (bien.getSurencheresEnregistrees().isEmpty())
            return montant >= bien.getMontantD();
        else
            return montant > bien.getMontant() * 1.1;
    }

}
