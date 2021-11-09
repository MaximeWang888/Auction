package fraisGestion;

import biens.IBien;

import java.util.Calendar;

public class FraisGestion10et5 extends AFraisGestion {
    @Override
    public double calculFraisGestion(IBien bien) {
        // Si le bien est vendu
        if (bien.getDateF().before(Calendar.getInstance().getTime()) && bien.getDernierEncherisseur() != null)
            return bien.getMontant()*0.10;
        else
            return bien.getMontant()*0.05;
    }
}
