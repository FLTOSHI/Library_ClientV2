package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.entity.CityEntity;
import edu.fltoshi.library_clientv2.entity.PublisherEntity;
import edu.fltoshi.library_clientv2.service.CityService;
import edu.fltoshi.library_clientv2.service.PublisherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPublisherController {




    private final CityService cityService = new CityService();
    private final PublisherService publisherService = new PublisherService();
    private boolean addFlag = true;

    @FXML
    private ComboBox<CityEntity> ComboBoxCity;

    @FXML
    private ListView<PublisherEntity> dataList;

    @FXML
    private TextField textTitle;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteButton;


    private PublisherEntity getSelectionElement() {
        PublisherEntity temp = dataList.getSelectionModel().getSelectedItem();
        return temp;
    }

    @FXML
    private void addAction(ActionEvent event) {
        PublisherEntity publisher = new PublisherEntity();
        publisher.setTitle(textTitle.getText());
        publisher.setCity(ComboBoxCity.getSelectionModel().getSelectedItem());
        if (addFlag) {
            publisherService.add(publisher);
        } else {
            publisher.setId(getSelectionElement().getId());
            publisherService.update(publisher, getSelectionElement());
        }
        textTitle.clear();

//        Stage stage = (Stage) addButton.getScene().getWindow();
//        stage.close();
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        addFlag = true;

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        publisherService.delete(getSelectionElement());
    }

    @FXML
    void clickedToList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                PublisherEntity temp = getSelectionElement();
                textTitle.setText(temp.getTitle());
                ComboBoxCity.getSelectionModel().select(temp.getCity());
            }
        }
    }

    @FXML
    private void initialize() {
        cityService.getAll();
        publisherService.getAll();
        dataList.setItems(publisherService.getData());
        ComboBoxCity.setItems(cityService.getData());
    }


}