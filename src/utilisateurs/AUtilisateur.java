package utilisateurs;

import biens.IBien;
import encheres.EncherirNotPossibleException;

import java.util.HashMap;

public class AUtilisateur implements IUtilisateur {
    private String nomUtilisateur;
    private HashMap<IBien, Double> biensSurencheris;
    private HashMap<IBien, Double> biensAchetes;

    public AUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.biensSurencheris = new HashMap<>();
        this.biensAchetes = new HashMap<>();
    }

    // Getters

    public HashMap<IBien, Double> getBiensSurencheris() {
        return biensSurencheris;
    }

    public HashMap<IBien, Double> getBiensAchetes() {
        return biensAchetes;
    }


    // Methods

    public void consulterBien() {
        // TODO implement method
    }

    public void surencherir(IBien bien, double montant) throws EncherirNotPossibleException {
        try {
            bien.encherir(montant, this);
            biensSurencheris.put(bien, montant);
        } catch (Exception e) {}
    }
}
