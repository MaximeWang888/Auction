package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

public class IsMontantMinValidVehicule implements ICondition {

    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        if (bien.getSurencheresEnregistrees().isEmpty())
            return montant >= bien.getMontantD();
        else
            return montant > bien.getMontant();
    }

}
