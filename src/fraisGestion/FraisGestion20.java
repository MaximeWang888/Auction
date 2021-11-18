package fraisGestion;

import encheres.interfaces.IBien;

public class FraisGestion20 extends AFraisGestion {

    @Override
    protected double calculFraisGestion(IBien bien) {
        return 1.2;
    }

}
