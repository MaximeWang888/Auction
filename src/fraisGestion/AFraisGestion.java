package fraisGestion;

import encheres.interfaces.IBien;
import encheres.interfaces.IFraisGestion;

/**
 * Modelise une regle de frais de gestion en general.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public abstract class AFraisGestion implements IFraisGestion {

    @Override
    public double fraisGestionActuel(IBien bien) {
        return calculFraisGestion(bien);
    }

    /**
     * Permet de connaître la regle de frais de calcul d'un bien
     * @param bien le bien que l'on veut connaître la regle de frais de gestion
     * @return la somme des frais de gestion
     */
    protected abstract double calculFraisGestion(IBien bien);

}
