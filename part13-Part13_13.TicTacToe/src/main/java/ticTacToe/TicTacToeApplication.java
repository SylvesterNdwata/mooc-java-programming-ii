package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private String currentPlayer = "X";
    private boolean gameEnded = false;
    private Label turnLabel;
    private Button[][] buttons = new Button[3][3];

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPrefSize(300, 340);

        turnLabel = new Label("Turn: X");

        turnLabel.setFont(Font.font("Monospaced", 40));
        turnLabel.setPadding(new Insets(10, 10, 10, 10));

        root.setTop(turnLabel);

        GridPane grid = new GridPane();
        root.setCenter(grid);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);

                buttons[row][col] = button;

                final int r = row;
                final int c = col;

                button.setOnAction(event -> handleMove(button, r, c));

                grid.add(button, col, row);
            }
        }

        Scene scene = new Scene(root, 320, 350);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }

    private void handleMove(Button button, int row, int col) {
        if (gameEnded) {
            return;
        }

        if (!button.getText().isEmpty()) {
            return;
        }

        button.setText(currentPlayer);

        if (hasWon(currentPlayer)) {
            turnLabel.setText("The end!");
            gameEnded = true;
            disableAllButtons();
            return;
        }

        if (isBoardFull()) {
            turnLabel.setText("The end!");
            gameEnded = true;
            disableAllButtons();
            return;
        }

        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }

        turnLabel.setText("Turn: " + currentPlayer);
    }

    private boolean hasWon(String player) {
        // Rows
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals(player)
                    && buttons[row][1].getText().equals(player)
                    && buttons[row][2].getText().equals(player)) {
                return true;
            }
        }

        // Columns
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getText().equals(player)
                    && buttons[1][col].getText().equals(player)
                    && buttons[2][col].getText().equals(player)) {
                return true;
            }
        }

        // Diagonal from top-left to bottom-right
        if (buttons[0][0].getText().equals(player)
                && buttons[1][1].getText().equals(player)
                && buttons[2][2].getText().equals(player)) {
            return true;
        }

        // Diagonal from top-right to bottom-left
        if (buttons[0][2].getText().equals(player)
                && buttons[1][1].getText().equals(player)
                && buttons[2][0].getText().equals(player)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableAllButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
