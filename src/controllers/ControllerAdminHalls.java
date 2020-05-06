package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerAdminHalls implements Initializable {


    @FXML
    private JFXButton spinningClass;

    @FXML
    private JFXButton forceClass;

    @FXML
    private JFXButton yogaClass;

    @FXML
    private JFXButton zumbaClass;

    @FXML
    private Button back;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    void onClickActionBack() throws Exception {
        back.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/adminPage.fxml"));
        Stage backStage = new Stage();
        backStage.setScene(new Scene(root));
        backStage.show();
    }

    @FXML
    void onClickActionForceClass() throws Exception {
        forceClass.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/ForceClass.fxml"));
        Stage forceClassStage = new Stage();
        forceClassStage.setScene(new Scene(root));
        forceClassStage.show();
    }

    @FXML
    void onClickActionYogaClass() throws Exception {
        yogaClass.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/YogaClass.fxml"));
        Stage yogaClassStage = new Stage();
        yogaClassStage.setScene(new Scene(root));
        yogaClassStage.show();
    }

    @FXML
    void onClickActionZumbaClass() throws Exception {
        zumbaClass.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/ZumbaClass.fxml"));
        Stage zumbaClassStage = new Stage();
        zumbaClassStage.setScene(new Scene(root));
        zumbaClassStage.show();
    }

    @FXML
    void onClickActionSpinningClass()throws Exception {
        spinningClass.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/SpinningClass.fxml"));
        Stage spinningClassStage = new Stage();
        spinningClassStage.setScene(new Scene(root));
        spinningClassStage.show();
    }
}

