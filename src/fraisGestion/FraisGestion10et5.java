package fraisGestion;

import encheres.interfaces.IBien;
import encheres.interfaces.IFraisGestion;

import java.util.Calendar;

/**
 * Modelise une regle de frais de gestion concrete.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class FraisGestion10et5 implements IFraisGestion {

    @Override
    public double fraisGestionActuel(IBien bien) {
        // Si le bien est vendu
        if (bien.getDateF().after(Calendar.getInstance().getTime()) && !bien.getSurencheresEnregistrees().isEmpty())
            return bien.getMontant()*0.10;
        else
            return bien.getMontant()*0.05;
    }

}
