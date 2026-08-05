package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) {
        Label instruction = new Label("Enter your name and start");
        TextField nameField = new TextField();
        Button start = new Button("Start");
        
        GridPane layout = new GridPane();
        
        layout.add(instruction, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(start, 0, 2);
        
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene startScene = new Scene(layout);
        
        Label welcomeText = new Label("");
        
        StackPane welcome = new StackPane();
        
        welcome.setPrefSize(300, 180);
        welcome.getChildren().add(welcomeText);
        welcome.setAlignment(Pos.CENTER);
        
        Scene welcomeView = new Scene(welcome);
        
        start.setOnAction((event) -> {
           welcomeText.setText("Welcome " + nameField.getText() + "!");
           
           window.setScene(welcomeView);
        });
        
        window.setScene(startScene);
        window.show();
    }
    
    
}
