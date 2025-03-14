public class Queen extends Piece {

    public Queen(String color) {
        super(color, "icons/" + "q" + color + ".png");
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
