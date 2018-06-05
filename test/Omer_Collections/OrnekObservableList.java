/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Omer_Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author thdursun
 */
public class OrnekObservableList {

    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList();
        ChoiceBox<String> box = new ChoiceBox<>(FXCollections.observableArrayList(
                "Asparagus", "Beans", "Broccoli", "Cabbage", "Carrot", "Celery", 
                "Cucumber", "Leek", "Mushroom", "Pepper", "Radish", "Shallot", "Spinach", "Swede", "Turnip"));
        SortedList<String> sortedList = new SortedList<>(list);
//      SortedList<String> sortedList = new SortedList<>(FXCollections.observableArrayList());


    }
}
