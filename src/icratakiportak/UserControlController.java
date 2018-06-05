/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icratakiportak;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author thdursun
 */
public class UserControlController implements Initializable {

    @FXML
    public AnchorPane userControlAnchorPane;
    @FXML
    private JFXButton jfxButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("UserControl.fxml"));
//        } catch (IOException ex) {
//            Logger.getLogger(UserControlController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
}
