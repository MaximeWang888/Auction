package conditions;

import biens.IBien;

public class IsMontantValid extends ACondition {
    private double montant;

    public IsMontantValid(IBien bien, double montant) {
        super(bien);
        this.montant = montant;
    }

    @Override
    public boolean isConditionRespected() {
        return bien.isMontantEnchereValid(montant);
    }
}
