package encheres.interfaces;

import encheres.EncherirNotPossibleException;

import java.util.HashMap;
import java.util.List;

/**
 * L'interface d'un utilisateur en general.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public interface IUtilisateur {

    /**
     * Permet de connaître le nom d'utilisateur
     * @return
     */
    String getNomUtilisateur();

    /**
     * Permet de connaître la liste de biens surencheri par cette utilisateur
     * @return la liste de biens surencheri par cette utilisateur
     */
    HashMap<IBien, Double> getBiensSurencheris();

    /**
     * Permet de connaître la liste de biens achetes par cette utilisateur
     * @return la liste de biens achetes par cette utilisateur
     */
    HashMap<IBien, Double> getBiensAchetes();

    /**
     * Permet de consultaer les biens mis en vente de l'application
     * @return la liste des biens mis en vente de l'application
     */
    List<IBien> consulterBiens();

    /**
     * Permet de surencherir un bien
     * @param bien le bien a surencherir
     * @param montant le montant du surencherissement
     * @throws EncherirNotPossibleException l'erreur rejete si l'encherissement est impossible
     */
    void surencherir(IBien bien, double montant) throws EncherirNotPossibleException;

    /**
     * Permet d'inscrire un bien dans l'application pour que les utilisateurs puissent encherir dessus par la suite
     * @param type le type du bien
     * @param attributs les attributs du bien
     * @return le bien qui a ete demander d'etre inscrit
     */
    IBien inscrireBien(String type, Object... attributs);

    /**
     * Permet de consulter les frais de gestion d'un bien
     * @param bien le bien ou l'on veut consulter les frais de gestion
     * @return le montant des frais de gestion de ce bien
     */
    double consulterFraisGestion(IBien bien);

}
