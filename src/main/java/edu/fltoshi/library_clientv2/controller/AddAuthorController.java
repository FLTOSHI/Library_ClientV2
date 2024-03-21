package edu.fltoshi.library_clientv2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddAuthorController {

    @FXML
    private Button addAction;

    @FXML
    private Button cancelAction;

    @FXML
    private ListView<?> dataList;

    @FXML
    private Button deleteAction;

    @FXML
    private TextField textFirstname;

    @FXML
    private TextField textLastname;

    @FXML
    private TextField textSurname;

}