package fraisGestion;

import biens.Habitation;
import biens.Vehicule;
import encheres.interfaces.IBien;

public class FraisGestion500et1000 extends AFraisGestion {

    @Override
    protected double calculFraisGestion(IBien bien) {
        if (bien instanceof Habitation)
            return 1000;
        else if (bien instanceof Vehicule)
            return 500;
        else
            throw new IllegalArgumentException("Le bien n'a pas de frais de gestion.");
    }

}
