import biens.BiensDeApplication;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;
import encheres.interfaces.IFraisGestion;
import encheres.interfaces.IUtilisateur;
import encheres.interfaces.fabriques.IFabriqueBien;
import encheres.interfaces.fabriques.IFabriqueCondition;
import encheres.interfaces.fabriques.IFabriqueFraisGestion;
import encheres.interfaces.fabriques.IFabriqueUtilisateur;
import fabriques.FabriqueBien;
import fabriques.FabriqueCondition;
import fabriques.FabriqueFraisGestion;
import fabriques.FabriqueUtilisateur;
import fraisGestion.FraisGestion10et5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BienTest {

    private IFabriqueBien fabriqueBien;
    private IFabriqueFraisGestion fabriqueFraisGestion;
    private IFabriqueUtilisateur fabriqueUtilisateur;
    private IFabriqueCondition fabriqueCondition;
    private Calendar dateD;
    private Calendar dateF;
    private IFraisGestion fraisGestion;
    private IUtilisateur c;
    private IUtilisateur r;
    private IUtilisateur e;
    private IBien habitation;
    private IBien vehicule;
    private static List<ICondition> conditions = new ArrayList<>();

    @BeforeEach
    void initialisationDonnee() {

        // Differentes Fabriques
        fabriqueBien = new FabriqueBien();
        fabriqueFraisGestion = new FabriqueFraisGestion();
        fabriqueUtilisateur = new FabriqueUtilisateur();
        fabriqueCondition = new FabriqueCondition();

        // Dates
        dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
        dateF = new GregorianCalendar(2021, Calendar.DECEMBER, 1);

        // Frais Gestion
        fraisGestion = fabriqueFraisGestion.fabriqueFraisGestion("fraisgestion10et5");

        // Les Utilisateurs
        c = fabriqueUtilisateur.fabriqueUtilisateur("client", "Jeff Bezos");
        r = fabriqueUtilisateur.fabriqueUtilisateur("responsable", "Coralie");
        e = fabriqueUtilisateur.fabriqueUtilisateur("employe", "Hervé");

        // Les Biens
        habitation = fabriqueBien.fabriqueBien(
                "habitation",
                "Un appartement dans le 16ème Arrondissement", 250000.0, dateD, dateF, fraisGestion,
                "Paris", 5);
        vehicule = fabriqueBien.fabriqueBien(
                "vehicule",
                "Une Tesla Model X", 55000.0, dateD, dateF, fraisGestion, "Tesla", 2021);



//        List<ICondition> conditions = new ArrayList<>();
//        conditions.add(new IsMontantValidHabitation());
//        conditions.add(new IsPeriodeValid());
//        ABien.setConditions(conditions);
    }

    @Test
    void clientConsulterFraisGestionImpossible() {
        // When
        assertThrows(RuntimeException.class, () -> c.consulterFraisGestion(habitation));
    }

    @Test
    void employeConsulterFraisGestionImpossible() {
        // When
        assertThrows(RuntimeException.class, () -> e.consulterFraisGestion(habitation));
    }

    @Test
    void responsableConsulterFraisGestionImpossible() {
        // When
        assertThrows(RuntimeException.class, () -> r.inscrireBien("habitation", "habitation",
                "Un appartement dans le 16ème Arrondissement", 250000.0, dateD, dateF, fraisGestion, "Paris", 5));
    }

    @Test
    void surrencherirHabitationMontantEtPeriodeConforme() {
        // Given
        conditions = fabriqueCondition.fabriqueCondition("habitation");

        // When
        assertDoesNotThrow(() -> habitation.encherir(300000.0, e));
    }

    @Test
    void surrencherirHabitationPeriodePasConforme() {
        // Given
        dateF = new GregorianCalendar(2021, Calendar.NOVEMBER, 1);
        IBien habitation2;
        conditions = fabriqueCondition.fabriqueCondition("habitation");

        // When : changing the end date
        habitation2 = e.inscrireBien("habitation",
                "Un appartement dans le 16ème Arrondissement", 250000.0, dateD,
                dateF,
                new FraisGestion10et5(), "Paris", 5);

        assertThrows(EncherirNotPossibleException.class, () -> habitation2.encherir(300000.0, e));

        // Then : Rien car pas de resultat

    }

    @Test
    void surrencherirHabitationMontantPasConforme() {
        // Given
        conditions = fabriqueCondition.fabriqueCondition("habitation");

        // When
        assertThrows(EncherirNotPossibleException.class, () -> habitation.encherir(200000.0, e));
    }

    @Test
    void surrencherirVehiculeMontantEtPeriodeConforme() {
        // Given
        conditions = fabriqueCondition.fabriqueCondition("vehicule");

        // When
        assertDoesNotThrow(()->vehicule.encherir(60000.0, e));
    }

    @Test
    void surrencherirVehiculePeriodePasConforme() {
        // Given
        dateF = new GregorianCalendar(2021, Calendar.NOVEMBER, 1);
        IBien vehicule2;
        conditions = fabriqueCondition.fabriqueCondition("vehicule");

        // When : changing the end date
        vehicule2 = fabriqueBien.fabriqueBien("vehicule",
                "Une Tesla Model X", 55000.0, dateD,
                dateF,
                new FraisGestion10et5(), "Tesla", 2021);

        assertThrows(EncherirNotPossibleException.class, () -> vehicule2.encherir(60000.0, e));

        // Then : Rien car pas de resultat

    }

    @Test
    void surrencherirVehiculeMontantPasConforme() {
        // Given
        conditions = fabriqueCondition.fabriqueCondition("vehicule");

        // Then
        assertThrows(EncherirNotPossibleException.class, ()-> vehicule.encherir(45000.0, e));
    }

    @Test
    void consulterFraisDeGestionDunBienVendu() throws EncherirNotPossibleException {
        // Given
        double expectedFraisGestion = 30000.0; // 10 % pour un bien non vendu
        conditions = fabriqueCondition.fabriqueCondition("habitation");

        // When
        c.surencherir(habitation, 300000.0);
        double actualFraisGestion = r.consulterFraisGestion(habitation);

        // Then
        assertEquals(expectedFraisGestion, actualFraisGestion);
    }

    @Test
    void consulterFraisDeGestionDunBienNonVendu() {
        // Given
        double expectedFraisGestion = 12500.0; // 5 % pour un bien non vendu

        // When
        double actualFraisGestion = r.consulterFraisGestion(habitation);

        // Then
        assertEquals(expectedFraisGestion, actualFraisGestion);
    }

    @Test
    void consulterBiensMisAuEnchereCorrect() {
        // Given
        BiensDeApplication.clearListBiens(); // reset la liste des biens à vide
        List<IBien> expectedBiens = new ArrayList<>();
        expectedBiens.add(vehicule); expectedBiens.add(habitation);

        // When
        BiensDeApplication.ajouterBien(vehicule);
        BiensDeApplication.ajouterBien(habitation);
        List<IBien> actualBiens = c.consulterBiens();

        // Then
        assertEquals(expectedBiens, actualBiens);
    }

    @Test
    void consulterBiensMisAuEnchereIncorrect() {
        // Given
        BiensDeApplication.clearListBiens(); // reset la liste des biens à vide
        List<IBien> expectedBiens = new ArrayList<>();
        expectedBiens.add(vehicule); expectedBiens.add(habitation);

        // When
        BiensDeApplication.ajouterBien(vehicule);
        List<IBien> actualBiens = c.consulterBiens();

        // Then
        assertNotEquals(expectedBiens, actualBiens);
    }

    @Test
    void consulterSurencheresEnregistrerHabitation() throws EncherirNotPossibleException {
        // Given
        HashMap<IUtilisateur, Double> expectedSEnregistrer = new HashMap<>();
        expectedSEnregistrer.put(c, 300000.0); expectedSEnregistrer.put(c, 350000.0);

        // When
        c.surencherir(habitation, 300000.0);
        c.surencherir(habitation, 350000.0);
        HashMap<IUtilisateur, Double> actualSEnregistrer = habitation.getSurencheresEnregistrees();

        // Then
        assertEquals(expectedSEnregistrer, actualSEnregistrer);
    }

    @Test
    void consulterSurencheresEnregistrerVehicule() throws EncherirNotPossibleException {
        // Given
        IUtilisateur c1 = fabriqueUtilisateur.fabriqueUtilisateur("client", "Bill Gates");
        HashMap<IUtilisateur, Double> expectedSEnregistrer = new HashMap<>();
        expectedSEnregistrer.put(c1, 300000.0); expectedSEnregistrer.put(c1, 300001.0);
        conditions = fabriqueCondition.fabriqueCondition("vehicule");

        // When
        c1.surencherir(vehicule, 300000.0);
        c1.surencherir(vehicule, 300001.0);
        HashMap<IUtilisateur, Double> actualSEnregistrer = vehicule.getSurencheresEnregistrees();

        // Then
        assertEquals(expectedSEnregistrer, actualSEnregistrer);
    }


}
