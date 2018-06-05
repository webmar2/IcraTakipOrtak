package muv;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class YeniKayitMuvController implements Initializable {

    static String sql = "";
    static Statement statement = null;

    @FXML
    private Menu muvDelete, muvSave;

    @FXML
    private TextField muvKodu, muvAd, muvFirma, muvFKodu, muvFKategori;

    @FXML
    private TextField muvMeslek, muvVergi, muvCinsiyet;

    @FXML
    private TextArea muvAdres;

    @FXML
    private TextArea muvTelefon;

    @FXML
    private TextArea muvPosta;

    @FXML
    private TextField muvAnne;

    @FXML
    private TextField muvBaba;

    @FXML
    private TextField muvDogum;

    @FXML
    private void menuSave(ActionEvent event) {
        try {
            Class.forName("org.sqlite.JDBC");

            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection;

            connection = DriverManager.getConnection("jdbc:sqlite:projectTask3.db");

            System.out.println("Database connected");

            // Create a statement
            statement = (Statement) connection.createStatement();
            String sql1 = "INSERT INTO Muvekkil(Kodu, AdSoyad, FirmaAdi, FirmaKodu, FirmaKategori, Cinsiyet, Meslek, VergiNo, Adres, Telefon, Eposta, AnneAdi, BabaAdi, DogumYeri)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql1);
            pst.setString(1, muvKodu.getText());
            pst.setString(2, muvAd.getText());
            pst.setString(3, muvFirma.getText());
            pst.setString(4, muvFKodu.getText());
            pst.setString(5, muvFKategori.getText());
            pst.setString(6, muvMeslek.getText());
            pst.setString(7, muvVergi.getText());
            pst.setString(8, muvCinsiyet.getText());
            pst.setString(9, muvAdres.getText());
            pst.setString(10, muvTelefon.getText());
            pst.setString(11, muvPosta.getText());
            pst.setString(12, muvAnne.getText());
            pst.setString(13, muvBaba.getText());
            pst.setString(14, muvDogum.getText());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(YeniKayitMuvController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YeniKayitMuvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        
        String Kod = muvKodu.getText();
        String Ad = muvAd.getText();
        String Frm = muvFirma.getText();
        String FKod = muvFKodu.getText();
        String FKat = muvFKategori.getText();
        String Mslk = muvMeslek.getText();
        String Ver = muvVergi.getText();
        String Cin = muvCinsiyet.getText();
        String Adr = muvAdres.getText();
        String Tel = muvTelefon.getText();
        String Pos = muvPosta.getText();
        String Ann = muvAnne.getText();
        String Bab = muvBaba.getText();
        String Dog = muvDogum.getText();
        
        String sql = "INSERT INTO Muvekkil(Kodu, AdSoyad, FirmaAdi, FirmaKodu, FirmaKategori, Cinsiyet, Meslek, VergiNo, Adres, Telefon, Eposta, AnneAdi, BabaAdi, DogumYeri)"
        + "VALUES('" + Kod + "','" + Ad + "','" + Frm + "','" + FKod + "','" + FKat + "','" + Mslk + "','" + Ver + "','" + Cin + "','" + Adr + "','" + Tel + "','" + Pos + "','" + Ann + "','" + Bab + "','" + Dog + "')";
        
        statement.executeUpdate(sql);
         */
    }

    public static void main(String[] args) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*        
        
        try {
        
        Class.forName("org.sqlite.JDBC");
        System.out.println("Driver loaded");
        
        // Establish a connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:projectTask3.db");
        System.out.println("Database connected");
        
        // Create a statement
        statement = (Statement) connection.createStatement();
        
        System.out.println("ttttt");
        } catch (SQLException ex) {
        Logger.getLogger(YeniKayitMuvController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(YeniKayitMuvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         */
    }

}
