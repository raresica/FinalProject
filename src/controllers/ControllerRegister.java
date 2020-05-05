package controllers;

import DBConnection.DBHandler;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerRegister implements Initializable {

    @FXML
    private Button Login;

    @FXML
    private Button SignUp;

    @FXML
    private JFXRadioButton male;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    handler=new DBHandler();

    }

    @FXML
    public void onClickActionLogIn() throws Exception {
        Login.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/LoginMain.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setScene(new Scene(root));
        signUpStage.show();
    }

    @FXML
    void signupAction(ActionEvent event) {

        //saving Data

        String insert = "INSERT INTO login(username, password,gender)"
                +"VALUES (?,?,?)";

        connection=handler.getConnection();
        try {
            pst=connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.setString(1,username.getText());
            pst.setString(2, password.getText());
            pst.setString(3, getGender());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public String getGender(){
        String gen="";
        if(male.isSelected())
        {
            gen="Male";
        }
        else if(female.isSelected())
        {
            gen="Female";
        }
        return gen;
    }
}
