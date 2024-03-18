package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.MainApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClientProperties {
    private final Properties properties = new Properties();

    // Книги
    public String getAllBook;
    public String findByIdBook;
    public String saveBook;
    public String updateBook;
    public String findByAuthorInBook;
    public String findByTitleInBook;
    // Авторы
    public String getAllAuthors;
    public String findByIdAuthor;
    public String saveAuthor;
    public String updateAuthor;
    // Города
    public String getAllCity;
    public String findByIdCity;
    public String saveCity;
    public String updateCity;
    // Жанры
    public String getAllGenre;
    public String findByIdGenre;
    public String saveGenre;
    public String updateGenre;
    // Издательства
    public String getAllPublisher;
    public String findByIdPublisher;
    public String savePublisher;
    public String updatePublisher;
    // Удаление
    public String deleteBook;
    public String deleteAuthor;
    public String deleteCity;
    public String deleteGenre;
    public String deletePublisher;

    public ClientProperties() {
        try (InputStream input = MainApplication.class.getClassLoader().getResourceAsStream("config.properties")) {
            System.out.println(input);
            properties.load(input); // Загрузка свойств из файла
            getAllBook = properties.getProperty("book.getAll");
            findByIdBook = properties.getProperty("book.findById");
            saveBook = properties.getProperty("book.save");
            updateBook = properties.getProperty("book.update");
            //
            findByAuthorInBook = properties.getProperty("book.findByAuthor");
            findByTitleInBook = properties.getProperty("book.findByTitle");
            getAllAuthors = properties.getProperty("author.getAll");
            findByIdAuthor = properties.getProperty("author.findById");
            saveAuthor = properties.getProperty("author.save");
            updateAuthor = properties.getProperty("author.update");
            //
            getAllCity = properties.getProperty("city.getAll");
            findByIdCity = properties.getProperty("city.findById");
            saveCity = properties.getProperty("city.save");
            updateCity = properties.getProperty("city.update");
            //
            getAllGenre = properties.getProperty("genre.getAll");
            findByIdGenre = properties.getProperty("genre.findById");
            saveGenre = properties.getProperty("genre.save");
            updateGenre = properties.getProperty("genre.update");
            //
            getAllPublisher = properties.getProperty("publisher.getAll");
            findByIdPublisher = properties.getProperty("publisher.findById");
            savePublisher = properties.getProperty("publisher.save");
            updatePublisher = properties.getProperty("publisher.update");
            //
            deleteBook = properties.getProperty("book.del");
            deleteCity = properties.getProperty("city.del");
            deleteGenre = properties.getProperty("genre.del");
            deletePublisher = properties.getProperty("publisher.del");
            deleteAuthor = properties.getProperty("author.del");
        } catch (IOException exception) {
            exception.printStackTrace(); // Обработка исключения в случае потопа
        }
    }
}
