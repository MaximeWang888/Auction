package utilisateurs;

import biens.BiensDeApplication;
import encheres.interfaces.IBien;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IUtilisateur;

import java.util.HashMap;
import java.util.List;

public class AUtilisateur implements IUtilisateur {
    private String nomUtilisateur;
    private HashMap<IBien, Double> biensSurencheris;
    private HashMap<IBien, Double> biensAchetes; // liste des biens acquis par cette utilisateur

    public AUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.biensSurencheris = new HashMap<>();
        this.biensAchetes = new HashMap<>();
    }

    // Getters

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public HashMap<IBien, Double> getBiensSurencheris() {
        return biensSurencheris;
    }

    public HashMap<IBien, Double> getBiensAchetes() {
        return biensAchetes;
    }


    // Methods

    @Override
    public List<IBien> consulterBiens() {
        return BiensDeApplication.getBiens();
    }

    public void surencherir(IBien bien, double montant) throws EncherirNotPossibleException {
        try {
            bien.encherir(montant, this);
            biensSurencheris.put(bien, montant);
        } catch (Exception e) {}
    }

}
