package com.example.chess.view;

import com.example.chess.model.Board;
import com.example.chess.model.BoardUtils;
import com.example.chess.model.Coordinates;
import com.example.chess.model.moves.Move;
import com.example.chess.model.pieces.Piece;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TilePane extends GridPane {

    private ArrayList<ImageView> imageViews;

    public TilePane(EventHandler<MouseEvent> controller) {
        imageViews = new ArrayList<>();

        int count = 0;
        for(int i = 0; i < BoardUtils.RANK_COUNT; i++) {
            count++;
            for(int j = 0; j < BoardUtils.FILE_COUNT; j++) {
                TileRectangle r = new TileRectangle(80, 80, 80, 80, i, j);
                r.setOnMouseClicked(controller);
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
        ArrayList<Move> moves = board.getLegalMoves();

        for(ImageView imageView: imageViews) {
            this.getChildren().remove(imageView);
        }
        imageViews = new ArrayList<>();

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

            imageViews.add(imageView);

            this.add(imageView, coordinates.getxCoordinate(), coordinates.getyCoordinate());
        }

        for(Move move: moves) {
            Coordinates coordinates = move.getDestination();
            Circle circle = new Circle(40, 40, 30, Color.BLACK);
            this.add(circle, coordinates.getxCoordinate(), coordinates.getyCoordinate());

            System.out.println(move);
        }
    }
}
