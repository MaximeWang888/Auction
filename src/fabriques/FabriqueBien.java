package fabriques;

import biens.Habitation;
import biens.Vehicule;
import biens.IBien;

import java.util.*;

public class FabriqueBien implements IFabrique {

    @Override
    public IBien fabriqueBien(String type, Object... attributs) {

        isParametreNonNull(type, attributs);

        type.toLowerCase(Locale.ROOT);

        switch (type) {

            case "habitation": {
                List<Object> list = getAttributs(attributs);
                return new Habitation((String) list.get(0), (double) list.get(1), (Calendar) list.get(2),
                        (Calendar) list.get(3), (String) list.get(4), (int) list.get(5));
            }
            case "vehicule" : {
                List<Object> list = getAttributs(attributs);
                return new Vehicule((String) list.get(0), (double) list.get(1), (Calendar) list.get(2),
                        (Calendar) list.get(3), (String) list.get(4), (int) list.get(5));
            }
        }

        return null;
    }

    private void isParametreNonNull(String type, Object[] attributs) {
        if (type == null)
            throw new IllegalArgumentException("Type n'est pas defini");
        else if (attributs == null)
            throw new IllegalArgumentException("Attribut n'est pas defini");
    }

    private List<Object> getAttributs(Object[] attributs) {
        List<Object> list = new ArrayList<>();
        for (Object attribut : attributs) {
            list.add(attribut);
        }
        return list;
    }

}
