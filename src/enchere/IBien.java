package enchere;

import java.util.Calendar;

public interface IBien {

    IBien consulterBien();

    boolean surencherir(IBien bien, double montant, Calendar dateActuelle);

}
