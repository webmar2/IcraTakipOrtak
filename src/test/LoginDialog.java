package test;

import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 * @author thdursun
 */
public class LoginDialog {

    static Label loginInfoLabel;
    static ButtonType loginButtonType;
    static ButtonType iptalButtonType;
    static TextField usernameTextField;
    static PasswordField passwordField;
    static Dialog< Pair<String, String>> dialog;

    public LoginDialog() {

        dialog = new Dialog<>();

// Standart bir Dialog oluştur ve özelliklerini belirt. 
// Parantez içinde ne sonuç vereceğini belirtiyoruz. String çifti verecek, biri username, diğeri password olacak.
        dialog.setTitle("Kullanıcı Girişi");
        dialog.setHeaderText("Kullanıcı Bilgilerinizi Giriniz");

// Proje dosyasında bulunan login.png resmini pencereye ekle
        dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Button tiplerini ayarla
        loginButtonType = new ButtonType("Giriş", ButtonData.OK_DONE);
        iptalButtonType = new ButtonType("İptal", ButtonData.CANCEL_CLOSE);
// Giriş butonunu ve İptal butonunu pencereye ekle
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, iptalButtonType);

// Kullanıcı ve Parola alanlarını ayarla ve ekle (label ve field)
        GridPane grid = new GridPane();

        grid.setHgap(10);  //Yatay Boşluk
        grid.setVgap(10);  //Dikey Boşluk
        grid.setPadding(new Insets(20, 150, 10, 10));

        usernameTextField = new TextField();
        usernameTextField.setPromptText("Kullanıcı Adı");
        usernameTextField.setText(System.getProperty("user.name")); //Bunu otomatik olarak alıyor

        passwordField = new PasswordField();
        passwordField.setPromptText("Parola");

        loginInfoLabel = new Label("Gelişmeler ... ");

        grid.add(new Label("Kullanıcı Adı:"), 1, 0);      //Grid 1 nci kolon 0 ncı sütun a ekle
        grid.add(usernameTextField, 1, 0);
        grid.add(new Label("Parola:"), 1, 1);             //Grid 1 nci kolon 1 nci sütun a ekle
        grid.add(passwordField, 1, 1);
        grid.add(loginInfoLabel, 1, 2);             //Grid 1 nci kolon 2 nci sütun a ekle - Başarısız olursa buradaki değer değişecek.
        grid.setBackground(arkaPlan("999999"));

// Kullanıcı Adı boş ise Login butonunu Pasif yapacağız. (Disable)
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType); //Dialog da verilen isimdeki butonu bul ve Node yap 
        if (usernameTextField.equals(null)) {
            loginButton.setDisable(true); // username (Node) boş ise Pasif olsun
        }
// Lambda yazımı ile login butonunda (Node) değişiklik olursa ve yeni değer boş ise login butonunu Pasif yap.
        usernameTextField.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    loginButton.setDisable(newValue.trim().isEmpty());
                }
                );

        dialog.getDialogPane().setContent(grid);

// Otomatik olarak password e focus yap
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                passwordField.requestFocus();
            }
        });

//        Button loginButonuNode = (Button) dialog.getDialogPane().lookupButton(loginButtonType);
//        loginButonuNode.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("MouseClick");
//                getLoginDialogResult();
//            }
//        });
//
//        loginButonuNode.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                System.out.println("ONACTION");
//                getLoginDialogResult();
//            }
//        });
    }

    static Pair<String, String> getLoginDialogResult() {

        // Login butonuna basıldığında değerleri al ve onları sonuç (Pair) olarak dön
        dialog.setResultConverter(new Callback<ButtonType, Pair<String, String>>() {
            @Override
            public Pair<String, String> call(ButtonType dialogButton) {
                if (dialogButton == loginButtonType) {
                    return new Pair<>(usernameTextField.getText(), passwordField.getText());
                }
                if (dialogButton == iptalButtonType) {
                    Platform.exit();
                }
                return null;
            }
        });

//<editor-fold defaultstate="collapsed" desc="Lambda Yazımı ile üstteki işlemlerin aynısı var">
//        dialog.setResultConverter(dialogButton
//                -> {
//            if (dialogButton == loginButtonType) {
//                return new Pair<>(usernameTextField.getText(), passwordField.getText());
//            }
//            if (dialogButton == iptalButtonType) {
//                Platform.exit();
//            }
//            return null;
//        }
//        );
//</editor-fold>
        // Optional sınıfında sonuç alınana kadar beklenir. Böylece bir sonraki ekran açılmaz.
        Optional<Pair<String, String>> sonuc = dialog.showAndWait();

        // Sonuç olarak kullanıcı adı ve şifresi Pair (String çifti) olarak döner.
        return new Pair<>(sonuc.get().getKey(), sonuc.get().getValue());
    }

    // Arkaplan için kısa bir metod. Color picker ile kullanılabilir.
    public Background arkaPlan(String value) {
        BackgroundFill fills = new BackgroundFill(Paint.valueOf(value), CornerRadii.EMPTY, Insets.EMPTY);
        Background bg = new Background(fills);
        return bg;
    }
}
