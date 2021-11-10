package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

public abstract class ACondition implements ICondition {
    public IBien bien;

    public ACondition(IBien bien) {
        this.bien = bien;
    }
}
