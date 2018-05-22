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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 * @author thdursun
 */
public class LoginDialog {
   

    public Pair<String, String> getLoginDialogData() {

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
        username.setText( System.getProperty("user.name") ); //Bunu otomatik olarak alıyor

        PasswordField password = new PasswordField();
        password.setPromptText("Parola");

        grid.add(new Label("Kullanıcı Adı:"), 1, 0);      //Grid ilk kolon ilk sütun a ekle
        grid.add(username, 1, 0);
        grid.add(new Label("Parola:"), 1, 1);             //Grid ilk kolon 2nci sütun a ekle
        grid.add(password, 1, 1);
        grid.setBackground(arkaPlan("999999"));

// Kullanıcı Adı boş ise Login butonunu Pasif yapacağız. (Disable)
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType); //Dialog da verilen isimdeki butonu bul ve Node yap 
        if (username.equals(null))
            loginButton.setDisable(true); // username (Node) boş ise Pasif olsun

// Lambda yazımı ile login butonunda (Node) değişiklik olursa ve yeni değer boş ise login butonunu Pasif yap.
        username.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    loginButton.setDisable(newValue.trim().isEmpty());
                }
                );

        dialog.getDialogPane().setContent(grid);

// Otomatik olarak password e focus yap
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
        
        dialog.initStyle(StageStyle.DECORATED);
        
        Optional<Pair<String,String>> sonuc = dialog.showAndWait();
        return new Pair<>(sonuc.get().getKey(), sonuc.get().getKey());
        
    }

    public Background arkaPlan (String value){
        
        BackgroundFill fills = new BackgroundFill(Paint.valueOf(value), CornerRadii.EMPTY, Insets.EMPTY);
        Background bg = new Background(fills);
        return bg;
    }
}
