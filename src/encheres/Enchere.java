package encheres;

import conditions.IsMontantValid;
import conditions.IsPeriodeValid;
import encheres.interfaces.IBien;
import encheres.interfaces.IUtilisateur;

/**
 * Modelise une enchere d'un bien.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class Enchere {

    /**
     * Represente le bien de l'enchere
     */
    private IBien bien;

    /**
     * Represente le montant de l'encherissement du bien
     */
    private double montant;

    /**
     * Represente l'encherisseur de l'enchere
     */
    private IUtilisateur enrichisseur;

    /**
     * Constructeur de l'enchere à partir d'un bien et d'un montant
     * @param bien le bien que l'on souhaite encherir
     * @param montant le montant de l'encherissement
     * @param enrichisseur l'enrichisseur
     * @throws EncherirNotPossibleException l'erreur rejete si l'encherissement est impossible
     */
    public Enchere(IBien bien, double montant, IUtilisateur enrichisseur) throws EncherirNotPossibleException {
        this.bien = bien;
        this.montant = montant;
        this.enrichisseur = enrichisseur;

        // commence la fonction de l'encherissement
        encherir();
    }

    /**
     * Permet de encherir le bien en verifiant si les conditions sont valides
     * @throws EncherirNotPossibleException
     */
    public void encherir() throws EncherirNotPossibleException {
        if (new IsPeriodeValid(bien).isConditionRespected() && new IsMontantValid(bien, montant).isConditionRespected()) {
            bien.setMontant(montant);
        }
        else
            throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir. Veuillez vérifier le montant et la date de l'enchère.");
    }
}
