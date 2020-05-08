package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerForceClass implements Initializable {
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void onClickActionBack() throws Exception {
        back.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/adminHalls.fxml"));
        Stage backStage = new Stage();
        backStage.setScene(new Scene(root));
        backStage.show();
    }

}
