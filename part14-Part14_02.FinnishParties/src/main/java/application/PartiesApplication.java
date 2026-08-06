package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {

        NumberAxis xAxis = new NumberAxis(1967, 2009, 4);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of parties");
        
        Map<String, Map<Integer, Double>> partyData = readFile("partiesdata.tsv");
        
        partyData.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);
            
            partyData.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            
            lineChart.getData().add(data);
        });
        
        Scene scene = new Scene(lineChart);
        arg0.setScene(scene);
        arg0.show();

    }

    private static Map<String, Map<Integer, Double>> readFile(String fileName) {
        ArrayList<Integer> years = new ArrayList<>();
        Map<String, Map<Integer, Double>> finalData = new HashMap<>();

        try ( Scanner reader = new Scanner(Paths.get(fileName))) {

            String row = reader.nextLine();

            String[] parts = row.split("\t");

            for (int i = 1; i < parts.length; i++) {
                years.add(Integer.valueOf(parts[i]));
            }

            while (reader.hasNextLine()) {

                String otherRow = reader.nextLine();

                String[] otherParts = otherRow.split("\t");

                String party = otherParts[0];

                Map<Integer, Double> numberData = new HashMap<>();

                for (int i = 1; i < otherParts.length; i++) {
                    if (!otherParts[i].equals("-")) {
                        int year = years.get(i - 1);
                        numberData.put(year, Double.valueOf(otherParts[i]));
                    }
                }

                finalData.put(party, numberData);

            }

        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }

        return finalData;
    }

}
