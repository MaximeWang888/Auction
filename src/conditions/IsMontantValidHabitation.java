package conditions;

import encheres.interfaces.IBien;

/**
 * Modélise une condition de l'enchere d'un bien
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class IsMontantValid extends ACondition {

    /**
     * Represente un montant
     */
    private double montant;

    /**
     * Constructeur d'une condition qui permet de verifier si le montant est valide ou non
     * @param bien le bien
     * @param montant le montant
     */
    public IsMontantValid(IBien bien, double montant) {
        super(bien);
        this.montant = montant;
    }

    @Override
    public boolean isConditionRespected() {
        if (getBien().getSurencheresEnregistrees().isEmpty())
            return montant >= getBien().getMontantD();
        else
            return montant >= getBien().getMontant() * 1.1;
    }

}
