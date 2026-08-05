package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) {
        
        BorderPane layout = new BorderPane();
        Button buttonFirst = new Button("To the second view!");
        
        layout.setTop(new Label("First view!"));
        layout.setCenter(buttonFirst);
        
        VBox vbox = new VBox();
        Button buttonSecond = new Button("To the third view!");
        Label labelSecond = new Label("Second view!");
        
        vbox.getChildren().addAll(buttonSecond, labelSecond);
        
        GridPane pane = new GridPane();
        Button buttonThree = new Button("To the first view");
        
        pane.add(new Label("Third view"), 0, 0);
        pane.add(buttonThree, 1, 1);
        
        Scene first = new Scene(layout);
        Scene second = new Scene(vbox);
        Scene third = new Scene(pane);
        
        buttonFirst.setOnAction((event) -> {
            window.setScene(second);
        });
        
        buttonSecond.setOnAction((event) -> {
            window.setScene(third);
        });
        
        buttonThree.setOnAction((event) -> {
            window.setScene(first);
        });
        
        window.setScene(first);
        window.show();
        
    }

}
