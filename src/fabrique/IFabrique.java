package fabrique;

import enchere.IBien;

public interface IFabrique {

    IBien fabriqueBien(String type, Object... attributs);

}
