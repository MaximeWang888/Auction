package fabriques;

import conditions.IsMontantValid;
import conditions.IsPeriodeValid;
import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;
import encheres.interfaces.fabriques.IFabriqueCondition;

import java.util.Locale;

public class FabriqueCondition implements IFabriqueCondition {

    @Override
    public ICondition fabriqueCondition(String type, IBien bien, double montant) {

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "ismontantvalid": {
                return new IsMontantValid(bien, montant);
            }
            case "isperiodevalid" : {
                return new IsPeriodeValid(bien);
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }
    }

}
