package encheres.interfaces.fabriques;

import encheres.interfaces.ICondition;

public interface IFabriqueCondition {

    ICondition fabriqueCondition(String type, Object... attributs);

}
