package controllers;

import DBConnection.DBHandler;

import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Handler;

public class ControllerZumbaClass implements Initializable {


    @FXML
    private Button back;


    @FXML
    private ListView<String> ListViewTrainersZumba;

    ObservableList<String> items = FXCollections.observableArrayList();

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        List<String> zumbaStringList= new ArrayList<>();
        zumbaStringList.add("Test");

        handler = new DBHandler();
        connection = handler.getConnection();
        String q1 = "SELECT * FROM user_trainer WHERE speciality=ZUMBA";
        try {
            try {
                pst = connection.prepareStatement(q1);
                ResultSet rs = pst.executeQuery();
                while(rs.next())
                {


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ListViewTrainersZumba.setItems(FXCollections.observableArrayList((new ArrayList<String>(zumbaStringList))));



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
