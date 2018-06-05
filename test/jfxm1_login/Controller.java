/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxm1_login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Robot;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author thdursun
 */
public class Controller implements Initializable {
    
    private Label label;
    @FXML
    private JFXButton btn1;
    @FXML
    private Label closeButton;
    @FXML
    private JFXButton btn11;
    @FXML
    private JFXTextField usernameLabel;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    private void btn1OnAction(ActionEvent event) {
        System.out.println("btn1 basıldı...");
    }
    
    @FXML
    private void closeAction(MouseEvent event) {
        
          int cevap = JOptionPane.showConfirmDialog(null, "Kapatılıyor, Emin misin ?");
                
        if (cevap == JOptionPane.OK_OPTION ) {
            System.exit(0);
        } else {
            System.out.println("iptal edildi");
        }
    }
    
    @FXML
    private void textChangedAction(InputMethodEvent event) {
        System.out.println("text changed");
    }
    
    @FXML
    private void onMouseMoveAction(MouseEvent event) {
        ((Label) event.getSource()).setBackground(Background.EMPTY);
    }
    
        @FXML
    private void onMouseClicked(MouseEvent event) {
            System.out.println("basıldı");
    }
}
