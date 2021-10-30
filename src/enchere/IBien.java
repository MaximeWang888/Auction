package enchere;

import java.util.Date;

public interface IBien {

    IBien consulterBien();

    boolean surencherir(IBien bien, double montant, Date dateActuelle);

}
