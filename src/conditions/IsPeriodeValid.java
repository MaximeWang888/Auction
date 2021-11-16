package conditions;

import encheres.interfaces.IBien;

import java.util.Calendar;

/**
 * Modélise une condition de l'enchere d'un bien
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class IsPeriodeValid extends ACondition {

    /**
     * Constructeur d'une condition pour verifier si la periode du bien est valide
     * @param bien le bien
     */
    public IsPeriodeValid(IBien bien) {
        super(bien);
    }

    @Override
    public boolean isConditionRespected() {
        return this.getBien().getDateD().before(Calendar.getInstance().getTime()) &&
                this.getBien().getDateF().after(Calendar.getInstance().getTime());
    }

}
