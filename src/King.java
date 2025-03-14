public class King extends Piece {

    public King(String color) {
        super(color, "icons/" + "k" + color + ".png");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] pieces) {
        if (pieces[endRow][endCol] != null && pieces[endRow][endCol].color.equals(this.color))
            return false;

        if (Math.abs(endRow - startRow) == 1 && Math.abs(endCol - startCol) == 1) {
            return true;
        }

        if (startRow == endRow && (endCol == startCol + 1 || endCol == startCol - 1))
            return true;

        if (startCol == endCol && (endRow == startRow + 1 || endRow == startRow - 1))
            return true;

        return false;
    }
}
