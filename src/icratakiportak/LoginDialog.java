package icratakiportak;

import java.util.Optional;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
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

    public LoginDialog() {

// Standart bir Dialog oluştur ve özelliklerini belirt.
        Dialog< Pair<String, String>> dialog = new Dialog<>();

        dialog.setTitle("Kullanıcı Girişi");
        dialog.setHeaderText("Kullanıcı Bilgilerinizi Giriniz");

// Proje dosyasında bulunan login.png resmini pencereye ekle
        dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Button tiplerini ayarla
        ButtonType loginButtonType = new ButtonType("Giriş", ButtonData.OK_DONE);
        ButtonType iptalButtonType = new ButtonType("İptal", ButtonData.CANCEL_CLOSE);
// Giriş butonunu ve İptal butonunu pencereye ekle
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,iptalButtonType);

// Kullanıcı ve Parola alanlarını ayarla ve ekle (label ve field)
        GridPane grid = new GridPane();

        grid.setHgap(10);  //Yatay Boşluk
        grid.setVgap(10);  //Dikey Boşluk
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Kullanıcı Adı");
        username.setText("thdursun"); //Bunu otomatik alcak sonradan

        PasswordField password = new PasswordField();
        password.setPromptText("Parola");

        grid.add(new Label("Kullanıcı Adı:"), 0, 0);      //Grid ilk kolon ilk sütun a ekle
        grid.add(username, 1, 0);
        grid.add(new Label("Parola:"), 0, 1);             //Grid ilk kolon 2nci sütun a ekle
        grid.add(password, 1, 1);

// Kullanıcı Adı boş ise Login butonunu Pasif yapacağız. (Disable)
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType); //Dialog da verilen isimdeki butonu bul ve Node yap 
        loginButton.setDisable(true); // Bu Node şimdi Pasif olsun

// Lambda yazımı ile login butonunda (Node) değişiklik olursa ve yeni değer boş ise login butonunu Pasif yap.
        username.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    loginButton.setDisable(newValue.trim().isEmpty());
                }
                );

        dialog.getDialogPane().setContent(grid);

// Otomatik olarak Kullanıcı Adına focus yap
        Platform.runLater(
                () -> password.requestFocus());

// Login butonuna basıldığında değerleri al ve onları sonuç (Pair) olarak dön
        dialog.setResultConverter(dialogButton
                -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            } if (dialogButton == iptalButtonType) {
                Platform.exit();
            } 
            return null;
        }
        );

        Optional< Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword
                -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        }
        );
        
    }

}
