package com.example.watchlist;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalTimeStringConverter;

import java.time.LocalTime;

import static com.example.watchlist.Media.allMedia;

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
public TableView mediaTable;

public void initialize() throws Exception {

    // tell each TableColumn which Media field to get data from
    tableTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    tableGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    tableStreaming.setCellValueFactory(new PropertyValueFactory<>("streamingService"));
    tableRunTime.setCellValueFactory(new PropertyValueFactory<>("runtime"));

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

}

public void insertMovie() throws Exception {
    Media emptyMedia = new Media();
    mediaTable.getItems().add(emptyMedia);





}

}