package utilisateurs;

import biens.BiensDeApplication;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import encheres.interfaces.IUtilisateur;

import java.util.HashMap;
import java.util.List;

public abstract class AUtilisateur implements IUtilisateur {
    private final String nomUtilisateur;
    private final HashMap<IBien, Double> biensSurencheris;
    private final HashMap<IBien, Double> biensAchetes; // liste des biens acquis par cette utilisateur

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
        try {
            bien.encherir(montant);
            biensSurencheris.put(bien, montant);
            bien.setSurencheresEnregistrees(this, montant);
        } catch (EncherirNotPossibleException e) {
            throw new EncherirNotPossibleException("L'enchère n'a pas pu aboutir." +
                    " Veuillez vérifier le montant et la date de l'enchère.");
        }
    }

}
