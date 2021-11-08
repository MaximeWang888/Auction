package conditions;

import biens.IBien;

public abstract class ACondition implements ICondition {
    public IBien bien;

    public ACondition(IBien bien) {
        this.bien = bien;
    }
}
