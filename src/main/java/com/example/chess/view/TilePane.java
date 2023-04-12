package com.example.chess.view;

import com.example.chess.model.Board;
import com.example.chess.model.BoardUtils;
import com.example.chess.model.Coordinates;
import com.example.chess.model.pieces.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TilePane extends GridPane {

    public TilePane() {
        int count = 0;
        for(int i = 0; i < BoardUtils.RANK_COUNT; i++) {
            count++;
            for(int j = 0; j < BoardUtils.FILE_COUNT; j++) {
                Rectangle r = new Rectangle(80, 80, 80, 80);
                r.setOnMouseClicked(event -> r.setFill(Color.BLACK));
                if(count % 2 == 0) {
                    r.setFill(Color.GREEN);
                } else {
                    r.setFill(Color.WHITE);
                }
                this.add(r, j, i);
                count++;
            }
        }
    }

    public void updateView(Board board) {
        HashMap<Coordinates, Piece> pieces = board.getPieces();

        for(Map.Entry<Coordinates, Piece> pieceEntry: pieces.entrySet()) {
            Coordinates coordinates = pieceEntry.getKey();
            Piece piece = pieceEntry.getValue();
            String factionColor = piece.getColor().getLabel();
            String pieceLabel = piece.getPieceLabel().getLabel();

            String url = "/com/example/chess/images/" + factionColor + "_" + pieceLabel + ".png";
            Image pieceImage = new Image(url);
            ImageView imageView = new ImageView();
            imageView.setImage(pieceImage);
            imageView.setFitWidth(80);
            imageView.setPreserveRatio(true);

            this.add(imageView, coordinates.getxCoordinate(), coordinates.getyCoordinate());
        }
    }
}
