package fabriques;

import biens.ABien;
import encheres.interfaces.ICondition;
import encheres.interfaces.fabriques.IFabriqueCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Modelise une fabrique de plusieurs conditions.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class FabriqueCondition implements IFabriqueCondition {

    @Override
    public List<ICondition> fabriqueCondition(String type, ICondition... attributs) {

        List<ICondition> conditions = getAttributs(attributs);

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "habitation":
            case "vehicule" : {
                ABien.setConditions(conditions);
                return conditions;
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }
    }

    /**
     * Permet de recuperer les attributs donc les conditions
     * @param attributs les attributs correspondant aux conditions
     * @return la liste de conditions passe en parametre
     */
    private List<ICondition> getAttributs(ICondition... attributs) {
        List<ICondition> list = new ArrayList<>();
        for (ICondition attribut : attributs) {
            list.add(attribut);
        }
        return list;
    }

}
