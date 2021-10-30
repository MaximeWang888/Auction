package enchere;

import java.util.Date;

public interface IBien {

    IBien consulterBien();

    boolean surencherir(String nom, double montant, Date dateActuelle);

}
