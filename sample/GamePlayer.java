package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;

public class GamePlayer {

    private Image playerImage;
    private ImageView playerImageView;
    private int currentCol;
    private int currentRow;
    private int gridRows;
    private int gridCols;
    private Point offset;

    public void draw(int dir, int row, int col){

    }

    public GamePlayer(int currentRow, int currentCol, int gridRows, int gridCols) {

        this.currentRow = currentRow;
        this.currentCol = currentCol;
        this.gridRows = gridRows;
        this.gridCols = gridCols;
        offset = new Point(0, 0);
        playerImageView = new ImageView();
    }

    public void setPlayerImage(Image playerImage){
        this.playerImage = playerImage;
        playerImageView.setImage(playerImage);
    }

    public ImageView getPlayerImageView(){
        return this.playerImageView;
    }

    public int getCurrentCol() {
        return this.currentCol;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }

    public Point getOffset() {
        return this.offset;
    }
}
