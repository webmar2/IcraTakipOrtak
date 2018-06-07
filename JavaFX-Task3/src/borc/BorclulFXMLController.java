package borc;

import muv.*;
import com.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BorclulFXMLController implements Initializable {

    @FXML
    private MenuItem newMuvek1;

    @FXML
    private TableView<BorcluList> tableBorclu;
    @FXML
    private TableColumn<?, ?> BkoduColumn;
    @FXML
    private TableColumn<?, ?> BAdSoyadColumn;
    @FXML
    private TableColumn<?, ?> BAdresColumn;
    @FXML
    private TableColumn<?, ?> BTelefonColumn;
    @FXML
    private TableColumn<?, ?> BEpostaColumn;
    @FXML
    private TableColumn<?, ?> BTCNoColumn;

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList<BorcluList> data;
     static Statement statement = null;
     

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

        data = FXCollections.observableArrayList();
        setCellTable();
        LoadDataFromDatabase();
    }

    private void setCellTable() {
        BkoduColumn.setCellValueFactory(new PropertyValueFactory<>("Bkodu1"));
        BAdSoyadColumn.setCellValueFactory(new PropertyValueFactory<>("BAdSoyad1"));
        BAdresColumn.setCellValueFactory(new PropertyValueFactory<>("BAdres1"));
        BTelefonColumn.setCellValueFactory(new PropertyValueFactory<>("BTelefon1"));
        BEpostaColumn.setCellValueFactory(new PropertyValueFactory<>("BEposta1"));
        BTCNoColumn.setCellValueFactory(new PropertyValueFactory<>("BTCNo1"));

    }

    private void LoadDataFromDatabase() {

        try {
             con = DriverManager.getConnection("jdbc:sqlite:projectTask3.db");
            
            // Create a statement
            statement = (Statement) con.createStatement();
            
            pst = con.prepareStatement("Select * from Borclu");
            rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new  BorcluList( rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),""+rs.getInt(6)));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorclulFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableBorclu.setItems(data);

    }


}
