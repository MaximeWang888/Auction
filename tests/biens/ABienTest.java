package biens;

import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import fabriques.FabriqueBien;
import encheres.interfaces.fabriques.IFabriqueBien;
import org.junit.Test;
import utilisateurs.Employe;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class ABienTest {

    private IFabriqueBien fabrique = new FabriqueBien();
    private Calendar dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
    private Calendar dateF = new GregorianCalendar(2021, Calendar.DECEMBER, 1);
    private Employe e = new Employe("Hervé", new FabriqueBien());
    private IBien habitation = e.inscrireBien("habitation",
            "Un appartement dans le 16ème Arrondissement", 250000.0, dateD, dateF, "Paris", 5);
    private IBien vehicule = fabrique.fabriqueBien("vehicule",
            "Une Tesla Model X", 55000.0, dateD, dateF, "Tesla", 2021);

    @Test
    public void creerHabitation() {
        // When
        double montantD = habitation.getMontantD();
        double montant = habitation.getMontant();

        // Then
        assertEquals(montantD, 250000.0);
        assertEquals(montant, 250000.0);
    }


    @Test
    public void surrencherirHabitationConforme() throws EncherirNotPossibleException {
        // Then
        assertDoesNotThrow( ()-> habitation.encherir(300000.0, e));
    }


    @Test
    public void surrencherirHabitationPasConforme() {
        // Then
        assertThrows(EncherirNotPossibleException.class, ()-> habitation.encherir(200000.0, e));
    }


    @Test
    public void surrencherirVehiculeConforme() {
        // Then
        assertDoesNotThrow(()->vehicule.encherir(60000.0, e));
    }


    @Test
    public void surrencherirVehiculePasConforme() {
        // Then
        assertThrows(EncherirNotPossibleException.class, ()-> vehicule.encherir(45000.0, e));
    }

}