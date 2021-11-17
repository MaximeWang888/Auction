package fraisGestion;

import encheres.interfaces.IBien;

import java.util.Calendar;

/**
 * Modelise une regle de frais de gestion concrete.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class FraisGestion10et5 extends AFraisGestion {

    @Override
    public double calculFraisGestion(IBien bien) {
        // Si le bien est vendu
        if (bien.getDateF().after(Calendar.getInstance().getTime()) && !bien.getSurencheresEnregistrees().isEmpty())
            return bien.getMontant()*0.10;
        else
            return bien.getMontant()*0.05;
    }

}
