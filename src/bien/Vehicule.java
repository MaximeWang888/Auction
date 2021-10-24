package bien;

import enchere.IBien;

public class Vehicule extends ABien {

    private String marque;

    private int anneeFabrication;

    public Vehicule(IBien nature, String description, double montantD, int dateD,
                    int dateF, String marque, int anneeFabrication) {
        super(nature, description, montantD, dateD, dateF);
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
    }

    @Override
    public IBien consulterBien() {
        return this;
    }

    @Override
    public void surencherir(String nom, double montant, int dateActuelle) {
        if (montant > getMontantD() * 1.1)
            System.out.println("enchère valide -vehicule");
    }
}
