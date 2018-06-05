/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icratakiportak;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 *
 * @author thdursun
 */
public class MainController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private JFXButton jfxButton;
    @FXML
    private JFXColorPicker colorPicker;
    @FXML
    private AnchorPane anchorPanel;
    @FXML
    private JFXColorPicker backgroundColorChanger;
    @FXML
    private Button colorChangerButton;
    @FXML
    private Label userinfoLabel;
    @FXML
    private BorderPane mainBorderPane;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void changeButtonColor(ActionEvent event) {
        jfxButton.setBackground(
                new Background(
                    new BackgroundFill(
                        Paint.valueOf( colorPicker.getValue().toString()), CornerRadii.EMPTY, Insets.EMPTY)));
        
    }
    
    @FXML
    private void changeBackgroundColor(ActionEvent event) {
        // Anchor pane arkaplan rengini değişir.
        backgroundColorChanger.show();
        anchorPanel.setBackground(
                new Background(
                    new BackgroundFill(
                        Paint.valueOf(backgroundColorChanger.getValue().toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    
    @FXML
    private void openUserControlAnchor (ActionEvent event) throws IOException {
        Parent userControlParent= FXMLLoader.load(getClass().getResource("UserControl.fxml"));
        Scene userControlScene = new Scene(userControlParent);
        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.hide();
        homeStage.setScene(userControlScene);
        homeStage.show();
        
        
        //UserControlController userControlPage = new UserControlController();
        //mainBorderPane.setCenter(userControlPage.userControlAnchorPane);
    //    anchorPanel.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getResource("UserControl.fxml")));
    //    AnchorPane yeni = FXMLLoader.getClass().getResource("UserControl.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

}
