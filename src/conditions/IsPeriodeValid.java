package conditions;

import biens.IBien;

import java.util.Calendar;

public class IsPeriodeValid extends ACondition {

    public IsPeriodeValid(IBien bien) {
        super(bien);
    }

    @Override
    public boolean isConditionRespected() {
        return bien.getDateD().before(Calendar.getInstance().getTime()) &&
                bien.getDateF().after(Calendar.getInstance().getTime());
    }
}
