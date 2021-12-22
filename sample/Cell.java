package sample;

import javafx.scene.layout.GridPane;

public abstract class Cell {

    public void draw(GridPane gridPane, int row, int col){

    }

    public abstract void action(GamePlayer gamePlayer);

}
