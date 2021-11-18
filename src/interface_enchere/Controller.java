package interface_enchere;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import appli.Application;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


/**
 * Le controller de notre interface graphique d'enchere.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
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
