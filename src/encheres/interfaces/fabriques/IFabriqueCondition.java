package encheres.interfaces.fabriques;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

public interface IFabriqueCondition {

    ICondition fabriqueCondition(String type, IBien bien, double montant);

}
