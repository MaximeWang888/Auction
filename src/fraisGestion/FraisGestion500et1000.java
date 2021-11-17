package fraisGestion;

import biens.Habitation;
import biens.Vehicule;
import encheres.interfaces.IBien;
import encheres.interfaces.IFraisGestion;

public class FraisGestion500et1000 implements IFraisGestion {

    @Override
    public double fraisGestionActuel(IBien bien) {
        if (bien instanceof Habitation)
            return 1000;
        else if (bien instanceof Vehicule)
            return 500;
        else
            throw new IllegalArgumentException("Le bien n'a pas de frais de gestion.");
    }

}
