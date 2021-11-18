package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * Modélise une condition de l'enchere d'une habitation
 * permettant la verification du mantant a ne pas exceder
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class IsMontantMaxValidHabitation extends AConditionMax {
    /**
     * Correspond au pourcentage maximal autorisé pour une enchère.
     */
    private double pourcentageMax = 1.25;

    @Override
    public double getPourcentageMax() {
        return pourcentageMax;
    }

    @Override
    public void setPourcentageMax(double pourcentageMax) {
        this.pourcentageMax = pourcentageMax;
    }
}
