package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.entity.CityEntity;
import edu.fltoshi.library_clientv2.service.CityService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCityController {

    CityService service = new CityService();

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ListView<CityEntity> dataList;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField textTitle;

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
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize(){
        service.getAll();
        dataList.setItems(service.getData());
    }
}
