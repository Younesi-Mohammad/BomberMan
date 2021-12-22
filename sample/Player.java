package sample;

public class Player extends GamePlayer {

    //TODO this class should be completed
    private static Player myPlayer;
    public static Player getInstance(){
        return myPlayer;
    }

    public static Player getInstance(int rows, int cols, int gridRows, int gridColumns) {
        myPlayer = new Player(rows,cols,gridRows,gridColumns);
        return myPlayer;
    }

    private Player(int currentRow, int currentColumn, int gridRows, int gridColumns) {
        super(currentRow, currentColumn, gridRows, gridColumns);

    }

    public void setPlayerImage (String image){
        super.setPlayerImage(PlayerMaker.setImage(image));
    }

}
