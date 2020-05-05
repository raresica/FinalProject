package controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLoginMain implements Initializable {


    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXCheckBox remember;

    @FXML
    private JFXButton login;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


      @FXML
    public void onClickActionSignUp() throws Exception {
        signup.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/Register.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setScene(new Scene(root));
        signUpStage.show();
    }



}



