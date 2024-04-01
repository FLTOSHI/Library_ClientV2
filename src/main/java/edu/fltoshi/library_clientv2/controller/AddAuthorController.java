package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.entity.AuthorEntity;
import edu.fltoshi.library_clientv2.service.AuthorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddAuthorController {
    private final AuthorService service = new AuthorService();
    private boolean addFlag = true;
    private AuthorEntity getSelectionElement(){
        AuthorEntity temp = dataList.getSelectionModel().getSelectedItem();
        return temp;
    }

    @FXML
    private ListView<AuthorEntity> dataList;

    @FXML
    private TextField textFirstname;

    @FXML
    private TextField textLastname;

    @FXML
    private TextField textSurname;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteButton;


    @FXML
    void addAction(ActionEvent event) {
        AuthorEntity author = new AuthorEntity();
        author.setLastname(textLastname.getText());
        author.setName(textFirstname.getText());
        author.setSurname(textSurname.getText());
        if (addFlag) {
            service.add(author);
        } else {
            author.setId(getSelectionElement().getId());
            service.update(author, getSelectionElement());
        }
        textLastname.clear();
        textFirstname.clear();
        textSurname.clear();

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteAction(ActionEvent event){
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickDataList(MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                AuthorEntity temp = getSelectionElement();
                textLastname.setText(temp.getLastname());
                textFirstname.setText(temp.getName());
                textSurname.setText(temp.getSurname());
            }
        }
    }
    @FXML
    private void initialize(){
        service.getAll();
        dataList.setItems(service.getData());
    }

}