package borc;

import muv.*;
import com.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BorclulFXMLController implements Initializable {

    @FXML
    private MenuItem newMuvek1;

    @FXML
    void newMuvek(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = FXMLLoader.load(getClass().getResource("/borc/yeniKayitBorclu.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println(" yeni kayıt ekranı görüntüleniyor.");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
