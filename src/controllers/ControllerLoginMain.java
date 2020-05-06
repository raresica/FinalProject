package controllers;

import DBConnection.DBHandler;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private DBHandler hander;
    private Connection connection;
    private PreparedStatement pst;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    hander = new DBHandler();
    }


      @FXML
    public void onClickActionSignUp() throws Exception {
        signup.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/Register.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setScene(new Scene(root));
        signUpStage.show();
    }


    @FXML
    void loginAction(ActionEvent event) {
        connection =hander.getConnection();
        String q1= "SELECT * FROM login WHERE username=? and password=?";

        try {
            pst = connection.prepareStatement(q1);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            ResultSet rs= pst.executeQuery();
            int count=0;
            while (rs.next()) {
                count++;
            }
            if (count==1){
                System.out.println("Login Succesfull");
            }
            else
            {
                System.out.println("Username or Password are is not correct");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}



