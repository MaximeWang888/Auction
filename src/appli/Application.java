package appli;

import biens.Habitation;
import encheres.interfaces.IBien;
import fraisGestion.FraisGestion10et5;
import fraisGestion.FraisGestion20;

import java.util.Calendar;

public class Application {

    public static void main(String[] args) {

        IBien habitation = new Habitation(
                "immeuble",
                200000,
                Calendar.getInstance(),
                Calendar.getInstance(),
                new FraisGestion20(),
                "Paris",
                5
                );

        habitation.setFraisGestion(new FraisGestion10et5());

        IBien habitation2 = new Habitation(
                "immeuble",
                200000,
                Calendar.getInstance(),
                Calendar.getInstance(),
                new FraisGestion20(),
                "Paris",
                5
        );

    }

}
