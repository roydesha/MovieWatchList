module com.example.watchlist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.watchlist to javafx.fxml;
    exports com.example.watchlist;
}