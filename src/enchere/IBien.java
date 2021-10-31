package enchere;

import java.util.Calendar;

public interface IBien {
    IBien consulterBien();
    double getMontantD();
    double getMontant();
    Calendar getDateD();
    Calendar getDateF();
    void setMontant(double montant);
    void encherir(double montant, Calendar dateActuelle) throws EncherirNotPossibleException;
    boolean isMontantEnchereValid(double montantEnchere);
}
