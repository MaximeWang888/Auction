package bien;

import enchere.IBien;
import fabrique.FabriqueBien;
import fabrique.IFabrique;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ABienTest {

    private IFabrique fabrique = new FabriqueBien();
    private IBien habitation;
    private IBien vehicule;
    private Calendar dateD;
    private Calendar dateF;


    @Test
    public void surrencherirHabitationConforme() {
        // Given
        dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
        dateF = new GregorianCalendar(2021, Calendar.DECEMBER, 1);

        habitation = fabrique.fabriqueBien("habitation",
                "Un appartement dans le 16ème Arrondissement", 250000.0, dateD, dateF, "Paris", 5);

        // When
        boolean actualRes = habitation.surencherir(habitation, 300000.0, Calendar.getInstance());

        // Then
        assertEquals(true, actualRes);
    }


    @Test
    public void surrencherirHabitationPasConforme() {
        // Given
        dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
        dateF = new GregorianCalendar(2021, Calendar.DECEMBER, 1);

        habitation = fabrique.fabriqueBien("habitation",
                "Un appartement dans le 16ème Arrondissement", 250000.0, dateD, dateF, "Paris", 5);

        // When
        boolean actualRes = habitation.surencherir(habitation, 240000.0, Calendar.getInstance());

        // Then
        assertEquals(false, actualRes);
    }


    @Test
    public void surrencherirVehiculeConforme() {
        // Given
        dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
        dateF = new GregorianCalendar(2021, Calendar.DECEMBER, 1);

        vehicule = fabrique.fabriqueBien("vehicule",
                "Une Tesla Model X", 55000.0, dateD, dateF, "Tesla", 2021);

        // When
        boolean actualRes = vehicule.surencherir(vehicule, 60000.0, Calendar.getInstance());

        // Then
        assertEquals(true, actualRes);
    }

    
    @Test
    public void surrencherirVehiculePasConforme() {
        // Given
        dateD = new GregorianCalendar(2021, Calendar.OCTOBER, 1);
        dateF = new GregorianCalendar(2021, Calendar.DECEMBER, 1);

        vehicule = fabrique.fabriqueBien("vehicule",
                "Une Tesla Model X", 55000.0, dateD, dateF, "Tesla", 2021);

        // When
        boolean actualRes = vehicule.surencherir(vehicule, 45000.0, Calendar.getInstance());

        // Then
        assertEquals(false, actualRes);
    }

}