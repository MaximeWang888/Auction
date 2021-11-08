package utilisateurs;

import biens.IBien;
import encheres.EncherirNotPossibleException;

import java.util.HashMap;

public interface IUtilisateur {
    HashMap<IBien, Double> getBiensSurencheris();
    HashMap<IBien, Double> getBiensAchetes();
    void consulterBien();
    void surencherir(IBien bien, double montant) throws EncherirNotPossibleException;
}
