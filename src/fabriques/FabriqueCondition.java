package fabriques;

import conditions.IsMontantValid;
import conditions.IsPeriodeValid;
import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;
import encheres.interfaces.fabriques.IFabriqueCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FabriqueCondition implements IFabriqueCondition {

    @Override
    public ICondition fabriqueCondition(String type, Object... attributs) {

        if (attributs == null)
            throw new IllegalArgumentException("Les attributs ne sont pas définis !!!");

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "ismontantvalid": {
                List<Object> list = getAttributs(attributs);
                return new IsMontantValid((IBien) list.get(0), (double) list.get(1));
            }
            case "isperiodevalid" : {
                List<Object> list = getAttributs(attributs);
                return new IsPeriodeValid((IBien) list.get(0));
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }
    }

    private List<Object> getAttributs(Object[] attributs) {
        List<Object> list = new ArrayList<>();
        for (Object attribut : attributs) {
            list.add(attribut);
        }
        return list;
    }
}
