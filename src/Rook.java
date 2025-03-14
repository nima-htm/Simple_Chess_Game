public class Rook extends Piece {

    public Rook(String color) {
        super(color, "icons/" + "r" + color + ".png");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] pieces) {
        if (pieces[endRow][endCol] != null && pieces[endRow][endCol].color.equals(this.color))
            return false;

        if (startRow == endRow) {
            for (int i = Math.min(startCol, endCol) + 1; i < Math.max(startCol, endCol); i++) {
                if (pieces[startRow][i] != null)
                    return false;
            }
            return true;
        }

        if (startCol == endCol) {
            for (int i = Math.min(startRow, endRow) + 1; i < Math.max(startRow, endRow); i++) {
                if (pieces[i][startCol] != null)
                    return false;
            }
            return true;
        }

        return false;
    }
}
