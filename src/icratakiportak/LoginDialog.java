/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icratakiportak;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * @author thdursun
 */
public class LoginDialog {
    
    static String username;
    static String password;
    static Label bilgiLabel = new Label("");
    static int hataliDenemeSayisi = 3;
    
    public LoginDialog() {
        // User ve pass aynı anda dönecek. Bu sebeple Pair kullanıyoruz.
        Dialog<Pair<String, String>> dialogEkranı = new Dialog<>();

        // Dialog ekranındaki nesneleri tanımlıyoruz
        dialogEkranı.setTitle("Kullanıcı Girişi");
        dialogEkranı.setHeaderText("Kullanıcı Bilgilerinizi Giriniz");

        // Proje dosyasında bulunan login.png resmini pencereye ekle
        dialogEkranı.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

        // Button tiplerini ayarla
        ButtonType girisButtonType = new ButtonType("Giriş", ButtonBar.ButtonData.OK_DONE);
        ButtonType iptalButtonType = new ButtonType("İptal", ButtonBar.ButtonData.CANCEL_CLOSE);

        // Giriş butonunu ve İptal butonunu pencereye ekle
        dialogEkranı.getDialogPane().getButtonTypes().addAll(girisButtonType, iptalButtonType);

        // İptal butonuna basıldığında direk çık.
        Node iptal = dialogEkranı.getDialogPane().lookupButton(iptalButtonType);
        ((Button) iptal).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args) {
                Platform.exit();
            }
        });

// Kullanıcı ve Parola alanlarını ayarla ve ekle (label ve field)
        GridPane grid = new GridPane();
        
        grid.setHgap(10);  //Yatay Boşluk
        grid.setVgap(10);  //Dikey Boşluk
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Kullanıcı Adı");
        // usernameTextField.setText(System.getProperty("user.name")); //Bunu otomatik olarak alıyor
        usernameTextField.setText("obaser"); //Bunu otomatik olarak alıyor

        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Parola");
        passwordField.setText("obaser"); // Sonradan silinecek test için yazıldı

        // bilgiLabel = new Label("Gelişmeler ... ");
        grid.add(new Label("Kullanıcı Adı:"), 1, 0);      //Grid 1 nci kolon 0 ncı sütun a ekle
        grid.add(usernameTextField, 1, 0);
        grid.add(new Label("Parola:"), 1, 1);             //Grid 1 nci kolon 1 nci sütun a ekle
        grid.add(passwordField, 1, 1);
        grid.add(bilgiLabel, 1, 2);             //Grid 1 nci kolon 2 nci sütun a ekle - Başarısız olursa buradaki değer değişecek.

        // Kullanıcı Adı boş ise Login butonunu Pasif yapacağız. (Disable)
        Node loginButton = dialogEkranı.getDialogPane().lookupButton(girisButtonType); //Dialog da verilen isimdeki butonu bul ve Node yap 
        if (usernameTextField.equals(null)) {
            loginButton.setDisable(true); // username alanı boş ise login butonu Pasif olsun
        }

        // Lambda yazımı ile login butonunda (Node) değişiklik olursa ve yeni değer boş ise login butonunu Pasif yap.
        usernameTextField.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    loginButton.setDisable(newValue.trim().isEmpty());
                }
                );

        // Grid Pane i ekrana ekle
        dialogEkranı.getDialogPane().setContent(grid);

        // Otomatik olarak password e focus yap
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                passwordField.requestFocus();
            }
        });

        // Şimdi ok e basınca sonuc dönecek 
        // Sql sorgusundan geçemezse hiçbir şey yapma, tekrar sor, label i değiş
        // Sql sorgusundan geçerse login ekranı kapanacak
        //result converter lazım ya da böyle yaparız.
        dialogEkranı.showAndWait();
        
        username = usernameTextField.getText();
        password = passwordField.getText();
    }
    
    // Kullanıcı adını ve parolayı al -> Sql sorgusundan geçir -> true false döner.
    public static boolean isLoginOK() {
        
        System.out.println("isLoginOK deyiz: " + username + " " + password);
        
        ResultSet sqlSonuc;
        try {
            sqlSonuc = Sql.getUserAndPassResultSet();
            
            // Varitabanından gelen her satır için aşağıdaki kontrolü gerçekleştir.
            while (sqlSonuc.next()) {
                if (sqlSonuc.getString("username").equalsIgnoreCase(username)) {
                    if (sqlSonuc.getString("password").equals(password)) {
                        System.out.println("Giriş Başarılı");
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Değerler tutmuyorsa bunları yap
        bilgiLabel.setText("Hatalı Deneme Kalan Hakkınız: " + hataliDenemeSayisi);
        hataliDenemeSayisi--;
        new LoginDialog();
        return false;
    }
}
