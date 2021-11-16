package biens;

import encheres.interfaces.IBien;

public class BienMontantMax {
    private static double tauxAugmentationMax;
    private IBien bien;

    public BienMontantMax(IBien bien) {
        this.bien = bien;
        BienMontantMax.tauxAugmentationMax = 20;
    }

    public boolean isMontantValid(double montant) {
        return bien.isMontantEnchereValid(montant) && montant <= montantMaxSurrenchere();
    }

    private double montantMaxSurrenchere(){
        return bien.getMontant() + bien.getMontant()*tauxAugmentationMax;
    }

    public static void setTauxAugmentationMax(int tauxAugmentationMax) {
        BienMontantMax.tauxAugmentationMax = tauxAugmentationMax;
    }
}
