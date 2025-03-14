
class Pawn extends Piece {
    public Pawn(String color) {
        super(color, "icons/" + "p" + color + ".png");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] pieces) {
        int direction = color.equals("w") ? -1 : 1;

        if (startCol == endCol && endRow == startRow + direction && pieces[endRow][endCol] == null) {
            return true;
        }

        if (startCol == endCol && startRow == (color.equals("w") ? 6 : 1) && endRow == startRow + 2 * direction && pieces[endRow][endCol] == null && pieces[startRow + direction][endCol] == null) {
            return true;
        }
        if (Math.abs(startCol - endCol) == 1 && endRow == startRow + direction && pieces[endRow][endCol] != null && !pieces[endRow][endCol].color.equals(this.color)) {
            return true;
        }

        return false;
    }
}
