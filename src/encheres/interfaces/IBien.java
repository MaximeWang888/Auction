package encheres.interfaces;

import encheres.EncherirNotPossibleException;

import java.util.Date;
import java.util.HashMap;

/**
 * L'interface d'un bien en general.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public interface IBien {

    /**
     * Permet de connaître la description du bien
     * @return la description du bien
     */
    String getDescription();

    /**
     * Permet de connaître le bien
     * @return le bien
     */
    IBien getBien();

    /**
     * Permet de connaître le montant de depart du bien
     * @return le montant de depart du bien
     */
    double getMontantD();

    /**
     * Permet de connaître le montant actuel bien
     * @return le montant actuel bien
     */
    double getMontant();

    /**
     * Permet de connaître la date de debut de l'enchere du bien
     * @return la date de debut de l'enchere du bien
     */
    Date getDateD();

    /**
     * Permet de connaître la date de fin de l'enchere du bien
     * @return la date de fin de l'enchere du bien
     */
    Date getDateF();

    /**
     * Permet de modifier le montant actuel du bien
     * @param montant le montant du bien
     */
    void setMontant(double montant);

    /**
     * Permet d'encherir un bien
     * @param montant le montant de l'encherissement
     * @throws EncherirNotPossibleException une erreur lorsque l'encherissement est impossible
     */
    void encherir(double montant) throws EncherirNotPossibleException;

    /**
     * Permet de modifier les frais de gestion du bien
     * @param fraisGestion le frais de gestion du bien
     */
    void setFraisGestion(IFraisGestion fraisGestion);

    /**
     * Permet de consulter les frais gestion du bien
     * @return le montant des frais de gestion du bien
     */
    double consulterFraisGestion();

    /**
     * Permet d'enregistrer les surencherissements valides dans la liste prevu a cette effet
     * @param utilisateur l'utilisateur qui a encheri sur le bien
     * @param montant le montant de son encherissement
     */
    void setSurencheresEnregistrees(IUtilisateur utilisateur, double montant);

    /**
     * Permet de connaître la liste des surencherissements enregistrees du bien
     * @return la liste des surencherissements du bien
     */
    HashMap<IUtilisateur, Double> getSurencheresEnregistrees();

}
