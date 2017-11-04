package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main1 extends Application {
    public Main1() {
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        primaryStage.setTitle("SchedulerFx");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600.0D, 350.0D));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
