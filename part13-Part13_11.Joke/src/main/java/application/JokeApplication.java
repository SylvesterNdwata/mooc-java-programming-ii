package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        BorderPane layout = new BorderPane();

        HBox nav = new HBox();
        nav.setPadding(new Insets(20, 20, 20, 20));
        nav.setSpacing(10);

        Button first = new Button("Joke");
        Button second = new Button("Answer");
        Button third = new Button("Explanation");

        nav.getChildren().addAll(first, second, third);

        layout.setTop(nav);

        StackPane joke = createView("What do you call a bear with no teeth?");
        StackPane answer = createView("A gummy bear.");
        StackPane explanation = createView("I have no idea");
        
        first.setOnAction((event) -> layout.setCenter(joke));
        second.setOnAction((event) -> layout.setCenter(answer));
        third.setOnAction((event) -> layout.setCenter(explanation));
        
        layout.setCenter(joke);
        
        Scene scene = new Scene(layout);
        
        arg0.setScene(scene);
        arg0.show();
    }

    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

}
