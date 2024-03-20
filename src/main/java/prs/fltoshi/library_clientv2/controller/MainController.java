package prs.fltoshi.library_clientv2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import prs.fltoshi.library_clientv2.service.HTTPService;


public class MainController {
    HTTPService service = new HTTPService();

    @FXML
    private TableView<?> bookTable;

    @FXML
    private TableColumn<?, ?> columnAuthor;

    @FXML
    private TableColumn<?, ?> columnGenre;

    @FXML
    private TableColumn<?, ?> columnNumber;

    @FXML
    private TableColumn<?, ?> columnPublisher;

    @FXML
    private TableColumn<?, ?> columnTitle;

    @FXML
    void addBookAction(ActionEvent event) {
    }

    @FXML
    void addOrChangeAuthorAction(ActionEvent event) {
    }

    @FXML
    void addOrChangeCityAction(ActionEvent event) {
    }

    @FXML
    void addOrChangeGenreAction(ActionEvent event) {
    }

    @FXML
    void addOrChangePublisherAction(ActionEvent event) {
    }

    @FXML
    void changeBookAction(ActionEvent event) {
    }

    @FXML
    void closeAction(ActionEvent event) {
    }

    @FXML
    void deleteAuthorAction(ActionEvent event) {
    }

    @FXML
    void deleteBookAction(ActionEvent event) {
    }

    @FXML
    void deleteCityAction(ActionEvent event) {
    }

    @FXML
    void deleteGenreAction(ActionEvent event) {
    }

    @FXML
    void deletePublisherAction(ActionEvent event) {
    }

    @FXML
    private void initialize(){
    }
}