package textstatistics;

import java.util.Arrays;
import java.util.Comparator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {
        
        BorderPane layout = new BorderPane();
        
        Label letters = new Label("Letters: ");
        Label wordCount = new Label("Words: ");
        Label longestWord = new Label("The longest word is: ");
        TextArea area = new TextArea();
        
        HBox labels = new HBox();
        labels.setSpacing(10);
        labels.getChildren().add(letters);
        labels.getChildren().add(wordCount);
        labels.getChildren().add(longestWord);
        
        area.textProperty().addListener((text, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] words = newValue.split(" ");
            String longest = Arrays.stream(words)
                    .max(Comparator.comparing(String::length))
                    .get();
            
            letters.setText("Letters: " + characters);
            wordCount.setText("Words: " + words.length);
            longestWord.setText("The longest word is: " + longest);
        });
        
        layout.setBottom(labels);
        
        layout.setCenter(area);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

}
