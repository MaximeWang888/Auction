package encheres.interfaces;

import encheres.EncherirNotPossibleException;

import java.util.Date;
import java.util.HashMap;

public interface IBien {

    IBien getBien();

    double getMontantD();

    double getMontant();

    Date getDateD();

    Date getDateF();

    void setMontant(double montant);

    void encherir(double montant, IUtilisateur encherisseur) throws EncherirNotPossibleException;

    boolean isMontantEnchereValid(double montantEnchere);

    void setFraisGestion(IFraisGestion fraisGestion);

    double consulterFraisGestion();

    void setSurencheresEnregistrees(IUtilisateur utilisateur, double montant);

    HashMap<IUtilisateur, Double> getSurencheresEnregistrees();

}
