package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.entity.GenreEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddGenreController {

    @FXML
    private TextField textTitle;

    @FXML
    private ListView<GenreEntity> dataList;

    @FXML
    private Button deleteButton;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;


    @FXML
    void addAction(ActionEvent event) {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteAction(ActionEvent event) {
    }

}
