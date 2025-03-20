import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MoveListener implements ActionListener {
    private ChessBoard game;

    public MoveListener(ChessBoard game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String[] pos = source.getActionCommand().split(" ");
        int row = Integer.parseInt(pos[0]);
        int col = Integer.parseInt(pos[1]);

        if (game.getSelectedButton() == null) {
            if (source.getIcon() != null) {
                Piece selectedPiece = game.getPieces()[row][col];
                if (selectedPiece != null && !selectedPiece.color.equals(game.getCurrentTurn())) {
                    JOptionPane.showMessageDialog(null, "It's not your turn!");
                    return;
                }
                game.setSelectedButton(source, row, col);
                source.setBackground(Color.getHSBColor(120 / 360f, 0.4f, 0.8f));
            }
        } else {
            Piece selectedPiece = game.getPieces()[game.getSelectedRow()][game.getSelectedCol()];
            if (selectedPiece != null && selectedPiece.isValidMove(game.getSelectedRow(), game.getSelectedCol(), row, col, game.getPieces())) {
                if (!GameRules.isValidMove(game,game.getSelectedRow(),game.getSelectedCol(),row,col)){
                    JOptionPane.showMessageDialog(null, "Move is not allowed. You are in check! ");
                }
                else
                {

                    source.setIcon(game.getSelectedButton().getIcon());
                    game.getSelectedButton().setIcon(null);
                    game.getPieces()[row][col] = selectedPiece;
                    game.getPieces()[game.getSelectedRow()][game.getSelectedCol()] = null;

                    game.switchTurn();
                    String opponentColor = selectedPiece.color.equals("w") ? "b" : "w";
                    if (GameRules.CheckKing(game, opponentColor)) {
                        JOptionPane.showMessageDialog(null, "Check! " + (opponentColor.equals("w") ? "White" : "Black") + " king is in danger!");
                    }

                    if (GameRules.Checkmate(game, opponentColor)) {
                        JOptionPane.showMessageDialog(null, "Checkmate! " + (opponentColor.equals("w") ? "Black" : "White") + " team won !");
                        System.exit(0);
                    }
                }

            } else
                System.out.println("you cant move that way");

            JButton previousButton = game.getSelectedButton();
            int prevRow = game.getSelectedRow();
            int prevCol = game.getSelectedCol();
            previousButton.setBackground((prevRow + prevCol) % 2 == 0 ? Color.WHITE : Color.GRAY);

            game.clearSelection();
        }
    }
}
