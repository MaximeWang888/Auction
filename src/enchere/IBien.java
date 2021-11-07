package enchere;

import bien.EnchereNotPossibleException;
import utilisateurs.IUtilisateur;

import java.util.Calendar;

public interface IBien {

    IBien consulterBien();

    double getMontant();

    IUtilisateur getDernierEncherisseur();

    void surencherir(IUtilisateur encherisseur, double montant) throws EnchereNotPossibleException;

    boolean isPeriodeOK();

    boolean isMontantOK(double montant);
}
