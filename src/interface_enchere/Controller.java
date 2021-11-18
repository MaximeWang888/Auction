package interface_enchere;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import appli.Application;
import appli.BiensDeApplication;
import biens.Habitation;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import fraisGestion.FraisGestion10et5;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextFlow listeDeBiens;

    @FXML
    private Text texttomodify;

    private static List<IBien> biens;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listeDeBiens = new TextFlow();

        Application.main(null);

        StringBuilder tTMP = new StringBuilder();

        for(IBien bien : Application.getBiens())
            tTMP.append(bien.getBien().toString());

        texttomodify.setText(tTMP.toString());
    }

    public void encherir () throws EncherirNotPossibleException {
        System.out.println("hello");
        Application.getBiens().get(0).encherir(230000.0);
        System.out.println(Application.getBiens().get(0).toString());
        StringBuilder tTMP = new StringBuilder();
        tTMP.append(Application.getBiens().get(0).toString());
        texttomodify.setText(tTMP.toString());
    }

}
