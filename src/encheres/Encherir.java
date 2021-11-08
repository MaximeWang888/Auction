package encheres;

import biens.IBien;
import conditions.IsMontantValid;
import conditions.IsPeriodeValid;
import utilisateurs.IUtilisateur;

public class Encherir {
    private IBien bien;
    private double montant;
    private IUtilisateur enrichisseur;
    // TODO créer attribut IsPeriodeValid et IsMontantValid

    public Encherir(IBien bien, double montant, IUtilisateur enrichisseur) throws EncherirNotPossibleException {
        this.bien = bien;
        this.montant = montant;
        this.enrichisseur = enrichisseur;

        encherir();
    }

    public void encherir() throws EncherirNotPossibleException {
        if (new IsPeriodeValid(bien).isConditionRespected() && new IsMontantValid(bien, montant).isConditionRespected()) {
            bien.setMontant(montant);
            bien.setDernierEncherisseur(enrichisseur);
        }
        else
            throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir. Veuillez vérifier le montant et la date de l'enchère.");
    }
}
