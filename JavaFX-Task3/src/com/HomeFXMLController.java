package com;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author obaser
 */
public class HomeFXMLController implements Initializable {

    @FXML
    private MenuBar menuBarHome;

    @FXML
    private Menu MenuFile;

    @FXML
    private MenuItem Close;

    @FXML
    private Menu edit;

    @FXML
    private MenuItem delete;

    @FXML
    private Menu help;

    @FXML
    private MenuItem about;

    @FXML
    private Menu Tanimlar;

    @FXML
    private MenuItem muvitem;

    @FXML
    void btnBorclu(ActionEvent event) throws IOException {
        System.out.println("Brclu FXML geliyor...");

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = null;
        root = FXMLLoader.load(getClass().getResource("/borc/BorcluFXML.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnBuro(ActionEvent event) {

    }

    @FXML
    void btnDosyalar(ActionEvent event) {

    }

    @FXML
    void btnFaiz(ActionEvent event) {

    }

    @FXML
    void btnMuvekkil(ActionEvent event) throws IOException {
        System.out.println("Müvekkil FXML geliyor...");

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = null;

        root = FXMLLoader.load(getClass().getResource("/muv/MuvekkilFXML.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
//            stage.fullScreenProperty();
//            stage.isFullScreen();
        stage.show();
    }

    @FXML
    void btnYazilim(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
