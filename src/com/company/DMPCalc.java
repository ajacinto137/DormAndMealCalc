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
    public String[] Dorms = {"Alen Hall", "Pike Hall", "Farthing Hall", "Universitie Suites"};
    public double[] ListOfDormPrices = {1800,2200,2800,3000};
    public String[] MealPlans = {"7 Meals", "14 Meals", "Unlimited"};
    public double[] ListOfMealPrices = {600,1100,1800};

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
        dormSelection.getItems().addAll(Dorms);

        ComboBox<String> foodSelection = new ComboBox<>();
        foodSelection.getItems().addAll(MealPlans);

        //Display total
        Label totatLabel = new Label("Total: $0.00");


        // CreateLabel
        Label outputlabel = new Label("Please Choose!");

        // Register  and event handler
        dormSelection.setOnAction(event ->{
            System.out.println("dormPrice = " + dormPrice);
            for (int i = 0; i <Dorms.length; i++){
                if (dormSelection.getValue() == Dorms[i]){
                    dormPrice = ListOfDormPrices[i];
                }
                outputlabel.setText(String.valueOf(dormPrice));
        }});

        foodSelection.setOnAction(event ->{

            for (int i = 0; i <MealPlans.length; i++){
                if (foodSelection.getValue() == MealPlans[i]){
                    mealPrice = ListOfMealPrices[i];
                }
                outputlabel.setText(String.valueOf(dormPrice+mealPrice));
            }});

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