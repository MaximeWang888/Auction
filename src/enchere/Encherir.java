package enchere;

import java.util.Calendar;

public class Encherir {
    private IBien bien;
    private double montant;
    private Calendar dateActuelle;

    public Encherir(IBien bien, double montant, Calendar dateActuelle) throws EncherirNotPossibleException {
        this.bien = bien;
        this.montant = montant;
        this.dateActuelle = dateActuelle;

        encherir();
    }

    public void encherir() throws EncherirNotPossibleException {
        if (isPeriodeValid() && isMontantValid())
            bien.setMontant(montant);
        else
            throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir. Veuillez vérifier le montant et la date de l'enchère.");
    }

    public boolean isPeriodeValid() {
        return bien.getDateD().before(dateActuelle.getTime()) &&
                bien.getDateF().before(dateActuelle.getTime());
    }

    public boolean isMontantValid() {
        return bien.isMontantEnchereValid(montant);
    }
}
