package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.entity.GenreEntity;
import edu.fltoshi.library_clientv2.service.GenreService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddGenreController {

    private boolean addFlag = true;
    GenreService service = new GenreService();

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


    // Actions
    @FXML
    void initialize() {
        service.getAll();
        dataList.setItems(service.getData());
    }

    @FXML
    void addAction(ActionEvent event) {
        GenreEntity genre = new GenreEntity();
        genre.setTitle(textTitle.getText());
        if (addFlag) {
            service.add(genre);
        } else {
            genre.setId(getSelectionElement().getId());
            service.update(genre, getSelectionElement());
        }
        textTitle.clear();

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
        addButton.setText("Добавить");

    }

    @FXML
    void cancelAction(ActionEvent event) {
        addFlag = true;
    }

    @FXML
    void deleteAction(ActionEvent event) {
        service.delete(getSelectionElement());
        textTitle.clear();
    }

    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                GenreEntity temp = getSelectionElement();
                textTitle.setText(temp.getTitle());
                addButton.setText("Изменить");
            }
        }
    }

    private GenreEntity getSelectionElement() {
        GenreEntity temp = dataList.getSelectionModel().getSelectedItem();
        return temp;
    }

    @FXML
    void editModeHandler(MouseEvent event) {
        dataList.editableProperty().setValue(false);
        textTitle.clear();
        addButton.setText("Добавить");
    }
}
