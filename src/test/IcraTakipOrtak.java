package test;

import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.application.Platform;
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

    static String programUsername = "Henuz Yok";
    static String password = "Henuz Yok";
    static LoginDialog loginPenceresi = new LoginDialog(); // Boş Constructor olmadığı için bir şey yapmaz.


    @Override
    public void start(Stage stage) throws Exception {

        loginProcess();
        mainStageShow(stage);

    }

    public void loginProcess() {

        Pair<String, String> resultPair = LoginDialog.getLoginDialogResult(); //kullanıcı adı ve parolayı döner (Pair)
        programUsername = resultPair.getKey();
        password = resultPair.getValue();
        int i = 0;
        while (!isLoginSuccessfull()) {
            LoginDialog.loginInfoLabel.setText("Tekrar deneyiniz... "+ i);
            System.out.println("Hatalı oldu...");
            //Burası metod olması lazım
            resultPair = LoginDialog.getLoginDialogResult();
        }
    }

    public boolean isLoginSuccessfull() {
        return SqlIslemleri.checkUserAndPass(programUsername, password);
    }

    public void mainStageShow(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

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
                    case ESCAPE:
                        Platform.exit();
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
