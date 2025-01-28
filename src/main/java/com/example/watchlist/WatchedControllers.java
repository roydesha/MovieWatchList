package com.example.watchlist;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalTime;



public class WatchedControllers {
    public TableColumn<Media,String> tableTitleWatched;
    public TableColumn<Media,String> tableGenreWatched;
    public TableColumn<Media, String> tableRunTimeWatched;
    public TableColumn<Media, String> tableStreamingWatched;
    public TableColumn<Media, Integer> tableRating;
    public TableView<Media> watchedMediaTable;
    public Button returnButton;

    public void initialize() {
        for (Media eachone :  Media.watchedMedia) {
            watchedMediaTable.getItems().add(eachone);
        }

        tableTitleWatched.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableGenreWatched.setCellValueFactory(new PropertyValueFactory<>("genre"));
        tableStreamingWatched.setCellValueFactory(new PropertyValueFactory<>("streamingService"));
        tableRunTimeWatched.setCellValueFactory(new PropertyValueFactory<>("runTime"));
        tableRating.setCellValueFactory(new PropertyValueFactory<>("ratingNumber"));

        tableTitleWatched.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, String> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setTitle(m.getNewValue());
                });

        tableGenreWatched.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, String> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setGenre(m.getNewValue());
                });

        tableRunTimeWatched.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, String> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setRunTime(m.getNewValue());
                });
        tableStreamingWatched.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, String> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setStreamingService(m.getNewValue());
                });
        tableRating.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, Integer> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setRatingNumber(m.getNewValue());
        });

    }

    public void switchToHomePage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Media.class.getResource("watch-list-view.fxml"));
        Scene watchedMoviesScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)returnButton.getScene().getWindow();
        mainStage.setScene(watchedMoviesScene);
        mainStage.show();
    }
}
