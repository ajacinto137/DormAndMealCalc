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


    // Fields to hold the price selected
    public double mealPrice;
    public double dormPrice;
    public double totalPrice;

    /*
    Fields to hold arryay and dorms
    Each has a ListOf... fields have the corresponding prices

            Alen Hall: 1,800
            Pike Hall: 2200
            Farthing Hall:2800
            Universitie Suites: 3000

            7 Meals Per Week: 600
            14 Meals Per Week: 1100
            Unlimited meals: 1800

     */
    public String[] Dorms = {"Alen Hall", "Pike Hall", "Farthing Hall", "Universitie Suites"};
    public double[] ListOfDormPrices = {1800,2200,2800,3000};
    public String[] MealPlans = {"7 Meals", "14 Meals", "Unlimited"};
    public double[] ListOfMealPrices = {600,1100,1800};

    // CreateLabel
    Label outputlabel = new Label("Please Choose!");

    public static void main(String[] args) {
        launch(args);
    }


    // Set the outPutLabel
    public void setTotalPrice() {

        if (dormPrice == 0.0 ){
            System.out.println("IN dormPriceLoop");
            outputlabel.setText("Please Choose A Dorm ");
        }

        if (mealPrice == 0.0 ){
            outputlabel.setText("Please Choose A Meal Plane");
        }

        if (mealPrice != 0 && dormPrice !=0 ){
            totalPrice = mealPrice + dormPrice;
            outputlabel.setText("Your total is: $" + String.valueOf(totalPrice));
        }
    }

    public void start(Stage primaryStage){



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




        // Register  and event handler
        //Loops through the arrays and sets the prices accordingly
        //Sets the prices and output labels accordingly
        dormSelection.setOnAction(event ->{
            System.out.println("dormPrice = " + dormPrice);
            for (int i = 0; i <Dorms.length; i++){
                if (dormSelection.getValue() == Dorms[i]){
                    dormPrice = ListOfDormPrices[i];
                }
        }
            setTotalPrice();
        });

        foodSelection.setOnAction(event ->{

            for (int i = 0; i <MealPlans.length; i++){
                if (foodSelection.getValue() == MealPlans[i]){
                    mealPrice = ListOfMealPrices[i];
                }
            }
            setTotalPrice();
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