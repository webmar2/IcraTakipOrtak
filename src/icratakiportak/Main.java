package icratakiportak;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * @author thdursun
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        // Dialog u getir, true ise devam et, yoksa çık.
        // LoginDialog loginPenceresi = new LoginDialog();
        while(LoginDialog.isLoginOK()== false){
            System.out.println("Login false döndü. Tekrar dene.");
        }  
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
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
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
