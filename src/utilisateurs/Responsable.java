package utilisateurs;

import fraisGestion.AFraisGestion;
import fraisGestion.IFraisGestion;

public class Responsable extends AUtilisateur {
    public Responsable(String nomUtilisateur) {
        super(nomUtilisateur);
    }

    public IFraisGestion consulterFraisGestion() {
        return AFraisGestion.fraisGestionActuel();
    }
}
