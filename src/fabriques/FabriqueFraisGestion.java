package fabriques;

import encheres.interfaces.IFraisGestion;
import encheres.interfaces.fabriques.IFabriqueFraisGestion;
import fraisGestion.FraisGestion10et5;
import fraisGestion.FraisGestion20;

import java.util.Locale;

/**
 * Modelise une fabrique d'une regle de frais de gestion.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class FabriqueFraisGestion implements IFabriqueFraisGestion {


    @Override
    public IFraisGestion fabriqueFraisGestion(String type) {

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "fraisgestion10et5": {
                return new FraisGestion10et5();
            }
            case "fraisgestion20" : {
                return new FraisGestion20();
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }

    }


}
