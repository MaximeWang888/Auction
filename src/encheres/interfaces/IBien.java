package encheres.interfaces;

import encheres.EncherirNotPossibleException;

import java.util.Date;

public interface IBien {

    IBien getBien();

    double getMontantD();

    double getMontant();

    IUtilisateur getDernierEncherisseur();

    Date getDateD();

    Date getDateF();

    void setMontant(double montant);

    void setDernierEncherisseur(IUtilisateur dernierEncherisseur);

    void encherir(double montant, IUtilisateur encherisseur) throws EncherirNotPossibleException;

    boolean isMontantEnchereValid(double montantEnchere);

    void setFraisGestion(IFraisGestion fraisGestion);

    double consulterFraisGestion();

}
