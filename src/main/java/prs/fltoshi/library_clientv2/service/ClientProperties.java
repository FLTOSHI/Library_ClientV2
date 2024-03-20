package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.MainApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClientProperties {
    private final Properties properties = new Properties();

    // GET
    public String getAllBook;
    public String getAllAuthors;
    public String getAllCity;
    public String getAllGenre;
    public String getAllPublisher;

    // FIND
    public String findByIdAuthor;
    public String findByAuthorInBook;
    public String findByTitleInBook;
    public String findByIdBook;
    public String findByIdCity;
    public String findByIdGenre;
    public String findByIdPublisher;

    // SAVE
    public String saveAuthor;
    public String saveBook;
    public String saveCity;
    public String saveGenre;
    public String savePublisher;

    // UPDATE
    public String updateAuthor;
    public String updateBook;
    public String updateCity;
    public String updateGenre;
    public String updatePublisher;

    // DELETE
    public String deleteBook;
    public String deleteAuthor;
    public String deleteCity;
    public String deleteGenre;
    public String deletePublisher;

    public ClientProperties() {
        try (InputStream input = MainApplication.class.getClassLoader().getResourceAsStream("config.properties")) {
            System.out.println(input);
            properties.load(input); // Загрузка свойств из файла
            // GET ALL
            getAllAuthors = properties.getProperty("author.getAll");
            getAllBook = properties.getProperty("book.getAll");
            getAllCity = properties.getProperty("city.getAll");
            getAllGenre = properties.getProperty("genre.getAll");
            getAllPublisher = properties.getProperty("publisher.getAll");

            // FIND
            findByIdAuthor = properties.getProperty("author.findById");
            findByAuthorInBook = properties.getProperty("book.findByAuthor");
            findByTitleInBook = properties.getProperty("book.findByTitle");
            findByIdCity = properties.getProperty("city.findById");
            findByIdGenre = properties.getProperty("genre.findById");
            findByIdPublisher = properties.getProperty("publisher.findById");

            // SAVE
            saveAuthor = properties.getProperty("author.save");
            saveBook = properties.getProperty("book.save");
            saveCity = properties.getProperty("city.save");
            saveGenre = properties.getProperty("genre.save");
            savePublisher = properties.getProperty("publisher.save");

            // UPDATE
            updateAuthor = properties.getProperty("author.update");
            updateBook = properties.getProperty("book.update");
            updateCity = properties.getProperty("city.update");
            updateGenre = properties.getProperty("genre.update");
            updatePublisher = properties.getProperty("publisher.update");

            // DELETE
            deleteAuthor = properties.getProperty("author.del");
            deleteBook = properties.getProperty("book.del");
            deleteCity = properties.getProperty("city.del");
            deleteGenre = properties.getProperty("genre.del");
            deletePublisher = properties.getProperty("publisher.del");
        } catch (IOException exception) {
            exception.printStackTrace(); // Обработка исключения в случае потопа
        }
    }
}
