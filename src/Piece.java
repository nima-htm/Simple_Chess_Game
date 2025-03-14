import javax.swing.*;

abstract class Piece {
    protected String color;
    protected ImageIcon icon;

    public Piece(String color, String imagePath) {
        this.color = color;
        this.icon = new ImageIcon(imagePath);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] pieces);
}
