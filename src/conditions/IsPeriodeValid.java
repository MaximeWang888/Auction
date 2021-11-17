package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

import java.util.Calendar;

/**
 * Modélise une condition de l'enchere d'un bien
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class IsPeriodeValid implements ICondition {

    @Override
    public boolean isConditionRespected(IBien bien, double montant) {
        return bien.getDateD().before(Calendar.getInstance().getTime()) &&
                bien.getDateF().after(Calendar.getInstance().getTime());
    }

}
