package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {

        BorderPane pane = new BorderPane();

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        XYChart.Series savingsLine = new XYChart.Series();
        XYChart.Series savingsWithInterestLine = new XYChart.Series();

        lineChart.getData().add(savingsLine);
        lineChart.getData().add(savingsWithInterestLine);

        pane.setCenter(lineChart);

        VBox vBox = new VBox();

        BorderPane innerPane1 = new BorderPane();
        BorderPane innerPane2 = new BorderPane();

        Label savings = new Label("Monthly savings");
        Label interest = new Label("Yearly interest rate");
        Label savingsValue = new Label("0.0");
        Label interestValue = new Label("0.0");

        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        Slider interestSlider = new Slider(0, 10, 2);

        innerPane1.setLeft(savings);
        innerPane1.setCenter(savingsSlider);
        innerPane1.setRight(savingsValue);

        innerPane2.setLeft(interest);
        innerPane2.setCenter(interestSlider);
        innerPane2.setRight(interestValue);

        vBox.getChildren().addAll(innerPane1, innerPane2);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);

        pane.setTop(vBox);

        savingsSlider.valueProperty().addListener((value, oldValue, newValue) -> {
            savingsValue.setText(String.format("%.2f", newValue.doubleValue()));

            updateChart(savingsSlider.getValue(), interestSlider.getValue(), savingsLine, savingsWithInterestLine);
        });

        interestSlider.valueProperty().addListener((value, oldValue, newValue) -> {
            interestValue.setText(String.format("%.2f", newValue.doubleValue()));

            updateChart(savingsSlider.getValue(), interestSlider.getValue(), savingsLine, savingsWithInterestLine);
        });

        updateChart(savingsSlider.getValue(), interestSlider.getValue(), savingsLine, savingsWithInterestLine);
        Scene scene = new Scene(pane);
        arg0.setScene(scene);
        arg0.show();
    }

    private void updateChart(double savingValue, double interestValue, XYChart.Series savingsLine, XYChart.Series savingsWithInterestLine) {

        savingsLine.getData().clear();
        savingsWithInterestLine.getData().clear();

        savingsLine.getData().add(new XYChart.Data(0, 0));
        savingsWithInterestLine.getData().add(new XYChart.Data(0, 0));

        double savings = 0;
        double savingsWithInterest = 0;

        for (int i = 1; i <= 30; i++) {

            savings += savingValue * 12;
            savingsWithInterest = savingsWithInterest * (1.0 + interestValue / 100);
            savingsWithInterest += savingValue * 12;

            savingsLine.getData().add(new XYChart.Data(i, savings));
            savingsWithInterestLine.getData().add(new XYChart.Data(i, savingsWithInterest));
        }
    }

}
