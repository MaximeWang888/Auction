package enchere;

public interface IBien {

    IBien consulterBien();

    void surencherir(String nom, double montant, int dateActuelle);

}
