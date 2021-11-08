package encheres;

import biens.IBien;
import conditions.isMontantValid;
import conditions.isPeriodeValid;
import utilisateurs.IUtilisateur;

public class Encherir {
    private IBien bien;
    private double montant;
    private IUtilisateur enrichisseur;

    public Encherir(IBien bien, double montant, IUtilisateur enrichisseur) throws EncherirNotPossibleException {
        this.bien = bien;
        this.montant = montant;
        this.enrichisseur = enrichisseur;

        encherir();
    }

    public void encherir() throws EncherirNotPossibleException {
        if (new isPeriodeValid(bien).isConditionRespected() && new isMontantValid(bien, montant).isConditionRespected()) {
            bien.setMontant(montant);
            bien.setDernierEncherisseur(enrichisseur);
        }
        else
            throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir. Veuillez vérifier le montant et la date de l'enchère.");
    }
}
