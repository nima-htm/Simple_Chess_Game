public class Knight extends Piece {

    public Knight(String color) {
        super(color, "icons/" + "h" + color + ".png");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] pieces) {
        if (pieces[endRow][endCol] != null && pieces[endRow][endCol].color.equals(this.color))
            return false;

        if (endRow == startRow + 1 && endCol == startCol + 2)
            return true;
        else if (endRow == startRow + 2 && endCol == startCol + 1)
            return true;
        else if (endRow == startRow - 1 && endCol == startCol + 2)
            return true;
        else if (endRow == startRow - 2 && endCol == startCol + 1)
            return true;
        else if (endRow == startRow + 1 && endCol == startCol - 2)
            return true;
        else if (endRow == startRow + 2 && endCol == startCol - 1)
            return true;
        else if (endRow == startRow - 1 && endCol == startCol - 2)
            return true;
        else if (endRow == startRow - 2 && endCol == startCol - 1)
            return true;

        return false;
    }
}
