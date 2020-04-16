package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DMPCalc extends Application {

    public double mealPrice;
    public double dormPrice;
    public double totalPrice;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage){

        /*
        Alen Hall: 1,800
        Pike Hall: 2200
        Farthing Hall:2800
        Universitie Suites: 3000

        7 Meals Per Week: 600
        14 Meals Per Week: 1100
        Unlimited meals: 1800
         */


        primaryStage.setTitle("Dorm & Meal Plan Calc");
        //Label Home
        Label homeLabel = new Label("Please Select Dorm and Meal Plan");

        //Combobxes for forms and food plan
        ComboBox<String> dormSelection = new ComboBox<>();
        dormSelection.getItems().addAll("Alen Hall", "Pike Hall", "Farthing Hall", "Universitie Suites");

        ComboBox<String> foodSelection = new ComboBox<>();
        foodSelection.getItems().addAll("7 Meals", "14 Meals", "Unlimited");

        //Display total
        Label totatLabel = new Label("Total: $0.00");


        // CreateLabel
        Label outputlabel = new Label("Select a Country");

        // Register  and event handler
        dormSelection.setOnAction(event ->{

            if (dormSelection.getValue() == "England"){
                outputlabel.setText(String.valueOf(2+2));
            }

        });

        // Container Controls
        HBox header = new HBox(10,homeLabel);
        header.setAlignment(Pos.CENTER);

        HBox userSelection = new HBox(10, dormSelection,foodSelection);
        userSelection.setAlignment(Pos.CENTER);

        HBox outputController = new HBox(10,outputlabel);
        outputController.setAlignment(Pos.CENTER);

        //Add Controls to a vbox
        VBox vBox = new VBox(10,header,userSelection,outputController);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.TOP_CENTER);

        //Create a scene and display it
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}