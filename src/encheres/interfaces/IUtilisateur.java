package encheres.interfaces;

import encheres.EncherirNotPossibleException;

import java.util.HashMap;
import java.util.List;

public interface IUtilisateur {

    HashMap<IBien, Double> getBiensSurencheris();

    HashMap<IBien, Double> getBiensAchetes();

    List<IBien> consulterBiens();

    void surencherir(IBien bien, double montant) throws EncherirNotPossibleException;

}
