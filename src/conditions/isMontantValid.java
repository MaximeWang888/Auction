package conditions;

import biens.IBien;

public class isMontantValid extends ACondition {
    private double montant;

    public isMontantValid(IBien bien, double montant) {
        super(bien);
        this.montant = montant;
    }

    @Override
    public boolean isConditionRespected() {
        return bien.isMontantEnchereValid(montant);
    }
}
