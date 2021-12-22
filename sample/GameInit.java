package sample;


import javafx.animation.AnimationTimer;
import javafx.scene.layout.GridPane;



public class GameInit {

    private boolean win = false;
    private boolean lose = false;
    private int playerScore = 0;
    private Cell[][] map;
    private static GamePlayer gamePlayer;
    private static boolean isPaused;
    private static Command command;
    private final long StartGameTime = System.currentTimeMillis();
    private int rows;
    private int cols;
    private static GameInit instance;
    private GridPane gridPane;
    //TODO another stage should be implemented here whether the player wins

    public void setGridPane(GridPane gridPane){
        this.gridPane = gridPane;

    }

    public static GameInit getInstance(){

        if(instance != null) {
            return instance;
        }
        return null;
    }


    public static GameInit getInstance(int rows,int cols){
        instance = new GameInit(rows,cols);
        return instance;
    }

    //here we can more parameters to GameInit constructor e.g. difficulty in next phase of project
    private GameInit(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        isPaused = false;
        start(rows,cols);
        todo();
    }

    public Cell[][] getMap(){
        return map;
    }

    private void start(int rows,int cols){
        map = MapGenerator.create(rows,cols);
        gamePlayer = Player.getInstance(1,0,map.length,map[0].length);

    }

    private void todo(){
        long StartTime = System.currentTimeMillis();
            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    GameController.clearCanvas();
                    double starTime = System.currentTimeMillis();
                    boolean hasMoved = false;
                    if (win || lose || isPaused) {
                        stop();
                    }

                    if (command != null) {
                        if (command.isValid()) {
                            int newRow = (int) (gamePlayer.getCurrentRow() + gamePlayer.getOffset().getX());
                            int newCol = (int) (gamePlayer.getCurrentCol() + gamePlayer.getOffset().getY());
                            if (map[newRow][newCol] instanceof EmptyCell) {
                                command.execute();
                                hasMoved = true;
                            } else if (map[newRow][newCol] instanceof Bomb) {
                                command.execute();
                                map[newRow][newCol].action(gamePlayer);
                                map[newRow][newCol] = new EmptyCell();
                                map[newRow][newCol].draw(gridPane, newCol, newRow);
                                GameController.drawExplosion(newRow, newCol);
                                hasMoved = true;
                            }
                            //TODO other options should be implemented her e.g. the player can't go in bomb cells or monster cells in next phases

                            try {
                                if (hasMoved) {
                                    gamePlayer.draw(directionMapped(), gamePlayer.getCurrentRow(), gamePlayer.getCurrentCol());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }


                    command = null;
                    long timePassed = StartTime - StartGameTime;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //TODO i should use this time for scoring the player

                }
            };

        animationTimer.start();
    }

    private int directionMapped(){
        if (command.toString().equalsIgnoreCase("up")) {
            return ConstantsThings.PlayerDirection.UP;
        } else if (command.toString().equalsIgnoreCase("down")) {
            return ConstantsThings.PlayerDirection.DOWN;
        } else if (command.toString().equalsIgnoreCase("left")) {
            return ConstantsThings.PlayerDirection.LEFT;
        } else if (command.toString().equalsIgnoreCase("right")) {
            return ConstantsThings.PlayerDirection.RIGHT;
        }
        return 0;
    }

    public static void togglePaused(){
        isPaused = !isPaused;
        if(!isPaused){
            GameInit.getInstance().todo();
        }
    }
}
