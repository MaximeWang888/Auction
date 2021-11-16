package fabriques;

import encheres.interfaces.IFraisGestion;
import encheres.interfaces.fabriques.IFabriqueFraisGestion;
import fraisGestion.FraisGestion10et5;
import fraisGestion.FraisGestion500et1000;

import java.util.Locale;

public class FabriqueFraisGestion implements IFabriqueFraisGestion {


    @Override
    public IFraisGestion fabriqueFraisGestion(String type) {

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "fraisgestion10et5": {
                return new FraisGestion10et5();
            }
            case "fraisgestion500et1000": {
                return new FraisGestion500et1000();
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }

    }


}
