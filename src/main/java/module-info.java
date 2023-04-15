module com.example.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chess to javafx.fxml;
    exports com.example.chess;
    exports com.example.chess.view;
    exports com.example.chess.model;
    exports com.example.chess.model.pieces;
    exports com.example.chess.model.moves;
    opens com.example.chess.view to javafx.fxml;
}