package icratakiportak;

import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author thdursun
 */
public class IcraTakipOrtak extends Application {

    static String programUsername;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        Pair<String, String> result = new LoginDialog().getLoginDialogData(); //kullanıcı adı ve parolayı döner (Pair)
        programUsername = result.getKey();
        SqlIslemleri.KullanıcıSorgula(programUsername, result.getValue());

        Scene scene = new Scene(root);
        //<editor-fold defaultstate="collapsed" desc="Hangi tuşa basınca ne olsun.">
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case F1:
                        System.out.println("F1 e basıldı");
                        break;
                    case F2:
                        System.out.println("F2 e basıldı");
                        break;
                }
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Maximize yapmanın diğer bir yolu">
//        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//
////Ana ekranın kenar boyutlarını al ve ata
//stage.setX(primaryScreenBounds.getMinX());
//stage.setY(primaryScreenBounds.getMinY());
//stage.setWidth(primaryScreenBounds.getWidth());
//stage.setHeight(primaryScreenBounds.getHeight());
//</editor-fold>
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}
