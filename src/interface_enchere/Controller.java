package interface_enchere;

import appli.Application;
import appli.BiensDeApplication;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import encheres.interfaces.fabriques.IFabriqueBien;
import fabriques.FabriqueBien;
import fraisGestion.FraisGestion10et5;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Le controller de notre interface graphique d'enchere.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField montantEnchere;

    @FXML
    private TextField nomEncherisseur;

    @FXML
    private Button surencherir;

    @FXML
    private Button ajouterBien;

    @FXML
    private DatePicker ajtDateDebut;

    @FXML
    private DatePicker ajtDateFin;

    @FXML
    private TextField ajtDescription;

    @FXML
    private TextField ajtMontant;

    @FXML
    private TextField ajtTypeBien;

    @FXML
    private TextField ajtStr;

    @FXML
    private TextField ajtInt;

    @FXML
    private TableView<BienController> listeBiens;

    @FXML
    private TableColumn<BienController, String> listeBiensDescription;

    @FXML
    private TableColumn<BienController, Double> listeBiensMontant;

    @FXML
    private void surencherir() throws EncherirNotPossibleException {
        if(listeBiens.getSelectionModel().isEmpty()) {
            System.out.println("Veuillez sélectionner un bien.");
            return;
        }
        IBien bienSelectionne = listeBiens.getSelectionModel().selectedItemProperty().get().getBien();

        double montant;
        try {
            montant = Double.parseDouble(montantEnchere.getText());
        } catch (Exception e) {
            System.out.println("Veuillez entrer une valeur.");
            return;
        }

        bienSelectionne.encherir(montant);
        actualiser();
    }

    @FXML
    private void ajouterBien() {
        assert !ajtTypeBien.getText().isEmpty();
        assert !ajtDescription.getText().isEmpty();
        assert !ajtMontant.getText().isEmpty();
        assert ajtDateDebut.getValue() != null;
        assert ajtDateFin.getValue() != null;
        assert !ajtStr.getText().isEmpty();
        assert !ajtInt.getText().isEmpty();

        String typeBien = ajtTypeBien.getText();
        String description = ajtDescription.getText();

        double montant;
        try {
            montant = Double.parseDouble(ajtMontant.getText());
        } catch (Exception e) {
            System.out.println("Veuillez entrer une valeur.");
            return;
        }


        // Get dateD
        Calendar dateD = Calendar.getInstance();
        try {
            Date dateD_date = Date.from(ajtDateDebut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            dateD.setTime(dateD_date);
        } catch (Exception e) {
            System.out.println("La date de début n'est pas bonne.");
            return;
        }


        // Get dateD
        Calendar dateF = Calendar.getInstance();
        try {
            Date dateF_date = Date.from(ajtDateFin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            dateF.setTime(dateF_date);
        } catch (Exception e) {
            System.out.println("La date de fin n'est pas bonne.");
            return;
        }


        String firstSpecialAttribute = ajtStr.getText();

        int secondSpecialAttribute;
        try {
            secondSpecialAttribute = Integer.parseInt(ajtInt.getText());
        } catch (Exception e) {
            System.out.println("Veuillez entrer une valeur.");
            return;
        }

        IFabriqueBien fb = new FabriqueBien();

        try {
            BiensDeApplication.ajouterBien(fb.fabriqueBien(typeBien, description, montant, dateD, dateF,
                    new FraisGestion10et5(), firstSpecialAttribute, secondSpecialAttribute));
        } catch (Exception e) {
            System.out.println("Des valeurs sont manquantes ou incorrectes");
            return;
        }


        actualiser();
    }

    @FXML
    void initialize() {
        Application.main(null);

        listeBiensDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        listeBiensMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));

        actualiser();
    }

    public void actualiser() {
        ObservableList liste_person = FXCollections.observableArrayList();
        for( IBien bien : BiensDeApplication.getBiens() ){
            liste_person.add(new BienController(bien));
        }
        listeBiens.setItems(liste_person);
    }
}
