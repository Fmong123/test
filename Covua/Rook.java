
public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int currentX = this.getCoordinatesX();
        int currentY = this.getCoordinatesY();

        boolean isHorizontal = (currentY == y) && (currentX != x);
        boolean isVertical = (currentX == x) && (currentY != y);

        if (!board.validate(x, y)) {
            return false;
        }

        if (!isHorizontal && !isVertical) {
            return false;
        }

        // Di chuyển ngang (Horizontal)
        if (isHorizontal) {
            int step = (x > currentX) ? 1 : -1;
            for (int i = currentX + step; i != x; i += step) {
                if (board.getAt(i, currentY) != null) {
                    return false;
                }
            }
        }

        // Di chuyển dọc (Vertical)
        if (isVertical) {
            int step = (y > currentY) ? 1 : -1;
            for (int i = currentY + step; i != y; i += step) {
                if (board.getAt(currentX, i) != null) {
                    return false;
                }
            }
        }

        Piece targetPiece = board.getAt(x, y);
        if (targetPiece != null) {
            return !targetPiece.getColor().equals(this.getColor());
        } else  {
            return true;
        }
    }
}
