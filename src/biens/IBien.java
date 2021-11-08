package biens;

import encheres.EncherirNotPossibleException;
import utilisateurs.IUtilisateur;

import java.util.Calendar;

public interface IBien {
    IBien getBien();
    double getMontantD();
    double getMontant();
    IUtilisateur getDernierEncherisseur();
    Calendar getDateD();
    Calendar getDateF();
    void setMontant(double montant);
    void setDernierEncherisseur(IUtilisateur dernierEncherisseur);
    void encherir(double montant, IUtilisateur encherisseur) throws EncherirNotPossibleException;
    boolean isMontantEnchereValid(double montantEnchere);
}
