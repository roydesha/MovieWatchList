module com.example.watchlist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.watchlist to javafx.fxml;
    exports com.example.watchlist;
}