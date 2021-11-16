package encheres;

import conditions.IsMontantValid;
import conditions.IsPeriodeValid;
import encheres.interfaces.IBien;
import encheres.interfaces.IUtilisateur;

public class Enchere {
    private final IBien bien;
    private final double montant;


    public Enchere(IBien bien, double montant) throws EncherirNotPossibleException {
        this.bien = bien;
        this.montant = montant;

        encherir();
    }

    public void encherir() throws EncherirNotPossibleException {
        if (new IsPeriodeValid(bien).isConditionRespected() && new IsMontantValid(bien, montant).isConditionRespected()) {
            bien.setMontant(montant);
        } else
            throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir. Veuillez vérifier le montant et la date de l'enchère.");
    }
}
