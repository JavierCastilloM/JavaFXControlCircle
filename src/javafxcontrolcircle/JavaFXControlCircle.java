/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxcontrolcircle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.shape.Circle;



import javafx.scene.paint.Color;


/**
 *
 * @author JavierCastilloM
 */
public class JavaFXControlCircle extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        // Adding horizontal box
        HBox box = new HBox();
        
        // Adding two buttons and setting text to them
        Button btnEnlarge = new Button();
        Button btnShrink = new Button();
        btnEnlarge.setText("Enlarge");
        btnShrink.setText("Shrink");
        
        // Including both buttons to the box
        box.getChildren().add(btnEnlarge);
        box.getChildren().add(btnShrink);
        
        // Implementing actions to both buttons
        btnEnlarge.setOnAction(new EnlargeHandler());
        btnShrink.setOnAction(new ShrinkHandler());
        
        
        // Creating a new schema
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(emptyCircle);
        borderPane.setBottom(box);
        
        
        

        
        Scene scene = new Scene(borderPane,300,200);
        box.setSpacing(55);
//        box.setPadding(new Insets(0,scene.getWidth()/3.633,0,scene.getWidth()/3.633));
        box.setPadding(new Insets(0,0,10,scene.getWidth()/5.2));
        primaryStage.setResizable(true);


        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //Inner class to Enlarge a circle
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            emptyCircle.Enlarge();
        }
    }
    
    //Inner class to Shrink a circle
    class ShrinkHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            emptyCircle.Shrink();
        }
    }
    //Constructor of the class Emptycircle
    private final EmptyCircle emptyCircle = new EmptyCircle();
    // Class to create an empty circle
    class EmptyCircle extends StackPane{
        
        //Constructor with a radius of 50 and a white color
        private final Circle circle = new Circle(50, Color.WHITE);

        public EmptyCircle(){
            getChildren().add(circle);
            // Adding color to the border of the circle
            circle.setStroke(Color.BLACK);  
        }
        
        //Methods to Enlarge and Shrink the circle within a set radius
        public void Enlarge(){
            if(circle.getRadius() < 70)
                circle.setRadius(circle.getRadius()+5);
        }
        public void Shrink(){
            if(circle.getRadius() >5)
                circle.setRadius(circle.getRadius()-5);
            
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
