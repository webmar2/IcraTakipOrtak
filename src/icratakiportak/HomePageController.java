/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icratakiportak;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * @author thdursun
 */
public class HomePageController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label bilgilerLabel;
    @FXML
    private AnchorPane anchorPanel;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    
    public String getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return( sdf.format(cal.getTime()) );
    }

    public Runnable bilgileriAtaRunnable (){
        return new Runnable() {
            @Override
            public void run() {
                bilgilerLabel.setText(
                "Program Kullanıcı Adı : " + IcraTakipOrtak.programUsername + "\n"
                + "Windows Kullanıcı Adı : " + System.getProperty("user.name") + "\n"
                + "Java Versionu : " + System.getProperty("java.version") + "\n"
                + "İşletim Sistemi : " + System.getProperty("os.name") + "\n" +
                "Oturum açılan saat : " + getCurrentTime()
        );
            }
        };
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bilgileriAtaRunnable().run();
    }

}
