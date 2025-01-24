package com.example.watchlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalTimeStringConverter;

import java.time.LocalTime;

public class HelloController {
public Pane pane;
public Button imageButton;
public Button addButton;
public Button finishedButton;
public Button rateButton;
public Button completedButton;
public RadioButton radioOne;
public RadioButton radioTwo;
public RadioButton radioThree;
public RadioButton radioFour;
public RadioButton radioFive;
public Button returnButton;
public TableColumn<Media,String> tableTitle;
public TableColumn<Media,String> tableGenre;
public TableColumn<Media, LocalTime> tableRunTime;
public TableColumn<Media, String> tableStreaming;
public TableColumn tablePoster;
public TableColumn tableWatched;
public TableView<Media> mediaTable;
public Label badLabel;
public Label goodLabel;

Media watchedMovie;
ToggleGroup ratingGroup = new ToggleGroup();

public void initialize() throws Exception {

    // tell each TableColumn which Media field to get data from
    tableTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    tableGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    tableStreaming.setCellValueFactory(new PropertyValueFactory<>("streamingService"));
    tableRunTime.setCellValueFactory(new PropertyValueFactory<>("runTime"));

    // make each TableColumn editable
    tableTitle.setCellFactory(TextFieldTableCell.forTableColumn());
    tableGenre.setCellFactory(TextFieldTableCell.forTableColumn());
    tableStreaming.setCellFactory(TextFieldTableCell.forTableColumn());
    tableRunTime.setCellFactory(TextFieldTableCell.forTableColumn(new LocalTimeStringConverter()));

    // tell each TableColumn which Media field to store data to
    tableTitle.setOnEditCommit(
            (TableColumn.CellEditEvent<Media, String> m) -> {
                int selectedRow = m.getTablePosition().getRow();
                Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                selectedMedia.setTitle(m.getNewValue());
            });

    tableGenre.setOnEditCommit(
            (TableColumn.CellEditEvent<Media, String> m) -> {
                int selectedRow = m.getTablePosition().getRow();
                Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                selectedMedia.setGenre(m.getNewValue());
            });

    tableRunTime.setOnEditCommit(
            (TableColumn.CellEditEvent<Media, LocalTime> m) -> {
                int selectedRow = m.getTablePosition().getRow();
                Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                //selectedMedia.setRunTime(m.getNewValue(LocalTime.parse()));
            });
    tableStreaming.setOnEditCommit(
            (TableColumn.CellEditEvent<Media, String> m) -> {
                int selectedRow = m.getTablePosition().getRow();
                Media selectedMedia = m.getTableView().getItems().get(selectedRow);
                selectedMedia.setStreamingService(m.getNewValue());
            });

    radioOne.setToggleGroup(ratingGroup);
    radioTwo.setToggleGroup(ratingGroup);
    radioThree.setToggleGroup(ratingGroup);
    radioFour.setToggleGroup(ratingGroup);
    radioFive.setToggleGroup(ratingGroup);


}

public void insertMovie() throws Exception {
    Media emptyMedia = new Media();
    mediaTable.getItems().add(emptyMedia);

        finishedButton.setVisible(true);

}

public void moviesWatched() throws Exception{
    watchedMovie = mediaTable.getSelectionModel().getSelectedItem();
   if (watchedMovie != null){
        watchedMovie.setWatched(true);
       goodLabel.setVisible(true);
       badLabel.setVisible(true);
       radioOne.setVisible(true);
       radioTwo.setVisible(true);
       radioThree.setVisible(true);
       radioFour.setVisible(true);
       radioFive.setVisible(true);
   }
}

public void ratingButtons() {

   RadioButton selectedButton = (RadioButton)ratingGroup.getSelectedToggle();
    if (selectedButton == radioOne) {
        watchedMovie = mediaTable.getSelectionModel().getSelectedItem();
        watchedMovie.setRatingNumber(1);
    }
    if (selectedButton == radioTwo) {
        watchedMovie = mediaTable.getSelectionModel().getSelectedItem();
        watchedMovie.setRatingNumber(2);
    }
    if (selectedButton == radioThree) {
        watchedMovie = mediaTable.getSelectionModel().getSelectedItem();
        watchedMovie.setRatingNumber(3);
    }
    if (selectedButton == radioFour) {
        watchedMovie = mediaTable.getSelectionModel().getSelectedItem();
        watchedMovie.setRatingNumber(4);
    }
    if (selectedButton == radioFive) {
        watchedMovie = mediaTable.getSelectionModel().getSelectedItem();
        watchedMovie.setRatingNumber(5);
    }

    watchedMovie.setWatched(true);
    mediaTable.getItems().remove(watchedMovie);


}

public void switchToNextView() throws Exception{
    FXMLLoader fxmlLoader = new FXMLLoader(Media.class.getResource("watchedmovies.fxml"));
    Scene watchedMoviesScene = new Scene(fxmlLoader.load(), 600, 400);
    Stage mainStage = (Stage)completedButton.getScene().getWindow();
    mainStage.setScene(watchedMoviesScene);
    mainStage.show();
}


}