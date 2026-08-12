package hurraa;

import java.applet.AudioClip;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button nappi = new Button("Hurray!");
        
//        final URL resource = getClass().getResource("Applause-Yannick_Lemieux.wav");
//        
//        AudioClip audioClip = new AudioClip(resource.toExternalForm());
        
        pane.setCenter(nappi);

        nappi.setOnAction(event -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("Applause-Yannick_Lemieux.wav")));
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }); 

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
