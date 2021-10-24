package bien;

import enchere.IBien;

public abstract class ABien implements IBien {

    private IBien nature;

    private String description;

    private double montantD;

    private int dateD;

    private int dateF;

    public ABien(IBien nature, String description, double montantD, int dateD, int dateF) {
        this.nature = nature;
        this.description = description;
        this.montantD = montantD;
        this.dateD = dateD;
        this.dateF = dateF;
    }

    @Override
    public void surencherir(String nom, double montant, int dateActuelle) {
        if (dateActuelle > dateD && dateActuelle < dateF)
            System.out.println("enchère valide");
    }

    public double getMontantD() {
        return montantD;
    }
}
