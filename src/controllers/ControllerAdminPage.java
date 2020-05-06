package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdminPage implements Initializable {

    @FXML
    private Button halls;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    public void onClickActionHalls() throws Exception {

                halls.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("../resources/view/adminHalls.fxml"));
                Stage signUpStage = new Stage();
                signUpStage.setScene(new Scene(root));
                signUpStage.show();
        }

}
