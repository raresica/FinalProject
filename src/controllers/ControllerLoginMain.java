package controllers;

import DBConnection.DBHandler;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
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
    private JFXCheckBox remember;

    @FXML
    private Button signup;

    @FXML
    private Button login;

    @FXML
    private ChoiceBox choiceBoxRole;


    private DBHandler hanlder;
    private Connection connection;
    private PreparedStatement pst;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    hanlder = new DBHandler();
    choiceBoxRole.setItems(FXCollections.observableArrayList("ADMIN", new Separator(), "TRAINER", new Separator(), "CUSTOMER"));
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

        connection =hanlder.getConnection();
        if(getRole()=="ADMIN") {
            String q1 = "SELECT * FROM user_admin WHERE username=? and password=?";

            try {
                pst = connection.prepareStatement(q1);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                ResultSet rs = pst.executeQuery();
                int count = 0;
                while (rs.next()) {
                    count++;
                }
                if (count == 1) {
                    login.getScene().getWindow().hide();


                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/adminPage.fxml"));
                        Stage test = new Stage();
                        test.setScene(new Scene(root));
                        test.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Username or password is not correct!");
                    alert.show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if(getRole()=="TRAINER") {
            String q1 = "SELECT * FROM user_trainer WHERE username=? and password=?";

            try {
                pst = connection.prepareStatement(q1);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                ResultSet rs = pst.executeQuery();
                int count = 0;
                while (rs.next()) {
                    count++;
                }
                if (count == 1) {
                    login.getScene().getWindow().hide();


                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/AddTrainerPage.fxml"));
                        Stage test = new Stage();
                        test.setScene(new Scene(root));
                        test.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Username or password is not correct!");
                    alert.show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if(getRole()=="CUSTOMER") {
            String q1 = "SELECT * FROM user_customer WHERE username=? and password=?";

            try {
                pst = connection.prepareStatement(q1);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                ResultSet rs = pst.executeQuery();
                int count = 0;
                while (rs.next()) {
                    count++;
                }
                if (count == 1) {
                    login.getScene().getWindow().hide();


                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("../resources/view/customerPage.fxml"));
                        Stage test = new Stage();
                        test.setScene(new Scene(root));
                        test.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Username or password is not correct!");
                    alert.show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public String getRole(){
        return (String) choiceBoxRole.getSelectionModel().getSelectedItem();

    }
}



