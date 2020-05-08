package controllers;

import DBConnection.DBHandler;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerAddTrainerPage implements Initializable {

    @FXML
    private Button SignUp;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private ChoiceBox choiceBoxGender;

    @FXML
    private ChoiceBox choiceBoxSpeciality;


    @FXML
    private Button back;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler=new DBHandler();
        choiceBoxGender.setItems(FXCollections.observableArrayList("MALE", new Separator(), "FEMALE"));
        choiceBoxSpeciality.setItems(FXCollections.observableArrayList("SPINNING", new Separator(), "FORCE", new Separator(), "YOGA", new Separator(), "ZUMBA"));
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
    void signupAction() {
        String insert = "INSERT INTO user_trainer(username, password,gender,speciality)"
                + "VALUES (?,?,?,?)";

        connection = handler.getConnection();
        try {
            pst = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            pst.setString(3, getGender());
            pst.setString(4, getSpeciality());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String getGender(){
        return (String) choiceBoxGender.getSelectionModel().getSelectedItem();

    }

    public String getSpeciality(){
        return (String) choiceBoxSpeciality.getSelectionModel().getSelectedItem();

    }
}
