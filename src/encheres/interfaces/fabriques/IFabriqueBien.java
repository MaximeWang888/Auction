package encheres.interfaces.fabriques;

import encheres.interfaces.IBien;

public interface IFabriqueBien {

    IBien fabriqueBien(String type, Object... attributs);

}
