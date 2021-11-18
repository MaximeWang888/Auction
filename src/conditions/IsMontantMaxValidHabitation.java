package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

public class IsMontantMaxValidHabitation implements ICondition {

    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        return montant <= bien.getMontant() * 1.2;
    }

}
