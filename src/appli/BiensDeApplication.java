package appli;

import encheres.interfaces.IBien;

import java.util.ArrayList;
import java.util.List;

/**
 * Modélise la liste des biens de notre application d'enchere.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class BiensDeApplication {

    /**
     * La liste de biens mis en vente a notre enchere
     */
    private static List<IBien> biens = new ArrayList<>();

    /**
     * Permet de connaître la liste de biens mis en vente
     * @return la liste de biens
     */
    public static List<IBien> getBiens() {
        return biens;
    }

    /**
     * Permet d'ajouter un bien dans la liste de biens mis en vente
     * @param bien le bien a ajoute a la liste de biens mis en vente
     */
    public static void ajouterBien(IBien bien) {
        biens.add(bien);
    }

    /**
     * Permet de suppprimer de la liste tous les biens qui s'y trouve
     */
    public static void clearListBiens() {
        biens.clear();
    }

}
