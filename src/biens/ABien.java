package biens;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;
import encheres.interfaces.IFraisGestion;
import encheres.interfaces.IUtilisateur;
import encheres.Enchere;
import encheres.EncherirNotPossibleException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Modélise un bien en general.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public abstract class ABien implements IBien {

    /**
     * Description du bien
     */
    private String description;

    /**
     * Montant de depart du bien
     */
    private double montantD;

    /**
     * Montant actuel du bien
     */
    private double montant;

    /**
     * Date de début de l'enchere du bien
     */
    private Calendar dateD;

    /**
     * Date de fin de l'enchere du bien
     */
    private Calendar dateF;

    /**
     * Frais de gestion du bien
     */
    private IFraisGestion fraisGestion;

    /**
     * Liste representant les surencheres enregistrees d'un bien
     */
    private HashMap<IUtilisateur, Double> surencheresEnregistrees;

    /**
     * La liste correspondant aux conditions d'un bien
     */
    private static List<ICondition> conditions;

    /**
     * Constructeur du bien
     * @param description la description du bien
     * @param montantD le montant depart du bien
     * @param dateD la date de debut de l'enchere du bien
     * @param dateF la date de fin de l'enchere du bien
     * @param fraisGestion les frais de gestion du bien
     */
    public ABien(String description, double montantD, Calendar dateD, Calendar dateF, IFraisGestion fraisGestion) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dateD = dateD;
        this.dateF = dateF;
        this.fraisGestion = fraisGestion;
        this.surencheresEnregistrees = new HashMap<>();
    }



    // Getters
    /**
     * Permet de connaître les conditions qu'un bien doit valider pour etre surrencherit
     * @return la liste des conditions qu'un bien doit valider
     */
    public static List<ICondition> getConditions() {
        return conditions;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getMontant() {
        return montant;
    }

    @Override
    public IBien getBien() {
        return this;
    }

    @Override
    public double getMontantD() {
        return montantD;
    }

    @Override
    public Date getDateD() {
        return dateD.getTime();
    }

    @Override
    public Date getDateF() {
        return dateF.getTime();
    }

    @Override
    public HashMap<IUtilisateur, Double> getSurencheresEnregistrees() {
        return surencheresEnregistrees;
    }


    // Setters


    /**
     * Permet de mettre a jour les conditions qu'un bien doit faire valider avant d'etre encherit
     * @param conditions la liste des conditions que devra suivre le bien pour etre validé
     */
    public static void setConditions(List<ICondition> conditions) {
        ABien.conditions = conditions;
    }

    @Override
    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public void setFraisGestion(IFraisGestion fraisGestion) {
        this.fraisGestion = fraisGestion;
    }

    @Override
    public void setSurencheresEnregistrees(IUtilisateur utilisateur, double montant) {
        this.surencheresEnregistrees.put(utilisateur, montant);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormatD = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat dateFormatF = new SimpleDateFormat("dd-MMM-yyyy");
        dateFormatD.setCalendar(dateD);
        String dateFormattedD = dateFormatD.format(dateD.getTime());

        dateFormatF.setCalendar(dateF);
        String dateFormattedF = dateFormatF.format(dateF.getTime());


        return "Bien : " + description +
                "\nmontant de depart : " + montantD +
                "\nmontant actuelle : " + montant +
                "\ndate de debut : " + dateFormattedD +
                "\ndate de fin : " + dateFormattedF ;
    }


// Methods

    @Override
    public void encherir(double montant) throws EncherirNotPossibleException {
        new Enchere(this, montant);
    }

    @Override
    public double consulterFraisGestion() {
        return fraisGestion.fraisGestionActuel(this);
    }
}
