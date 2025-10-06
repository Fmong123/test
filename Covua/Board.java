

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     *cmt.
     */
    public boolean validate(int x, int y) {
        return x >= 1 && y >= 1 && x < WIDTH && y < HEIGHT;
    }

    /**
     *cmt.
     */
    public void addPiece(Piece piece) {
        if (!pieces.contains(piece) && validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    /**
     *cmt.
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    /**
     *cmt.
     */
    public void removeAt(int x, int y) {
        Iterator<Piece> iterator = pieces.iterator();
        while (iterator.hasNext()) {
            Piece piece = iterator.next();
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                iterator.remove();
                return;
            }
        }
    }
}
