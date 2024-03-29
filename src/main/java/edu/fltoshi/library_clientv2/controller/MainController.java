package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.MainApplication;
import edu.fltoshi.library_clientv2.service.BookService;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.fltoshi.library_clientv2.entity.BookEntity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Optional;

public class MainController {

    BookService service = new BookService();
    private Optional<BookEntity> book = Optional.empty();

    public void setBook(Optional<BookEntity> book) {
        this.book = book;
        if (book.isPresent()) {
            if (book.get().getId() != null) {
                service.update(book.get());
            } else service.add(book.get());
        }
    }


    @FXML
    private TableView<BookEntity> bookTable;

    @FXML
    private TableColumn<BookEntity, String> columnAuthor;

    @FXML
    private TableColumn<BookEntity, String> columnGenre;

    @FXML
    private TableColumn<BookEntity, String> columnNumber;

    @FXML
    private TableColumn<BookEntity, String> columnPublisher;

    @FXML
    private TableColumn<BookEntity, String> columnTitle;

    @FXML
    void addBookAction(ActionEvent event) {
        Optional<BookEntity> book = Optional.empty();
        MainApplication.showBookDialog(book);
    }

    @FXML
    void addOrChangeAuthorAction(ActionEvent event) {
        MainApplication.showDialog("add-author-view.fxml", "Работа с авторами");
    }

    @FXML
    void addOrChangeCityAction(ActionEvent event) {
        MainApplication.showDialog("add-city-view.fxml", "Работа с городами");
    }

    @FXML
    void addOrChangeGenreAction(ActionEvent event) {
        MainApplication.showDialog("add-genre-view.fxml", "Работа с жанрами");

    }

    @FXML
    void addOrChangePublisherAction(ActionEvent event) {
        MainApplication.showDialog("add-publisher-view.fxml", "Работа с издательствами");
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
    private void initialize() {
        //получаем все книги с сервера
        service.getAll();
        //связываем поля таблицы со столбцами
        columnAuthor.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("author"));
        columnGenre.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("genre"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("year"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("title"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("publisher"));
        bookTable.setItems(service.getData());
    }
}