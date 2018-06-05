package borc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class YeniKayitBorcController implements Initializable {

    static String query = "";
    static Statement statement = null;

    @FXML
    private Label ResultLabel;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button saveBtn, reset;

    @FXML
    private Menu borcDelete, borcluSave, menuFile;

    @FXML
    private TextField borcluKodu, borcluAd, borcluTCNo;

    @FXML
    private TextArea borcAdres, borcTelefon, borcPosta;

    @FXML
    void reset(ActionEvent event) {
        borcluKodu.setText("");
        borcluAd.setText("");
        borcluTCNo.setText("");
        borcAdres.setText("");
        borcTelefon.setText("");
        borcPosta.setText("");

        ResultLabel.setText("Form temizlendi...");
    }

    @FXML
    void CloseBtn(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    void menuSave(ActionEvent event) throws SQLException {
        statement.executeUpdate("INSERT INTO Borclu(BKodu, "
                + "BAdSoyad, "
                + "BAdres, "
                + "BTelefon, "
                + "BEposta, "
                + "BTCNo)"
                + "VALUES('" + borcluKodu.getText()
                + "','" + borcluAd.getText()
                + "','" + borcluTCNo.getText()
                + "','" + borcAdres.getText()
                + "','" + borcTelefon.getText()
                + "','" + borcPosta.getText() + "')");

        ResultLabel.setText("yeni kayıt oluşturuldu...");
        /*         
        try {
        // Class.forName("org.sqlite.JDBC");
        System.out.println("Driver loaded");
        
        // Establish a connection
        Connection connection;      
        connection = DriverManager.getConnection("jdbc:sqlite:projectTask3.db");
       
        // Create a statement
        String sql1 = "INSERT INTO Borclu(BKodu, BAdSoyad, BAdres, BTelefon, BEposta, BTCNo)VALUES (?,?,?,?,?,?)";
        
        PreparedStatement pst = connection.prepareStatement(sql1);
        pst.setString(1, borcluKodu.getText());
        pst.setString(2, borcluAd.getText());
        pst.setString(3, borcluTCNo.getText());
        pst.setString(4, borcAdres.getText());
        pst.setString(5, borcTelefon.getText());
        pst.setString(6, borcPosta.getText());
        
        pst.execute();
        
        } catch (SQLException ex) {
        Logger.getLogger(YeniKayitBorcController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void main(String[] args) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("Driver loaded");
            // Establish a connection
            Connection connection;
            connection = DriverManager.getConnection("jdbc:sqlite:projectTask3.db");
            System.out.println("Database connected");
            ResultLabel.setText("Connection Sağlandı...");
            // Create a statement
            statement = (Statement) connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(YeniKayitBorcController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
