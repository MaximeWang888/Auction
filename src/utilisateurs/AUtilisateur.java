package utilisateurs;

import appli.BiensDeApplication;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import encheres.interfaces.IUtilisateur;

import java.util.HashMap;
import java.util.List;

/**
 * Modelise une utilisateur en general.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public abstract class AUtilisateur implements IUtilisateur {

    /**
     * Represente le nom d'utilisateur
     */
    private String nomUtilisateur;

    /**
     * Represente les biens surencheris par l'utilisateur
     */
    private HashMap<IBien, Double> biensSurencheris;

    /**
     * Represente la liste des biens acquis par cette utilisateur
     */
    private HashMap<IBien, Double> biensAchetes;

    /**
     * Constructeur d'un utilisateur à partir d'un nom d'utilisateur
     * @param nomUtilisateur le nom d'utilisateur de l'utilisateur
     */
    public AUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.biensSurencheris = new HashMap<>();
        this.biensAchetes = new HashMap<>();
    }

    // Getters

    @Override
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    @Override
    public HashMap<IBien, Double> getBiensSurencheris() {
        return biensSurencheris;
    }

    @Override
    public HashMap<IBien, Double> getBiensAchetes() {
        return biensAchetes;
    }


    // Methods

    @Override
    public List<IBien> consulterBiens() {
        return BiensDeApplication.getBiens();
    }

    @Override
    public void surencherir(IBien bien, double montant) throws EncherirNotPossibleException {

        bien.encherir(montant);
        biensSurencheris.put(bien, montant);
        bien.setSurencheresEnregistrees(this, montant);

    }

}
