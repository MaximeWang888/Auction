package encheres;

import biens.ABien;
import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * Modelise une enchere d'un bien.
 * @author  Martin-Dipp Daryl, Maxime Wang
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
     * Constructeur de l'enchere à partir d'un bien et d'un montant
     * @param bien le bien que l'on souhaite encherir
     * @param montant le montant de l'encherissement
     * @param enrichisseur l'enrichisseur
     * @throws EncherirNotPossibleException l'erreur rejete si l'encherissement est impossible
     */
    public Enchere(IBien bien, double montant) throws EncherirNotPossibleException {
        this.bien = bien;
        this.montant = montant;

        // commence la fonction de l'encherissement
        encherir();
    }

    /**
     * Permet de encherir le bien en verifiant si les conditions sont valides
     * @throws EncherirNotPossibleException
     */
    public void encherir() throws EncherirNotPossibleException {
        for (ICondition condi : ABien.getConditions())
            if (!condi.isConditionRespected(bien, montant)) {
                throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir. Veuillez vérifier le montant et la date de l'enchère.");
            }

        bien.setMontant(montant);

    }
}
