package com.example.watchlist;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalTime;



public class WatchedControllers {
    public TableColumn<Media,String> tableTitleWatched;
    public TableColumn<Media,String> tableGenreWatched;
    public TableColumn<Media, LocalTime> tableRunTimeWatched;
    public TableColumn<Media, String> tableStreamingWatched;
    public TableColumn<Media, Integer> tableRating;

    TableView watchedMediaTable;

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
                (TableColumn.CellEditEvent<Media, LocalTime> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    //selectedMedia.setRunTime(m.getNewValue(LocalTime.parse()));
                });
        tableStreamingWatched.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, String> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setStreamingService(m.getNewValue());
                });
        tableRunTimeWatched.setOnEditCommit(
                (TableColumn.CellEditEvent<Media, Integer> m) -> {
                    int selectedRow = m.getTablePosition().getRow();
                    Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                    selectedMedia.setRatingNumber(m.getNewValue());
        }
        );

    }
}
