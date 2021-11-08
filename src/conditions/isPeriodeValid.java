package conditions;

import biens.IBien;

import java.util.Calendar;

public class isPeriodeValid extends ACondition {

    public isPeriodeValid(IBien bien) {
        super(bien);
    }

    @Override
    public boolean isConditionRespected() {
        return bien.getDateD().before(Calendar.getInstance().getTime()) &&
                bien.getDateF().before(Calendar.getInstance().getTime());
    }
}
