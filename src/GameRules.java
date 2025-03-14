import java.util.ArrayList;
import java.util.List;

public class GameRules {
    public static class PiecePosition {
        int row, col;
        Piece piece;

        PiecePosition(int row, int col, Piece piece) {
            this.row = row;
            this.col = col;
            this.piece = piece;
        }
    }

    public static PiecePosition FindKingPosition(ChessBoard game, String kingColor) {
        Piece[][] pieces = game.getPieces();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = pieces[i][j];
                if (p instanceof King && p.color.equals(kingColor)) {
                    return new PiecePosition(i, j, p);
                }
            }

        }
        return null;
    }

    private static List<PiecePosition> getOpponentPositions(ChessBoard game, String kingColor) {
        Piece[][] pieces = game.getPieces();
        List<PiecePosition> opponentPositions = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = pieces[row][col];
                if (piece != null && !piece.color.equals(kingColor)) {
                    opponentPositions.add(new PiecePosition(row, col, piece));
                }
            }
        }
        return opponentPositions;
    }
    public static boolean CheckKing(ChessBoard game, String kingColor) {
        PiecePosition kingPos = FindKingPosition(game, kingColor);
        if (kingPos == null) return false;

        List<PiecePosition> opponentPieces = getOpponentPositions(game, kingColor);

        for (PiecePosition pos : opponentPieces) {
            if (pos.piece.isValidMove(pos.row, pos.col, kingPos.row, kingPos.col, game.getPieces())) {
                return true;
            }
        }
        return false;
    }
    public static boolean Checkmate()
    {
        return false;
    }

    public static boolean isValidMove(ChessBoard game,int startRow, int startCol, int endRow, int endCol){
        Piece[][] pieces = game.getPieces();
        Piece CurrentPiece = pieces[startRow][startCol];
        if (CurrentPiece == null) return false;

        Piece temp = pieces[endRow][endCol];
        pieces[endRow][endCol] = CurrentPiece;
        pieces[startRow][startCol] = null;

        boolean SecondaryKingCheck = CheckKing(game, CurrentPiece.color);
        pieces[startRow][startCol] = CurrentPiece;
        pieces[endRow][endCol] = temp;


        return !SecondaryKingCheck;
    }
}
