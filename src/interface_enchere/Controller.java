package interface_enchere;

import java.net.URL;
import java.util.ResourceBundle;

import appli.Application;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


/**
 * Le controller de notre interface graphique d'enchere.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class Controller implements Initializable {
    @FXML
    private Text listeBiens;

    @FXML
    private TextField montantFourni;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Application.main(null);

        StringBuilder tTMP = new StringBuilder();

        for(IBien bien : Application.getBiens()) {
            tTMP.append(bien.getBien().toString());
            tTMP.append("\n\n");
        }

        listeBiens.setText(tTMP.toString());

        if (Application.getBiens().isEmpty())
            listeBiens.setText("Aucun bien n'est pour l'instant disponible dans l'application !");
    }

    public void encherir () throws EncherirNotPossibleException {
        double montantEnchere = 0.0;

        try {
            montantEnchere = Double.parseDouble(montantFourni.getText());
        } catch (NumberFormatException e) {
            System.out.println("La valeur entrée n'est pas un nombre !");
            return;
        }

        Application.getBiens().get(0).encherir(montantEnchere);

        StringBuilder tTMP = new StringBuilder();
        tTMP.append(Application.getBiens().get(0).toString());

        listeBiens.setText(tTMP.toString());
    }

}
