package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

public abstract class AConditionMax implements ICondition {
    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        return montant <= bien.getMontant() * getPourcentageMax();
    }

    /**
     * Permet de changer le pourcentage maximal.
     * @param pourcentageMax le nouveau pourcentage maximal.
     */
    protected abstract void setPourcentageMax(double pourcentageMax);

    /**
     * Permet de retourner le pourcentage maximal.
     * @return le pourcentage maximal.
     */
    protected abstract double getPourcentageMax();
}

