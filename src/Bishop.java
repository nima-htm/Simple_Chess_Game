public class Bishop extends Piece {
    public Bishop(String color) {
        super(color, "icons/" + "b" + color + ".png");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] pieces) {
        if (pieces[endRow][endCol] != null && pieces[endRow][endCol].color.equals(this.color))
            return false;

        int h_diff = Math.abs(endRow - startRow);
        int v_diff = Math.abs(endCol - startCol);
        if (h_diff != v_diff)
            return false;

        //define direction
        int dx = (endRow > startRow) ? 1 : -1;
        int dy = (endCol > startCol) ? 1 : -1;
        //loop for check direction
        int x = startRow + dx, y = startCol + dy;
        while (x != endRow && y != endCol) {
            if (pieces[x][y] != null) {
                return false;
            }
            x += dx;
            y += dy;
        }


        return true;
    }
}
