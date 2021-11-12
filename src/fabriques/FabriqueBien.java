package fabriques;

import biens.Habitation;
import biens.Vehicule;
import encheres.interfaces.IBien;
import encheres.interfaces.fabriques.IFabriqueBien;
import encheres.interfaces.IFraisGestion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FabriqueBien implements IFabriqueBien {

    @Override
    public IBien fabriqueBien(String type, Object... attributs) {

        if (attributs == null)
            throw new IllegalArgumentException("Les attributs ne sont pas définis ! ! !");

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "habitation": {
                List<Object> list = getAttributs(attributs);
                return new Habitation((String) list.get(0), (double) list.get(1), (Calendar) list.get(2),
                        (Calendar) list.get(3), (IFraisGestion) list.get(4), (String) list.get(5), (int) list.get(6));
            }
            case "vehicule" : {
                List<Object> list = getAttributs(attributs);
                return new Vehicule((String) list.get(0), (double) list.get(1), (Calendar) list.get(2),
                        (Calendar) list.get(3), (IFraisGestion) list.get(4), (String) list.get(5), (int) list.get(6));
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");
        }

    }

    private List<Object> getAttributs(Object[] attributs) {
        List<Object> list = new ArrayList<>();
        for (Object attribut : attributs) {
            list.add(attribut);
        }
        return list;
    }

}
