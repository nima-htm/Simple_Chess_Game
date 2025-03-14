import javax.swing.*;
import java.awt.*;

public class ChessBoard {
    private static int SIZE = 8;
    private JFrame frame;
    private JButton[][] board;
    private Piece[][] pieces;
    private JButton selectedButton = null;
    private int selectedRow = -1, selectedCol = -1;

    private String currentTurn = "w";

    public ChessBoard() {

        frame = new JFrame();
        frame.setTitle("Chess");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(SIZE, SIZE));

        board = new JButton[SIZE][SIZE];
        pieces = new Piece[SIZE][SIZE];
        initializeBoard();

        frame.setVisible(true);
    }

    private void initializeBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JButton button = new JButton();
                button.setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                button.setActionCommand(row + " " + col);
                button.addActionListener(new MoveListener(this));
                board[row][col] = button;
                frame.add(button);
            }
        }
        PieceState();
    }

    // Getters
    public JButton[][] getBoard() {
        return board;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public JButton getSelectedButton() {
        return selectedButton;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public int getSelectedCol() {
        return selectedCol;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    //Setters
    public void setSelectedButton(JButton button, int row, int col) {
        selectedButton = button;
        selectedRow = row;
        selectedCol = col;
    }


    public void setCurrentTurn(String currentTurn) {
        currentTurn = currentTurn;
    }

    //Methods
    public void clearSelection() {
        selectedButton = null;
        selectedRow = -1;
        selectedCol = -1;
    }

    private void PieceState() {
        //Pawn
        for (int col = 0; col < SIZE; col++) {
            pieces[1][col] = new Pawn("b");
            pieces[6][col] = new Pawn("w");
            board[1][col].setIcon(pieces[1][col].getIcon());
            board[6][col].setIcon(pieces[6][col].getIcon());
        }
        // Rook
        pieces[0][0] = new Rook("b");
        pieces[0][7] = new Rook("b");
        pieces[7][0] = new Rook("w");
        pieces[7][7] = new Rook("w");
        board[0][0].setIcon(pieces[0][0].getIcon());
        board[0][7].setIcon(pieces[0][7].getIcon());
        board[7][0].setIcon(pieces[7][0].getIcon());
        board[7][7].setIcon(pieces[7][7].getIcon());

        //Bishop
        pieces[0][2] = new Bishop("b");
        pieces[0][5] = new Bishop("b");
        pieces[7][2] = new Bishop("w");
        pieces[7][5] = new Bishop("w");
        board[0][2].setIcon(pieces[0][2].getIcon());
        board[0][5].setIcon(pieces[0][5].getIcon());
        board[7][2].setIcon(pieces[7][2].getIcon());
        board[7][5].setIcon(pieces[7][5].getIcon());

        //Knight
        pieces[0][1] = new Knight("b");
        pieces[0][6] = new Knight("b");
        pieces[7][1] = new Knight("w");
        pieces[7][6] = new Knight("w");
        board[0][1].setIcon(pieces[0][1].getIcon());
        board[0][6].setIcon(pieces[0][6].getIcon());
        board[7][1].setIcon(pieces[7][1].getIcon());
        board[7][6].setIcon(pieces[7][6].getIcon());

        //Queen and King
        pieces[0][3] = new Queen("b");
        pieces[0][4] = new King("b");
        pieces[7][3] = new Queen("w");
        pieces[7][4] = new King("w");
        board[0][3].setIcon(pieces[0][3].getIcon());
        board[0][4].setIcon(pieces[0][4].getIcon());
        board[7][3].setIcon(pieces[7][3].getIcon());
        board[7][4].setIcon(pieces[7][4].getIcon());
    }


    public void switchTurn() {
        currentTurn = currentTurn.equals("w") ? "b" : "w";
    }
}