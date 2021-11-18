package interface_enchere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


/**
 * La classe main qui lance l'application.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.getIcons().add(new Image("ventes-encheres-immobilier.jpg"));
        primaryStage.setTitle("Enchère");
        Scene scene = new Scene(root, 600, 600);
        String fontSheet = fileToStylesheetString( new File("src/interface_enchere/stylesheet.css") );

        scene.getStylesheets().add( fontSheet );

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String fileToStylesheetString ( File stylesheetFile ) {
        try {
            return stylesheetFile.toURI().toURL().toString();
        } catch ( MalformedURLException e ) {
            return null;
        }
    }

}
