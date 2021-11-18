package appli;

import biens.Habitation;
import conditions.IsMontantMinValidVehicule;
import conditions.IsPeriodeValid;
import encheres.interfaces.IBien;
import encheres.interfaces.fabriques.IFabriqueCondition;
import fabriques.FabriqueCondition;
import fraisGestion.FraisGestion10et5;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Modélise l'application lancant une session d'enchere.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class Application {

    /**
     * Creation et lancement de l'enchere
     */
    public static void main(String[] args) {
        // Dates
        Calendar dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
        Calendar dateF = new GregorianCalendar(2022, Calendar.DECEMBER, 1);

        IFabriqueCondition fabriqueCondition = new FabriqueCondition();
        IBien habitation = new Habitation(
                "immeuble",
                200000,
                dateD,
                dateF,
                new FraisGestion10et5(),
                "Paris",
                5
                );

        habitation.setFraisGestion(new FraisGestion10et5());

        BiensDeApplication.ajouterBien(habitation);
        fabriqueCondition.fabriqueCondition("habitation", new IsMontantMinValidVehicule(),
                new IsPeriodeValid());
    }

    public static List<IBien> getBiens() {
        return BiensDeApplication.getBiens();
    }

}


