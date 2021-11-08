package fabriques;

import biens.IBien;

public interface IFabrique {

    IBien fabriqueBien(String type, Object... attributs);

}
