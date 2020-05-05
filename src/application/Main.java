package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("../resources/view/LoginMain.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("../resources/view/SignUp.fxml"));
    //  Parent root = FXMLLoader.load(getClass().getResource("../resources/view/test.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}