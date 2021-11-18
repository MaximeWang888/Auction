package fabriques;

import biens.ABien;
import conditions.IsMontantMinValidHabitation;
import conditions.IsMontantMinValidVehicule;
import conditions.IsPeriodeValid;
import encheres.interfaces.ICondition;
import encheres.interfaces.fabriques.IFabriqueCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Modelise une fabrique d'une condition.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class FabriqueCondition implements IFabriqueCondition {

    @Override
    public List<ICondition> fabriqueCondition(String type) {

        type.toLowerCase(Locale.ROOT);

        List<ICondition> conditions = new ArrayList<>();

        switch (type) {

            case "habitation": {
                conditions.add(new IsMontantMinValidHabitation());
                conditions.add(new IsPeriodeValid());
                ABien.setConditions(conditions);
                return conditions;
            }
            case "vehicule" : {
                conditions.add(new IsMontantMinValidVehicule());
                conditions.add(new IsPeriodeValid());
                ABien.setConditions(conditions);
                return conditions;
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }
    }

}
