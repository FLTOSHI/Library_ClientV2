package edu.fltoshi.library_clientv2.controller;

import edu.fltoshi.library_clientv2.entity.AuthorEntity;
import edu.fltoshi.library_clientv2.entity.BookEntity;
import edu.fltoshi.library_clientv2.entity.GenreEntity;
import edu.fltoshi.library_clientv2.entity.PublisherEntity;
import edu.fltoshi.library_clientv2.service.AuthorService;
import edu.fltoshi.library_clientv2.service.GenreService;
import edu.fltoshi.library_clientv2.service.PublisherService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class AddBookController {

    @Getter
    @Setter
    private Optional<BookEntity> book;

    public void start() {
        if (book.isPresent()) {
            textTitle.setText(book.get().getTitle());
            textYear.setText(book.get().getYear());
            ComboBoxAuthor.setValue(book.get().getAuthor());
            ComboBoxGenre.setValue(book.get().getGenre());
            ComboBoxPublisher.setValue(book.get().getPublisher());
        }
    }

    AuthorService authorService = new AuthorService();
    PublisherService publisherService = new PublisherService();
    GenreService genreService = new GenreService();

    @FXML
    private ComboBox<AuthorEntity> ComboBoxAuthor;

    @FXML
    private ComboBox<GenreEntity> ComboBoxGenre;

    @FXML
    private ComboBox<PublisherEntity> ComboBoxPublisher;

    @FXML
    private TextField textTitle;

    @FXML
    private TextField textYear;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    void addAction(ActionEvent event) {
        BookEntity temp = BookEntity.builder()
                .title(textTitle.getText())
                .year(textYear.getText())
                .genre(ComboBoxGenre.getSelectionModel().getSelectedItem())
                .publisher(ComboBoxPublisher.getSelectionModel().getSelectedItem())
                .author(ComboBoxAuthor.getSelectionModel().getSelectedItem())
                .build();
        book = Optional.of(temp);
        System.out.println(temp);
//        Stage stage = (Stage) addButton.getScene().getWindow();
//        stage.close();
    }

    @FXML
    void cancelAction(ActionEvent event) {
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
//        stage.close();
    }

    @FXML
    private void initialize() {
        authorService.getAll();
        publisherService.getAll();
        genreService.getAll();
        ComboBoxAuthor.setItems(authorService.getData());
        ComboBoxGenre.setItems(genreService.getData());
        ComboBoxPublisher.setItems(publisherService.getData());
    }
}
