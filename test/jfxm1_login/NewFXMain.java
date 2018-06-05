/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxm1_login;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.lang.Math;

/**
 *
 * @author thdursun
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {

//        Circle circ = new Circle(200, 200, 200);
//        Group root = new Group(circ);
        Group root = new Group();
        for (int i = 0; i < 6; i++) {
            Rectangle dortgen = new Rectangle();
            dortgen.setY(i * 100);
            dortgen.setWidth(400);
            dortgen.setHeight(75);
            dortgen.setFill(Color.RED);
            root.getChildren().add(dortgen);
        }
        root.setAutoSizeChildren(false);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("My JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();

//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
