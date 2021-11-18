package fraisGestion;

import encheres.interfaces.IBien;
import encheres.interfaces.IFraisGestion;

public abstract class AFraisGestion implements IFraisGestion {

    @Override
    public double fraisGestionActuel(IBien bien) {
        return calculFraisGestion(bien);
    }

    protected abstract double calculFraisGestion(IBien bien);

}
