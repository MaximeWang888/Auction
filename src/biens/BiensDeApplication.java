package biens;

import encheres.interfaces.IBien;

import java.util.ArrayList;
import java.util.List;

public class BiensDeApplication {

    private static List<IBien> biens = new ArrayList<>();

    public static List<IBien> getBiens() {
        return biens;
    }

    public static void setBien(IBien bien) {
        biens.add(bien);
    }

}
