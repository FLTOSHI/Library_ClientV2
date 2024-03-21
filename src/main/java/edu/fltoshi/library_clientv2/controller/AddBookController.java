package edu.fltoshi.library_clientv2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddBookController {

    @FXML
    private ComboBox<?> ComboBoxAuthor;

    @FXML
    private ComboBox<?> ComboBoxGenre;

    @FXML
    private ComboBox<?> ComboBoxPublisher;

    @FXML
    private TextField textTitle;

    @FXML
    private TextField textYear;

    @FXML
    void addAction(ActionEvent event) {

    }

    @FXML
    void cancelAction(ActionEvent event) {

    }

}
