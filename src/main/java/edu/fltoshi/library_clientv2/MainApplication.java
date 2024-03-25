package edu.fltoshi.library_clientv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 600);
        stage.setTitle("Электронная библиотека");
        stage.setScene(scene);
        stage.show();
    }

    public static void showAuthorDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("add-author-view.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавить/изменить автора");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void showPublisherDialog() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApplication.class.getResource("publisher-add-view.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Добавить/изменить автора");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
//            dialogStage.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        launch();
    }
}