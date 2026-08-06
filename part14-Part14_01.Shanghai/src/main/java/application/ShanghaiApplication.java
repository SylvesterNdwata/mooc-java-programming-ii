package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 4);
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        XYChart.Series uhData = new XYChart.Series();
        uhData.getData().add(new XYChart.Data<>(2007, 73));
        uhData.getData().add(new XYChart.Data(2008, 68));
        uhData.getData().add(new XYChart.Data(2009, 72));
        uhData.getData().add(new XYChart.Data(2010, 72));
        uhData.getData().add(new XYChart.Data(2011, 74));
        uhData.getData().add(new XYChart.Data(2012, 73));
        uhData.getData().add(new XYChart.Data(2013, 76));
        uhData.getData().add(new XYChart.Data(2014, 73));
        uhData.getData().add(new XYChart.Data(2015, 67));
        uhData.getData().add(new XYChart.Data(2016, 56));
        uhData.getData().add(new XYChart.Data(2017, 56));
        
        lineChart.getData().add(uhData);
        
        Scene scene = new Scene(lineChart, 640, 480);
        arg0.setScene(scene);
        arg0.show();
        
    }

}
