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
    public List<ICondition> fabriqueCondition(String type, ICondition... attributs) {

        List<ICondition> conditions = getAttributs(attributs);

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "habitation": {
                ABien.setConditions(conditions);
                return conditions;
            }
            case "vehicule" : {
                ABien.setConditions(conditions);
                return conditions;
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }
    }

    private List<ICondition> getAttributs(ICondition... attributs) {
        List<ICondition> list = new ArrayList<>();
        for (ICondition attribut : attributs) {
            list.add(attribut);
        }
        return list;
    }

}
